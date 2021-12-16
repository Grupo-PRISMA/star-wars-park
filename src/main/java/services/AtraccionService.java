package services;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Atraccion;
import persistence.DAO;


public class AtraccionService {

	public ArrayList<Atraccion> listar() throws SQLException {
		return DAO.getAtraccionDAO().buscarTodo();
	}
	
	public void borrar(int id) throws SQLException {
		DAO.getAtraccionDAO().borrarPorId(id);
	}
	
//	public void actualizar(int id, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//		DAO.getUsuarioDAO().actualizar(id, clave, nombre, preferencia, presupuesto, tiempo, admin);
//	}
	public void actualizar(Atraccion atraccion) throws SQLException {
		DAO.getAtraccionDAO().actualizar(atraccion);
	}

//	public void insertar(String usuario, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//		DAO.getUsuarioDAO().insertar(usuario, clave, nombre, preferencia, presupuesto, tiempo, admin);
//	}
	public void insertar(Atraccion atraccion) throws SQLException {
		DAO.getAtraccionDAO().insertar(atraccion);
	}
/*
	public Attraction create(String name, Integer cost, Double duration, Integer capacity) {

		Attraction attraction = new Attraction(-1, name, cost, duration, capacity);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Attraction update(Integer id, String name, Integer cost, Double duration, Integer capacity) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}*/

	
	public ArrayList<Atraccion> buscarPorTipo(String tipo) throws SQLException {
		return DAO.getAtraccionDAO().buscarTodoPorTipo(tipo);
	}

	public ArrayList<Atraccion> buscarPorOtroTipo(String tipo) throws SQLException {
		return DAO.getAtraccionDAO().buscarTodoPorOtroTipo(tipo);
	}
	
	public Atraccion buscar(int id) throws SQLException {
		return DAO.getAtraccionDAO().buscarPorId(id);
	}
	
	public ArrayList<Atraccion> listarActivos() throws SQLException {
		return DAO.getAtraccionDAO().buscarActivos();
	}

}
