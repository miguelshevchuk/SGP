package ar.com.IOO.SGP.grafico;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import ar.com.IOO.SGP.excepcion.BaseException;

public abstract class BasePanel extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3955733027699942248L;

	protected void mostrarError(BaseException excepcion) {
		JOptionPane.showMessageDialog(this, excepcion.getDescripcion());
	}
	
	protected void mostrarOk() {
		JOptionPane.showMessageDialog(this, "La operacion se realizo con exito");
	}
	
}
