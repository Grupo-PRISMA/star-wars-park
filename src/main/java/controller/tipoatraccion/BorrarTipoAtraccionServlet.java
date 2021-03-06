package controller.tipoatraccion;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TipoAtraccionService;

@WebServlet("/tipo-atraccion/borrar.do")
public class BorrarTipoAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			this.tipoAtraccionService.borrar(req.getParameter("id"));
		} catch (SQLException e) {
			System.out.println("Error borrando tipo atraccion: " + e.getMessage());
			e.printStackTrace();
		}

		resp.sendRedirect("/star-wars-park/tipo-atraccion/index.do");
	}


}
