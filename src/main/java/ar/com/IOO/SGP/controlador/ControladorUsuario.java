package ar.com.IOO.SGP.controlador;

import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.servicio.ServicioUsuarios;

public class ControladorUsuario {
	
	private ServicioUsuarios servicioUsuario = new ServicioUsuarios();
	
	public void grabarUsuario(String userName, String dni, String password, String rol, String nombre) throws PermisoDenegadoException {
	
		UsuarioDTO unUsuarioNuevo = new UsuarioDTO();
		
		unUsuarioNuevo.setUserName(userName);
		unUsuarioNuevo.setDni(dni);
		unUsuarioNuevo.setPassword(password);
		unUsuarioNuevo.setRol(rol);
		unUsuarioNuevo.setRol(nombre);
		
		this.servicioUsuario.agregarUsuario(unUsuarioNuevo);
		
	}
	
}
