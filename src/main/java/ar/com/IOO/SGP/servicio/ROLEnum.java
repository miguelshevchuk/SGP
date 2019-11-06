package ar.com.IOO.SGP.servicio;

public enum ROLEnum {

	LAB("Laboratorista"),
	ADM("Administrador"),
	REC("Recepcionista");
	
	private String codigo;
	
	private ROLEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public ROLEnum getROLPorCodigo(String codigo) {
		if(ROLEnum.LAB.getCodigo().equals(codigo)) {
			return ROLEnum.LAB;
		}else if(ROLEnum.REC.getCodigo().equals(codigo)) {
			return ROLEnum.REC;
		}else {
			return ROLEnum.ADM;
		}
	}
	
}
