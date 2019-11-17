package ar.com.IOO.SGP.dao;

import java.util.List;

import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.modelo.Sucursal;

public class SucursalDAO extends BaseDAO<Sucursal>{

	private static SucursalDAO instancia;
	
	public static SucursalDAO getInstancia() {
		return (instancia == null)? new SucursalDAO() : instancia;
	}
	
	public SucursalDAO() {
		super("sucursal.txt", Sucursal.class, "Numero");
	}

	public void alta(Sucursal unaSucursal) throws BaseException {
		super.insertar(unaSucursal);
	}
	
	public List<Sucursal> buscarSucursales() throws BaseException {
		return super.traerRegistros();
	}
	
	public Sucursal buscarSucursal(String numero) throws BaseException {
		return (Sucursal) super.traerRegistroPor(numero);
	}
	
	public void modificar(Sucursal sucursal) throws ErrorGenericoException {
		super.modificar(sucursal);
	}
	
	public void eliminar(String numero) throws ErrorGenericoException {
		super.eliminarRegistro(numero);
	}
}
