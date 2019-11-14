package ar.com.IOO.SGP.modelo;

public abstract class ValorResultado {
	
	private String codigoPractica;

	public abstract Boolean cumpleValor(Object unValor);

	public String getCodigoPractica() {
		return codigoPractica;
	}

	public void setCodigoPractica(String codigoPractica) {
		this.codigoPractica = codigoPractica;
	}
	
}
