package ar.com.IOO.SGP.modelo.peticion;

public class PracticaPeticion {
	private Practica practica;
	private Integer resultado;

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

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

}
