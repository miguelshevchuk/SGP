package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.modelo.Sucursal;

public class SucursalDAO extends BaseDAO<Sucursal>{

	public SucursalDAO() {
		super("sucursal.txt", Sucursal.class, "Numero");
	}

	public void alta(Sucursal unaSucursal) throws BaseException {
		super.insertar(unaSucursal);
	}
	
}
