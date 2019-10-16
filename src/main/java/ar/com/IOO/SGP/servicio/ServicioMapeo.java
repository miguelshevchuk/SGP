package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.modelo.Paciente;
import ar.com.IOO.SGP.modelo.peticion.Peticion;
import ar.com.IOO.SGP.modelo.usuario.Administrador;
import ar.com.IOO.SGP.modelo.usuario.Laboratorista;
import ar.com.IOO.SGP.modelo.usuario.Recepcionista;
import ar.com.IOO.SGP.modelo.usuario.Usuario;

public class ServicioMapeo {

	public Paciente mapear(PacienteDTO unPaciente){
		Paciente paciente = new Paciente();
		
		return paciente;
	}
	
	public Peticion mapear(PeticionDTO unaPeticion){
		Peticion peticion = new Peticion();
		
		return peticion;
	}
	
	public Usuario mapear(UsuarioDTO unUsuario){
		Usuario usuario = new Usuario();
		usuario.setDni(unUsuario.getDni());
		usuario.setNombre(unUsuario.getNombre());
		usuario.setUserName(unUsuario.getUserName());
		usuario.setPassword(unUsuario.getPassword());
		
		if(unUsuario.getRol().equals("Administrador")) {
			usuario.setRol(new Administrador());
		}else if(unUsuario.getRol().equals("Recepcionista")) {
			usuario.setRol(new Recepcionista());
		}else {
			usuario.setRol(new Laboratorista());
		}
		
		return usuario;
	}
	
	
	
	
}
