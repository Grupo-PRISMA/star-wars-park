package model;

import java.sql.SQLException;
import java.util.ArrayList;

import persistence.DAO;
import utils.Crypt;
import utils.Mensajes;

//import sugerencia.Sugerencia;

public class Usuario {
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponibleHs;
	private String preferencia;
	private String usuario;
	private String clave;
	private boolean activo;
	private boolean admin;

	public Usuario(int id, String nombre, String preferencia, double presupuesto, double tiempoDisponibleHs, String usuario, String clave, boolean activo, boolean admin) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponibleHs = tiempoDisponibleHs;
		this.preferencia = preferencia;
		this.usuario = usuario;
		this.clave = clave;
		this.activo = activo;
		this.admin = admin;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getPreferencia() {
		return this.preferencia;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempoDisponibleHs() {
		return this.tiempoDisponibleHs;
	}
	/*
	public boolean decidirSugerencia(Sugerencia sugerencia) {	
		char respuesta;
		Scanner entrada = new Scanner(System.in);	
		
		do {
			System.out.println("Acepta sugerencia? Ingrese S o N");
			String ingreso = entrada.nextLine();
			if (ingreso.length() > 0) {
				respuesta = Character.toUpperCase(ingreso.charAt(0));
			}else {
				respuesta = ' ';
			}
			
		} while (respuesta != 'S' && respuesta != 'N' && entrada.hasNextLine());

		if(respuesta == 'S') {
			this.presupuesto -= sugerencia.getCosto();
			this.tiempoDisponibleHs -= sugerencia.getDuracion();
		}
		
		return respuesta == 'S';
	}
	*/
	


	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponibleHs="
				+ tiempoDisponibleHs + ", preferencia=" + preferencia + ", usuario=" + usuario + ", clave=" + clave
				+ ", activo=" + activo + ", admin=" + admin + "]";
	}

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public boolean isActivo() {
		return activo;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponibleHs(double tiempoDisponibleHs) {
		this.tiempoDisponibleHs = tiempoDisponibleHs;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		this.clave = this.clave.equals("") ? "": Crypt.hash(clave);
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public ArrayList<String> validar() throws SQLException {
		ArrayList<String> errores = new ArrayList<String>();
		
		if (this.usuario.length() < 1) {
			errores.add(String.format(Mensajes.ERROR_VACIO, "usuario"));
		}

		if (this.id < 1 && this.clave.length() < 1) {
			errores.add(String.format(Mensajes.ERROR_VACIO, "contraseña"));
		}

		if (this.nombre.length() < 1) {
			errores.add(String.format(Mensajes.ERROR_VACIO, "nombre"));
			
			//errores.add("El nombre no puede ser vacio");
		}

		//		this.usuario = usuario; SI ID=0 UNICO; SI ID>0 QUE ID ESTE EN DB
		//		this.id = id; NUMERO POSITIVO
		if (this.id == 0) {
			if (DAO.getUsuarioDAO().buscarPorUsuario(this.usuario) != null) {
				errores.add(String.format(Mensajes.ERROR_EN_USO, "usuario"));
				//errores.add("El usuario ya está en uso");
			}
		} else if (this.id > 0) {
			if (DAO.getUsuarioDAO().buscarPorId(this.id) == null) {
				errores.add(String.format(Mensajes.ERROR_INVALIDO, "ID"));
				//errores.add("Id inválido");
			}
		}

		//		this.presupuesto = presupuesto; NUMERO POSITIVO
		if (this.presupuesto < 0) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Presupuesto"));
			//errores.add("Presupuesto debe ser un número igual o mayor a cero");
		}

		//		this.tiempoDisponibleHs = tiempoDisponibleHs; NUMERO POSITIVO
		if (this.tiempoDisponibleHs < 0) {
			errores.add(String.format(Mensajes.ERROR_NUMERO, "Tiempo Disponible"));
			//errores.add("Tiempo debe ser un número igual o mayor a cero");
		}

		//		this.preferencia = preferencia; QUE ESTE EN DB
		if (DAO.getTipoAtraccionDAO().buscarPorTipo(this.preferencia) == null) {
			errores.add(String.format(Mensajes.ERROR_INVALIDO, "Tipo de preferencia"));
			//errores.add("Tipo de preferencia inválido");
		}
		
		return errores;
	}
	
	public boolean verificarClave(String clave) {
		// this.password en realidad es el hash del password
		return Crypt.match(clave, this.clave);
	}
}
