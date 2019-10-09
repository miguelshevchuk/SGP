package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.PacienteDAO;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;

public class ServicioPacientes extends ServicioBase{

	private ServicioPeticiones servicioPeticiones = new ServicioPeticiones();
	private PacienteDAO pacienteDAO;
	
	public void bajaPaciente(String dniPaciente) throws TienePeticionesCompletasException{
		
		PacienteDTO paciente = new PacienteDTO();
		paciente.setDni(dniPaciente);
		
		if(!this.servicioPeticiones.tienePeticionesCompletas(paciente)){
			
			this.pacienteDAO.borrarPaciente(this.servicioMapeo.mapear(paciente));
		}else{
			throw new TienePeticionesCompletasException();
		}
		
	}
	
	public void modificarPaciente(PacienteDTO paciente){
		this.pacienteDAO.modificarPaciente(this.servicioMapeo.mapear(paciente));
	}
	
	public void altaPaciente(PacienteDTO unPaciente){
		this.pacienteDAO.altaPaciente(this.servicioMapeo.mapear(unPaciente));
	}
	
	
	
}
