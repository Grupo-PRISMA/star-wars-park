package controller.attractions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.DAO;
import services.ComprarAtraccionService;

@WebServlet("/atraccion/buy.do")
public class ComprarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarAtraccionService ComprarAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ComprarAtraccionService = new ComprarAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer atraccionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("user");
		Map<String, String> errors = null;
		try {
			errors = ComprarAtraccionService.comprar(usuario.getId(), atraccionId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario2 = null;
		try {
			usuario2 = DAO.getUsuarioDAO().buscarPorId(usuario.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/atraccion/index.do");
		dispatcher.forward(req, resp);
	}
}
