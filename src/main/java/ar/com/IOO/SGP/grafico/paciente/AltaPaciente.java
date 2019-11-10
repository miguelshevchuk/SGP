package ar.com.IOO.SGP.grafico.paciente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPaciente;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class AltaPaciente extends BasePanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPaciente frame = new AltaPaciente();
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
	public AltaPaciente() {
		setBounds(100, 100, 523, 354);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(28, 51, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(25, 23, 61, 16);
		getContentPane().add(lblDni);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 51, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(282, 23, 61, 16);
		getContentPane().add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(28, 128, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(28, 100, 61, 16);
		getContentPane().add(lblEdad);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteDTO unPaciente = new PacienteDTO();
				unPaciente.setDni(textField.getText());
				unPaciente.setNombre(textField_1.getText());
				unPaciente.setEdad(Integer.parseInt(textField_2.getText()));
				
				try {
					ControladorPaciente.getInstancia().grabar(unPaciente);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					mostrarOk();
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnCargar.setBounds(28, 190, 117, 29);
		getContentPane().add(btnCargar);

	}
}
