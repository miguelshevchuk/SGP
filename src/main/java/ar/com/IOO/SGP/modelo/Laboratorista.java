package ar.com.IOO.SGP.modelo;

import java.util.ArrayList;
import java.util.List;

public class Laboratorista extends Rol {

	public Laboratorista() {
		super("Laboratorista");
		tareasDisponibles.add("cargarResultado");
	}

	private List<String> tareasDisponibles = new ArrayList<String>();

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
