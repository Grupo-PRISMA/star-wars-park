package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoAtraccion;

public class TipoAtraccionDAO extends DAOGenerico<TipoAtraccion> {
	
	@Override
	public TipoAtraccion armarObjeto(ResultSet resultado) throws SQLException {
		return new TipoAtraccion(
							resultado.getString("tipo"),
							resultado.getBoolean("activo")
							);
							
	}
	
	public ArrayList<TipoAtraccion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM tipo_de_atraccion ORDER BY tipo ASC");
	}
	
	public int borrarPorTipo(String tipo) throws SQLException {
		String sql = "UPDATE"
						+ " tipo_de_atraccion"
					+ " SET"
						+ " activo = ((activo | 1) - (activo & 1))"
					+ " WHERE"
						+ " tipo = '" + tipo + "'";
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	/*
	public Usuario buscarPorId(int id) throws SQLException {
		return super.ejecutarSelect("SELECT * FROM visitante WHERE id = " + id).get(0);
	}
	*/
	
	public int actualizar(String tipo, String nuevo) throws SQLException {
		String sql = "UPDATE"
						+ " tipo_de_atraccion"
					+ " SET"
						+ " tipo = '" + nuevo + "'"
					+ " WHERE"
						+ " tipo = '" + tipo + "'";
		
		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();
	}
	
	public int insertar(String tipo) throws SQLException {
		String sql = "INSERT INTO"
				+ " tipo_de_atraccion(tipo)"
			+ " VALUES("
				+ "'" + tipo + "')";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
	public TipoAtraccion buscarPorTipo(String tipo) throws SQLException {
		ArrayList<TipoAtraccion> tipos = super.ejecutarSelect("SELECT * FROM tipo_de_atraccion WHERE tipo = '" + tipo + "'");
		return tipos.isEmpty() ? null : tipos.get(0);
	}
	
	public ArrayList<TipoAtraccion> buscarActivos() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM tipo_de_atraccion WHERE activo = 1 ORDER BY tipo ASC");
	}

}
