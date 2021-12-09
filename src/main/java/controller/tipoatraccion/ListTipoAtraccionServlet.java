package controller.tipoatraccion;

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
import model.TipoAtraccion;
//import model.Attraction;
//import services.AttractionService;
import services.TipoAtraccionService;

@WebServlet("/tipo-atraccion/index.do")
public class ListTipoAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<TipoAtraccion> tipoAtracciones = new ArrayList<>();
		
		try {
			tipoAtracciones = this.tipoAtraccionService.listar();
		} catch (SQLException e) {
			System.out.println("Error listando tipo atraccion: " + e.getMessage());
			e.printStackTrace();
		}
		
		req.setAttribute("tipo_atracciones", tipoAtracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/tipo_atraccion/index.jsp");
		dispatcher.forward(req, resp);

	}

}
