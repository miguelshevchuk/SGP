package ar.com.IOO.SGP.servicio;

import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.dto.ValorDesdeHastaDTO;
import ar.com.IOO.SGP.dto.ValorPositivoNegativoDTO;
import ar.com.IOO.SGP.dto.ValorResultadoDTO;
import ar.com.IOO.SGP.modelo.Administrador;
import ar.com.IOO.SGP.modelo.Laboratorista;
import ar.com.IOO.SGP.modelo.Paciente;
import ar.com.IOO.SGP.modelo.Peticion;
import ar.com.IOO.SGP.modelo.Practica;
import ar.com.IOO.SGP.modelo.PracticaPeticion;
import ar.com.IOO.SGP.modelo.Recepcionista;
import ar.com.IOO.SGP.modelo.Sucursal;
import ar.com.IOO.SGP.modelo.Usuario;
import ar.com.IOO.SGP.modelo.ValorDesdeHasta;
import ar.com.IOO.SGP.modelo.ValorPositivoNegativo;
import ar.com.IOO.SGP.modelo.ValorResultado;

public class ServicioMapeo {

	public static Paciente mapear(PacienteDTO unPaciente){
		Paciente paciente = new Paciente();
		paciente.setDni(unPaciente.getDni());
		paciente.setNombre(unPaciente.getNombre());
		paciente.setEdad(unPaciente.getEdad());
		
		return paciente;
	}
	
	public static PacienteDTO mapear(Paciente unPaciente){
		PacienteDTO paciente = new PacienteDTO();
		paciente.setDni(unPaciente.getDni());
		paciente.setNombre(unPaciente.getNombre());
		paciente.setEdad(unPaciente.getEdad());
		
		return paciente;
	}
	
	public static Peticion mapear(PeticionDTO unaPeticion){
		Peticion peticion = new Peticion();
		peticion.setPaciente(mapear(unaPeticion.getPaciente()));
		peticion.setSucursal(mapear(unaPeticion.getSucursal()));
		peticion.setObraSocial(unaPeticion.getObraSocial());
		peticion.setIdPeticion(unaPeticion.getIdPeticion());
		peticion.setEstado(unaPeticion.getEstado());
		peticion.setFechaDeCarga(unaPeticion.getFechaDeCarga());
		
		for(PracticaPeticionDTO practicaPeticion: unaPeticion.getPracticas()) {
			peticion.getPracticas().add(mapear(practicaPeticion));
		}
		
		return peticion;
	}
	
	public static PeticionDTO mapear(Peticion unaPeticion){
		PeticionDTO peticion = new PeticionDTO();
		peticion.setPaciente(mapear(unaPeticion.getPaciente()));
		peticion.setSucursal(mapear(unaPeticion.getSucursal()));
		peticion.setObraSocial(unaPeticion.getObraSocial());
		peticion.setIdPeticion(unaPeticion.getIdPeticion());
		peticion.setEstado(unaPeticion.getEstado());
		peticion.setFechaDeCarga(unaPeticion.getFechaDeCarga());
		
		for(PracticaPeticion practicaPeticion: unaPeticion.getPracticas()) {
			peticion.getPracticas().add(mapear(practicaPeticion));
		}
		
		return peticion;
	}
	
	public static PracticaPeticion mapear(PracticaPeticionDTO practicaPeticion) {
		PracticaPeticion practicaPeticionMapeada = new PracticaPeticion();
		
		practicaPeticionMapeada.setPractica(mapear(practicaPeticion.getPractica()));
		practicaPeticionMapeada.setResultado(practicaPeticion.getResultado());
		
		return practicaPeticionMapeada;
	}

	public static PracticaPeticionDTO mapear(PracticaPeticion practicaPeticion) {
		PracticaPeticionDTO practicaPeticionMapeada = new PracticaPeticionDTO();
		
		practicaPeticionMapeada.setPractica(mapear(practicaPeticion.getPractica()));
		practicaPeticionMapeada.setResultado(practicaPeticion.getResultado());
		
		return practicaPeticionMapeada;
	}
	
