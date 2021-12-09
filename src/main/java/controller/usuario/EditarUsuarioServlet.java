package controller.usuario;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/usuario/editar.do")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = null;
		
		try {
			usuario = this.usuarioService.buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/editar.jsp");
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
		
		/*Attraction attraction =*/ 
		try {
			if (id.equals("")) {
				this.usuarioService.insertar(nuevo);
			} else {
				this.usuarioService.actualizar(id, nuevo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (true /*attraction.isValid()*/) {
			resp.sendRedirect("/star-wars-park/usuario/index.do");
		} else {
			/*req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
			dispatcher.forward(req, resp);
			*/
		}
	}
	
}
