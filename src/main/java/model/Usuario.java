package model;

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
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "\n";
	}

	public int getId() {
		return this.id;
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
		this.clave = clave;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
