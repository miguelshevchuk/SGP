package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class UsuarioDAO  extends BaseDAO<Usuario>{

	public UsuarioDAO() {
		super("usuario.txt", Usuario.class);
	}

	public void grabar(Usuario unUsuario) {
		super.insertar(unUsuario);
	}
	
	public void modificar(Usuario unUsuario) {
		super.insertar(unUsuario);
	}
	
	public List<Usuario> buscarUsuarios() {
		return super.traerRegistros();
	}
	
}
