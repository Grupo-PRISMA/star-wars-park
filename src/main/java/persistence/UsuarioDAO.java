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
		return super.ejecutarSelect("SELECT * FROM visitante ORDER BY nombre ASC");
	}
	
	public Usuario buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante WHERE id = " + id).get(0);
	}
	
	public int actualizar(String usuario, String nuevo) throws SQLException {
		
		
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
	}
	
	public Usuario buscarPorUsuario(String usuario) throws SQLException {
		ArrayList<Usuario> usuarios = super.ejecutarSelect("SELECT * FROM visitante WHERE usuario = '" + usuario + "'");
		return usuarios.isEmpty() ? null : usuarios.get(0); 
	}
	
	public int insertar(String usuario) throws SQLException {
		String sql = "INSERT INTO"
				+ " visitante"
			+ " VALUES("
				+ "'" + usuario + "'
				+ "'" + usuario + "')";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
	public int borrarPorUsuario(String usuario) throws SQLException {
		String sql = "UPDATE"
						+ " visitantes"
					+ " SET"
						+ " activo = ((activo | 1) - (activo & 1))"
					+ " WHERE"
						+ " usuario = '" + usuario + "'";
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}

}
