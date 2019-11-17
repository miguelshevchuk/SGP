package ar.com.IOO.SGP.servicio;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.PracticaDAO;
import ar.com.IOO.SGP.dao.ValorCriticoDAO;
import ar.com.IOO.SGP.dao.ValorReservadoDAO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PracticaUsadaException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Practica;

public class ServicioPracticas extends ServicioBase{

	
	private static ServicioPracticas instancia;
	
	public static ServicioPracticas getInstancia() {
		return (instancia == null)? new ServicioPracticas() : instancia;
	}

	public void alta(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroExistenteException {
		Practica practicaParaGuardar = ServicioMapeo.mapear(unaPractica);
		
		ValorCriticoDAO.getInstancia().insertar(practicaParaGuardar.getValoresCriticos());
		ValorReservadoDAO.getInstancia().insertar(practicaParaGuardar.getValoresReservados());
		PracticaDAO.getInstancia().insertar(practicaParaGuardar);
		
	}
	
	public List<PracticaDTO> buscarPracticas() throws BaseException{
		List<Practica> practicas = PracticaDAO.getInstancia().buscarPracticas();
		
		for(Practica unaPractica: practicas) {
			this.completarValoresPractica(unaPractica);
		}
		
		List<PracticaDTO> practicasDTO = practicas.stream().map(unaPractica -> ServicioMapeo.mapear(unaPractica)).collect(Collectors.toList());
	
		return practicasDTO;
	}
	
	private void completarValoresPractica(Practica unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		unaPractica.setValoresCriticos(ValorCriticoDAO.getInstancia().buscarPorPractica(unaPractica));
		unaPractica.setValoresReservados(ValorReservadoDAO.getInstancia().buscarPorPractica(unaPractica));
//		return unaPractica;
	}
	
	public void eliminar(String codigo) throws BaseException {
		
		if(ServicioPeticiones.getInstancia().hayPeticionesDe(codigo)) {
			throw new PracticaUsadaException();
		}
		
		ValorCriticoDAO.getInstancia().eliminar(codigo);
		ValorReservadoDAO.getInstancia().eliminar(codigo);
		PracticaDAO.getInstancia().eliminar(codigo);
	}
	
	public PracticaDTO buscar(String unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		Practica practica = PracticaDAO.getInstancia().buscar(unaPractica);
		completarValoresPractica(practica);
		
		return ServicioMapeo.mapear(practica);
	}
	
	public void modificar(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		Practica practica = PracticaDAO.getInstancia().buscar(unaPractica.getCodigo());
		completarValoresPractica(practica);
		
		practica.setGrupo(unaPractica.getGrupo());
		practica.setHabilitada(unaPractica.getHabilitada());
		practica.setHorasResultado(unaPractica.getHorasResultado());
		practica.setNombre(unaPractica.getNombre());
		practica.setValoresCriticos(ServicioMapeo.mapear(unaPractica.getValoresCriticos()));
		practica.setValoresReservados(ServicioMapeo.mapear(unaPractica.getValoresReservados()));
		
		ValorCriticoDAO.getInstancia().modificar(practica.getValoresCriticos());
		ValorReservadoDAO.getInstancia().modificar(practica.getValoresReservados());
		PracticaDAO.getInstancia().modificar(practica);
	}
}
