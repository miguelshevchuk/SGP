package ar.com.IOO.SGP.servicio;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.PacienteDAO;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;
import ar.com.IOO.SGP.modelo.Paciente;

public class ServicioPacientes extends ServicioBase{

	private static ServicioPacientes instancia;
	
	public static ServicioPacientes getInstancia() {
		return (instancia == null)? new ServicioPacientes() : instancia;
	}
	
	public void eliminar(String dniPaciente) throws BaseException{
		
		PacienteDTO paciente = new PacienteDTO();
		paciente.setDni(dniPaciente);
		
		if(!ServicioPeticiones.getInstancia().tienePeticionesCompletas(paciente)){
			
			PacienteDAO.getInstancia().borrarPaciente(ServicioMapeo.mapear(paciente));
		}else{
			throw new TienePeticionesCompletasException();
		}
		
	}
	
	public void modificar(PacienteDTO paciente) throws ErrorGenericoException, RegistroInexistenteException{
		
		PacienteDTO pacienteGuardado = this.buscarPaciente(paciente.getDni());
		pacienteGuardado.setNombre(paciente.getNombre());
		pacienteGuardado.setEdad(paciente.getEdad());
		
		
		PacienteDAO.getInstancia().modificarPaciente(ServicioMapeo.mapear(pacienteGuardado));
	}
	
	public void altaPaciente(PacienteDTO unPaciente) throws ErrorGenericoException, RegistroExistenteException{
		PacienteDAO.getInstancia().altaPaciente(ServicioMapeo.mapear(unPaciente));
	}
	
	public PacienteDTO buscarPaciente(String dni) throws ErrorGenericoException, RegistroInexistenteException {
		Paciente paciente = PacienteDAO.getInstancia().buscarPaciente(dni);
		
		return ServicioMapeo.mapear(paciente);
	}
	
	public List<PacienteDTO> buscarPacientes() throws ErrorGenericoException, RegistroInexistenteException, RegistroExistenteException {
		
		return PacienteDAO.getInstancia().buscarPacientes().stream().map(unPaciente -> ServicioMapeo.mapear(unPaciente)).collect(Collectors.toList());
		
	}
	
	
	
}
