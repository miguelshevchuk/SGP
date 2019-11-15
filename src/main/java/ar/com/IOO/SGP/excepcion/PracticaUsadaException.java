package ar.com.IOO.SGP.excepcion;

public class PracticaUsadaException extends BaseException{

	private static final long serialVersionUID = 1L;

	public PracticaUsadaException() {
		super("PRACTICA_USADA", "La practica fue usada en alguna peticion. Puede deshabilitar la practica para nuevos usos desde el menu de modificacion");
	}

}
