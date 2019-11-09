package ar.com.IOO.SGP.grafico;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.com.IOO.SGP.grafico.usuario.PanelAltaUsuario;
import ar.com.IOO.SGP.grafico.usuario.PanelBajaUsuario;
import ar.com.IOO.SGP.grafico.usuario.PanelModifUsuario;

public class Contenedor extends JFrame{

	
	public Contenedor() {
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.info);
		desktopPane.setBounds(6, 249, 438, -243);
		this.getContentPane().add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mnUsuarios.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelBajaUsuario bajaUsuario = new PanelBajaUsuario();
				bajaUsuario.setSize(900, 500);
				desktopPane.add(bajaUsuario);
				bajaUsuario.setClosable(true);
				bajaUsuario.setVisible(true);
			}
		});
		mnUsuarios.add(mntmBaja);
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelModifUsuario modifUsuario = new PanelModifUsuario();
				modifUsuario.setSize(900, 500);
				desktopPane.add(modifUsuario);
				modifUsuario.setClosable(true);
				modifUsuario.setVisible(true);
			}
		});
		mnUsuarios.add(mntmModificacion);
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAltaUsuario altaUsuario = new PanelAltaUsuario();
				altaUsuario.setSize(900, 500);
				desktopPane.add(altaUsuario);
				altaUsuario.setClosable(true);
				altaUsuario.setVisible(true);
			}
		});
		
		this.setJMenuBar(menuBar);
		
		
	}
}
