package ar.com.IOO.SGP.dao;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.PracticaPeticion;

public class ResultadoDAO extends BaseDAO<PracticaPeticion>{

	private static ResultadoDAO instancia;
	
	public static ResultadoDAO getInstancia() {
		return (instancia == null)? new ResultadoDAO() : instancia;
	}
	
	public ResultadoDAO() {
		super("resultados.txt", PracticaPeticion.class, "IdResultado");
	}

	public void alta(PracticaPeticion resultado) throws ErrorGenericoException, RegistroExistenteException{
		super.insertar(resultado);
	}
	
	public void baja(String idResultado) throws ErrorGenericoException{
		super.eliminarRegistro(idResultado);
	}
	
	public void modificar(PracticaPeticion resultado) throws ErrorGenericoException{
		super.modificar(resultado);
	}
	
	public List<PracticaPeticion> buscarResultadosDe(String unaPeticion) throws ErrorGenericoException {
		return super.traerRegistros().stream().filter(resultado -> resultado.getIdPeticion().equals(unaPeticion))
				.collect(Collectors.toList());
	}
	
	public PracticaPeticion buscarResultado(String idResultado) throws ErrorGenericoException, RegistroInexistenteException {
		return (PracticaPeticion) super.traerRegistroPor(idResultado);
	}
	
}
