package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.controlador.ControladorResultados;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class AltaResultado extends BasePanel {
	private JTextField peticion;
	private JTextField paciente;
	private JTextField valorResultado;
	private JTextField sucursal;
	private Integer tipoResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaResultado frame = new AltaResultado();
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
	public AltaResultado() {
		setBounds(100, 100, 826, 621);
		getContentPane().setLayout(null);
		
		JLabel lblPeticion = new JLabel("Peticion");
		lblPeticion.setBounds(6, 21, 61, 16);
		getContentPane().add(lblPeticion);
		
		peticion = new JTextField();
		peticion.setBounds(6, 49, 130, 26);
		getContentPane().add(peticion);
		peticion.setColumns(10);
		
		paciente = new JTextField();
		paciente.setEditable(false);
		paciente.setBounds(6, 109, 130, 26);
		getContentPane().add(paciente);
		paciente.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(6, 81, 61, 16);
		getContentPane().add(lblPaciente);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(6, 135, 769, 422);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelDesdeHasta = new JPanel();
		panelDesdeHasta.setBounds(6, 92, 234, 27);
		panel.add(panelDesdeHasta);
		panelDesdeHasta.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(6, 6, 61, 16);
		panelDesdeHasta.add(lblValor);
		
		valorResultado = new JTextField();
		valorResultado.setBounds(50, 1, 130, 26);
		panelDesdeHasta.add(valorResultado);
		valorResultado.setColumns(10);
		
		JPanel panelPosNeg = new JPanel();
		panelPosNeg.setBounds(6, 128, 274, 35);
		panel.add(panelPosNeg);
		panelPosNeg.setLayout(null);
		
		JCheckBox positivoResultado = new JCheckBox("Positivo");
		positivoResultado.setBounds(6, 6, 128, 23);
		panelPosNeg.add(positivoResultado);
		
		JComboBox practicas = new JComboBox();
		practicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaPeticionDTO practicaElegida = (PracticaPeticionDTO) practicas.getSelectedItem();
				
				if(practicaElegida.getPractica().getTipoResultado() == 1) {
					panelPosNeg.setVisible(false);
					if(practicaElegida.getResultado() != null) {
						valorResultado.setText(practicaElegida.getResultado().toString());
					}else{
						valorResultado.setText("");
					}
					panelDesdeHasta.setVisible(true);
				}else {
					panelPosNeg.setVisible(true);
					if(practicaElegida.getResultado() != null) {
						positivoResultado.setSelected((boolean)practicaElegida.getResultado());
					}else {
						positivoResultado.setSelected(false);
					}
					panelDesdeHasta.setVisible(false);
				}
			}
		});
		practicas.setBounds(6, 53, 234, 27);
		panel.add(practicas);
		
		JLabel lblPractica = new JLabel("Practica");
		lblPractica.setBounds(6, 25, 61, 16);
		panel.add(lblPractica);
		
		JButton btnGuardarResultado = new JButton("Guardar Resultado");
		btnGuardarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaPeticionDTO practicaElegida = (PracticaPeticionDTO) practicas.getSelectedItem();
				
				if(practicaElegida.getPractica().getTipoResultado() == 1) {
					practicaElegida.setResultado(valorResultado.getText());
				}else {
					practicaElegida.setResultado(positivoResultado.isSelected());
				}
				
				try {
					ControladorResultados.getInstancia().cargarResultado(practicaElegida);
					mostrarOk();
					panel.setVisible(false);
				} catch (BaseException e1) {
					mostrarError(e1);
				} 
			}
		});
		btnGuardarResultado.setBounds(6, 179, 150, 29);
		panel.add(btnGuardarResultado);
		
		sucursal = new JTextField();
		sucursal.setEditable(false);
		sucursal.setBounds(155, 109, 130, 26);
		getContentPane().add(sucursal);
		sucursal.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PeticionDTO unaPeticion = ControladorPeticion.getInstancia().buscarpeticion(peticion.getText());
					sucursal.setText(unaPeticion.getSucursal().toString());
					paciente.setText(unaPeticion.getPaciente().toString());
					
//					practicas.removeAll();
					practicas.removeAllItems();
					for(PracticaPeticionDTO resultado : unaPeticion.getPracticas()) {
						practicas.addItem(resultado);
					}
					
					panel.setVisible(true);
				} catch (BaseException e1) {
					mostrarError(e1);
					panel.setVisible(false);
				}
			}
		});
		btnCargar.setBounds(155, 49, 117, 29);
		getContentPane().add(btnCargar);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(165, 81, 61, 16);
		getContentPane().add(lblSucursal);
		
		

	}

}
