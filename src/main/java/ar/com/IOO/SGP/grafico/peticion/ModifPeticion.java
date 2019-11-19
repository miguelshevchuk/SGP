package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.controlador.ControladorSucursal;
import ar.com.IOO.SGP.dto.ComboDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;
import ar.com.IOO.SGP.grafico.practica.PracticaTableModel;

public class ModifPeticion extends BasePanel {
	private JTextField obraSocial;
	private JTextField paciente;
	private JTable tablaElegidas;
	private JTable tablaParaElegir;
	PracticaTableModel practicasParaElegir;
	PracticaTableModel practicasElegidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifPeticion frame = new ModifPeticion();
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
	public ModifPeticion() {
		setBounds(0, 0, 900, 716);
		getContentPane().setLayout(null);
		
		JComboBox peticionS = new JComboBox();
		try {
			for(PeticionDTO peticion : ControladorPeticion.getInstancia().buscarPeticiones()) {
				peticionS.addItem(peticion);
;			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		peticionS.setBounds(6, 49, 218, 27);
		getContentPane().add(peticionS);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(6, 89, 900, 521);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionDTO peticionSeleccionada = (PeticionDTO) peticionS.getSelectedItem();
				try {
					peticionSeleccionada= ControladorPeticion.getInstancia().buscarpeticion(peticionSeleccionada.getIdPeticion());
				
					obraSocial.setText(peticionSeleccionada.getObraSocial());
					paciente.setText(peticionSeleccionada.getPaciente().toString());
					panel.setVisible(true);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnCargarDatos.setBounds(259, 48, 117, 29);
		getContentPane().add(btnCargarDatos);
		
		JLabel lblPeticion = new JLabel("Peticion");
		lblPeticion.setBounds(6, 21, 61, 16);
		getContentPane().add(lblPeticion);
		
		try {
			practicasParaElegir = new PracticaTableModel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 180, 243, 238);
			panel.add(scrollPane);
			
			tablaParaElegir = new JTable();
			tablaParaElegir.setModel(practicasParaElegir);
			tablaParaElegir.setBounds(6, 6, 689, 260);
			scrollPane.setViewportView(tablaParaElegir);
		}catch(BaseException e) {
			mostrarError(e);
		}
		
		try {
			practicasElegidas = new PracticaTableModel();
			practicasElegidas.limpiarTabla();
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(334, 180, 266, 238);
			panel.add(scrollPane_1);
			
			tablaElegidas = new JTable();
			tablaElegidas.setModel(practicasElegidas);
			tablaElegidas.setBounds(6, 6, 689, 260);
			scrollPane_1.setViewportView(tablaElegidas);
			
		} catch (BaseException e2) {
			mostrarError(e2);
		}
		
		obraSocial = new JTextField();
		obraSocial.setBounds(6, 47, 169, 26);
		panel.add(obraSocial);
		obraSocial.setColumns(10);
		
		JLabel lblObraSocial = new JLabel("Obra Social");
		lblObraSocial.setBounds(6, 19, 124, 16);
		panel.add(lblObraSocial);
		
		JComboBox sucursal = new JComboBox();
		try {
			for(SucursalDTO suc: ControladorSucursal.getInstancia().buscarSucursales()) {
				sucursal.addItem(suc);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		sucursal.setBounds(243, 103, 184, 27);
		panel.add(sucursal);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(243, 75, 61, 16);
		panel.add(lblSucursal);
		
		paciente = new JTextField();
		paciente.setEditable(false);
		paciente.setBounds(243, 47, 205, 26);
		panel.add(paciente);
		paciente.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(243, 19, 61, 16);
		panel.add(lblPaciente);
		
		JComboBox grupo = new JComboBox();
		grupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboDTO grupoElegido = (ComboDTO) grupo.getSelectedItem();
				try {
					List<PracticaDTO> practicasDelGrupo = ControladorPractica.getInstancia().buscarPracticasDel(grupoElegido.getCodigo());
					practicasParaElegir.getLista().clear();
					for(PracticaDTO practica: practicasDelGrupo) {
						practicasParaElegir.agregar(practica);
					}
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		for(ComboDTO grupoP : ControladorPractica.getInstancia().buscarGruposPosibles()) {
			grupo.addItem(grupoP);
		}
		grupo.setBounds(6, 141, 169, 27);
		panel.add(grupo);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(6, 118, 61, 16);
		panel.add(lblGrupo);
		
		JLabel lblAgregarPracticas = new JLabel("Agregar practicas");
		lblAgregarPracticas.setBounds(16, 90, 184, 16);
		panel.add(lblAgregarPracticas);
		
		JButton btnNewButton = new JButton(">>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaDTO practica = practicasParaElegir.getSeleccionado(tablaParaElegir.getSelectedRow());
				practicasElegidas.agregar(practica);
			}
		});
		btnNewButton.setBounds(261, 222, 61, 29);
		panel.add(btnNewButton);
		
		JButton button = new JButton("<<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int practica = tablaParaElegir.getSelectedRow();
				practicasElegidas.eliminar(practica);
			}
		});
		button.setBounds(261, 263, 61, 29);
		panel.add(button);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionDTO nuevaPeticion = new PeticionDTO();
				
				nuevaPeticion.setObraSocial(obraSocial.getText());
				List<PracticaDTO> peticionesElegidas = practicasElegidas.getLista();
				List<PracticaPeticionDTO> resultados = new ArrayList<PracticaPeticionDTO>();
				PeticionDTO peticionSeleccionada = (PeticionDTO) peticionS.getSelectedItem();
				
				for(PracticaDTO practica: peticionesElegidas) {
					PracticaPeticionDTO resultado = new PracticaPeticionDTO();
					resultado.setPractica(new PracticaDTO(practica.getCodigo()));
					resultado.setIdPeticion(peticionSeleccionada.getIdPeticion());
					resultados.add(resultado);
				}
				
				nuevaPeticion.setPracticas(resultados);
				nuevaPeticion.setSucursal((SucursalDTO)sucursal.getSelectedItem());
				nuevaPeticion.setIdPeticion(peticionSeleccionada.getIdPeticion());
				
				try {
					ControladorPeticion.getInstancia().modificar(nuevaPeticion);
					mostrarOk();
					panel.setVisible(false);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnModificar.setBounds(6, 427, 117, 29);
		panel.add(btnModificar);

	}

}
