package ar.com.IOO.SGP.modelo;

import java.util.ArrayList;
import java.util.List;

public class Recepcionista extends Rol {

	private List<String> tareasDisponibles = new ArrayList<String>();
	
	public Recepcionista() {
		super("Recepcionista");
		tareasDisponibles.add("modifPaciente");
		tareasDisponibles.add("altaPaciente");
		tareasDisponibles.add("altaPeticion");
		tareasDisponibles.add("consResultados");
	}

	@Override
	public Boolean puedoRealizar(String unaTarea) {
		return this.tareasDisponibles.contains(unaTarea);
	}

	public List<String> getTareasDisponibles() {
		return tareasDisponibles;
	}

	public void setTareasDisponibles(List<String> tareasDisponibles) {
		this.tareasDisponibles = tareasDisponibles;
	}

}
