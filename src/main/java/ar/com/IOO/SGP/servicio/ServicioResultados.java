package ar.com.IOO.SGP.servicio;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.ResultadoDAO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.PracticaPeticion;

public class ServicioResultados extends ServicioBase {


	private static ServicioResultados instancia;
	
	public static ServicioResultados getInstancia() {
		return (instancia == null)? new ServicioResultados() : instancia;
	}
	
	public List<PracticaPeticionDTO> buscarResultadosDe(String unaPeticion) throws ErrorGenericoException {
		return ResultadoDAO.getInstancia().buscarResultadosDe(unaPeticion).stream()
				.map(resultado -> ServicioMapeo.mapear(resultado)).collect(Collectors.toList());
	}

	public void eliminarResultadosDe(String unaPeticion) throws ErrorGenericoException {
		List<PracticaPeticion> resultados = ResultadoDAO.getInstancia().buscarResultadosDe(unaPeticion);
		for(PracticaPeticion resultado : resultados) {
			ResultadoDAO.getInstancia().baja(resultado.getIdResultado());
		}
	}

	public void alta(PracticaPeticionDTO resultado) throws ErrorGenericoException, RegistroExistenteException {
		ResultadoDAO.getInstancia().alta(ServicioMapeo.mapear(resultado));
	}

	public void modificar(PracticaPeticionDTO resultado) throws ErrorGenericoException, RegistroInexistenteException {
		PracticaPeticion resultadoCargado = ResultadoDAO.getInstancia().buscarResultado(resultado.getIdResultado());
		resultadoCargado.setResultado(resultado.getResultado());
		ResultadoDAO.getInstancia().modificar(resultadoCargado);
	}
	
}
