package ar.com.IOO.SGP.modelo;

public class ValorDesdeHasta extends ValorResultado{

	private Integer valorDesde;
	private Integer valorHasta;

	public Boolean cumpleValor(Object unValor){
		
		return ((Integer)unValor >= valorDesde) && ((Integer)unValor <= valorHasta) ;
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
