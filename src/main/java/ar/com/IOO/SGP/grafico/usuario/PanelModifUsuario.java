package ar.com.IOO.SGP.grafico.usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.IOO.SGP.grafico.BasePanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				panel.setVisible(false);
			}
		});
		btnModificar.setBounds(16, 161, 117, 29);
		panel.add(btnModificar);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		btnCargarDatos.setBounds(181, 37, 117, 29);
		add(btnCargarDatos);
		
		
	}
}
