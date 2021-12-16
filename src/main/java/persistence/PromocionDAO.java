package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;

public class PromocionDAO extends DAOGenerico<Promocion> {
	private static String TIPO_ABSOLUTA = "absoluta";
	private static String TIPO_PORCENTUAL = "porcentual";
	private static String TIPO_AxB = "axb";
	
	public ArrayList<Promocion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM promocion");
	}
	
	public Promocion armarObjeto(ResultSet resultado) throws SQLException {
		int id = resultado.getInt("id");
		String tipoPromocion = resultado.getString("fk_tipo_promo");
		String tipoAtraccion = resultado.getString("fk_tipo_atraccion");
		Promocion promocion;
		ArrayList<Atraccion> atracciones = DAO.getAtraccionDAO().buscarTodoPorIdPromocion(id);
		boolean activo = resultado.getBoolean("activo");
		
		if (tipoPromocion.equalsIgnoreCase(TIPO_PORCENTUAL)) {
			promocion = new PromocionPorcentual(
					id,
					tipoAtraccion,
					this.getDescuento(id),
					atracciones,
					activo
				);
		} else if (tipoPromocion.equalsIgnoreCase(TIPO_ABSOLUTA)) {
			promocion = new PromocionAbsoluta(
					id,
					tipoAtraccion,
					this.getDescuento(id),
					atracciones,
					activo
				);
		} else { // AxB
			promocion = new PromocionAxB(
					id,
					tipoAtraccion,
					DAO.getAtraccionDAO().buscarGratisPorIdPromocion(id),
					atracciones,
					activo
				);
		}
		
		return promocion;
	}
	
	private double getDescuento(int id) throws SQLException {
		ResultSet resultado = super.getResultsetSelect("SELECT descuento FROM promocion_descuento WHERE fk_id_promocion = " + id);
		resultado.next();
		
		return resultado.getDouble("descuento");
	}
	
	public ArrayList<Promocion> buscarTodoPorIdVisitante(int idVisitante) throws SQLException {
		String sql = "SELECT * FROM promocion"
				+ " JOIN itinerario_promocion ON promocion.id = itinerario_promocion.fk_id_promocion"
				+ " WHERE itinerario_promocion.fk_id_itinerario = " + idVisitante;
		return super.ejecutarSelect(sql);
	}
	
	public Promocion buscarPorId(int id) throws SQLException {
		ArrayList<Promocion> promociones = super.ejecutarSelect("SELECT * FROM promocion WHERE id = " + id);
		return promociones.isEmpty() ? null : promociones.get(0);
	}
	
	public int borrarPorId(int id) throws SQLException {
		String sql = "UPDATE"
						+ " promocion"
					+ " SET"
						+ " activo = ((activo | 1) - (activo & 1))"
					+ " WHERE"
						+ " id = " + id;
	
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int actualizar(Promocion promocion) throws SQLException {
		String sql = "UPDATE"
						+ " promocion"
					+ " SET"
						+ " fk_tipo_promo = '" + promocion.getTipoPromo() + "'" 
						+ ", fk_tipo = '" + promocion.getTipo() + "'"
					+ " WHERE"
						+ " id = " + promocion.getId();
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int insertar(PromocionAxB promocion) throws SQLException {
		int id = this.agregar(promocion);
		
		String sql = "INSERT INTO"
				+ " promocion_atraccion_gratis (fk_id_promocion, fk_id_atraccion)"
			+ " VALUES("
				 + id +
			", " + promocion.getAtraccionGratis().getId()+ ")"
				;
		
		System.out.println(sql);
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int insertar(PromocionPorcentual promocion) throws SQLException {
		int id = this.agregar(promocion);
		
		String sql = "INSERT INTO"
				+ " promocion_descuento (fk_id_promocion, descuento)"
			+ " VALUES("
				 + id +
			", " + promocion.getDescuento()+ ")"
				;
		System.out.println(sql);
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int insertar(PromocionAbsoluta promocion) throws SQLException {
		int id = this.agregar(promocion);
		
		String sql = "INSERT INTO"
				+ " promocion_descuento (fk_id_promocion, descuento)"
			+ " VALUES("
				 + id +
			", " + promocion.getDescuento()+ ")"
				;
		
		System.out.println(sql);
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	private int agregar(Promocion promocion) throws SQLException {
		String sql = "INSERT INTO"
				+ " promocion (fk_tipo_promo, fk_tipo)"
			+ " VALUES("
				+ "'" + promocion.getTipoPromo() + "'"
				+ ", '" + promocion.getTipo() + "')"
				;

		System.out.println(sql);
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		declaracion.executeUpdate();
		
		int id = declaracion.getGeneratedKeys().getInt("id");
		
		for (Atraccion atraccion : promocion.getAtracciones()) {
			sql = "INSERT INTO"
					+ " promocion_atraccion (fk_id_promocion, fk_id_atraccion)"
				+ " VALUES("
					 + id +
				", " + atraccion.getId() + ")"
					;
			
			System.out.println(sql);
			
			declaracion = conexion.prepareStatement(sql);
			declaracion.executeUpdate();
		}
		
		return id;
	}
	
	/*public void insertarEnItinerario(int idItinerario) {
		
	}*/

	public ArrayList<Promocion> buscarTodoPorTipo(String tipo) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM promocion WHERE fk_tipo_atraccion = '" + tipo + "'");
	}
	
	public ArrayList<Promocion> buscarTodoPorOtroTipo(String tipo) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM promocion WHERE fk_tipo_atraccion != '" + tipo + "'");
	}
	
	public ArrayList<Integer> buscarIdsPorIdAtraccion(int idAtraccion) throws SQLException {
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT fk_id_promocion FROM promocion_atraccion WHERE fk_id_atraccion = " + idAtraccion + " GROUP BY fk_id_promocion";

		ResultSet resultado = super.getResultsetSelect(sql);

		while (resultado.next()) {
			ids.add(resultado.getInt("fk_id_promocion"));
		}

		return ids;
	}

}
