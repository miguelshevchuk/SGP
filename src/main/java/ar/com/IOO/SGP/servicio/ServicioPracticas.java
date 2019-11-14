package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.PracticaDAO;
import ar.com.IOO.SGP.dao.ValorCriticoDAO;
import ar.com.IOO.SGP.dao.ValorReservadoDAO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.modelo.Practica;

public class ServicioPracticas extends ServicioBase{

	PracticaDAO practicaDAO = new PracticaDAO();
	ValorCriticoDAO valorCriticoDAO = new ValorCriticoDAO();
	ValorReservadoDAO valorReservadoDAO = new ValorReservadoDAO();
	
	public void alta(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroExistenteException {
		Practica practicaParaGuardar = this.servicioMapeo.mapear(unaPractica);
		
		valorCriticoDAO.insertar(practicaParaGuardar.getValoresCriticos());
		valorReservadoDAO.insertar(practicaParaGuardar.getValoresReservados());
		practicaDAO.insertar(practicaParaGuardar);
		
	}
	
}
