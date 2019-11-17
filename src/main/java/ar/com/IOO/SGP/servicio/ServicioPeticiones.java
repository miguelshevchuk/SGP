package ar.com.IOO.SGP.servicio;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import ar.com.IOO.SGP.dao.PeticionDAO;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.modelo.Peticion;
import ar.com.IOO.SGP.modelo.PracticaPeticion;
import ar.com.IOO.SGP.modelo.Sucursal;

public class ServicioPeticiones extends ServicioBase{
	
	private static ServicioPeticiones instancia;
	
	public static ServicioPeticiones getInstancia() {
		return (instancia == null)? new ServicioPeticiones() : instancia;
	}

	public void altaPeticion(PeticionDTO unaPeticion) throws ErrorGenericoException, RegistroExistenteException{
		
		unaPeticion.setFechaDeCarga(new Date());
		unaPeticion.setIdPeticion(UUID.randomUUID().toString());
		
		
		for(PracticaPeticionDTO resultado : unaPeticion.getPracticas()) {
			resultado.setIdResultado(UUID.randomUUID().toString());
			resultado.setIdPeticion(unaPeticion.getIdPeticion());
			ServicioResultados.getInstancia().alta(resultado);
		}
		
		unaPeticion.setPracticas(null);
		PeticionDAO.getInstancia().altaPeticion(ServicioMapeo.mapear(unaPeticion));
			
	}
	
	public void eliminar(String idPeticion) throws ErrorGenericoException{
		ServicioResultados.getInstancia().eliminarResultadosDe(idPeticion);
		PeticionDAO.getInstancia().bajaPeticion(idPeticion);
		
	}
	

	public void modificarPeticion(PeticionDTO unaPeticion) throws ErrorGenericoException{
		unaPeticion.setPracticas(null);
		PeticionDAO.getInstancia().modificarPeticion(ServicioMapeo.mapear(unaPeticion));
		
	}
	
	public List<PeticionDTO> buscarPeticiones() throws BaseException{
		
		List<Peticion> peticionesGuardadas = PeticionDAO.getInstancia().buscarPeticiones();
		
		for(Peticion peticion: peticionesGuardadas) {
			this.completarPeticion(peticion);
		}
		
		return peticionesGuardadas.stream().map(peticion -> ServicioMapeo.mapear(peticion))
				.collect(Collectors.toList());
	}
	
	public PeticionDTO buscarPeticion(String idPeticion) throws BaseException{
		
		Peticion peticion = PeticionDAO.getInstancia().buscarPeticion(idPeticion);
		
		this.completarPeticion(peticion);
		
		return ServicioMapeo.mapear(peticion);
	}
	
	private void completarPeticion(Peticion unaPeticion) throws BaseException {
		PacienteDTO paciente = ServicioPacientes.getInstancia().buscarPaciente(unaPeticion.getPaciente().getDni());
		SucursalDTO sucursal = ServicioSucursales.getInstancia().buscarSucursal(unaPeticion.getSucursal().getNumero());
		List<PracticaPeticionDTO> resultados = ServicioResultados.getInstancia().buscarResultadosDe(unaPeticion.getIdPeticion());
		List<PracticaPeticion> resultadosMapeados = resultados.stream()
				.map(resultado -> ServicioMapeo.mapear(resultado)).collect(Collectors.toList());
		
		
		unaPeticion.setPaciente(ServicioMapeo.mapear(paciente));
		unaPeticion.setSucursal(ServicioMapeo.mapear(sucursal));
		unaPeticion.setPracticas(resultadosMapeados);
		
	}

	public Boolean tienePeticionesCompletas(PacienteDTO unPaciente) throws BaseException{
		
		List<Peticion> peticionesDelPaciente = this.buscarPeticionesDe(unPaciente);
		
		return !filtrarPeticionesCompletas(peticionesDelPaciente).isEmpty();
		
	}
	
	public Boolean tienePeticionesCompletas(SucursalDTO unaSucursal) throws BaseException{
		
		List<Peticion> peticionesDeLaSucursal = this.buscarPeticionesDe(unaSucursal);
		
		return !filtrarPeticionesCompletas(peticionesDeLaSucursal).isEmpty();
		
	}
	
	private List<Peticion> filtrarPeticionesCompletas(List<Peticion> peticionesDelPaciente){
		
		return peticionesDelPaciente.stream().filter(peticion -> peticion.estaCompleta()).collect(Collectors.toList());

	}
	
	private List<Peticion> buscarPeticionesDe(PacienteDTO unPaciente) throws BaseException{
		
		List<PeticionDTO> peticionesDTO = this.buscarPeticiones();
		
		return peticionesDTO.stream()
				.map(peticion -> ServicioMapeo.mapear(peticion))
				.filter(peticion -> peticion.laPeticionEsDelPaciente(unPaciente.getDni()))
				.collect(Collectors.toList());
	}
	
	private List<Peticion> buscarPeticionesDe(SucursalDTO unaSucursal) throws BaseException{
		
		List<PeticionDTO> peticionesDTO = this.buscarPeticiones();
		
		return peticionesDTO.stream()
				.map(peticion -> ServicioMapeo.mapear(peticion))
				.filter(peticion -> peticion.laPeticionEsDeLaSucursal(unaSucursal.getNumero()))
				.collect(Collectors.toList());
	}
	
	public Boolean hayPeticionesDe(String unaPractica) throws BaseException {
		
		List<PeticionDTO> peticiones = this.buscarPeticiones();
		
		return peticiones.stream()
				.map(peticion -> ServicioMapeo.mapear(peticion))
				.anyMatch(peticion -> peticion.tiene(unaPractica));
	}
	
	public void pasarPeticionesDe(SucursalDTO unaSucursal, String otraSucursal) throws BaseException {
		
		List<Peticion> peticiones = buscarPeticionesDe(unaSucursal);
		
		Sucursal sucursalNueva = new Sucursal();
		sucursalNueva.setNumero(otraSucursal);
		
		for(Peticion peticion : peticiones) {
			peticion.setSucursal(sucursalNueva);
			PeticionDAO.getInstancia().modificarPeticion(peticion);
		}
	}

	
}
