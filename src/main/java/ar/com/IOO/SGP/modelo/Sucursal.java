package ar.com.IOO.SGP.modelo;

public class Sucursal {

	private String numero;
	private String direccion;
	private Usuario responsableTecnico;

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

	public Usuario getResponsableTecnico() {
		return responsableTecnico;
	}

	public void setResponsableTecnico(Usuario responsableTecnico) {
		this.responsableTecnico = responsableTecnico;
	}

}
