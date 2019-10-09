package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.modelo.Paciente;
import ar.com.IOO.SGP.modelo.peticion.Peticion;

public class ServicioMapeo {

	public Paciente mapear(PacienteDTO unPaciente){
		Paciente paciente = new Paciente();
		
		return paciente;
	}
	
	public Peticion mapear(PeticionDTO unaPeticion){
		Peticion peticion = new Peticion();
		
		return peticion;
	}
	
	
}
