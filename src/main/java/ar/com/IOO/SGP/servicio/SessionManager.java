package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.modelo.Administrador;
import ar.com.IOO.SGP.modelo.Rol;
import ar.com.IOO.SGP.modelo.Usuario;

public class SessionManager {

	private Usuario usuarioLogueado;
	
	public SessionManager() {
		this.usuarioLogueado = new Usuario();
		
		Rol rol = new Administrador();
		this.usuarioLogueado.setRol(rol);
	}
	
	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
