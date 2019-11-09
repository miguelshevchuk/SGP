package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.servicio.ServicioUsuarios;

public class ControladorUsuario {
	
	private ServicioUsuarios servicioUsuario = new ServicioUsuarios();
	
	public static ControladorUsuario getInstancia() {
		return new ControladorUsuario();
	}
	
	public void grabarUsuario(String userName, String dni, String password, String rol, String nombre) throws BaseException {
	
		UsuarioDTO unUsuarioNuevo = new UsuarioDTO();
		
		unUsuarioNuevo.setUserName(userName);
		unUsuarioNuevo.setDni(dni);
		unUsuarioNuevo.setPassword(password);
		unUsuarioNuevo.setRol(rol);
		unUsuarioNuevo.setNombre(nombre);
		
		this.servicioUsuario.agregarUsuario(unUsuarioNuevo);
		
	}
	
	public List<UsuarioDTO> buscarUsuarios() throws PermisoDenegadoException, ErrorGenericoException{
		return this.servicioUsuario.buscarUsuarios();
	}
	
	public void eliminarUsuario(UsuarioDTO unUsuario) throws PermisoDenegadoException, ErrorGenericoException{
		this.servicioUsuario.eliminarUsuario(unUsuario);
	}
	
	public UsuarioDTO buscarUsuario(String dni) throws PermisoDenegadoException, ErrorGenericoException, RegistroInexistenteException{
		return this.servicioUsuario.buscarUsuario(dni);
	}
	
	public void modificarUsuario(UsuarioDTO unUsuario) throws BaseException {
		this.servicioUsuario.modificar(unUsuario);
	}
}
