package ar.com.IOO.SGP.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dao.UsuarioDAO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class ServicioUsuarios extends ServicioBase{
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void agregarUsuario(UsuarioDTO unUsuario) throws BaseException{
		
		this.puedeRealizar("altaUsuario");
		
		this.usuarioDAO.grabar(this.servicioMapeo.mapear(unUsuario));
		
	}
	
	public List<UsuarioDTO> buscarUsuarios() throws PermisoDenegadoException, ErrorGenericoException{
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for(Usuario unUsuario: this.usuarioDAO.buscarUsuarios()) {
			usuariosDTO.add(this.servicioMapeo.mapear(unUsuario));
		}
		
		return usuariosDTO;
		
	}
	
	public void eliminarUsuario(UsuarioDTO unUsuario) throws ErrorGenericoException {
		this.usuarioDAO.eliminar(this.servicioMapeo.mapear(unUsuario));
	}
	
	
	public UsuarioDTO buscarUsuario(String dni) throws ErrorGenericoException, RegistroInexistenteException {
		return this.servicioMapeo.mapear(this.usuarioDAO.buscarUsuario(dni));
	}

	public void modificar(UsuarioDTO unUsuario) throws BaseException {
		UsuarioDTO usuarioGuardado = this.buscarUsuario(unUsuario.getDni());
		usuarioGuardado.setNombre(unUsuario.getNombre());
		usuarioGuardado.setUserName(unUsuario.getUserName());
		usuarioGuardado.setPassword(unUsuario.getPassword());
		
		this.usuarioDAO.modificar(this.servicioMapeo.mapear(usuarioGuardado));
	}
}
