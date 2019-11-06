package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.modelo.usuario.Administrador;
import ar.com.IOO.SGP.modelo.usuario.Rol;
import ar.com.IOO.SGP.modelo.usuario.Usuario;

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
