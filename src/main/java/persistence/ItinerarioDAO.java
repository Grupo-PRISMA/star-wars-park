package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Itinerario;
import model.Usuario;
//import persistence.ConnectionProvider;


public class ItinerarioDAO extends DAOGenerico<Itinerario> {
	
	@Override
	public Itinerario armarObjeto(ResultSet resultado) throws SQLException {
		return new Itinerario(
					resultado.getInt("id_visitante"), 
					resultado.getString("atracciones"), 
					resultado.getDouble("costo"), 
					resultado.getDouble("tiempo"),
					resultado.getInt("id_lugar"),
					resultado.getString("tipo_lugar")
		);
	}
	
	public ArrayList<Itinerario> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM itinerario");
	}
	
	public int insertar(Itinerario itinerario) throws SQLException {
		String sql = "INSERT INTO"
				+ " itinerario (id_visitante, atracciones, costo, tiempo, id_lugar, tipo_lugar)"
			+ " VALUES("
				+ itinerario.getIdVisitante()
				+ ", '" + itinerario.getAtracciones() + "'"
				+ ", " + itinerario.getCosto()
				+ ", " + itinerario.getTiempo()
				+ ", " + itinerario.getIdLugar()
				+ ", '" + itinerario.getTipoLugar() + "')";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
//	public Usuario buscarPorId(int id) throws SQLException {
//		return super.ejecutarSelect("SELECT * FROM visitante WHERE id = " + id).get(0);
//	}
//	
////	public int actualizar(int id, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
////		
////		String sql = "UPDATE"
////						+ " visitante"
////					+ " SET"
////						+ " clave = '" + clave + "'"
////						+ ", nombre = '" + nombre + "'"
////						+ ", fk_preferencia = '" + preferencia + "'"
////						+ ", presupuesto = " + presupuesto
////						+ ", tiempo = " + tiempo
////						+ ", admin = " +  admin
////					+ " WHERE"
////						+ " id = " + id;
//		public int actualizar(Usuario usuario) throws SQLException {
//			String sql = "UPDATE"
//							+ " visitante"
//						+ " SET"
//							+ " clave = '" + usuario.getClave() + "'"
//							+ ", nombre = '" + usuario.getNombre() + "'"
//							+ ", fk_preferencia = '" + usuario.getPreferencia() + "'"
//							+ ", presupuesto = " + usuario.getPresupuesto()
//							+ ", tiempo = " + usuario.getTiempoDisponibleHs()
//							+ ", admin = " +  (usuario.isAdmin() ? 1 : 0)
//						+ " WHERE"
//							+ " id = " + usuario.getId();
//		
//		Connection conexion = ConnectionProvider.getConexion();
//		PreparedStatement declaracion = conexion.prepareStatement(sql);
//		
//		return declaracion.executeUpdate();
//	}
//	
//	
//	/*public int actualizar(int id, String clave, String nombre, double presupuesto, double tiempo, boolean admin) throws SQLException {
//		
//		String sql = "UPDATE"
//						+ " visitante"
//					+ " SET"
//						+ " presupuesto = " + visitante.getPresupuesto()
//						+ ", tiempo = " + visitante.getTiempoDisponibleHs()
//					+ " WHERE"
//						+ " id = " + visitante.getId();
//		
//		Connection conexion = ConnectionProvider.getConexion();
//		PreparedStatement declaracion = conexion.prepareStatement(sql);
//		
//		return declaracion.executeUpdate();
//	}*/
//	
//	public Usuario buscarPorUsuario(String usuario) throws SQLException {
//		ArrayList<Usuario> usuarios = super.ejecutarSelect("SELECT * FROM visitante WHERE usuario = '" + usuario + "'");
//		return usuarios.isEmpty() ? null : usuarios.get(0); 
//	}
//	
//	//public int insertar(String usuario, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//	public int insertar(Usuario usuario) throws SQLException {
////		String sql = "INSERT INTO"
////				+ " visitante (usuario, clave, nombre, fk_preferencia, presupuesto, tiempo, admin)"
////			+ " VALUES("
////				+ "'" + usuario + "'"
////				+ ", '" + clave + "'"
////				+ ", '" + nombre + "'"
////				+ ", '" + preferencia + "'"
////				+ ", " + presupuesto +
////				", " + tiempo +
////				", " + admin + ")";
//
//		String sql = "INSERT INTO"
//				+ " visitante (usuario, clave, nombre, fk_preferencia, presupuesto, tiempo, admin)"
//			+ " VALUES("
//				+ "'" + usuario.getUsuario() + "'"
//				+ ", '" + usuario.getClave() + "'"
//				+ ", '" + usuario.getNombre() + "'"
//				+ ", '" + usuario.getPreferencia() + "'"
//				+ ", " + usuario.getPresupuesto() +
//				", " + usuario.getTiempoDisponibleHs() +
//				", " + usuario.isAdmin() + ")";
//
//		Connection conexion = ConnectionProvider.getConexion();
//		PreparedStatement declaracion = conexion.prepareStatement(sql);
//		
//		return declaracion.executeUpdate();		
//	}
//	
//	public int borrarPorId(int id) throws SQLException {
//		String sql = "UPDATE"
//						+ " visitante"
//					+ " SET"
//						+ " activo = ((activo | 1) - (activo & 1))"
//					+ " WHERE"
//						+ " id = " + id;
//		
//		Connection conexion = ConnectionProvider.getConexion();
//		PreparedStatement declaracion = conexion.prepareStatement(sql);
//		
//		return declaracion.executeUpdate();
//	}
	
	public ArrayList<Itinerario> buscarPorTipo(String tipo, int idUsusario) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM itinerario WHERE id_visitante = " + idUsusario + " AND tipo_lugar = '" + tipo + "'");
	}

	public ArrayList<Itinerario> buscarTodoPorIdUsuario(int idUsuario) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM itinerario WHERE id_visitante = " + idUsuario);
	}
}
