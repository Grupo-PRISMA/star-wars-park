package controller.itinerario;

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
import model.Atraccion;
import model.Itinerario;
import model.TipoAtraccion;
import model.Usuario;
import services.AtraccionService;
import services.ItinerarioService;
//import model.Attraction;
//import services.AttractionService;
import services.TipoAtraccionService;

@WebServlet("/itinerario")
public class ItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private ItinerarioService itinerarioService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Itinerario> itinerario = new ArrayList<>();
		
		try {
			Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
			itinerario = this.itinerarioService.buscarPorIdUsuario(usuario.getId());
			
			for (int i = 0; i < itinerario.size(); i++) {
				Itinerario it = itinerario.get(i);
				ArrayList<Integer> ids = new Gson().fromJson(it.getAtracciones(), new TypeToken<ArrayList<Integer>>(){}.getType());
				ArrayList<String> nombres = new ArrayList<>();
				
				for (int id : ids) {
					Atraccion atraccion = this.atraccionService.buscar(id);
					nombres.add(atraccion.getNombre());
				}
				
				it.setAtracciones(new Gson().toJson(nombres).replace("[", "").replace("]", "").replace("\"", ""));
				itinerario.set(i, it);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("itinerario", itinerario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerario/index.jsp");
		dispatcher.forward(req, resp);
	}
}
