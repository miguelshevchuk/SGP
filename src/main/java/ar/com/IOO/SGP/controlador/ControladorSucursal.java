package ar.com.IOO.SGP.controlador;

import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.servicio.ServicioSucursales;

public class ControladorSucursal {

	private ServicioSucursales servicio = new ServicioSucursales();
	private static ControladorSucursal instancia;
	
	public static ControladorSucursal getInstancia() {
		if(instancia == null) {
			instancia = new ControladorSucursal();
		}
		return instancia;
	}
	
	public void alta(SucursalDTO unaSucursal) throws BaseException {
		this.servicio.alta(unaSucursal);
	}
	
	
}
