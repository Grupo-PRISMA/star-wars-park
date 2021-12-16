package controller.tipoatraccion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.TipoAtraccion;

import services.TipoAtraccionService;
import utils.Mensajes;

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
		String id = req.getParameter("id").trim();
		String nuevo = req.getParameter("tipo");
		
		if (nuevo != null) {
			nuevo = nuevo.trim();
		} else {
			nuevo = "";
		}
		
		TipoAtraccion tipo = new TipoAtraccion(nuevo, true);

		ArrayList<String> errores = new ArrayList<String>();
		
		try {
			errores = tipo.validar();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		if (errores.isEmpty()) {
			try {
				if (id.equals("")) {
					this.tipoAtraccionService.insertar(nuevo);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ALTA, "tipo de atracción"));
				} else {
					this.tipoAtraccionService.actualizar(id, nuevo);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ACTUALIZACION, "tipo de atracción"));
				}
				
				resp.sendRedirect("/star-wars-park/tipo-atraccion/index.do");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("errores", errores);
			req.setAttribute("tipo_atraccion", nuevo);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/tipo_atraccion/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}
