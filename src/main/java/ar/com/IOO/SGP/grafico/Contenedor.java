package ar.com.IOO.SGP.grafico;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.com.IOO.SGP.grafico.paciente.AltaPaciente;
import ar.com.IOO.SGP.grafico.paciente.BajaPaciente;
import ar.com.IOO.SGP.grafico.paciente.ModifPaciente;
import ar.com.IOO.SGP.grafico.peticion.AltaPeticion;
import ar.com.IOO.SGP.grafico.peticion.AltaResultado;
import ar.com.IOO.SGP.grafico.peticion.BajaPeticion;
import ar.com.IOO.SGP.grafico.peticion.ConsCriticos;
import ar.com.IOO.SGP.grafico.peticion.ConsultarResultados;
import ar.com.IOO.SGP.grafico.peticion.ModifPeticion;
import ar.com.IOO.SGP.grafico.practica.AltaPractica;
import ar.com.IOO.SGP.grafico.practica.BajaPractica;
import ar.com.IOO.SGP.grafico.practica.ModifPractica;
import ar.com.IOO.SGP.grafico.sucursal.AltaSucursal;
import ar.com.IOO.SGP.grafico.sucursal.BajaSucursal;
import ar.com.IOO.SGP.grafico.sucursal.ModifSucursal;
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
		
		JMenu mnSucursales = new JMenu("Sucursales");
		menuBar.add(mnSucursales);
		
		JMenuItem mntmAlta_3 = new JMenuItem("Alta");
		mntmAlta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaSucursal pantalla = new AltaSucursal();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnSucursales.add(mntmAlta_3);
		
		JMenuItem mntmBaja_3 = new JMenuItem("Baja");
		mntmBaja_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaSucursal pantalla = new BajaSucursal();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
				
			}
		});
		mnSucursales.add(mntmBaja_3);
		
		JMenuItem mntmModificacion_3 = new JMenuItem("Modificacion");
		mntmModificacion_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifSucursal pantalla = new ModifSucursal();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnSucursales.add(mntmModificacion_3);
		
		JMenu mnPacientes = new JMenu("Pacientes");
		menuBar.add(mnPacientes);
		
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPaciente altaPaciente = new AltaPaciente();
				altaPaciente.setSize(900, 500);
				desktopPane.add(altaPaciente);
				altaPaciente.setClosable(true);
				altaPaciente.setVisible(true);
			}
		});
		mnPacientes.add(mntmAlta_1);
		
		JMenuItem mntmBaja_1 = new JMenuItem("Baja");
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaPaciente bajaPaciente = new BajaPaciente();
				bajaPaciente.setSize(900, 500);
				desktopPane.add(bajaPaciente);
				bajaPaciente.setClosable(true);
				bajaPaciente.setVisible(true);
			}
		});
		mnPacientes.add(mntmBaja_1);
		
		JMenuItem mntmModificacion_1 = new JMenuItem("Modificacion");
		mntmModificacion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifPaciente pantalla = new ModifPaciente();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPacientes.add(mntmModificacion_1);
		
		JMenu mnPracticas = new JMenu("Practicas");
		menuBar.add(mnPracticas);
		
		JMenuItem mntmAlta_2 = new JMenuItem("Alta");
		mntmAlta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPractica pantalla = new AltaPractica();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPracticas.add(mntmAlta_2);
		
		JMenuItem mntmBaja_2 = new JMenuItem("Baja");
		mntmBaja_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaPractica pantalla = new BajaPractica();
				pantalla.setSize(900, 500);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
				
			}
		});
		mnPracticas.add(mntmBaja_2);
		
		JMenuItem mntmModificacion_2 = new JMenuItem("Modificacion");
		mntmModificacion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifPractica pantalla = new ModifPractica();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPracticas.add(mntmModificacion_2);
		
		JMenu mnPeticiones = new JMenu("Peticiones");
		menuBar.add(mnPeticiones);
		
		JMenuItem mntmAlta_4 = new JMenuItem("Alta");
		mntmAlta_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPeticion pantalla = new AltaPeticion();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPeticiones.add(mntmAlta_4);
		
		JMenuItem mntmBaja_4 = new JMenuItem("Baja");
		mntmBaja_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaPeticion pantalla = new BajaPeticion();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPeticiones.add(mntmBaja_4);
		
		JMenuItem mntmModificacion_4 = new JMenuItem("Modificacion");
		mntmModificacion_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifPeticion pantalla = new ModifPeticion();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPeticiones.add(mntmModificacion_4);
		
		JMenuItem mntmConsultarCriticos = new JMenuItem("Consultar criticos");
		mntmConsultarCriticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsCriticos pantalla = new ConsCriticos();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnPeticiones.add(mntmConsultarCriticos);
		
		JMenu mnResultados = new JMenu("Resultados");
		menuBar.add(mnResultados);
		
		JMenuItem mntmAlta_5 = new JMenuItem("Cargar Resultados");
		mntmAlta_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaResultado pantalla = new AltaResultado();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnResultados.add(mntmAlta_5);
		
		JMenuItem mntmConsultarresultados = new JMenuItem("Consultar Resultados");
		mntmConsultarresultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarResultados pantalla = new ConsultarResultados();
				pantalla.setSize(900, 600);
				desktopPane.add(pantalla);
				pantalla.setClosable(true);
				pantalla.setVisible(true);
			}
		});
		mnResultados.add(mntmConsultarresultados);
		
		
	}
}
