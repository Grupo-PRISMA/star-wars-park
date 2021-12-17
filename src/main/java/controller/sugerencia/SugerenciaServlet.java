package controller.sugerencia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import services.AtraccionService;
import services.ItinerarioService;
import services.PromocionService;
import services.UsuarioService;

@WebServlet("/sugerencias")
public class SugerenciaServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;
	private ItinerarioService itinerarioService;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
		this.itinerarioService = new ItinerarioService();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Promocion> promocionesPreferidas = new ArrayList<>();
		ArrayList<Promocion> promocionesComunes = new ArrayList<>();
		ArrayList<Atraccion> atraccionesPreferidas = new ArrayList<>();
		ArrayList<Atraccion> atraccionesComunes = new ArrayList<>();
		ArrayList<Itinerario> itinerarioPromociones = new ArrayList<>();
		ArrayList<Itinerario> itinerarioAtracciones = new ArrayList<>();
		ArrayList<Integer> idsPromociones = new ArrayList<>();
		ArrayList<Integer> idsAtracciones = new ArrayList<>();
		
		try {
			Usuario usuario = (Usuario) req.getSession().getAttribute("usuario"); 
			promocionesPreferidas = this.promocionService.buscarPorTipo(usuario.getPreferencia());
			promocionesComunes = this.promocionService.buscarPorOtroTipo(usuario.getPreferencia());
			atraccionesPreferidas = this.atraccionService.buscarPorTipo(usuario.getPreferencia());
			atraccionesComunes = this.atraccionService.buscarPorOtroTipo(usuario.getPreferencia());
			itinerarioPromociones = this.itinerarioService.buscarPromociones(usuario.getId());
			itinerarioAtracciones = this.itinerarioService.buscarAtracciones(usuario.getId());
			
			for (Itinerario itinerario : itinerarioPromociones) {
				idsPromociones.add(itinerario.getIdLugar());
				ArrayList<Integer> ids = new Gson().fromJson(itinerario.getAtracciones(), new TypeToken<ArrayList<Integer>>(){}.getType());
				idsAtracciones.addAll(ids);
			}
			
			for (Itinerario itinerario : itinerarioAtracciones) {
				idsAtracciones.add(itinerario.getIdLugar());
				idsPromociones.addAll(this.promocionService.buscarIdsPorIdAtraccion(itinerario.getIdLugar()));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("promociones_preferidas", promocionesPreferidas);
		req.setAttribute("promociones_comunes", promocionesComunes);
		req.setAttribute("atracciones_preferidas", atraccionesPreferidas);
		req.setAttribute("atracciones_comunes", atraccionesComunes);
		req.setAttribute("itinerario_atracciones", itinerarioAtracciones);
		req.setAttribute("itinerario_promociones", itinerarioPromociones);
		req.setAttribute("atracciones_deshabilitadas", idsAtracciones);
		req.setAttribute("promociones_deshabilitadas", idsPromociones);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sugerencia/index.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// TODO falta validar que no puedan hackear el formulario para comprar algo ya comprado
			
			int id = Integer.parseInt(req.getParameter("id").trim());
			String tipo = req.getParameter("tipo").trim();			
			
			if (id < 1) {
				throw new Exception("Error interno: id");
			}
			
			if (!tipo.equals("promocion") && !tipo.equals("atraccion")) {
				throw new Exception("Error interno: tipo");
			}
			
			Promocion promocion = null;
			Atraccion atraccion = null;
			Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
			int idUsuario = usuario.getId();
			String atracciones;
			double gastoTotal;
			double tiempoTotal;
			int idLugar;
			String tipoLugar;
			
			if (tipo.equals("promocion")) {
				promocion = this.promocionService.buscar(id);
				
				if (promocion == null) {
					throw new Exception("Error interno: id");
				}
				
				if (!promocion.hayCupo() ) {
					throw new Exception("Alguna de las atracciones de la promoción no tiene cupo");
				}
				
				atracciones = new Gson().toJson(promocion.getIdAtracciones());
				gastoTotal = promocion.getCostoTotal();
				tiempoTotal = promocion.getDuracionTotal();
				idLugar = promocion.getId();
				tipoLugar = "P";
			} else {
				atraccion = this.atraccionService.buscar(id);
				
				if (atraccion == null) {
					throw new Exception("Error interno: id");
				}
				
				if (!atraccion.hayCupo() ) {
					throw new Exception("La atracción no tiene cupo");
				}
				
				atracciones = "[" + atraccion.getId() + "]";
				gastoTotal = atraccion.getCostoTotal();
				tiempoTotal = atraccion.getDuracionTotal();
				idLugar = atraccion.getId();
				tipoLugar = "A";
			}
			
			if (usuario.getPresupuesto() < gastoTotal) {
				throw new Exception("No dispones de suficiente dinero");	
			}
			
			if (usuario.getTiempoDisponibleHs() < tiempoTotal) {
				throw new Exception("No dispones de suficiente tiempo");	
			}
			
			Itinerario itinerario = new Itinerario(idUsuario, atracciones, gastoTotal, tiempoTotal, idLugar, tipoLugar);
			this.itinerarioService.insertar(itinerario);
			
			// sacar recursos a usuario
			usuario.setPresupuesto(usuario.getPresupuesto() - gastoTotal);
			usuario.setTiempoDisponibleHs(usuario.getTiempoDisponibleHs() - tiempoTotal);
			this.usuarioService.actualizar(usuario);
			req.getSession().setAttribute("usuario", usuario);
			
			// bajar cupo
			if (tipo.equals("promocion")) {
				promocion.bajarCupo();
				for (Atraccion a : promocion.getAtracciones()) {
					this.atraccionService.actualizar(a);	
				}
			} else {
				atraccion.bajarCupo();
				this.atraccionService.actualizar(atraccion);
			}
			
			req.setAttribute("mensaje", "Compra exitosa");
			req.setAttribute("tipo_mensaje", "success");
		} catch (Exception e) {
			req.setAttribute("mensaje", "Error interno: " + e.getMessage());
			req.setAttribute("tipo_mensaje", "danger");
		}

		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sugerencia/index.jsp");
		//dispatcher.forward(req, resp);
		this.doGet(req, resp);
	}
}
