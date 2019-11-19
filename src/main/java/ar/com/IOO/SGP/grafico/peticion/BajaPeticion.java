package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.TienePeticionesCompletasException;
import ar.com.IOO.SGP.grafico.BasePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaPeticion extends BasePanel {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPeticion frame = new BajaPeticion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws BaseException 
	 */
	public BajaPeticion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		try {
			for(PeticionDTO peticion : ControladorPeticion.getInstancia().buscarPeticiones()) {
				comboBox.addItem(peticion);
;			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		comboBox.setBounds(6, 51, 273, 27);
		getContentPane().add(comboBox);
		
		JLabel lblPeticion = new JLabel("Peticion");
		lblPeticion.setBounds(6, 23, 61, 16);
		getContentPane().add(lblPeticion);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionDTO peticionSeleccionada = (PeticionDTO) comboBox.getSelectedItem();
				
				try {
					ControladorPeticion.getInstancia().eliminar(peticionSeleccionada.getIdPeticion());
					mostrarOk();
				} catch (BaseException e1) {
					mostrarError(e1);
				} 
			}
		});
		btnEliminar.setBounds(6, 90, 117, 29);
		getContentPane().add(btnEliminar);

	}

}
