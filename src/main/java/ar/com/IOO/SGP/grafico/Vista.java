package ar.com.IOO.SGP.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.excepcion.BaseException;

public class Vista {	
	
	private JFrame frmSgpIoo;
	private JTextField usuarioAlta;
	private JTextField passAlta;
	private JTextField nacimientoAlta;
	private JTextField nombreAlta;
	private JTextField dniAlta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frmSgpIoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		
		frmSgpIoo = new JFrame();
		frmSgpIoo.setTitle("SGP IOO");
		frmSgpIoo.setBounds(100, 100, 785, 595);
		frmSgpIoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSgpIoo.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(3, 3, 773, 567);
		frmSgpIoo.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Usuarios", null, tabbedPane_1, null);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Alta", null, panel, null);
		panel.setLayout(null);
		
		usuarioAlta = new JTextField();
		usuarioAlta.setBounds(37, 66, 130, 26);
		panel.add(usuarioAlta);
		usuarioAlta.setColumns(10);
		
		passAlta = new JTextField();
		passAlta.setBounds(37, 157, 130, 26);
		panel.add(passAlta);
		passAlta.setColumns(10);
		
		nacimientoAlta = new JTextField();
		nacimientoAlta.setBounds(315, 66, 130, 26);
		panel.add(nacimientoAlta);
		nacimientoAlta.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 38, 61, 16);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(37, 129, 130, 16);
		panel.add(lblContrasea);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setBounds(315, 38, 136, 16);
		panel.add(lblNacimiento);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(315, 129, 61, 16);
		panel.add(lblRol);
		
		String [] roles = new String[] {"Recepcionista", "Laborista",
        "Administrador"};
		
		JComboBox<String> rolAlta = new JComboBox(roles);
		rolAlta.setBounds(315, 158, 205, 27);
		
		panel.add(rolAlta);
		
		nombreAlta = new JTextField();
		nombreAlta.setBounds(37, 241, 130, 26);
		panel.add(nombreAlta);
		nombreAlta.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 213, 61, 16);
		panel.add(lblNombre);
		
		dniAlta = new JTextField();
		dniAlta.setBounds(315, 241, 130, 26);
		panel.add(dniAlta);
		dniAlta.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(315, 213, 61, 16);
		panel.add(lblDni);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					controladorUsuario.grabarUsuario(nombreAlta.getText(), dniAlta.getText(), passAlta.getText(), rolAlta.getSelectedItem().toString(), nombreAlta.getText());
				}catch(BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnAgregar.setBounds(37, 369, 117, 29);
		panel.add(btnAgregar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Baja", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Modificacion", null, panel_2, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Prestaciones", null, tabbedPane_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel_5, null);
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private void mostrarError(BaseException excepcion) {
		JOptionPane.showMessageDialog(frmSgpIoo, excepcion.getDescripcion());
	}
}
