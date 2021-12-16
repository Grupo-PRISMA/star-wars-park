package controller.promocion;

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
import model.Promocion;
import model.Usuario;
import services.AtraccionService;
import services.PromocionService;
import services.UsuarioService;

@WebServlet("/promocion/index.do")
public class ListPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Promocion> promociones = new ArrayList<>();
		
		try {
			promociones = this.promocionService.listar();
		} catch (SQLException e) {
			System.out.println("Error listando de promociones: " + e.getMessage());
			e.printStackTrace();
		}
		
		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promocion/index.jsp");
		dispatcher.forward(req, resp);

	}

}
