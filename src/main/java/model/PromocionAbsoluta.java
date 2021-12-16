package model;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.Mensajes;


public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(int id, String tipo, double descuento, ArrayList<Atraccion> atracciones, boolean activo) {
		super(id, tipo, atracciones, activo);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return this.descuento;
	}
	
	@Override
	public String getBonificacion() {
		return Double.toString(this.getDescuento());
	}

	/*@Override
	public String toString() {
		return "" + atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "\n-Duración: "
				+ this.getDuracionTotal() + " horas" + "\n-Precio original: $" + super.getCostoSinDescuento()
				+ "\n-Precio con descuento: $" + this.getCostoTotal() + " " + tipo;
	}*/
}
