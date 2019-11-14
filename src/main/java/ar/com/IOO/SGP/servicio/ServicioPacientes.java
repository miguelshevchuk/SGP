package ar.com.IOO.SGP.servicio;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.PacienteDAO;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;
import ar.com.IOO.SGP.modelo.Paciente;

public class ServicioPacientes extends ServicioBase{

	private ServicioPeticiones servicioPeticiones = new ServicioPeticiones();
	private PacienteDAO pacienteDAO = new PacienteDAO();
	
	public void eliminar(String dniPaciente) throws TienePeticionesCompletasException, ErrorGenericoException{
		
		PacienteDTO paciente = new PacienteDTO();
		paciente.setDni(dniPaciente);
		
		if(!this.servicioPeticiones.tienePeticionesCompletas(paciente)){
			
			this.pacienteDAO.borrarPaciente(this.servicioMapeo.mapear(paciente));
		}else{
			throw new TienePeticionesCompletasException();
		}
		
	}
	
	public void modificar(PacienteDTO paciente) throws ErrorGenericoException, RegistroInexistenteException{
		
		PacienteDTO pacienteGuardado = this.buscarPaciente(paciente.getDni());
		pacienteGuardado.setNombre(paciente.getNombre());
		pacienteGuardado.setEdad(paciente.getEdad());
		
		
		this.pacienteDAO.modificarPaciente(this.servicioMapeo.mapear(pacienteGuardado));
	}
	
	public void altaPaciente(PacienteDTO unPaciente) throws ErrorGenericoException, RegistroExistenteException{
		this.pacienteDAO.altaPaciente(this.servicioMapeo.mapear(unPaciente));
	}
	
	public PacienteDTO buscarPaciente(String dni) throws ErrorGenericoException, RegistroInexistenteException {
		Paciente paciente = this.pacienteDAO.buscarPaciente(dni);
		
		return this.servicioMapeo.mapear(paciente);
	}
	
	public List<PacienteDTO> buscarPacientes() throws ErrorGenericoException, RegistroInexistenteException, RegistroExistenteException {
		
		return this.pacienteDAO.buscarPacientes().stream().map(unPaciente -> this.servicioMapeo.mapear(unPaciente)).collect(Collectors.toList());
		
	}
	
	
	
}
