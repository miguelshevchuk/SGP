package ar.com.IOO.SGP.excepcion;

public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	private String codigo;
	private String descripcion;

	protected BaseException(String unCodigo, String unaDescripcion){
		this.codigo = unCodigo;
		this.descripcion = unaDescripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
