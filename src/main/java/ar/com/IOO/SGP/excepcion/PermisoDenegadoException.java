package ar.com.IOO.SGP.excepcion;

public class PermisoDenegadoException extends BaseException{

	private static final long serialVersionUID = 1L;

	public PermisoDenegadoException() {
		super("PERMISO_DENEGADO", "Usted no posee autorizacion para realizar esta operacion");
	}

}
