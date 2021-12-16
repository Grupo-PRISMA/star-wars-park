package model;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.Mensajes;

public class TipoAtraccion {
	private String tipo;
	private boolean activo;

	public TipoAtraccion(String tipo, boolean activo) {
		this.tipo = tipo;
		this.activo = activo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public ArrayList<String> validar() throws SQLException {
		ArrayList<String> errores = new ArrayList<String>();
		
		if (this.tipo.length() < 1) {
			errores.add(String.format(Mensajes.ERROR_VACIO, "tipo de atracción"));
		}
		
		return errores;
	}
}
