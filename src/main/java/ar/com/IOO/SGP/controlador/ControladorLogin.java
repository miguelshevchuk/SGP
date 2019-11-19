package ar.com.IOO.SGP.controlador;

import ar.com.IOO.SGP.servicio.ServicioLogin;

public class ControladorLogin {
	private static ControladorLogin instancia;
	
	public static ControladorLogin getInstancia() {
		if(instancia == null) {
			instancia = new ControladorLogin();
		}
		return instancia;
	}
	
	public void loguearComo(String unRol) {
		ServicioLogin.getInstancia().loguear(unRol);
	}
}
