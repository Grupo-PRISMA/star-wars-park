package controller.atraccion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import services.AtraccionService;
import services.TipoAtraccionService;
import utils.Mensajes;

@WebServlet("/atraccion/editar.do")
public class EditarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService atraccionService;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Atraccion atraccion = new Atraccion(0, null, null, 0, 0, 0, true);
		ArrayList<TipoAtraccion> tipos = new ArrayList<TipoAtraccion>();
		
		String ide = req.getParameter("id");
		
		try {	
			tipos = this.tipoAtraccionService.listarActivos();
			
			if(ide != null) {
				int id = Integer.parseInt(ide);
				atraccion = this.atraccionService.buscar(id);	
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("atraccion", atraccion);
		req.setAttribute("tipos", tipos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atraccion/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;
		double presupuesto;
		double tiempo;
		int cupo;
		String nombre = req.getParameter("nombre");
		String tipo = req.getParameter("tipo");
		
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		try {
			presupuesto = Double.parseDouble(req.getParameter("costo"));
		} catch (NumberFormatException e) {
			presupuesto = -1;
		}

		try {
			tiempo = Double.parseDouble(req.getParameter("duracion"));
		} catch (NumberFormatException e) {
			tiempo = -1;
		}
		
		try {
			cupo = Integer.parseInt(req.getParameter("cupo"));
		} catch (NumberFormatException e) {
			cupo = -1;
		}

		if (nombre != null) {
			nombre = nombre.trim();
		} else {
			nombre = "";
		}
		
		
		Atraccion atraccion = new Atraccion
		(
			id,
			nombre,
			tipo,
			presupuesto,
			tiempo,
			cupo,
			true
		);
		
		
		ArrayList<String> errores = new ArrayList<String>();
		
		try {
			errores = atraccion.validar();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (errores.isEmpty()) {
			try {
				if (id == 0) {
					this.atraccionService.insertar(atraccion);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ALTA, "atracción"));
					
				} else {
					this.atraccionService.actualizar(atraccion);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ACTUALIZACION, "atracción"));
					
				}
				
				resp.sendRedirect("/star-wars-park/atraccion/index.do");

			} catch (SQLException e) {
				e.printStackTrace();
			}			
			
			
		} else {
			ArrayList<TipoAtraccion> tipos = new ArrayList<>();
			
			try {
				tipos = this.tipoAtraccionService.listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			req.setAttribute("errores", errores);
			req.setAttribute("atraccion", atraccion);
			req.setAttribute("tipos", tipos);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atraccion/editar.jsp");
			dispatcher.forward(req, resp);
			//resp.sendRedirect("/star-wars-park/usuario/editar.do?id=" + usuario.getId());
		}
	}
}
