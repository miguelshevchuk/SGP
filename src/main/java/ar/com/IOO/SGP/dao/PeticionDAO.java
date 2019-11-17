package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Peticion;

public class PeticionDAO extends BaseDAO<Peticion>{

	private static PeticionDAO instancia;
	
	public static PeticionDAO getInstancia() {
		return (instancia == null)? new PeticionDAO() : instancia;
	}
	
	public PeticionDAO() {
		super("peticion.txt", Peticion.class, "IdPeticion");
	}

	public void altaPeticion(Peticion unaPeticion) throws ErrorGenericoException, RegistroExistenteException{
		super.insertar(unaPeticion);
	}
	
	public void bajaPeticion(String idPeticion) throws ErrorGenericoException{
		super.eliminarRegistro(idPeticion);
	}
	
	public void modificarPeticion(Peticion unaPeticion) throws ErrorGenericoException{
		super.modificar(unaPeticion);
	}
	
	public List<Peticion> buscarPeticiones() throws ErrorGenericoException{
		return super.traerRegistros();
	}
	
	public Peticion buscarPeticion(String idPeticion) throws ErrorGenericoException, RegistroInexistenteException {
		return (Peticion) super.traerRegistroPor(idPeticion);
	}
	
}
