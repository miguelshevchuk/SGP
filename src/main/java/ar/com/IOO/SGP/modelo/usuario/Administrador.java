package ar.com.IOO.SGP.modelo.usuario;

public class Administrador extends Rol {

	@Override
	public Boolean puedoRealizar(String unaTarea) {
		return Boolean.TRUE;
	}

}
