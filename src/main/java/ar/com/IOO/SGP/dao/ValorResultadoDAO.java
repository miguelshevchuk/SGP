package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Practica;
import ar.com.IOO.SGP.modelo.ValorDesdeHasta;
import ar.com.IOO.SGP.modelo.ValorPositivoNegativo;
import ar.com.IOO.SGP.modelo.ValorResultado;

public abstract class ValorResultadoDAO extends BaseDAO<ValorResultado>{

	public ValorResultadoDAO(String nombreArchivo, Class<ValorResultado> typeParameterClass, String identificador) {
		super(nombreArchivo, typeParameterClass, identificador);
	}

	public void insertar(ValorResultado unValor) throws ErrorGenericoException, RegistroExistenteException {
		super.insertar(unValor);
	}
	
	public ValorResultado buscarPorPractica(Practica unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		if(unaPractica.getTipoResultado() == 1) {
			return (ValorDesdeHasta) super.traerRegistroPor(unaPractica.getCodigo(), ValorDesdeHasta.class);
		}else {
			return (ValorPositivoNegativo) super.traerRegistroPor(unaPractica.getCodigo(), ValorPositivoNegativo.class);
		}
		
	}
	
	public void eliminar(String unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		super.eliminarRegistro(unaPractica);
		
	}
	
	public void modificar(ValorResultado unValor) throws ErrorGenericoException, RegistroInexistenteException {
		
		super.modificar(unValor);
		
	}
	
}
