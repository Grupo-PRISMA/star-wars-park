package services;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import model.Itinerario;
//import model.TipoAtraccion;
import model.Usuario;
//import model.Attraction;
//import persistence.AttractionDAO;
import persistence.DAO;
//import persistence.commons.DAOFactory;

public class ItinerarioService {

	// TODO lo dejo comentado por si se usaba
	/*public ArrayList<Itinerario> buscar() throws SQLException {
		return DAO.getItinerarioDAO().buscarTodo();
	}*/
	
	public ArrayList<Itinerario> buscarPorIdUsuario(int idUsuario) throws SQLException {
		return DAO.getItinerarioDAO().buscarTodoPorIdUsuario(idUsuario);
	}

	public void insertar(Itinerario itinerario) throws SQLException {
		DAO.getItinerarioDAO().insertar(itinerario);
	}
	
	public ArrayList<Itinerario> buscarAtracciones() throws SQLException {
		return DAO.getItinerarioDAO().buscarPorTipo("A");
	}
	
	public ArrayList<Itinerario> buscarPromociones() throws SQLException {
		return DAO.getItinerarioDAO().buscarPorTipo("P");
	}

}