	public static Usuario mapear(UsuarioDTO unUsuario){
		Usuario usuario = new Usuario();
		usuario.setDni(unUsuario.getDni());
		usuario.setNombre(unUsuario.getNombre());
		usuario.setUserName(unUsuario.getUserName());
		usuario.setPassword(unUsuario.getPassword());
		
		if(unUsuario.getRol() != null) {
			if(unUsuario.getRol().equals("Administrador")) {
				usuario.setRol(new Administrador());
			}else if(unUsuario.getRol().equals("Recepcionista")) {
				usuario.setRol(new Recepcionista());
			}else {
				usuario.setRol(new Laboratorista());
			}
		}
		
		return usuario;
	}
	
	public static UsuarioDTO mapear(Usuario unUsuario){
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setDni(unUsuario.getDni());
		usuario.setNombre(unUsuario.getNombre());
		usuario.setUserName(unUsuario.getUserName());
		usuario.setPassword(unUsuario.getPassword());
		
		usuario.setRol(unUsuario.getRol().getNombreRol());
		
		return usuario;
	}
	
	public static Practica mapear(PracticaDTO unaPracticaDTO){
		Practica unaPractica = new Practica();
		unaPractica.setCodigo(unaPracticaDTO.getCodigo());
		unaPractica.setNombre(unaPracticaDTO.getNombre());
		unaPractica.setGrupo(unaPracticaDTO.getGrupo());
		unaPractica.setHorasResultado(unaPracticaDTO.getHorasResultado());
		unaPractica.setHabilitada(unaPracticaDTO.getHabilitada());
		unaPractica.setTipoResultado(unaPracticaDTO.getTipoResultado());
		
		
		if(unaPracticaDTO.getTipoResultado() == 1) {
			ValorDesdeHasta valorCritico = new ValorDesdeHasta();
			ValorDesdeHasta valorReservado = new ValorDesdeHasta();
			
			valorCritico.setCodigoPractica(unaPracticaDTO.getCodigo());
			valorReservado.setCodigoPractica(unaPracticaDTO.getCodigo());
			
			valorCritico.setValorDesde(((ValorDesdeHastaDTO)unaPracticaDTO.getValoresCriticos()).getValorDesde());
			valorCritico.setValorHasta(((ValorDesdeHastaDTO)unaPracticaDTO.getValoresCriticos()).getValorHasta());
			
			valorReservado.setValorDesde(((ValorDesdeHastaDTO)unaPracticaDTO.getValoresReservados()).getValorDesde());
			valorReservado.setValorHasta(((ValorDesdeHastaDTO)unaPracticaDTO.getValoresReservados()).getValorHasta());
			
			unaPractica.setValoresCriticos(valorCritico);
			unaPractica.setValoresReservados(valorReservado);
		}else {
			ValorPositivoNegativo valorCritico = new ValorPositivoNegativo();
			ValorPositivoNegativo valorReservado = new ValorPositivoNegativo();
			
			valorCritico.setCodigoPractica(unaPracticaDTO.getCodigo());
			valorReservado.setCodigoPractica(unaPracticaDTO.getCodigo());
			
			valorCritico.setValor(((ValorPositivoNegativoDTO)unaPracticaDTO.getValoresCriticos()).getValor());
			
			valorReservado.setValor(((ValorPositivoNegativoDTO)unaPracticaDTO.getValoresReservados()).getValor());
			
			unaPractica.setValoresCriticos(valorCritico);
			unaPractica.setValoresReservados(valorReservado);
		}
		
		
		return unaPractica;
	}
	
