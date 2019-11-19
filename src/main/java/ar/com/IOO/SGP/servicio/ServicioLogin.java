package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.LoginDAO;

public class ServicioLogin {

	private static ServicioLogin instancia;
	
	public static ServicioLogin getInstancia() {
		if(instancia == null) {
			instancia = new ServicioLogin();
		}
		return instancia;
	}
	
	public void loguear(String unRol) {
		LoginDAO.getInstancia().loguear(unRol);
	}
	
}
