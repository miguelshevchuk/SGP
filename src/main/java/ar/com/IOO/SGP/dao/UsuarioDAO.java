package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class UsuarioDAO  extends BaseDAO{

	public UsuarioDAO() {
		super("usuario.txt");
	}

	public void grabar(Usuario unUsuario) {
		super.insertar(unUsuario);
	}
	
	public void modificar(Usuario unUsuario) {
		super.insertar(unUsuario);
	}
	
}
