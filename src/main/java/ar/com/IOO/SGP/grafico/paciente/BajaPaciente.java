package ar.com.IOO.SGP.grafico.paciente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ar.com.IOO.SGP.controlador.ControladorPaciente;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class BajaPaciente extends BasePanel {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPaciente frame = new BajaPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	/**
	 * Create the frame.
	 */
	public BajaPaciente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		PacienteTableModel pacienteTableModel;
		try {
			pacienteTableModel = new PacienteTableModel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setLocation(6, 18);
			scrollPane.setSize(587, 194);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setModel(pacienteTableModel);
			table.setBounds(6, 6, 689, 260);
			scrollPane.setViewportView(table);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer fila = table.getSelectedRow();
					
					String dni = (String) pacienteTableModel.getValueAt(fila, 0);
					
					try {
						ControladorPaciente.getInstancia().eliminar(dni);
						pacienteTableModel.eliminar(fila);
						mostrarOk();
					} catch (BaseException e1) {
						mostrarError(e1);
					}
				}
			});
			btnEliminar.setBounds(0, 219, 117, 29);
			getContentPane().add(btnEliminar);
		} catch (BaseException e) {
			mostrarError(e);
		}
		

	}
}
