package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorReservadoDAO extends BaseDAO<ValorResultado>{

	public ValorReservadoDAO() {
		super("ValorReservado.txt", ValorResultado.class, "CodigoPractica");
	}
	
	public void insertar(ValorResultado unValor) throws ErrorGenericoException, RegistroExistenteException {
		super.insertar(unValor);
	}

}
