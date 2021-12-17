package model;

import java.sql.SQLException;
import java.util.ArrayList;

import persistence.DAO;
import utils.Crypt;
import utils.Mensajes;

//import sugerencia.Sugerencia;

public class Itinerario {
	private int idVisitante;
	private String atracciones;
	private double costo;
	private double tiempo;
	private int idLugar;
	private String tipoLugar;
	
	public Itinerario(int idVisitante, String atracciones, double costo, double tiempo, int idLugar, String tipoLugar) {
		super();
		this.idVisitante = idVisitante;
		this.atracciones = atracciones;
		this.costo = costo;
		this.tiempo = tiempo;
		this.idLugar = idLugar;
		this.tipoLugar = tipoLugar;
	}

	public int getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(String atracciones) {
		this.atracciones = atracciones;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getTipoLugar() {
		return tipoLugar;
	}

	public void setTipoLugar(String tipoLugar) {
		this.tipoLugar = tipoLugar;
	}	
}