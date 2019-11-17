package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Paciente;

public class PacienteDAO extends BaseDAO<Paciente>{

	private static PacienteDAO instancia;
	
	public static PacienteDAO getInstancia() {
		return (instancia == null)? new PacienteDAO() : instancia;
	}
	
	public PacienteDAO() {
		super("paciente.txt", Paciente.class, "Dni");
	}

	public Paciente buscarPaciente(String dni) throws ErrorGenericoException, RegistroInexistenteException{
	
		return (Paciente) super.traerRegistroPor(dni);
		
	}
	
	public void borrarPaciente(Paciente unPaciente) throws ErrorGenericoException{
		super.eliminarRegistro(unPaciente.getDni());
	}
	
	public void modificarPaciente(Paciente unPaciente) throws ErrorGenericoException{
		super.modificar(unPaciente);
	}
	
	public void altaPaciente(Paciente unPaciente) throws ErrorGenericoException, RegistroExistenteException{
		super.insertar(unPaciente);
	}
	
	public List<Paciente> buscarPacientes() throws ErrorGenericoException, RegistroExistenteException{
		return super.traerRegistros();
	}
	
}
