package controller.usuario;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UsuarioService;

@WebServlet("/usuario/borrar.do")
public class BorrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			this.usuarioService.borrar(req.getParameter("usuario"));
		} catch (SQLException e) {
			System.out.println("Error borrando usuario: " + e.getMessage());
			e.printStackTrace();
		}

		resp.sendRedirect("/star-wars-park/usuario/index.do");
	}


}
