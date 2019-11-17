package ar.com.IOO.SGP.modelo;

public class PracticaPeticion {
	private String idPeticion;
	private String idResultado;
	private Practica practica;
	private Object resultado;

	public Boolean tieneResultadoReservado() {
		return this.practica.esValorReservado(this.resultado);
	}

	// GETTERS Y SETTERS

	public Practica getPractica() {
		return practica;
	}

	public void setPractica(Practica practica) {
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
