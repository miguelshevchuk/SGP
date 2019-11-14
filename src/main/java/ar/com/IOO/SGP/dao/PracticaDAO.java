package ar.com.IOO.SGP.dao;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.modelo.Practica;

public class PracticaDAO extends BaseDAO<Practica>{

	public PracticaDAO() {
		super("practica.txt", Practica.class, "Codigo");
	}

	public void insertar(Practica practica) throws ErrorGenericoException, RegistroExistenteException {
		//Esto es por que se va a guardar en otro archivo
		practica.setValoresCriticos(null);
		practica.setValoresReservados(null);
		
		super.insertar(practica);
	}
	
	
}
