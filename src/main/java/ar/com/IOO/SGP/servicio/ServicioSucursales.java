package ar.com.IOO.SGP.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dao.SucursalDAO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;
import ar.com.IOO.SGP.modelo.Sucursal;

public class ServicioSucursales extends ServicioBase{
	
	private static ServicioSucursales instancia;
	
	public static ServicioSucursales getInstancia() {
		return (instancia == null)? new ServicioSucursales() : instancia;
	}
	
	public void alta(SucursalDTO unaSucursal) throws BaseException{
		
		SucursalDAO.getInstancia().alta(ServicioMapeo.mapear(unaSucursal));
		
	}
	
	public List<SucursalDTO> buscarSucursales() throws BaseException {
		
		List<SucursalDTO> sucursales = new ArrayList<SucursalDTO>();
		
		for(Sucursal sucursal: SucursalDAO.getInstancia().buscarSucursales()) {
			SucursalDTO sucursalDTO = ServicioMapeo.mapear(sucursal);
			
			this.completarSucursal(sucursalDTO);
			
			sucursales.add(sucursalDTO);
		}
		return sucursales;
	}
	
	public SucursalDTO buscarSucursal(String numero) throws BaseException {
		Sucursal sucursal = SucursalDAO.getInstancia().buscarSucursal(numero);
		
		SucursalDTO sucursalDTO = ServicioMapeo.mapear(sucursal);
		
		this.completarSucursal(sucursalDTO);
		
		return sucursalDTO;
	}
	
	private void completarSucursal(SucursalDTO sucursalDTO) throws ErrorGenericoException, RegistroInexistenteException {
		UsuarioDTO responsable = ServicioUsuarios.getInstancia().buscarUsuario(sucursalDTO.getResponsableTecnico().getDni());
		sucursalDTO.setResponsableTecnico(responsable);
	}
	
	public void modificar(SucursalDTO sucursal) throws ErrorGenericoException {
		
		SucursalDAO.getInstancia().modificar(ServicioMapeo.mapear(sucursal));
	}
	
	public void eliminar(String numero, String sucursalDestino) throws BaseException {
		
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setNumero(numero);
		
		if(ServicioPeticiones.getInstancia().tienePeticionesCompletas(sucursalDTO)){
			throw new TienePeticionesCompletasException();
		}
		
		ServicioPeticiones.getInstancia().pasarPeticionesDe(sucursalDTO, sucursalDestino);
		
		SucursalDAO.getInstancia().eliminar(numero);
	}

}
