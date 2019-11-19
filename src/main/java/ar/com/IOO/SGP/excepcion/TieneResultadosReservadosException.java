package ar.com.IOO.SGP.excepcion;

public class TieneResultadosReservadosException extends BaseException{

	private static final long serialVersionUID = 1L;

	public TieneResultadosReservadosException() {
		super("PETIC_RESERVADA", "Por favor, retirar los resultados por la sucursal");
	}

}
