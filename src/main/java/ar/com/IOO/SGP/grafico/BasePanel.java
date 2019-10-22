package ar.com.IOO.SGP.grafico;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ar.com.IOO.SGP.excepcion.BaseException;

public abstract class BasePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3955733027699942248L;

	protected void mostrarError(BaseException excepcion) {
		JOptionPane.showMessageDialog(this, excepcion.getDescripcion());
	}
	
}