	public static PracticaDTO mapear(Practica unaPracticaDTO){
		PracticaDTO unaPractica = new PracticaDTO();
		unaPractica.setCodigo(unaPracticaDTO.getCodigo());
		unaPractica.setNombre(unaPracticaDTO.getNombre());
		unaPractica.setGrupo(unaPracticaDTO.getGrupo());
		unaPractica.setHorasResultado(unaPracticaDTO.getHorasResultado());
		unaPractica.setHabilitada(unaPracticaDTO.getHabilitada());
		unaPractica.setTipoResultado(unaPracticaDTO.getTipoResultado());
		
		
		if(unaPracticaDTO.getTipoResultado() == 1) {
			ValorDesdeHastaDTO valorCritico = new ValorDesdeHastaDTO();
			ValorDesdeHastaDTO valorReservado = new ValorDesdeHastaDTO();
			
			valorCritico.setCodigoPractica(unaPracticaDTO.getCodigo());
			valorReservado.setCodigoPractica(unaPracticaDTO.getCodigo());
			
			valorCritico.setValorDesde(((ValorDesdeHasta)unaPracticaDTO.getValoresCriticos()).getValorDesde());
			valorCritico.setValorHasta(((ValorDesdeHasta)unaPracticaDTO.getValoresCriticos()).getValorHasta());
			
			valorReservado.setValorDesde(((ValorDesdeHasta)unaPracticaDTO.getValoresReservados()).getValorDesde());
			valorReservado.setValorHasta(((ValorDesdeHasta)unaPracticaDTO.getValoresReservados()).getValorHasta());
			
			unaPractica.setValoresCriticos(valorCritico);
			unaPractica.setValoresReservados(valorReservado);
		}else {
			ValorPositivoNegativoDTO valorCritico = new ValorPositivoNegativoDTO();
			ValorPositivoNegativoDTO valorReservado = new ValorPositivoNegativoDTO();
			
			valorCritico.setCodigoPractica(unaPracticaDTO.getCodigo());
			valorReservado.setCodigoPractica(unaPracticaDTO.getCodigo());
			
			valorCritico.setValor(((ValorPositivoNegativo)unaPracticaDTO.getValoresCriticos()).getValor());
			
			valorReservado.setValor(((ValorPositivoNegativo)unaPracticaDTO.getValoresReservados()).getValor());
			
			unaPractica.setValoresCriticos(valorCritico);
			unaPractica.setValoresReservados(valorReservado);
		}
		
		
		return unaPractica;
	}
	
	public static ValorResultado mapear(ValorResultadoDTO valorResultado){
		
		if(valorResultado instanceof ValorDesdeHastaDTO) {
			ValorDesdeHasta valorMapeado = new ValorDesdeHasta();
			
			valorMapeado.setCodigoPractica(valorResultado.getCodigoPractica());
			
			valorMapeado.setValorDesde(((ValorDesdeHastaDTO)valorResultado).getValorDesde());
			
			valorMapeado.setValorHasta(((ValorDesdeHastaDTO)valorResultado).getValorHasta());
			
			return valorMapeado;
		}else {
			ValorPositivoNegativo valorMapeado = new ValorPositivoNegativo();
			
			valorMapeado.setCodigoPractica(((ValorPositivoNegativoDTO)valorResultado).getCodigoPractica());
			valorMapeado.setValor(((ValorPositivoNegativoDTO)valorResultado).getValor());
			
			return valorMapeado;
		}
		
	}
	
	public static SucursalDTO mapear(Sucursal unaSucursal){
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setDireccion(unaSucursal.getDireccion());
		sucursalDTO.setNumero(unaSucursal.getNumero());
		UsuarioDTO responsable = new UsuarioDTO();
		responsable.setDni(unaSucursal.getResponsableTecnico().getDni());
		sucursalDTO.setResponsableTecnico(responsable);
		
		return sucursalDTO;
	}
	
	public static Sucursal mapear(SucursalDTO unaSucursal){
		Sucursal sucursalDTO = new Sucursal();
		sucursalDTO.setDireccion(unaSucursal.getDireccion());
		sucursalDTO.setNumero(unaSucursal.getNumero());
		Usuario responsable = new Usuario();
		responsable.setDni(unaSucursal.getResponsableTecnico().getDni());
		sucursalDTO.setResponsableTecnico(responsable);
		
		return sucursalDTO;
	}
	
	
}
