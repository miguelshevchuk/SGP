package ar.com.IOO.SGP.modelo.peticion;

public class Practica {
	private Integer codigo;
	private String nombre;
	private Integer grupo;
	private ValorResultado valoresCriticos;
	private ValorResultado valoresReservados;
	private Integer horasResultado;
	private Boolean habilitada;

	public Boolean esValorReservado(Integer unValor) {
		return this.valoresReservados.cumpleValor(unValor);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

}
