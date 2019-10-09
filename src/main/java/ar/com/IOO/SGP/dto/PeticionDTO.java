package ar.com.IOO.SGP.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionDTO {

	private PacienteDTO paciente;
	private String obraSocial;
	private Date fechaDeCarga;
	private List<PracticaPeticionDTO> practicas = new ArrayList<PracticaPeticionDTO>();
	private Date fechaEntrega;
	private String idPeticion;
	private String estado;
	private SucursalDTO sucursal;

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Date getFechaDeCarga() {
		return fechaDeCarga;
	}

	public void setFechaDeCarga(Date fechaDeCarga) {
		this.fechaDeCarga = fechaDeCarga;
	}

	public List<PracticaPeticionDTO> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<PracticaPeticionDTO> practicas) {
		this.practicas = practicas;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

}
