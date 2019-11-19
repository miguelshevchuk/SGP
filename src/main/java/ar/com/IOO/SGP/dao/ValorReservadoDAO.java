package ar.com.IOO.SGP.dao;

public class ValorReservadoDAO extends ValorResultadoDAO{

	private static ValorReservadoDAO instancia;
	
	public static ValorReservadoDAO getInstancia() {
		return (instancia == null)? new ValorReservadoDAO() : instancia;
	}
	
	public ValorReservadoDAO() {
		super("ValorReservado.txt");
	}

}
