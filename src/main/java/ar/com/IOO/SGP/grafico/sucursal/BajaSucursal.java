package ar.com.IOO.SGP.grafico.sucursal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ar.com.IOO.SGP.controlador.ControladorSucursal;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class BajaSucursal extends BasePanel {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaSucursal frame = new BajaSucursal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BajaSucursal() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		try {
			for(SucursalDTO sucursal: ControladorSucursal.getInstancia().buscarSucursales()) {
				comboBox.addItem(sucursal);
				comboBox_1.addItem(sucursal);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		comboBox_1.setBounds(6, 123, 243, 27);
		getContentPane().add(comboBox_1);
		comboBox.setBounds(6, 46, 243, 27);
		getContentPane().add(comboBox);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(6, 18, 61, 16);
		getContentPane().add(lblSucursal);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SucursalDTO sucursal = (SucursalDTO) comboBox.getSelectedItem();
				SucursalDTO sucursalDestino = (SucursalDTO) comboBox_1.getSelectedItem();
				try {
					ControladorSucursal.getInstancia().eliminar(sucursal.getNumero(), sucursalDestino.getNumero());
					mostrarOk();
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnEliminar.setBounds(6, 173, 117, 29);
		getContentPane().add(btnEliminar);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(6, 95, 153, 16);
		getContentPane().add(lblSucursalDestino);

	}

}
