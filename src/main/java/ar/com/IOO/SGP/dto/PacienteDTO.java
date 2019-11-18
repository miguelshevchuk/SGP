package ar.com.IOO.SGP.dto;

public class PacienteDTO extends PersonaDTO{

	public PacienteDTO() {
		
	}
	
	public PacienteDTO(String dni) {
		this.setDni(dni);
	}
	
	@Override
	public String toString() {
		return this.getDni()+" - "+this.getNombre();
	}

}
