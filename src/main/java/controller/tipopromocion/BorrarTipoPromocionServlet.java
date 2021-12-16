package controller.tipopromocion;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TipoPromocionService;

@WebServlet("/tipo-promocion/borrar.do")
public class BorrarTipoPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private TipoPromocionService tipoPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoPromocionService = new TipoPromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			this.tipoPromocionService.borrar(req.getParameter("id"));
		} catch (SQLException e) {
			System.out.println("Error borrando tipo atraccion: " + e.getMessage());
			e.printStackTrace();
		}

		resp.sendRedirect("/star-wars-park/tipo-promocion/index.do");
	}


}
