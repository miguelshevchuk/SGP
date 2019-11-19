package ar.com.IOO.SGP.grafico;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import ar.com.IOO.SGP.controlador.ControladorLogin;
import ar.com.IOO.SGP.servicio.ROLEnum;

public class ElegirROL extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirROL frame = new ElegirROL();
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
	public ElegirROL() {
		setBounds(0, 0, 793, 586);
		getContentPane().setLayout(null);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorLogin.getInstancia().loguearComo(ROLEnum.ADM.getCodigo());
			}
		});
		btnAdministrador.setBounds(6, 41, 414, 80);
		getContentPane().add(btnAdministrador);
		
		JLabel lblElegirElRol = new JLabel("Elegir el rol con el que se desea ingresar al sistema");
		lblElegirElRol.setBounds(6, 13, 377, 16);
		getContentPane().add(lblElegirElRol);
		
		JButton btnLaboratorista = new JButton("Laboratorista");
		btnLaboratorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorLogin.getInstancia().loguearComo(ROLEnum.LAB.getCodigo());
			}
		});
		btnLaboratorista.setBounds(6, 151, 414, 80);
		getContentPane().add(btnLaboratorista);
		
		JButton btnRecepcionista = new JButton("Recepcionista");
		btnRecepcionista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorLogin.getInstancia().loguearComo(ROLEnum.REC.getCodigo());
			}
		});
		btnRecepcionista.setBounds(6, 259, 414, 80);
		getContentPane().add(btnRecepcionista);

	}

}
