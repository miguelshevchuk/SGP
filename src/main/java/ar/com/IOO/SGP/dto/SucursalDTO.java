package ar.com.IOO.SGP.dto;

public class SucursalDTO {

	private String numero;
	private String direccion;
	private UsuarioDTO responsableTecnico;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public UsuarioDTO getResponsableTecnico() {
		return responsableTecnico;
	}

	public void setResponsableTecnico(UsuarioDTO responsableTecnico) {
		this.responsableTecnico = responsableTecnico;
	}

}
