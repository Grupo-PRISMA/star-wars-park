package model;

import java.util.ArrayList;


public class PromocionPorcentual extends Promocion {
	private double descuento;
	private String nombre;

	public PromocionPorcentual(int id, String tipo, double descuento, ArrayList<Atraccion> atracciones, boolean activo) {
		super(id, tipo, atracciones, activo);
		this.descuento = descuento;
		this.nombre = "PORCENTUAL";
	}

	public double getCostoTotal() {
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return Math.round(costoTotal * (1 - descuento));
	}

	public double getDescuento() {
		return this.descuento;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	/*@Override
	public String toString() {
		return "[" + this.getNombre() + ", "+ atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "]\n-Duración: "
				+ this.getDuracionTotal() + " horas" + "\n-Precio original: $" + super.getCostoSinDescuento()
				+ "\n-Precio con descuento: $" + this.getCostoTotal();
	}*/
	
	@Override
	public String getBonificacion() {
		return Double.toString(this.getDescuento() * 100) + "%";
	}
}