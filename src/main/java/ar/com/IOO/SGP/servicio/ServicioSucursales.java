package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dao.SucursalDAO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;

public class ServicioSucursales extends ServicioBase{
	
	private SucursalDAO sucursalDAO = new SucursalDAO();
	
	public void alta(SucursalDTO unaSucursal) throws BaseException{
		
		this.sucursalDAO.alta(this.servicioMapeo.mapear(unaSucursal));
		
	}
	
	public void bajaPractica(Integer idPractica){
		
	}
	
	public void modificarPractica(PracticaDTO unaPractica){
		
	}

}
