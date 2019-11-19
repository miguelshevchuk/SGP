package ar.com.IOO.SGP.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dao.UsuarioDAO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Usuario;

public class ServicioUsuarios extends ServicioBase{
	
	private static ServicioUsuarios instancia;
	
	public static ServicioUsuarios getInstancia() {
		return (instancia == null)? new ServicioUsuarios() : instancia;
	}
	
	public void agregarUsuario(UsuarioDTO unUsuario) throws BaseException{
		
		this.puedeRealizar("altaUsuario");
		
		UsuarioDAO.getInstancia().grabar(ServicioMapeo.mapear(unUsuario));
		
	}
	
	public List<UsuarioDTO> buscarUsuarios() throws PermisoDenegadoException, ErrorGenericoException{
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for(Usuario unUsuario: UsuarioDAO.getInstancia().buscarUsuarios()) {
			usuariosDTO.add(ServicioMapeo.mapear(unUsuario));
		}
		
		return usuariosDTO;
		
	}
	
	public void eliminarUsuario(UsuarioDTO unUsuario) throws ErrorGenericoException, PermisoDenegadoException {
		this.puedeRealizar("bajaUsuario");
		UsuarioDAO.getInstancia().eliminar(ServicioMapeo.mapear(unUsuario));
	}
	
	
	public UsuarioDTO buscarUsuario(String dni) throws ErrorGenericoException, RegistroInexistenteException {
		return ServicioMapeo.mapear(UsuarioDAO.getInstancia().buscarUsuario(dni));
	}

	public void modificar(UsuarioDTO unUsuario) throws BaseException {
		this.puedeRealizar("modifUsuario");
		
		UsuarioDTO usuarioGuardado = this.buscarUsuario(unUsuario.getDni());
		usuarioGuardado.setNombre(unUsuario.getNombre());
		usuarioGuardado.setUserName(unUsuario.getUserName());
		usuarioGuardado.setPassword(unUsuario.getPassword());
		
		UsuarioDAO.getInstancia().modificar(ServicioMapeo.mapear(usuarioGuardado));
	}
}
