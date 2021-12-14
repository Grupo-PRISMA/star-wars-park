package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;

public class AtraccionDAO extends DAOGenerico<Atraccion> {

	@Override
	public ArrayList<Atraccion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion ORDER BY UPPER(nombre) ASC");
	}

	@Override
	public Atraccion armarObjeto(ResultSet resultado) throws SQLException {
		return new Atraccion(
					resultado.getInt("id"), 
					resultado.getString("nombre"), 
					resultado.getString("fk_tipo"),
					resultado.getDouble("costo"), 
					resultado.getDouble("duracion"),
					resultado.getInt("cupo"),
					resultado.getInt("activo"),
					resultado.getString("info")
		);
	}
	
	public Atraccion buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM atraccion WHERE id = " + id).get(0);
	}
	
//	public int actualizar(int id, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//	
//	String sql = "UPDATE"
//					+ " visitante"
//				+ " SET"
//					+ " clave = '" + clave + "'"
//					+ ", nombre = '" + nombre + "'"
//					+ ", fk_preferencia = '" + preferencia + "'"
//					+ ", presupuesto = " + presupuesto
//					+ ", tiempo = " + tiempo
//					+ ", admin = " +  admin
//				+ " WHERE"
//					+ " id = " + id;
	public int actualizar(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE"
						+ " atraccion"
					+ " SET"
						+ "nombre = '" + atraccion.getNombre() + "'"
						+ ", fk_tipo = '" + atraccion.getTipoAtraccion() + "'"
						+ ", costo = " + atraccion.getCosto() + "'"
						+ ", duracion = " + atraccion.getDuracion() + "'"
						+ ", cupo = " +  atraccion.getCupo() + "'"
						+ ", activo = " +  atraccion.getActivo() + "'"
						+ ", info = " +  atraccion.getInfo() + "'"
					+ " WHERE"
						+ " id = " + atraccion.getId();
	
	Connection conexion = ConnectionProvider.getConexion();
	PreparedStatement declaracion = conexion.prepareStatement(sql);
	
	return declaracion.executeUpdate();
}


/*public int actualizar(int id, String clave, String nombre, double presupuesto, double tiempo, boolean admin) throws SQLException {
	
	String sql = "UPDATE"
					+ " visitante"
				+ " SET"
					+ " presupuesto = " + visitante.getPresupuesto()
					+ ", tiempo = " + visitante.getTiempoDisponibleHs()
				+ " WHERE"
					+ " id = " + visitante.getId();
	
	Connection conexion = ConnectionProvider.getConexion();
	PreparedStatement declaracion = conexion.prepareStatement(sql);
	
	return declaracion.executeUpdate();
}*/

public Atraccion buscarPorAtraccion(String atraccion) throws SQLException {
	ArrayList<Atraccion> atracciones = super.ejecutarSelect("SELECT * FROM atraccion WHERE nombre = '" + atraccion + "'");
	return atracciones.isEmpty() ? null : atracciones.get(0); 
}

//public int insertar(String usuario, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
public int insertar(Atraccion atraccion) throws SQLException {
//	String sql = "INSERT INTO"
//			+ " visitante (usuario, clave, nombre, fk_preferencia, presupuesto, tiempo, admin)"
//		+ " VALUES("
//			+ "'" + usuario + "'"
//			+ ", '" + clave + "'"
//			+ ", '" + nombre + "'"
//			+ ", '" + preferencia + "'"
//			+ ", " + presupuesto +
//			", " + tiempo +
//			", " + admin + ")";

	String sql = "INSERT INTO"
			+ " atraccion (nombre, fk_tipo, costo, duracion, cupo, activo, info)"
		+ " VALUES("
			+ "'" + atraccion.getNombre() + "'"
			+ ", '" + atraccion.getTipoAtraccion() + "'"
			+ ", '" + atraccion.getCosto() + "'"
			+ ", '" + atraccion.getDuracion() + "'"
			+ ", '" + atraccion.getCupo() + "'"
			+ ", '" + atraccion.getActivo() + "'"
	        + ", '" + atraccion.getInfo() + "')";
	Connection conexion = ConnectionProvider.getConexion();
	PreparedStatement declaracion = conexion.prepareStatement(sql);
	
	return declaracion.executeUpdate();		
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

}
