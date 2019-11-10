package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.modelo.Administrador;
import ar.com.IOO.SGP.modelo.Laboratorista;
import ar.com.IOO.SGP.modelo.Paciente;
import ar.com.IOO.SGP.modelo.Peticion;
import ar.com.IOO.SGP.modelo.Recepcionista;
import ar.com.IOO.SGP.modelo.Usuario;

public class ServicioMapeo {

	public Paciente mapear(PacienteDTO unPaciente){
		Paciente paciente = new Paciente();
		paciente.setDni(unPaciente.getDni());
		paciente.setNombre(unPaciente.getNombre());
		paciente.setEdad(unPaciente.getEdad());
		
		return paciente;
	}
	
	public PacienteDTO mapear(Paciente unPaciente){
		PacienteDTO paciente = new PacienteDTO();
		paciente.setDni(unPaciente.getDni());
		paciente.setNombre(unPaciente.getNombre());
		paciente.setEdad(unPaciente.getEdad());
		
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
		
		if(unUsuario.getRol() != null) {
			if(unUsuario.getRol().equals("Administrador")) {
				usuario.setRol(new Administrador());
			}else if(unUsuario.getRol().equals("Recepcionista")) {
				usuario.setRol(new Recepcionista());
			}else {
				usuario.setRol(new Laboratorista());
			}
		}
		
		return usuario;
	}
	
	public UsuarioDTO mapear(Usuario unUsuario){
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setDni(unUsuario.getDni());
		usuario.setNombre(unUsuario.getNombre());
		usuario.setUserName(unUsuario.getUserName());
		usuario.setPassword(unUsuario.getPassword());
		
		usuario.setRol(unUsuario.getRol().getNombreRol());
		
		return usuario;
	}
	
	
	
	
}
