package model;

public class TipoPromocion {
	private String tipo;
	private boolean activo;

	public TipoPromocion(String tipo, boolean activo) {
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
