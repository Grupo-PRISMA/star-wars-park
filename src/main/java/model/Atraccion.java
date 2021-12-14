package model;

import java.util.HashMap;
import java.util.Map;

public class Atraccion {

	private int id;
	private String nombre;
	private String fk_tipo;
	private double costo;
	private double duracion;
	private int cupo;
	private int activo;
	private String info;

	private Map<String, String> errors;

	public Atraccion(int id, String nombre, String fk_tipo, double costo, double duracion, int cupo, int activo,
			String info) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fk_tipo = fk_tipo;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.activo = activo;
		this.info = info;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (duracion <= 0) {
			errors.put("duracion", "Debe ser positivo");
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getTipoAtraccion() {
		return fk_tipo;
	}

	public void setTipoAtraccion(String fk_tipo) {
		this.fk_tipo = fk_tipo;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	

	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", nombre=" + nombre + ", fk_tipo=" + fk_tipo + ", costo=" + costo
				+ ", duracion=" + duracion + ", cupo=" + cupo + ", activo=" + activo + ", info=" + info + "]";
	}

	public boolean tieneCupo(int i) {
		return cupo >= i;
	}

	public void descuentaCupo(int i) {
		this.cupo -= i;
	}

}
