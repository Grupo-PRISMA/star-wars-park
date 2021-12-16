package controller.promocion;

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
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import model.TipoPromocion;
import services.AtraccionService;
import services.PromocionService;
import services.TipoAtraccionService;
import services.TipoPromocionService;
import utils.Mensajes;

@WebServlet("/promocion/editar.do")
public class EditarPromocionServlet extends HttpServlet {
	private static String TIPO_ABSOLUTA = "absoluta";
	private static String TIPO_PORCENTUAL = "porcentual";
	
	private static final long serialVersionUID = 7598291131560345626L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;
	private TipoAtraccionService tipoAtraccionService;
	private TipoPromocionService tipoPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.tipoAtraccionService = new TipoAtraccionService();
		this.tipoPromocionService = new TipoPromocionService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		ArrayList<TipoPromocion> tiposPromo = new ArrayList<>();
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		
		try {
			tiposAtraccion = this.tipoAtraccionService.listarActivos();
			tiposPromo = this.tipoPromocionService.listarActivos();
			atracciones = this.atraccionService.listarActivos();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("tiposPromo", tiposPromo);
		req.setAttribute("atracciones", atracciones);
		req.setAttribute("tiposAtraccion", tiposAtraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promocion/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;
		double descuento;
		String tipoPromo = req.getParameter("tipoPromo");
		int atraccionGratis = Integer.parseInt(req.getParameter("atraccionGratis"));
		//double costoTotal;
		//double duracionTotal;

		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		try {
			descuento = Double.parseDouble(req.getParameter("descuento"));
		} catch (NumberFormatException e) {
			descuento = -1;
		}
		
		/*try {
			costoTotal = Double.parseDouble(req.getParameter("costo"));
		} catch (NumberFormatException e) {
			costoTotal = -1;
		}

		try {
			duracionTotal = Double.parseDouble(req.getParameter("duracion"));
		} catch (NumberFormatException e) {
			duracionTotal = -1;
		}*/
		
		
		Promocion promocion = null;
		ArrayList<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		ArrayList<TipoPromocion> tiposPromo = new ArrayList<TipoPromocion>();
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		

		if (tipoPromo.equalsIgnoreCase(TIPO_PORCENTUAL)) {
			promocion = new PromocionPorcentual(id, tipoPromo, descuento, atracciones, true);
		} else if (tipoPromo.equalsIgnoreCase(TIPO_ABSOLUTA)) {
			promocion = new PromocionAbsoluta(id, tipoPromo, descuento, atracciones, true);
		} else { // AxB
			try {
				promocion = new PromocionAxB(id, tipoPromo, this.atraccionService.buscar(atraccionGratis), atracciones,
						true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		ArrayList<String> errores = new ArrayList<String>();
		
		try {
			errores = promocion.validar();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		if (errores.isEmpty()) {
			try {
				if (id == 0) {
					this.promocionService.insertar(promocion);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ALTA, "promoción"));
					
				} else {
					this.promocionService.actualizar(promocion);
					req.getSession(false).setAttribute("mensaje", String.format(Mensajes.EXITO_ACTUALIZACION, "promoción"));
					
				}
				
				resp.sendRedirect("/star-wars-park/promocion/index.do");

			} catch (SQLException e) {
				e.printStackTrace();
			}			
			
			
		} else {
			try {
				tiposAtraccion = this.tipoAtraccionService.listarActivos();
				tiposPromo = this.tipoPromocionService.listarActivos();
				atracciones = this.atraccionService.listarActivos();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			req.setAttribute("errores", errores);
			req.setAttribute("promocion", promocion);
			req.setAttribute("tiposAtraccion", tiposAtraccion);
			req.setAttribute("atracciones", atracciones);
			req.setAttribute("tiposPromo", tiposPromo);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promocion/editar.jsp");
			dispatcher.forward(req, resp);
			//resp.sendRedirect("/star-wars-park/usuario/editar.do?id=" + usuario.getId());
		}
	}
}
