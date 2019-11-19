package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;

public abstract class ServicioBase {

	protected void puedeRealizar(String unaTarea) throws PermisoDenegadoException, ErrorGenericoException {	
		
		if(!SessionManager.getInstancia().getUsuarioLogueado().puedoRealizar(unaTarea)){
			throw new PermisoDenegadoException();
		}
		
	}

//	public SessionManager getSessionManager() {
//		return sessionManager;
//	}
//
//	public void setSessionManager(SessionManager sessionManager) {
//		this.sessionManager = sessionManager;
//	}

}
