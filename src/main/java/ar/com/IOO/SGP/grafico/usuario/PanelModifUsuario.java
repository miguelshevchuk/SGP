package ar.com.IOO.SGP.grafico.usuario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.PermisoDenegadoException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class PanelModifUsuario extends BasePanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelModifUsuario frame = new PanelModifUsuario();
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
	public PanelModifUsuario() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 37, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(23, 16, 61, 16);
		add(lblDni);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(18, 98, 426, 196);
		add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 35, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(6, 7, 118, 16);
		panel.add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(221, 35, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(219, 7, 132, 16);
		panel.add(lblContrasea);
		
		textField_3 = new JTextField();
		textField_3.setBounds(6, 119, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(6, 91, 61, 16);
		panel.add(lblNombre);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDTO usuarioModificado = new UsuarioDTO();
				usuarioModificado.setDni(textField.getText());
				usuarioModificado.setUserName(textField_1.getText());
				usuarioModificado.setPassword(textField_2.getText());
				usuarioModificado.setNombre(textField_3.getText());
				
				try {
					ControladorUsuario.getInstancia().modificarUsuario(usuarioModificado);
					mostrarOk();
					textField.enable();
					panel.setVisible(false);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnModificar.setBounds(16, 161, 117, 29);
		panel.add(btnModificar);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDTO usuario;
				try {
					usuario = ControladorUsuario.getInstancia().buscarUsuario(textField.getText());
					textField_1.setText(usuario.getUserName());
					textField_2.setText(usuario.getPassword());
					textField_3.setText(usuario.getNombre());
					textField.disable();
					panel.setVisible(true);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnCargarDatos.setBounds(181, 37, 117, 29);
		add(btnCargarDatos);
		
		
	}
}
