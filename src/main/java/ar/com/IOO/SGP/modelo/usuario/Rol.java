package ar.com.IOO.SGP.modelo.usuario;

public abstract class Rol {

	private String nombreRol;
	
	public Rol(String nombre) {
		this.nombreRol = nombre;
	}
	
	public abstract Boolean puedoRealizar(String unaTarea);

	public String getNombreRol() {
		return nombreRol;
	}

}
