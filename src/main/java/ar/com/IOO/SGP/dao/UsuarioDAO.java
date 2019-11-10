package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Usuario;

public class UsuarioDAO  extends BaseDAO<Usuario>{

	public UsuarioDAO() {
		super("usuario.txt", Usuario.class, "Dni");
	}

	public void grabar(Usuario unUsuario) throws BaseException {
		super.insertar(unUsuario);
	}
	
	public void modificar(Usuario unUsuario) throws BaseException {
		super.modificar(unUsuario);
	}
	
	public List<Usuario> buscarUsuarios() throws ErrorGenericoException {
		return super.traerRegistros();
	}
	
	public void eliminar(Usuario unUsuario) throws ErrorGenericoException {
		super.eliminarRegistro(unUsuario.getDni());
	}

	public Usuario buscarUsuario(String dni) throws ErrorGenericoException, RegistroInexistenteException {
		return (Usuario) super.traerRegistroPor(dni);
		
	}
	
}
