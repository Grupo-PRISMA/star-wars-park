package services;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
//import model.TipoAtraccion;
import model.Usuario;
//import model.Attraction;
//import persistence.AttractionDAO;
import persistence.DAO;
import persistence.PromocionDAO;
//import persistence.commons.DAOFactory;

public class PromocionService {
	private static String TIPO_ABSOLUTA = "absoluta";
	private static String TIPO_AxB = "axb";
	
	public ArrayList<Promocion> listar() throws SQLException {
		return DAO.getPromocionDAO().buscarTodo();
	}
	
	public void borrar(int id) throws SQLException {
		DAO.getPromocionDAO().borrarPorId(id);
	}

	public void actualizar(Promocion promocion) throws SQLException {
		DAO.getPromocionDAO().actualizar(promocion);
	}

	public void insertar(PromocionAbsoluta promocion) throws SQLException {
		DAO.getPromocionDAO().insertar(promocion);
	}
	
	public void insertar(PromocionAxB promocion) throws SQLException {
		DAO.getPromocionDAO().insertar(promocion);
	}
	
	public void insertar(PromocionPorcentual promocion) throws SQLException {
		DAO.getPromocionDAO().insertar(promocion);
	}
	
	public void insertar(Promocion promocion) throws SQLException {
		if (promocion.getTipoPromo().equalsIgnoreCase(TIPO_ABSOLUTA)) {
			DAO.getPromocionDAO().insertar((PromocionAbsoluta)promocion);
		} else if (promocion.getTipoPromo().equalsIgnoreCase(TIPO_AxB)) {
			DAO.getPromocionDAO().insertar((PromocionAxB)promocion);
		} else {
			DAO.getPromocionDAO().insertar((PromocionPorcentual)promocion);
		}
	}

	public ArrayList<Promocion> buscarPorTipo(String tipo) throws SQLException {
		return DAO.getPromocionDAO().buscarTodoPorTipo(tipo);
	}

	public ArrayList<Promocion> buscarPorOtroTipo(String tipo) throws SQLException {
		return DAO.getPromocionDAO().buscarTodoPorOtroTipo(tipo);
	}

	public Promocion buscar(int id) throws SQLException {
		return DAO.getPromocionDAO().buscarPorId(id);
	}

	public ArrayList<Integer> buscarIdsPorIdAtraccion(int idAtraccion) throws SQLException {
		return DAO.getPromocionDAO().buscarIdsPorIdAtraccion(idAtraccion);
	}
}
