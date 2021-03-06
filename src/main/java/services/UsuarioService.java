package services;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

//import model.TipoAtraccion;
import model.Usuario;
//import model.Attraction;
//import persistence.AttractionDAO;
import persistence.DAO;
//import persistence.commons.DAOFactory;

public class UsuarioService {

	public ArrayList<Usuario> listar() throws SQLException {
		return DAO.getUsuarioDAO().buscarTodo();
	}
	
	public void borrar(int id) throws SQLException {
		DAO.getUsuarioDAO().borrarPorId(id);
	}
	
//	public void actualizar(int id, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//		DAO.getUsuarioDAO().actualizar(id, clave, nombre, preferencia, presupuesto, tiempo, admin);
//	}
	public void actualizar(Usuario usuario) throws SQLException {
		DAO.getUsuarioDAO().actualizar(usuario);
	}

//	public void insertar(String usuario, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//		DAO.getUsuarioDAO().insertar(usuario, clave, nombre, preferencia, presupuesto, tiempo, admin);
//	}
	public void insertar(Usuario usuario) throws SQLException {
		DAO.getUsuarioDAO().insertar(usuario);
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

	public Usuario buscar(int id) throws SQLException {
		return DAO.getUsuarioDAO().buscarPorId(id);
	}

}
