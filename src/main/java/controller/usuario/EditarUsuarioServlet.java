package controller.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
import model.Usuario;
import services.TipoAtraccionService;
import services.UsuarioService;
import utils.Mensajes;

@WebServlet("/usuario/editar.do")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UsuarioService usuarioService;
	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.tipoAtraccionService = new TipoAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new Usuario(0, null, null, 0, 0, null, null, true, false);
		ArrayList<TipoAtraccion> tipos = new ArrayList<TipoAtraccion>();
		
		String ide = req.getParameter("id");
		
		try {	
			tipos = this.tipoAtraccionService.listarActivos();
			
			if(ide != null) {
				int id = Integer.parseInt(ide);
				usuario = this.usuarioService.buscar(id);	
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("usuario", usuario);
		req.setAttribute("tipos", tipos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int id = Integer.parseInt(req.getParameter("id"));
//		String usuario = req.getParameter("usuario");
//		String clave = req.getParameter("clave");
//		String nombre = req.getParameter("nombre");
//		String preferencia = req.getParameter("preferencia");
//		double presupuesto = req.getParameter("presupuesto").trim() == "" ? null : Double.parseDouble(req.getParameter("presupuesto"));
//		double tiempo = Double.parseDouble(req.getParameter("tiempo"));
//		int admin = req.getParameter("admin") != null ? 1 : 0;
//
//		try {
//			if (id == 0) {
//				this.usuarioService.insertar(usuario, clave, nombre, preferencia, presupuesto, tiempo, admin);
//			} else {
//				this.usuarioService.actualizar(id, clave, nombre, preferencia, presupuesto, tiempo, admin);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if (true /* attraction.isValid() */) {
//			resp.sendRedirect("/star-wars-park/usuario/index.do");
//		} else {
//			/*
//			 * req.setAttribute("attraction", attraction);
//			 * 
//			 * RequestDispatcher dispatcher =
//			 * getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
//			 * dispatcher.forward(req, resp);
//			 */
//		}
		int id;
		double presupuesto;
		double tiempo;
		
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		try {
			presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		} catch (NumberFormatException e) {
			presupuesto = -1;
		}

		try {
			tiempo = Double.parseDouble(req.getParameter("tiempo"));
		} catch (NumberFormatException e) {
			tiempo = -1;
		}

		
		Usuario usuario = new Usuario
		(
			id,
			req.getParameter("nombre").trim(),
			req.getParameter("preferencia"),
			presupuesto,
			tiempo,
			req.getParameter("usuario").trim(),
			req.getParameter("clave").trim(),
			true,
			req.getParameter("admin") != null
		);
		
		ArrayList<String> errores = new ArrayList<String>();
		
		try {
			errores = usuario.validar();
			usuario.setClave(usuario.getClave());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (errores.isEmpty()) {
			try {
				if (id == 0) {
					this.usuarioService.insertar(usuario);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ALTA, "usuario"));
					
				} else {
					this.usuarioService.actualizar(usuario);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ACTUALIZACION, "usuario"));
					
				}
				
				resp.sendRedirect("/star-wars-park/usuario/index.do");

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
			req.setAttribute("usuario", usuario);
			req.setAttribute("tipos", tipos);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/editar.jsp");
			dispatcher.forward(req, resp);
			//resp.sendRedirect("/star-wars-park/usuario/editar.do?id=" + usuario.getId());
		}
	}
}
