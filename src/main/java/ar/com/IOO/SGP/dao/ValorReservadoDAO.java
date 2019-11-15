package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorReservadoDAO extends ValorResultadoDAO{

	public ValorReservadoDAO() {
		super("ValorReservado.txt", ValorResultado.class, "CodigoPractica");
	}

}
