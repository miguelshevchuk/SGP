package ar.com.IOO.SGP.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dao.SucursalDAO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Sucursal;

public class ServicioSucursales extends ServicioBase{
	
	private SucursalDAO sucursalDAO = new SucursalDAO();
	private ServicioUsuarios servicioUsuario = new ServicioUsuarios();
	private ServicioPeticiones servicioPeticiones= new ServicioPeticiones();
	
	public void alta(SucursalDTO unaSucursal) throws BaseException{
		
		this.sucursalDAO.alta(this.servicioMapeo.mapear(unaSucursal));
		
	}
	
	public List<SucursalDTO> buscarSucursales() throws BaseException {
		
		List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
		
		for(Sucursal sucursal: this.sucursalDAO.buscarSucursales()) {
			SucursalDTO sucursalDTO = this.servicioMapeo.mapear(sucursal);
			
			this.completarSucursal(sucursalDTO);
			
			sucursales.add(sucursalDTO);
		}
		return sucursales;
	}
	
	public SucursalDTO buscarSucursal(String numero) throws BaseException {
		Sucursal sucursal = this.sucursalDAO.buscarSucursal(numero);
		
		SucursalDTO sucursalDTO = this.servicioMapeo.mapear(sucursal);
		
		this.completarSucursal(sucursalDTO);
		
		return sucursalDTO;
	}
	
	private void completarSucursal(SucursalDTO sucursalDTO) throws ErrorGenericoException, RegistroInexistenteException {
		UsuarioDTO responsable = this.servicioUsuario.buscarUsuario(sucursalDTO.getResponsableTecnico().getDni());
		sucursalDTO.setResponsableTecnico(responsable);
	}
	
	public void modificar(SucursalDTO sucursal, String sucursalDestino) throws ErrorGenericoException {
		
		if(servicioPeticiones.tienePeticionesCompletas(sucursal)){
			
		}
		
		this.sucursalDAO.modificar(this.servicioMapeo.mapear(sucursal));
	}
	
	public void eliminar(String numero) throws ErrorGenericoException {
		this.sucursalDAO.eliminar(numero);
	}

}
