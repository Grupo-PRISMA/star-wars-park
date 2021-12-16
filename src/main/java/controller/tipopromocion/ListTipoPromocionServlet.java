package controller.tipopromocion;

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
import model.TipoPromocion;
//import model.TipoAtraccion;
//import model.Attraction;
//import services.AttractionService;
//import services.TipoAtraccionService;
import services.TipoPromocionService;

@WebServlet("/tipo-promocion/index.do")
public class ListTipoPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private TipoPromocionService tipoPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoPromocionService = new TipoPromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<TipoPromocion> tipoPromociones = new ArrayList<>();
		
		try {
			tipoPromociones = this.tipoPromocionService.listar();
		} catch (SQLException e) {
			System.out.println("Error listando tipo promocion: " + e.getMessage());
			e.printStackTrace();
		}
		
		req.setAttribute("tipo_promociones", tipoPromociones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/tipo_promocion/index.jsp");
		dispatcher.forward(req, resp);

	}

}
