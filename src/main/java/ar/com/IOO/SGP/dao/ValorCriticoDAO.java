package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.modelo.ValorResultado;

public class ValorCriticoDAO extends ValorResultadoDAO{

	private static ValorCriticoDAO instancia;
	
	public static ValorCriticoDAO getInstancia() {
		return (instancia == null)? new ValorCriticoDAO() : instancia;
	}
	
	public ValorCriticoDAO() {
		super("ValorCritico.txt", ValorResultado.class, "CodigoPractica");
	}

}
