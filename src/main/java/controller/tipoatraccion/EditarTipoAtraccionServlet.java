package controller.tipoatraccion;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import services.AttractionService;
import services.TipoAtraccionService;

@WebServlet("/tipo-atraccion/editar.do")
public class EditarTipoAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		//Attraction attraction = this.tipoAtraccionService.find(id);
		//req.setAttribute("attraction", attraction);
		req.setAttribute("tipo_atraccion", req.getParameter("id"));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/tipo_atraccion/editar.jsp");
		dispatcher.forward(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));
		//String name = req.getParameter("name");
		//Integer cost = Integer.parseInt(req.getParameter("cost"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		//Double duration = Double.parseDouble(req.getParameter("duration"));
		//Integer capacity = Integer.parseInt(req.getParameter("capacity"));
		String id = req.getParameter("id");
		String nuevo = req.getParameter("nuevo");
		
		/*Attraction attraction =*/ try {
			if (id.equals("")) {
				this.tipoAtraccionService.insertar(nuevo);
			} else {
				this.tipoAtraccionService.actualizar(id, nuevo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (true /*attraction.isValid()*/) {
			resp.sendRedirect("/star-wars-park/tipo-atraccion/index.do");
		} else {
			/*req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
			dispatcher.forward(req, resp);
			*/
		}
	}
	
}
