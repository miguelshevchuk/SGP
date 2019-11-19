package ar.com.IOO.SGP.excepcion;

public class TienePeticionesCompletasException extends BaseException{

	private static final long serialVersionUID = 1L;

	public TienePeticionesCompletasException() {
		super("PETICIONES_COMPLETAS", "No se puede eliminar. Tiene peticiones completas");
	}

}