package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;

public abstract class ServicioBase {

	private SessionManager sessionManager;
	protected ServicioMapeo servicioMapeo;

	protected void puedeRealizar(String unaTarea) throws PermisoDenegadoException {	
		
		if(!this.sessionManager.getUsuarioLogueado().puedoRealizar(unaTarea)){
			throw new PermisoDenegadoException();
		}
		
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

}
