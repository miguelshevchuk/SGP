package ar.com.IOO.SGP.modelo;

public class Rol {

	private String nombreRol;
	
	public Rol() {
	}
	
	public Rol(String nombre) {
		this.nombreRol = nombre;
	}
	
	public Boolean puedoRealizar(String unaTarea) {
		return Boolean.FALSE;
	}

	public String getNombreRol() {
		return nombreRol;
	}

}
