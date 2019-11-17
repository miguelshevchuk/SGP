package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Practica;

public class PracticaDAO extends BaseDAO<Practica>{

	private static PracticaDAO instancia;
	
	public static PracticaDAO getInstancia() {
		return (instancia == null)? new PracticaDAO() : instancia;
	}
	
	public PracticaDAO() {
		super("practica.txt", Practica.class, "Codigo");
	}

	public void insertar(Practica practica) throws ErrorGenericoException, RegistroExistenteException {
		//Esto es por que se va a guardar en otro archivo
		practica.setValoresCriticos(null);
		practica.setValoresReservados(null);
		
		super.insertar(practica);
	}
	
	public List<Practica> buscarPracticas() throws ErrorGenericoException{
		return super.traerRegistros();
	}
	
	public void eliminar(String codigo) throws ErrorGenericoException {
		super.eliminarRegistro(codigo);
	}
	
	public Practica buscar(String unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		return (Practica) super.traerRegistroPor(unaPractica);
	}
	
	public void modificar(Practica practica) throws ErrorGenericoException, RegistroInexistenteException {
		practica.setValoresCriticos(null);
		practica.setValoresReservados(null);
		super.modificar(practica);
	}
	
}
