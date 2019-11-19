package ar.com.IOO.SGP.modelo;

public class ValorDesdeHasta extends ValorResultado{

	private Integer valorDesde;
	private Integer valorHasta;

	public Boolean cumpleValor(Object unValor){
		
		return (Integer.parseInt(unValor.toString()) >= valorDesde) && (Integer.parseInt(unValor.toString()) <= valorHasta) ;
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
