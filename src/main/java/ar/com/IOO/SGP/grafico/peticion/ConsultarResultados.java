package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.controlador.ControladorResultados;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class ConsultarResultados extends BasePanel {
	private JTextField peticion;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	ResultadosTableModel resultadosTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarResultados frame = new ConsultarResultados();
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
	public ConsultarResultados() {
		setBounds(100, 100, 794, 595);
		getContentPane().setLayout(null);
		
		try {
			resultadosTableModel = new ResultadosTableModel();
			resultadosTableModel.limpiarTabla();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 146, 332, 246);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setModel(resultadosTableModel);
			table.setBounds(6, 6, 689, 260);
			scrollPane.setViewportView(table);
		} catch (BaseException e) {
			mostrarError(e);
		}
		
		peticion = new JTextField();
		peticion.setBounds(6, 43, 130, 26);
		getContentPane().add(peticion);
		peticion.setColumns(10);
		
		JLabel lblPeticion = new JLabel("Peticion");
		lblPeticion.setBounds(6, 15, 61, 16);
		getContentPane().add(lblPeticion);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(6, 108, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(218, 108, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnVerResultados = new JButton("Ver resultados");
		btnVerResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PeticionDTO peticionBuscada = ControladorPeticion.getInstancia().buscarpeticion(peticion.getText());
					textField_1.setText(peticionBuscada.getPaciente().toString());
					textField_2.setText(peticionBuscada.getSucursal().toString());
					
					resultadosTableModel.limpiarTabla();
					List<PracticaPeticionDTO> resultados = ControladorResultados.getInstancia().buscarResultadosNoReservadosDe(peticion.getText());
					for(PracticaPeticionDTO resultado: resultados) {
						resultadosTableModel.agregar(resultado);
					}
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnVerResultados.setBounds(169, 40, 117, 29);
		getContentPane().add(btnVerResultados);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(6, 81, 61, 16);
		getContentPane().add(lblPaciente);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(218, 80, 61, 16);
		getContentPane().add(lblSucursal);
		
	}

}
