package ar.com.IOO.SGP.servicio;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.ResultadoDAO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.excepcion.TieneResultadosReservadosException;
import ar.com.IOO.SGP.modelo.Peticion;
import ar.com.IOO.SGP.modelo.PracticaPeticion;

public class ServicioResultados extends ServicioBase {


	private static ServicioResultados instancia;
	
	public static ServicioResultados getInstancia() {
		return (instancia == null)? new ServicioResultados() : instancia;
	}
	
	public List<PracticaPeticionDTO> buscarResultadosDe(String unaPeticion) throws ErrorGenericoException, RegistroInexistenteException {
		List<PracticaPeticionDTO> resultados = ResultadoDAO.getInstancia()
				.buscarResultadosDe(unaPeticion).stream()
				.map(resultado -> ServicioMapeo.mapear(resultado)).collect(Collectors.toList());
		
		for(PracticaPeticionDTO resultado : resultados) {
			resultado.setPractica(ServicioPracticas.getInstancia().buscar(resultado.getPractica().getCodigo()));
		}
		
		return resultados;
	}
	public List<PracticaPeticionDTO> buscarResultadosNoReservadosDe(String unaPeticion) throws BaseException {
		
		Peticion peticion = ServicioMapeo.mapear(ServicioPeticiones.getInstancia().buscarPeticion(unaPeticion));
		
		if(peticion.esUnaPeticionReservada()) {
			throw new TieneResultadosReservadosException();
		}
		
		return this.buscarResultadosDe(unaPeticion);
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
