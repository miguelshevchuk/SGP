package ar.com.IOO.SGP.excepcion;

public class ErrorGenericoException extends BaseException{

	private static final long serialVersionUID = 1L;

	public ErrorGenericoException() {
		super("ERROR_GENERICO", "Ocurrio un error inesperador. Por favor, contacte al administrador del sistema");
	}
	
}
