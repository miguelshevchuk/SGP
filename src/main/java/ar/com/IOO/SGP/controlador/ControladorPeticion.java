package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;
import ar.com.IOO.SGP.servicio.ServicioPeticiones;

public class ControladorPeticion {

	private ServicioPeticiones servicio = new ServicioPeticiones();
	
	private static ControladorPeticion instancia;
	
	public static ControladorPeticion getInstancia() {
		if(instancia == null) {
			instancia = new ControladorPeticion();
		}
		return instancia;
	}
	
	public void alta(PeticionDTO unaPeticion) throws BaseException {
		this.servicio.altaPeticion(unaPeticion);
	}
	
	public List<PeticionDTO> buscarPeticiones() throws BaseException {
		
		return servicio.buscarPeticiones();
	}
	
	public List<PeticionDTO> buscarPeticionesConValoresCriticos() throws BaseException {
		
		return servicio.buscarPeticionesConValoresCriticos();
	}
	
	public PeticionDTO buscarpeticion(String idPeticion) throws BaseException {
		
		return servicio.buscarPeticion(idPeticion);
	}
	
	public void modificar(PeticionDTO peticion) throws BaseException {
		servicio.modificarPeticion(peticion);
	}
	
	public void eliminar(String idPeticion) throws ErrorGenericoException, TienePeticionesCompletasException {
		servicio.eliminar(idPeticion);
	}
	
}
