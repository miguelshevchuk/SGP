package ar.com.IOO.SGP.grafico.sucursal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorSucursal;
import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class AltaSucursal extends BasePanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSucursal frame = new AltaSucursal();
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
	public AltaSucursal() {
		setBounds(100, 100, 572, 409);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 57, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(6, 33, 61, 16);
		getContentPane().add(lblNumero);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 57, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(237, 33, 61, 16);
		getContentPane().add(lblDireccion);
		
		JComboBox comboBox = new JComboBox();
		
		try {
			for(UsuarioDTO usuario : ControladorUsuario.getInstancia().buscarUsuarios()) {
				comboBox.addItem(usuario);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		
		comboBox.setBounds(6, 135, 188, 27);
		getContentPane().add(comboBox);
		
		JLabel lblUsuarioEncargado = new JLabel("Usuario encargado");
		lblUsuarioEncargado.setBounds(6, 108, 130, 16);
		getContentPane().add(lblUsuarioEncargado);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SucursalDTO sucursal = new SucursalDTO();
				
				UsuarioDTO usuarioSeleccionado = (UsuarioDTO) comboBox.getSelectedItem();
				
				sucursal.setNumero(textField.getText());
				sucursal.setDireccion(textField_1.getText());
				sucursal.setResponsableTecnico(usuarioSeleccionado);
				
				try {
					ControladorSucursal.getInstancia().alta(sucursal);
					mostrarOk();
					textField.setText("");
					textField_1.setText("");
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnCargar.setBounds(6, 189, 117, 29);
		getContentPane().add(btnCargar);

	}

}
