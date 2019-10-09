package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class SessionManager {

	private Usuario usuarioLogueado;
	
	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
