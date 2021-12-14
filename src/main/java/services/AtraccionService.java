package services;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.DAO;

public class AtraccionService {

	public List<Atraccion> buscarTodo() throws SQLException {
		return DAO.getAtraccionDAO().buscarTodo();
	}

	public Atraccion crear(String nombre, String fk_tipo, Integer costo, Double duracion, Integer cupo,
			Integer activo, String info) throws SQLException {

		Atraccion atraccion = new Atraccion(-1, nombre, fk_tipo, costo, duracion, cupo, activo, info);

		if (atraccion.isValid()) {
			AtraccionDAO attractionDAO = DAO.getAtraccionDAO();
			attractionDAO.insertar(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion actualizar(Integer id, String nombre, String fk_tipo, Integer costo, Double duracion, Integer cupo,
			Integer activo, String info) throws SQLException {

		AtraccionDAO atraccionDAO = DAO.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.buscarPorId(id);

		atraccion.setNombre(nombre);
		atraccion.setTipoAtraccion(fk_tipo);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupo(cupo);
		atraccion.setActivo(activo);
		atraccion.setInfo(info);

		if (atraccion.isValid()) {
			atraccionDAO.actualizar(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public void borrarPorId(Integer id) throws SQLException {
		Atraccion atraccion = new Atraccion(id, "", "", 0.0, 0.0, 0, 0, "");

		AtraccionDAO atraccionDAO = DAO.getAtraccionDAO();
		atraccionDAO.borrarPorId(atraccion.getId());
	}

	public Atraccion buscarPorId(Integer id) throws SQLException {
		AtraccionDAO atraccionDAO = DAO.getAtraccionDAO();
		return atraccionDAO.buscarPorId(id);
	}

}
