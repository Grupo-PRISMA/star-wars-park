package controller.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/usuario/index.do")
public class ListUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		try {
			usuarios = this.usuarioService.listar();
		} catch (SQLException e) {
			System.out.println("Error listando de usuarios: " + e.getMessage());
			e.printStackTrace();
		}
		
		req.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/index.jsp");
		dispatcher.forward(req, resp);

	}

}
