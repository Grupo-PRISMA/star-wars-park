package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;
//import persistence.ConnectionProvider;


public class UsuarioDAO extends DAOGenerico<Usuario> {
	
	@Override
	public Usuario armarObjeto(ResultSet resultado) throws SQLException {
		return new Usuario(
					resultado.getInt("id"), 
					resultado.getString("nombre"), 
					resultado.getString("fk_preferencia"),
					resultado.getDouble("presupuesto"), 
					resultado.getDouble("tiempo"),
					resultado.getString("usuario"),
					resultado.getString("clave"),
					resultado.getBoolean("activo"),
					resultado.getBoolean("admin")
		);
	}
	
	public ArrayList<Usuario> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante ORDER BY UPPER(usuario) ASC");
	}
	
	public Usuario buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante WHERE id = " + id).get(0);
	}
	
//	public int actualizar(int id, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
//		
//		String sql = "UPDATE"
//						+ " visitante"
//					+ " SET"
//						+ " clave = '" + clave + "'"
//						+ ", nombre = '" + nombre + "'"
//						+ ", fk_preferencia = '" + preferencia + "'"
//						+ ", presupuesto = " + presupuesto
//						+ ", tiempo = " + tiempo
//						+ ", admin = " +  admin
//					+ " WHERE"
//						+ " id = " + id;
		public int actualizar(Usuario usuario) throws SQLException {
			String sql = "UPDATE"
							+ " visitante"
						+ " SET"
							+ " nombre = '" + usuario.getNombre() + "'"
							+ ", fk_preferencia = '" + usuario.getPreferencia() + "'"
							+ ", presupuesto = " + usuario.getPresupuesto()
							+ ", tiempo = " + usuario.getTiempoDisponibleHs()
							+ ", admin = " +  (usuario.isAdmin() ? 1 : 0);
			if(!usuario.getClave().equals("")) {
				sql += ", clave = '" + usuario.getClave() + "'";
			} 
			
			sql += " WHERE"
							+ " id = " + usuario.getId();
		
			System.out.println("prueba " + sql);
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
	
	public Usuario buscarPorUsuario(String usuario) throws SQLException {
		ArrayList<Usuario> usuarios = super.ejecutarSelect("SELECT * FROM visitante WHERE usuario = '" + usuario + "'");
		return usuarios.isEmpty() ? null : usuarios.get(0); 
	}
	
	//public int insertar(String usuario, String clave, String nombre, String preferencia, double presupuesto, double tiempo, int admin) throws SQLException {
	public int insertar(Usuario usuario) throws SQLException {
//		String sql = "INSERT INTO"
//				+ " visitante (usuario, clave, nombre, fk_preferencia, presupuesto, tiempo, admin)"
//			+ " VALUES("
//				+ "'" + usuario + "'"
//				+ ", '" + clave + "'"
//				+ ", '" + nombre + "'"
//				+ ", '" + preferencia + "'"
//				+ ", " + presupuesto +
//				", " + tiempo +
//				", " + admin + ")";

		String sql = "INSERT INTO"
				+ " visitante (usuario, clave, nombre, fk_preferencia, presupuesto, tiempo, admin)"
			+ " VALUES("
				+ "'" + usuario.getUsuario() + "'"
				+ ", '" + usuario.getClave() + "'"
				+ ", '" + usuario.getNombre() + "'"
				+ ", '" + usuario.getPreferencia() + "'"
				+ ", " + usuario.getPresupuesto() +
				", " + usuario.getTiempoDisponibleHs() +
				", " + usuario.isAdmin() + ")";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
	public int borrarPorId(int id) throws SQLException {
		String sql = "UPDATE"
						+ " visitante"
					+ " SET"
						+ " activo = ((activo | 1) - (activo & 1))"
					+ " WHERE"
						+ " id = " + id;
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}

}
