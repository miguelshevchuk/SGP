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

	PracticaDAO practicaDAO = new PracticaDAO();
	ValorCriticoDAO valorCriticoDAO = new ValorCriticoDAO();
	ValorReservadoDAO valorReservadoDAO = new ValorReservadoDAO();
	ServicioPeticiones servicioPeticiones = new ServicioPeticiones();
	
	public void alta(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroExistenteException {
		Practica practicaParaGuardar = this.servicioMapeo.mapear(unaPractica);
		
		valorCriticoDAO.insertar(practicaParaGuardar.getValoresCriticos());
		valorReservadoDAO.insertar(practicaParaGuardar.getValoresReservados());
		practicaDAO.insertar(practicaParaGuardar);
		
	}
	
	public List<PracticaDTO> buscarPracticas() throws BaseException{
		List<Practica> practicas = practicaDAO.buscarPracticas();
		
		for(Practica unaPractica: practicas) {
			this.completarValoresPractica(unaPractica);
		}
		
		List<PracticaDTO> practicasDTO = practicas.stream().map(unaPractica -> this.servicioMapeo.mapear(unaPractica)).collect(Collectors.toList());
	
		return practicasDTO;
	}
	
	private void completarValoresPractica(Practica unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		unaPractica.setValoresCriticos(valorCriticoDAO.buscarPorPractica(unaPractica));
		unaPractica.setValoresReservados(valorReservadoDAO.buscarPorPractica(unaPractica));
//		return unaPractica;
	}
	
	public void eliminar(String codigo) throws BaseException {
		
		if(servicioPeticiones.hayPeticionesDe(codigo)) {
			throw new PracticaUsadaException();
		}
		
		valorCriticoDAO.eliminar(codigo);
		valorReservadoDAO.eliminar(codigo);
		practicaDAO.eliminar(codigo);
	}
	
	public PracticaDTO buscar(String unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		Practica practica = this.practicaDAO.buscar(unaPractica);
		completarValoresPractica(practica);
		
		return this.servicioMapeo.mapear(practica);
	}
	
	public void modificar(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		Practica practica = this.practicaDAO.buscar(unaPractica.getCodigo());
		completarValoresPractica(practica);
		
		practica.setGrupo(unaPractica.getGrupo());
		practica.setHabilitada(unaPractica.getHabilitada());
		practica.setHorasResultado(unaPractica.getHorasResultado());
		practica.setNombre(unaPractica.getNombre());
		practica.setValoresCriticos(this.servicioMapeo.mapear(unaPractica.getValoresCriticos()));
		practica.setValoresReservados(this.servicioMapeo.mapear(unaPractica.getValoresReservados()));
		
		valorCriticoDAO.modificar(practica.getValoresCriticos());
		valorReservadoDAO.modificar(practica.getValoresReservados());
		this.practicaDAO.modificar(practica);
	}
}
