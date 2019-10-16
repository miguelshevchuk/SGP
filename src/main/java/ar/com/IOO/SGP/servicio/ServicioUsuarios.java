package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.UsuarioDAO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;

public class ServicioUsuarios extends ServicioBase{
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void agregarUsuario(UsuarioDTO unUsuario) throws PermisoDenegadoException{
		
		this.puedeRealizar("altaUsuario");
		
		this.usuarioDAO.grabar(this.servicioMapeo.mapear(unUsuario));
		
	}
	

}
