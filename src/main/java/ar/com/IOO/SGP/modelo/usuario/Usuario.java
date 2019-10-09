package ar.com.IOO.SGP.modelo.usuario;

import ar.com.IOO.SGP.modelo.Persona;

public class Usuario extends Persona{

	private String userName;
	private String password;
	private Rol rol;
	
	public Boolean puedoRealizar(String unaTarea){
		return this.rol.puedoRealizar(unaTarea);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
