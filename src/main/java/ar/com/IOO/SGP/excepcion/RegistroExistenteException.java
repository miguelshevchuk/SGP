package ar.com.IOO.SGP.excepcion;

public class RegistroExistenteException extends BaseException{

	private static final long serialVersionUID = 1L;

	public RegistroExistenteException() {
		super("REG_EXISTENTE", "Ya existe un registro con el identificador ingresado. Por favor, ingrese otro identificador");
	}
	
}
