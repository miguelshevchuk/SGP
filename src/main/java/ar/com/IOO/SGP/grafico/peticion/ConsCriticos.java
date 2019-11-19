package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class ConsCriticos extends BasePanel {

	private JTable tabla;
	PeticionesCriticasTableModel practicasParaElegir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsCriticos frame = new ConsCriticos();
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
	public ConsCriticos() {
		setBounds(100, 100, 450, 300);
		
		try {
			practicasParaElegir = new PeticionesCriticasTableModel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 190, 311, 246);
			getContentPane().add(scrollPane);
			
			tabla = new JTable();
			tabla.setModel(practicasParaElegir);
			tabla.setBounds(6, 6, 689, 260);
			scrollPane.setViewportView(tabla);
		}catch(BaseException e) {
			mostrarError(e);
		}

	}

}
