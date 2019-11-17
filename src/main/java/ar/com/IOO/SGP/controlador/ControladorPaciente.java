package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.servicio.ServicioPacientes;

public class ControladorPaciente {

	
	private ServicioPacientes servicioPaciente = new ServicioPacientes();
	
	private static ControladorPaciente instancia;
	
	public static ControladorPaciente getInstancia() {
		if(instancia == null) {
			instancia = new ControladorPaciente();
		}
		return instancia;
	}
	
	public void grabar(PacienteDTO unPaciente) throws BaseException {
		
		this.servicioPaciente.altaPaciente(unPaciente);
		
	}
	
	public List<PacienteDTO> buscarPacientes() throws PermisoDenegadoException, ErrorGenericoException, RegistroInexistenteException, RegistroExistenteException{
		return this.servicioPaciente.buscarPacientes();
	}
	
	public void eliminar(String dni) throws BaseException{
		this.servicioPaciente.eliminar(dni);
	}
	
	public PacienteDTO buscarPaciente(String dni) throws PermisoDenegadoException, ErrorGenericoException, RegistroInexistenteException{
		return this.servicioPaciente.buscarPaciente(dni);
	}
	
	public void modificar(PacienteDTO unPaciente) throws BaseException {
		this.servicioPaciente.modificar(unPaciente);
	}
	
}
