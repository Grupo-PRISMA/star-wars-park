package controller.promocion;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;
import services.PromocionService;
import services.UsuarioService;

@WebServlet("/promocion/borrar.do")
public class BorrarPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			this.promocionService.borrar(Integer.parseInt(req.getParameter("id")));
		} catch (SQLException e) {
			System.out.println("Error borrando promoción: " + e.getMessage());
			e.printStackTrace();
		}

		resp.sendRedirect("/star-wars-park/promocion/index.do");
	}


}
