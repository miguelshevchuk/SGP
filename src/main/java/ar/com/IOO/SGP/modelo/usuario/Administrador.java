package ar.com.IOO.SGP.modelo.usuario;

import ar.com.IOO.SGP.servicio.ROLEnum;

public class Administrador extends Rol {

	public Administrador() {
		super(ROLEnum.ADM.getCodigo());
	}

	@Override
	public Boolean puedoRealizar(String unaTarea) {
		return Boolean.TRUE;
	}

}
