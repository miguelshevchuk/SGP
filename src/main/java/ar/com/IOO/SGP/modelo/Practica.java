package ar.com.IOO.SGP.modelo;

public class Practica {
	private String codigo;
	private String nombre;
	private Integer grupo;
	private ValorResultado valoresCriticos;
	private ValorResultado valoresReservados;
	private Integer horasResultado;
	private Boolean habilitada;
	private Integer tipoResultado;

	public Boolean esValorReservado(Object unValor) {
		return this.valoresReservados.cumpleValor(unValor);
	}
	
	public Boolean esValorCritico(Object unValor) {
		return this.valoresCriticos.cumpleValor(unValor);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public ValorResultado getValoresCriticos() {
		return valoresCriticos;
	}

	public void setValoresCriticos(ValorResultado valoresCriticos) {
		this.valoresCriticos = valoresCriticos;
	}

	public ValorResultado getValoresReservados() {
		return valoresReservados;
	}

	public void setValoresReservados(ValorResultado valoresReservados) {
		this.valoresReservados = valoresReservados;
	}

	public Integer getHorasResultado() {
		return horasResultado;
	}

	public void setHorasResultado(Integer horasResultado) {
		this.horasResultado = horasResultado;
	}

	public Boolean getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Boolean habilitada) {
		this.habilitada = habilitada;
	}

	public Integer getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(Integer tipoResultado) {
		this.tipoResultado = tipoResultado;
	}
	
}
