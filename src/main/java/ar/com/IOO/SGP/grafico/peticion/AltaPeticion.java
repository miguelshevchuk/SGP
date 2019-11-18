package ar.com.IOO.SGP.grafico.peticion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPaciente;
import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.controlador.ControladorSucursal;
import ar.com.IOO.SGP.dto.ComboDTO;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.dto.SucursalDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;
import ar.com.IOO.SGP.grafico.practica.PracticaTableModel;

public class AltaPeticion extends BasePanel {
	private JTextField obraSocial;
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
					AltaPeticion frame = new AltaPeticion();
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
	public AltaPeticion() {
		setBounds(100, 100, 817, 600);
		getContentPane().setLayout(null);
		
		JComboBox pacientes = new JComboBox();
		try {
			for(PacienteDTO paciente: ControladorPaciente.getInstancia().buscarPacientes()) {
				pacientes.addItem(paciente);
			}
		} catch (BaseException e) {
			mostrarError(e);
		} 
		pacientes.setBounds(6, 55, 196, 27);
		getContentPane().add(pacientes);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(6, 27, 61, 16);
		getContentPane().add(lblPaciente);
		
		obraSocial = new JTextField();
		obraSocial.setBounds(265, 54, 207, 26);
		getContentPane().add(obraSocial);
		obraSocial.setColumns(10);
		
		JLabel lblObraSocial = new JLabel("Obra social");
		lblObraSocial.setBounds(265, 27, 122, 16);
		getContentPane().add(lblObraSocial);
		
		JComboBox sucursal = new JComboBox();
		try {
			for(SucursalDTO suc: ControladorSucursal.getInstancia().buscarSucursales()) {
				sucursal.addItem(suc);
			}
		} catch (BaseException e) {
			mostrarError(e);
		}
		sucursal.setBounds(265, 123, 207, 27);
		getContentPane().add(sucursal);
		
		try {
			practicasParaElegir = new PracticaTableModel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 190, 311, 246);
			getContentPane().add(scrollPane);
			
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
			scrollPane_1.setBounds(409, 190, 332, 246);
			getContentPane().add(scrollPane_1);
			
			tablaElegidas = new JTable();
			tablaElegidas.setModel(practicasElegidas);
			tablaElegidas.setBounds(6, 6, 689, 260);
			scrollPane_1.setViewportView(tablaElegidas);
			
		} catch (BaseException e2) {
			mostrarError(e2);
		}
		
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionDTO nuevaPeticion = new PeticionDTO();
				PacienteDTO pacienteElegido = (PacienteDTO) pacientes.getSelectedItem();
				nuevaPeticion.setPaciente(new PacienteDTO(pacienteElegido.getDni()));
				
				nuevaPeticion.setObraSocial(obraSocial.getText());
				List<PracticaDTO> peticionesElegidas = practicasElegidas.getLista();
				List<PracticaPeticionDTO> resultados = new ArrayList<PracticaPeticionDTO>();
				
				for(PracticaDTO practica: peticionesElegidas) {
					PracticaPeticionDTO resultado = new PracticaPeticionDTO();
					resultado.setPractica(new PracticaDTO(practica.getCodigo()));
					resultados.add(resultado);
				}
				
				nuevaPeticion.setPracticas(resultados);
				nuevaPeticion.setSucursal((SucursalDTO)sucursal.getSelectedItem());
				
				try {
					ControladorPeticion.getInstancia().alta(nuevaPeticion);
					mostrarOk();
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnCargar.setBounds(6, 446, 117, 29);
		getContentPane().add(btnCargar);
		
		JButton agregar = new JButton(">>>");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaDTO practica = practicasParaElegir.getSeleccionado(tablaParaElegir.getSelectedRow());
				practicasElegidas.agregar(practica);
			}
		});
		agregar.setBounds(329, 265, 61, 29);
		getContentPane().add(agregar);
		
		JButton quitar = new JButton("<<<");
		quitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int practica = tablaParaElegir.getSelectedRow();
				practicasElegidas.eliminar(practica);
			}
		});
		quitar.setBounds(329, 322, 61, 29);
		getContentPane().add(quitar);
		
		JLabel lblPracticas = new JLabel("Practicas");
		lblPracticas.setBounds(6, 162, 75, 16);
		getContentPane().add(lblPracticas);
		
		JComboBox grupo = new JComboBox();
		grupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboDTO grupoElegido = (ComboDTO) grupo.getSelectedItem();
				try {
					List<PracticaDTO> practicasDelGrupo = ControladorPractica.getInstancia().buscarPracticasDel(grupoElegido.getCodigo());
					practicasParaElegir.setLista((ArrayList<PracticaDTO>) practicasDelGrupo);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		for(ComboDTO grupoP : ControladorPractica.getInstancia().buscarGruposPosibles()) {
			grupo.addItem(grupoP);
		}
		grupo.setBounds(6, 123, 189, 27);
		getContentPane().add(grupo);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(6, 95, 61, 16);
		getContentPane().add(lblGrupo);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(265, 95, 61, 16);
		getContentPane().add(lblSucursal);

	}
}
