package ar.com.IOO.SGP.excepcion;

public class RegistroInexistenteException extends BaseException{

	private static final long serialVersionUID = 1L;

	public RegistroInexistenteException() {
		super("REF_NO_EXISTE", "El registro que esta buscando no existe");
	}
	
}
