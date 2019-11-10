package ar.com.IOO.SGP.modelo;

public class ValorResultado {

	private Integer valorDesde;
	private Integer valorHasta;

	public Boolean cumpleValor(Integer unValor){
		return (unValor >= valorDesde) && (unValor <= valorHasta) ;
	}
	
	public Integer getValorDesde() {
		return valorDesde;
	}

	public void setValorDesde(Integer valorDesde) {
		this.valorDesde = valorDesde;
	}

	public Integer getValorHasta() {
		return valorHasta;
	}

	public void setValorHasta(Integer valorHasta) {
		this.valorHasta = valorHasta;
	}

}
