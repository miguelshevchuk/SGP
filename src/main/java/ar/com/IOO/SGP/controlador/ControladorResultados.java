package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.servicio.ServicioResultados;

public class ControladorResultados {

	private static ControladorResultados instancia;
	
	public static ControladorResultados getInstancia() {
		if(instancia == null) {
			instancia = new ControladorResultados();
		}
		return instancia;
	}
	
	public void cargarResultado(PracticaPeticionDTO unResultado) throws ErrorGenericoException, RegistroInexistenteException, PermisoDenegadoException {
		ServicioResultados.getInstancia().modificar(unResultado);
	}
	
	public List<PracticaPeticionDTO> buscarResultadosNoReservadosDe(String unaPeticion) throws BaseException{
		return ServicioResultados.getInstancia().buscarResultadosNoReservadosDe(unaPeticion);
	}
}
