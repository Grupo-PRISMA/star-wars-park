package model;

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
}
