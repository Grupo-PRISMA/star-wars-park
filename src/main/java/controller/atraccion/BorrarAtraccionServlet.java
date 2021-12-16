package controller.atraccion;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;
import services.UsuarioService;

@WebServlet("/atraccion/borrar.do")
public class BorrarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			this.atraccionService.borrar(Integer.parseInt(req.getParameter("id")));
		} catch (SQLException e) {
			System.out.println("Error borrando atracción: " + e.getMessage());
			e.printStackTrace();
		}

		resp.sendRedirect("/star-wars-park/atraccion/index.do");
	}


}
