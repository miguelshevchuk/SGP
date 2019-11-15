package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorCriticoDAO extends ValorResultadoDAO{

	public ValorCriticoDAO() {
		super("ValorCritico.txt", ValorResultado.class, "CodigoPractica");
	}

}
