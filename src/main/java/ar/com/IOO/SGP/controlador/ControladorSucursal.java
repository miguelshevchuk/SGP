package ar.com.IOO.SGP.controlador;

import java.util.List;

import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
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
	
	public List<SucursalDTO> buscarSucursales() throws BaseException {
		
		return servicio.buscarSucursales();
	}
	
	public SucursalDTO buscarSucursal(String numero) throws BaseException {
		
		return servicio.buscarSucursal(numero);
	}
	
	public void modificar(SucursalDTO sucursal) throws ErrorGenericoException {
		servicio.modificar(sucursal);
	}
	
	public void eliminar(String numero, String sucursalDestino) throws BaseException {
		servicio.eliminar(numero, sucursalDestino);
	}
	
	
}
