package ar.com.IOO.SGP.grafico.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;
import ar.com.IOO.SGP.servicio.ROLEnum;

public class PanelAltaUsuario extends BasePanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8548776546431012977L;
	private JTextField usuarioAlta;
	private JTextField passAlta;
	private JTextField nacimientoAlta;
	private JTextField nombreAlta;
	private JTextField dniAlta;
	
	private ControladorUsuario controladorUsuario = new ControladorUsuario();

	/**
	 * Create the panel.
	 */
	public PanelAltaUsuario() {
		setLayout(null);
		
		usuarioAlta = new JTextField();
		usuarioAlta.setBounds(37, 66, 130, 26);
		this.add(usuarioAlta);
		usuarioAlta.setColumns(10);
		
		passAlta = new JTextField();
		passAlta.setBounds(37, 157, 130, 26);
		this.add(passAlta);
		passAlta.setColumns(10);
		
		nacimientoAlta = new JTextField();
		nacimientoAlta.setBounds(315, 66, 130, 26);
		this.add(nacimientoAlta);
		nacimientoAlta.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 38, 61, 16);
		this.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(37, 129, 130, 16);
		this.add(lblContrasea);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setBounds(315, 38, 136, 16);
		this.add(lblNacimiento);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(315, 129, 61, 16);
		this.add(lblRol);
		
		String [] roles = new String[] {ROLEnum.REC.getCodigo(), ROLEnum.LAB.getCodigo(),
				ROLEnum.ADM.getCodigo()};
		
		JComboBox<String> rolAlta = new JComboBox(roles);
		rolAlta.setBounds(315, 158, 205, 27);
		
		this.add(rolAlta);
		
		nombreAlta = new JTextField();
		nombreAlta.setBounds(37, 241, 130, 26);
		this.add(nombreAlta);
		nombreAlta.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 213, 61, 16);
		this.add(lblNombre);
		
		dniAlta = new JTextField();
		dniAlta.setBounds(315, 241, 130, 26);
		this.add(dniAlta);
		dniAlta.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(315, 213, 61, 16);
		this.add(lblDni);
		
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
		this.add(btnAgregar);

	}
	
}
