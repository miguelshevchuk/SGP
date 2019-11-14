package ar.com.IOO.SGP.modelo;

public class ValorPositivoNegativo extends ValorResultado {

	private Boolean valor;

	@Override
	public Boolean cumpleValor(Object unValor) {
		return (Boolean) unValor == this.valor;
	}

	public Boolean getValor() {
		return valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

}
