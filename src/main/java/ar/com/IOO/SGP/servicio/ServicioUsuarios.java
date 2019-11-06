package ar.com.IOO.SGP.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dao.UsuarioDAO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class ServicioUsuarios extends ServicioBase{
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void agregarUsuario(UsuarioDTO unUsuario) throws PermisoDenegadoException{
		
		this.puedeRealizar("altaUsuario");
		
		this.usuarioDAO.grabar(this.servicioMapeo.mapear(unUsuario));
		
	}
	
	public List<UsuarioDTO> buscarUsuarios() throws PermisoDenegadoException{
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for(Usuario unUsuario: this.usuarioDAO.buscarUsuarios()) {
			usuariosDTO.add(this.servicioMapeo.mapear(unUsuario));
		}
		
		return usuariosDTO;
		
	}

}
