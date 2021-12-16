package model;

import java.sql.SQLException;
import java.util.ArrayList;
import persistence.DAO;
import utils.Mensajes;


public abstract class Promocion {

	protected int id;
	protected String tipo;
	protected ArrayList<Atraccion> atracciones = new ArrayList<>();
	public boolean activo;

	public Promocion(int id, String tipo, ArrayList<Atraccion> atracciones, boolean activo) {
		this.id = id;
		this.tipo = tipo;
		this.atracciones = atracciones;
		this.activo = activo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public double getCostoTotal() {
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal - this.getDescuento();
	}

	public double getCostoSinDescuento() {
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal;
	}

	public double getDuracionTotal() {
		double duracionTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}

		return duracionTotal;
	}

	public abstract double getDescuento();
	
	public abstract String getBonificacion();

	public boolean hayCupo() {
		boolean hay = true;

		for (Atraccion atraccion : this.atracciones) {
			hay &= atraccion.hayCupo();
		}

		return hay;
	}

	public void bajarCupo() {
		for (Atraccion atraccion : this.atracciones) {
			atraccion.bajarCupo();
			try {
				DAO.getAtraccionDAO().actualizar(atraccion);
			} catch (SQLException e) {
				System.out.println("Error actualizando cupo de promocion " + this.id + ", atraccion " + atraccion.getId());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> nombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<String>();

		for (Atraccion atraccion : this.atracciones) {
			nombres.add(atraccion.getNombre());
		}
		return nombres;
	}

	@Override
	public String toString() {
		String texto = this.nombreAtracciones().toString();

		return texto;
	}
	
	public int getId() {
		return this.id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getTipoPromo() {
		return this.getClass().toString().replaceAll("class model.Promocion", "");
	}
	
	public String getNombre() {
		return this.nombreAtracciones().toString();
	}

	public ArrayList<Integer> getIdAtracciones() {
		ArrayList<Integer> ids = new ArrayList<>();
		for (Atraccion atraccion : this.atracciones) {
			ids.add(atraccion.getId());
		}
		
		return ids;
	}

	public ArrayList<String> validar() throws SQLException {
		ArrayList<String> errores = new ArrayList<String>();
	
		if (this.getDescuento() < 1) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Bonificación"));
			
			//errores.add("El nombre no puede ser vacio");
		}
		
		return errores;
	}
	
}
