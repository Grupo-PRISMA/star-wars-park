package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import persistence.commons.ConnectionProvider;

public class ConnectionProvider {

	private static String url;// = "jdbc:sqlite:TP2.db";
	private static Connection conexion;

	static {
		Properties properties = new Properties();
		
		try {
			properties.load(ConnectionProvider.class.getResourceAsStream("/env.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		url = properties.getProperty("datasource");
	}
	
	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return prop;
	}
	
	/*public static Connection getConexion() throws SQLException {
		if (conexion == null) {
			conexion = DriverManager.getConnection(url);
		}

		return conexion;
	}*/
		
	public static Connection getConexion() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		if (conexion == null) {
			conexion = DriverManager.getConnection(url);
		}
		
		return conexion;
	}
}
