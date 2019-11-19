package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.LoginDAO;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.modelo.Administrador;
import ar.com.IOO.SGP.modelo.Laboratorista;
import ar.com.IOO.SGP.modelo.Recepcionista;
import ar.com.IOO.SGP.modelo.Rol;
import ar.com.IOO.SGP.modelo.Usuario;

public class SessionManager {
	
	private static SessionManager instancia;
	
	public static SessionManager getInstancia() throws ErrorGenericoException {
		if(instancia == null) {
			instancia = new SessionManager();
		}
		return instancia;
	}
	
	private Usuario usuarioLogueado;
	
	public SessionManager() throws ErrorGenericoException {
		this.usuarioLogueado = new Usuario();
		
		Rol rol;
		
		String logueado = LoginDAO.getInstancia().getTipoUsuarioLogueado();
		
		if(logueado.equals('"'+ROLEnum.ADM.getCodigo()+'"')) {
			rol = new Administrador();
		}else if(logueado.equals('"'+ROLEnum.LAB.getCodigo()+'"')) {
			rol = new Laboratorista();
		}else {
			rol = new Recepcionista();
		}
		
		this.usuarioLogueado.setRol(rol);
	}
	
	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
