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
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class Vista {	
	
	private JFrame frmSgpIoo;
	private JTable table;

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
		
		JPanel panel = new PanelAltaUsuario();
		tabbedPane_1.addTab("Alta", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new PanelBajaUsuario();
		tabbedPane_1.addTab("Baja", null, panel_1, null);
//		panel_1.setLayout(null);
		
		table = new JTable(new UsuarioTableModel());
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Modificacion", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Peticiones", null, tabbedPane_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_2.addTab("Alta", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("Baja", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("Peticiones", null, panel_5, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Pacientes", null, tabbedPane_3, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_3.addTab("Alta", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_3.addTab("Baja", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_3.addTab("Modificacion", null, panel_8, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Sucursales", null, tabbedPane_4, null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_4.addTab("Alta", null, panel_9, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_4.addTab("Baja", null, panel_10, null);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_4.addTab("Modificacion", null, panel_11, null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Practicas", null, tabbedPane_5, null);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_5.addTab("Alta", null, panel_12, null);
		
		JPanel panel_13 = new JPanel();
		tabbedPane_5.addTab("Baja", null, panel_13, null);
		
		JPanel panel_14 = new JPanel();
		tabbedPane_5.addTab("Modificacion", null, panel_14, null);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Resultados", null, tabbedPane_6, null);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_6.addTab("Alta", null, panel_15, null);
		
		JPanel panel_16 = new JPanel();
		tabbedPane_6.addTab("Baja", null, panel_16, null);
		
		JPanel panel_17 = new JPanel();
		tabbedPane_6.addTab("Modificacion", null, panel_17, null);
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
}
