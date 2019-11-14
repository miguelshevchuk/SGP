package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorCriticoDAO extends BaseDAO<ValorResultado>{

	public ValorCriticoDAO() {
		super("ValorCritico.txt", ValorResultado.class, "CodigoPractica");
	}

	public void insertar(ValorResultado unValor) throws ErrorGenericoException, RegistroExistenteException {
		super.insertar(unValor);
	}
	
}
