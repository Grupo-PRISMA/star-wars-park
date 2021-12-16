package model;

import java.sql.SQLException;
import java.util.ArrayList;

import persistence.DAO;
import utils.Mensajes;

public class Atraccion {
	private int id;
	private String nombre;
	private String tipo;
	private double costo;
	private double duracionHs;
	private int cupoPersonas;
	private boolean activo;

	public Atraccion(int id, String nombre, String tipo, double costo, double horas, int cupoPersonas, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.duracionHs = horas;
		this.cupoPersonas = cupoPersonas;
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracionHs;
	}

	public int getCupoPersonas() {
		return this.cupoPersonas;
	}

	public boolean hayCupo() {
		return this.cupoPersonas > 0;
	}

	@Override
	public String toString() {
		/*return "Nombre = " + nombre + ", Tipo = " + tipo + ", Costo = " + costo + ", Duracion en Horas = " + duracionHs
				+ ", Cupo Personas = " + cupoPersonas + "\n";*/
		return this.nombre;
	}

	public void bajarCupo() {
		this.cupoPersonas--;
	}
	
	public int getId() {
		return this.id;
	}

	public double getDuracionHs() {
		return duracionHs;
	}

	public boolean isActivo() {
		return activo;
	}

	public double getDuracionTotal() {
		return this.getDuracion();
	}

	public double getCostoTotal() {
		return this.getCosto();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setDuracionHs(double duracionHs) {
		this.duracionHs = duracionHs;
	}

	public void setCupoPersonas(int cupoPersonas) {
		this.cupoPersonas = cupoPersonas;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public ArrayList<String> validar() throws SQLException {
		ArrayList<String> errores = new ArrayList<String>();
	
		if (this.nombre.length() < 1) {
			errores.add(String.format(Mensajes.ERROR_VACIO, "nombre"));
		}

		if (this.costo < 0) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Costo"));
		}

		if (this.duracionHs < 0) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Tiempo Disponible"));
		}
		
		if (this.cupoPersonas < 0) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Capacidad"));
		}

		if (DAO.getTipoAtraccionDAO().buscarPorTipo(this.tipo) == null) {
			errores.add(String.format(Mensajes.ERROR_INVALIDO, "Tipo de atracción"));
		}
			
		return errores;
	}
}
