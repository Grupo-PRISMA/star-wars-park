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
	
	
//	public ArrayList<String> validar() throws SQLException {
//		ArrayList<String> errores = new ArrayList<String>();
//		
//		if (this.usuario.length() < 1) {
//			errores.add(String.format(Mensajes.ERROR_VACIO, "usuario"));
//		}
//
//		if (this.clave.length() < 1) {
//			errores.add(String.format(Mensajes.ERROR_VACIO, "contraseña"));
//		}
//
//		if (this.nombre.length() < 1) {
//			errores.add(String.format(Mensajes.ERROR_VACIO, "nombre"));
//			
//			//errores.add("El nombre no puede ser vacio");
//		}
//
//		//		this.usuario = usuario; SI ID=0 UNICO; SI ID>0 QUE ID ESTE EN DB
//		//		this.id = id; NUMERO POSITIVO
//		if (this.id == 0) {
//			if (DAO.getUsuarioDAO().buscarPorUsuario(this.usuario) != null) {
//				errores.add(String.format(Mensajes.ERROR_EN_USO, "usuario"));
//				//errores.add("El usuario ya está en uso");
//			}
//		} else if (this.id > 0) {
//			if (DAO.getUsuarioDAO().buscarPorId(this.id) == null) {
//				errores.add(String.format(Mensajes.ERROR_INVALIDO, "ID"));
//				//errores.add("Id inválido");
//			}
//		}
//
//		//		this.presupuesto = presupuesto; NUMERO POSITIVO
//		if (this.presupuesto < 0) {
//			errores.add(String.format(Mensajes.ERROR_NUMERO, "Presupuesto"));
//			//errores.add("Presupuesto debe ser un número igual o mayor a cero");
//		}
//
//		//		this.tiempoDisponibleHs = tiempoDisponibleHs; NUMERO POSITIVO
//		if (this.tiempoDisponibleHs < 0) {
//			errores.add(String.format(Mensajes.ERROR_NUMERO, "Tiempo Disponible"));
//			//errores.add("Tiempo debe ser un número igual o mayor a cero");
//		}
//
//		//		this.preferencia = preferencia; QUE ESTE EN DB
//		if (DAO.getTipoAtraccionDAO().buscarPorTipo(this.preferencia) == null) {
//			errores.add(String.format(Mensajes.ERROR_INVALIDO, "Tipo de preferencia"));
//			//errores.add("Tipo de preferencia inválido");
//		}
//		
//		return errores;
//	}
//	
//	public boolean verificarClave(String clave) {
//		// this.password en realidad es el hash del password
//		return Crypt.match(clave, this.clave);
//	}
}
