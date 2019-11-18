package ar.com.IOO.SGP.dto;

public class PracticaDTO {

	private String codigo;
	private String nombre;
	private Integer grupo;
	private ValorResultadoDTO valoresCriticos;
	private ValorResultadoDTO valoresReservados;
	private Integer horasResultado;
	private Boolean habilitada;
	private Integer tipoResultado;

	public PracticaDTO() {}
	public PracticaDTO(String codigo) {
		this.codigo = codigo;
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

	public ValorResultadoDTO getValoresCriticos() {
		return valoresCriticos;
	}

	public void setValoresCriticos(ValorResultadoDTO valoresCriticos) {
		this.valoresCriticos = valoresCriticos;
	}

	public ValorResultadoDTO getValoresReservados() {
		return valoresReservados;
	}

	public void setValoresReservados(ValorResultadoDTO valoresReservados) {
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
