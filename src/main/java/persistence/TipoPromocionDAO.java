package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoAtraccion;
//import model.TipoAtraccion;
import model.TipoPromocion;

public class TipoPromocionDAO extends DAOGenerico<TipoPromocion> {
	
	@Override
	public TipoPromocion armarObjeto(ResultSet resultado) throws SQLException {
		return new TipoPromocion(
							resultado.getString("tipo"),
							resultado.getBoolean("activo")
							);
							
	}
	
	public ArrayList<TipoPromocion> buscarTodo() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM tipo_de_promocion ORDER BY tipo ASC");
	}
	
	public int borrarPorTipo(String tipo) throws SQLException {
		String sql = "UPDATE"
						+ " tipo_de_promocion"
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
						+ " tipo_de_promocion"
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
				+ " tipo_de_promocion(tipo)"
			+ " VALUES("
				+ "'" + tipo + "')";

		Connection conexion = ConnectionProvider.getConexion();
		PreparedStatement declaracion = conexion.prepareStatement(sql);
		
		return declaracion.executeUpdate();		
	}
	
	public ArrayList<TipoPromocion> buscarActivos() throws SQLException {
		return super.ejecutarSelect("SELECT * FROM tipo_de_promocion WHERE activo = 1 ORDER BY tipo ASC");
	}

}
