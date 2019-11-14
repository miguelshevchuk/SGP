package ar.com.IOO.SGP.servicio;

public enum GrupoPracticaEnum {

	BAS(1, "Complejidad basica"),
	MED(2, "Complejidad media"),
	ALT(3, "Complejidad alta");
	
	
	private Integer codigo;
	private String descripcion;

	private GrupoPracticaEnum(Integer codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public GrupoPracticaEnum getGrupoPorCodigo(Integer codigo) {
		if(GrupoPracticaEnum.BAS.getCodigo() == codigo) {
			return GrupoPracticaEnum.BAS;
		}else if(GrupoPracticaEnum.MED.getCodigo() == codigo) {
			return GrupoPracticaEnum.MED;
		}else {
			return GrupoPracticaEnum.ALT;
		}
	}
	
}
