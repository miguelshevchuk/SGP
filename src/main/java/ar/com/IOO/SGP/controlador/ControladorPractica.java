package ar.com.IOO.SGP.controlador;

import java.util.ArrayList;
import java.util.List;

import ar.com.IOO.SGP.dto.ComboDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.servicio.GrupoPracticaEnum;
import ar.com.IOO.SGP.servicio.ServicioPracticas;

public class ControladorPractica {

	ServicioPracticas servicio = new ServicioPracticas();
	private static ControladorPractica instancia;
	
	public static ControladorPractica getInstancia() {
		if(instancia == null) {
			instancia = new ControladorPractica();
		}
		return instancia;
	}
	
	public List<ComboDTO> buscarGruposPosibles(){
		
		List<ComboDTO> grupos = new ArrayList<ComboDTO>();
		
		ComboDTO basicos = new ComboDTO(GrupoPracticaEnum.BAS.getCodigo(), GrupoPracticaEnum.BAS.getDescripcion());
		ComboDTO medio = new ComboDTO(GrupoPracticaEnum.MED.getCodigo(), GrupoPracticaEnum.MED.getDescripcion());
		ComboDTO alta = new ComboDTO(GrupoPracticaEnum.ALT.getCodigo(), GrupoPracticaEnum.ALT.getDescripcion());
		
		grupos.add(basicos);
		grupos.add(medio);
		grupos.add(alta);
		
		return grupos;
	}
	
	public List<ComboDTO> buscarTiposDeResultadosPosibles(){
		
		List<ComboDTO> grupos = new ArrayList<ComboDTO>();
		
		ComboDTO basicos = new ComboDTO(1, "Desde/Hasta");
		ComboDTO medio = new ComboDTO(2, "Positivo/Negativo");
		
		grupos.add(basicos);
		grupos.add(medio);
		
		return grupos;
	}
	
	public void alta(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroExistenteException, PermisoDenegadoException {
		servicio.alta(unaPractica);
	}
	
	public List<PracticaDTO> buscarPracticas() throws BaseException {
		return servicio.buscarPracticas();
	}
	
	public void eliminar(String codigo) throws BaseException{
		servicio.eliminar(codigo);
	}
	
	public PracticaDTO buscar(String unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		return servicio.buscar(unaPractica);
	}
	
	public void modificar(PracticaDTO unaPractica) throws ErrorGenericoException, RegistroInexistenteException, PermisoDenegadoException {
		servicio.modificar(unaPractica);
	}
	
	public List<PracticaDTO> buscarPracticasDel(Integer grupo) throws BaseException{
		return servicio.buscarPracticasPor(grupo);
	}
	
}
