package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorReservadoDAO extends ValorResultadoDAO{

	private static ValorReservadoDAO instancia;
	
	public static ValorReservadoDAO getInstancia() {
		return (instancia == null)? new ValorReservadoDAO() : instancia;
	}
	
	public ValorReservadoDAO() {
		super("ValorReservado.txt", ValorResultado.class, "CodigoPractica");
	}

}
