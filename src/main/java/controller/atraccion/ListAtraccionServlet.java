package controller.atraccion;

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
import model.Atraccion;
import model.Usuario;
import services.AtraccionService;
import services.UsuarioService;

@WebServlet("/atraccion/index.do")
public class ListAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		
		try {
			atracciones = this.atraccionService.listar();
		} catch (SQLException e) {
			System.out.println("Error listando de atracciones: " + e.getMessage());
			e.printStackTrace();
		}
		
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atraccion/index.jsp");
		dispatcher.forward(req, resp);

	}

}
