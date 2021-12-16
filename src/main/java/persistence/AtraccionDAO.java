package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;
import model.TipoAtraccion;
import model.Usuario;


public class AtraccionDAO extends DAOGenerico<Atraccion> {

	public Atraccion armarObjeto(ResultSet resultado) throws SQLException {
		return new Atraccion(
					resultado.getInt("id"), 
					resultado.getString("nombre"), 
					resultado.getString("fk_tipo"),
					resultado.getDouble("costo"), 
					resultado.getDouble("duracion"), 
					resultado.getInt("cupo"),
					resultado.getBoolean("activo")
		);
	}

	public ArrayList<Atraccion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion ORDER BY costo DESC, duracion DESC");
	}
	
	public Atraccion buscarPorId(int id) throws SQLException {
		ArrayList<Atraccion> atracciones = super.ejecutarSelect("SELECT * FROM atraccion WHERE id = " + id);	
		return atracciones.isEmpty() ? null : atracciones.get(0);
	}

	public int actualizar(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE"
						+ " atraccion"
					+ " SET"
						+ " nombre = '" + atraccion.getNombre() + "'"
						+ ", fk_tipo = '" + atraccion.getTipo() + "'"
						+ ", costo = " + atraccion.getCosto()
						+ ", duracion = " + atraccion.getDuracionHs()
						+ ", cupo = " + atraccion.getCupoPersonas()
					+ " WHERE"
						+ " id = " + atraccion.getId();
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public ArrayList<Atraccion> buscarTodoPorIdPromocion(int idPromocion) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN promocion_atraccion ON atraccion.id = promocion_atraccion.fk_id_atraccion"
				+ " WHERE promocion_atraccion.fk_id_promocion = " + idPromocion;
		return super.ejecutarSelect(sql);
	}
	
	public Atraccion buscarGratisPorIdPromocion(int idPromocion) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN promocion_atraccion_gratis ON atraccion.id = promocion_atraccion_gratis.fk_id_atraccion"
				+ " WHERE promocion_atraccion_gratis.fk_id_promocion = " + idPromocion;
		return super.ejecutarSelect(sql).get(0);
	}
	
	public ArrayList<Atraccion> buscarTodoPorIdVisitante(int idVisitante) throws SQLException {
		String sql = "SELECT * FROM atraccion"
				+ " JOIN itinerario_atraccion ON atraccion.id = itinerario_atraccion.fk_id_atraccion"
				+ " WHERE itinerario_atraccion.fk_id_itinerario = " + idVisitante;
		return super.ejecutarSelect(sql);
	}
	
	public int borrarPorId(int id) throws SQLException {
		String sql = "UPDATE"
						+ " atraccion"
					+ " SET"
						+ " activo = ((activo | 1) - (activo & 1))"
					+ " WHERE"
						+ " id = " + id;
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int insertar(Atraccion atraccion) throws SQLException {
		
		String sql = "INSERT INTO"
				+ " atraccion (nombre, fk_tipo, costo, duracion, cupo)"
			+ " VALUES("
				+ "'" + atraccion.getNombre() + "'"
				+ ", '" + atraccion.getTipo() + "'"
				+ ", " + atraccion.getCosto() +
				", " + atraccion.getDuracionHs() +
				", " + atraccion.getCupoPersonas() + ")";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
	public ArrayList<Atraccion> buscarTodoPorTipo(String tipo) throws SQLException {
		String sql = "SELECT * FROM atraccion WHERE fk_tipo = '" + tipo + "'";
		return super.ejecutarSelect(sql);
	}

	public ArrayList<Atraccion> buscarTodoPorOtroTipo(String tipo) throws SQLException {
		String sql = "SELECT * FROM atraccion WHERE fk_tipo != '" + tipo + "'";
		return super.ejecutarSelect(sql);
	}

	
	public ArrayList<Atraccion> buscarActivos() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion WHERE activo = 1 ORDER BY fk_tipo ASC");
	}
	
}
