package ar.com.IOO.SGP.grafico.sucursal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorSucursal;
import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class ModifSucursal extends BasePanel {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifSucursal frame = new ModifSucursal();
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
	public ModifSucursal() {
		setBounds(100, 100, 571, 457);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		try {
			for(SucursalDTO sucursal: ControladorSucursal.getInstancia().buscarSucursales()) {
				comboBox.addItem(sucursal);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		comboBox.setBounds(6, 46, 179, 27);
		getContentPane().add(comboBox);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(6, 18, 61, 16);
		getContentPane().add(lblSucursal);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(6, 85, 482, 320);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 47, 220, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(6, 19, 61, 16);
		panel.add(lblDireccion);
		
		JComboBox comboBox_1 = new JComboBox();
		try {
			for(UsuarioDTO usuario : ControladorUsuario.getInstancia().buscarUsuarios()) {
				comboBox_1.addItem(usuario);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		comboBox_1.setBounds(6, 109, 220, 27);
		panel.add(comboBox_1);
		
		JLabel lblUsuarioEncargado = new JLabel("Usuario encargado");
		lblUsuarioEncargado.setBounds(6, 81, 163, 16);
		panel.add(lblUsuarioEncargado);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SucursalDTO sucursal = (SucursalDTO) comboBox.getSelectedItem();
				sucursal.setDireccion(textField.getText());
				UsuarioDTO usuarioSeleccionado = (UsuarioDTO) comboBox_1.getSelectedItem();
				
				UsuarioDTO responsable = new UsuarioDTO();
				responsable.setDni(usuarioSeleccionado.getDni());
				
				sucursal.setResponsableTecnico(responsable);
				
				try {
					ControladorSucursal.getInstancia().modificar(sucursal);
					mostrarOk();
					panel.setVisible(false);
					comboBox.enable();
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnModificar.setBounds(6, 148, 117, 29);
		panel.add(btnModificar);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SucursalDTO sucursal = (SucursalDTO) comboBox.getSelectedItem();
				try {
					sucursal = ControladorSucursal.getInstancia().buscarSucursal(sucursal.getNumero());
					textField.setText(sucursal.getDireccion());
					comboBox.disable();
					panel.setVisible(true);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnCargarDatos.setBounds(197, 45, 117, 29);
		getContentPane().add(btnCargarDatos);
		
		

	}
}
