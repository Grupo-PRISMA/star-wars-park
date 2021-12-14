package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.DAO;
import persistence.UsuarioDAO;

public class ComprarAtraccionService {

	AtraccionDAO atraccionDAO = DAO.getAtraccionDAO();
	UsuarioDAO usuarioDAO = DAO.getUsuarioDAO();

	public Map<String, String> comprar(Integer userId, Integer atraccionId) throws SQLException {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.buscarPorId(userId);
		Atraccion atraccion = atraccionDAO.buscarPorId(atraccionId);

		if (!atraccion.tieneCupo(1)) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.puedePagar(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!usuario.tieneTiempo(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.addToItinerary(atraccion);
			atraccion.descuentaCupo(1);

			// no grabamos para no afectar la base de pruebas
			atraccionDAO.actualizar(atraccion);
			usuarioDAO.actualizar(usuario);
		}

		return errors;

	}

}
