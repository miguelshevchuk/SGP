package ar.com.IOO.SGP;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.IOO.SGP.dao.UsuarioDAO;
import ar.com.IOO.SGP.modelo.usuario.Administrador;
import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class UsuarioDAOTest {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@Test
	public void grabarUsuario() {
		
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setUserName("Miguel");

		Administrador administrador = new Administrador();
		
		usuarioNuevo.setRol(administrador);
		
		
		usuarioDAO.grabar(usuarioNuevo);
		
		assertTrue( true );
	}

}