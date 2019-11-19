package ar.com.IOO.SGP.dao;

public class ValorCriticoDAO extends ValorResultadoDAO{

	private static ValorCriticoDAO instancia;
	
	public static ValorCriticoDAO getInstancia() {
		return (instancia == null)? new ValorCriticoDAO() : instancia;
	}
	
	public ValorCriticoDAO() {
		super("ValorCritico.txt");
	}

}
