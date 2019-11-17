package ar.com.IOO.SGP.dto;

public class PracticaPeticionDTO {

	private String idPeticion;
	private String idResultado;
	private PracticaDTO practica;
	private Object resultado;

	public PracticaDTO getPractica() {
		return practica;
	}

	public void setPractica(PracticaDTO practica) {
		this.practica = practica;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public String getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}

	public String getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(String idResultado) {
		this.idResultado = idResultado;
	}

}
