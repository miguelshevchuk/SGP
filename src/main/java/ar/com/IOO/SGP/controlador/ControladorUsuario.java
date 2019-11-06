package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.servicio.ServicioUsuarios;

public class ControladorUsuario {
	
	private ServicioUsuarios servicioUsuario = new ServicioUsuarios();
	
	public static ControladorUsuario getInstancia() {
		return new ControladorUsuario();
	}
	
	public void grabarUsuario(String userName, String dni, String password, String rol, String nombre) throws PermisoDenegadoException {
	
		UsuarioDTO unUsuarioNuevo = new UsuarioDTO();
		
		unUsuarioNuevo.setUserName(userName);
		unUsuarioNuevo.setDni(dni);
		unUsuarioNuevo.setPassword(password);
		unUsuarioNuevo.setRol(rol);
		unUsuarioNuevo.setRol(nombre);
		
		this.servicioUsuario.agregarUsuario(unUsuarioNuevo);
		
	}
	
	public List<UsuarioDTO> buscarUsuarios() throws PermisoDenegadoException{
		return this.servicioUsuario.buscarUsuarios();
	}
	
}
