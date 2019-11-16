package ar.com.IOO.SGP.grafico.practica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.dto.ComboDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.ValorDesdeHastaDTO;
import ar.com.IOO.SGP.dto.ValorPositivoNegativoDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;
import ar.com.IOO.SGP.grafico.usuario.PanelModifUsuario;

public class ModifPractica extends BasePanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField horas;
	private JTextField nombre;
	private JTextField tipoResultado;
	private JTextField desdeCritico;
	private JTextField desdeReservado;
	private JTextField hastaReservado;
	private JTextField hastaCritico;
	private Integer tipoResultadoGuardado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelModifUsuario frame = new PanelModifUsuario();
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
	public ModifPractica() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 37, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDni = new JLabel("Codigo");
		lblDni.setBounds(23, 16, 61, 16);
		getContentPane().add(lblDni);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(18, 98, 760, 456);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		horas = new JTextField();
		horas.setBounds(6, 35, 130, 26);
		panel.add(horas);
		horas.setColumns(10);
		
		JLabel lblUsername = new JLabel("Horas para el resultado");
		lblUsername.setBounds(6, 7, 162, 16);
		panel.add(lblUsername);
		
		nombre = new JTextField();
		nombre.setBounds(6, 119, 130, 26);
		panel.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(6, 91, 61, 16);
		panel.add(lblNombre);
		
		JComboBox comboBox = new JComboBox();
		for(ComboDTO grupo : ControladorPractica.getInstancia().buscarGruposPosibles()) {
			comboBox.addItem(grupo);
		}
		comboBox.setBounds(247, 36, 217, 27);
		panel.add(comboBox);
		

		JCheckBox habilitada = new JCheckBox("Habilitada");
		habilitada.setBounds(6, 186, 128, 23);
		panel.add(habilitada);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboDTO grupoSeleccionado = (ComboDTO) comboBox.getSelectedItem();
				
				PracticaDTO practica = new PracticaDTO();
				practica.setCodigo(textField.getText());
				practica.setHabilitada(habilitada.isSelected());
				practica.setHorasResultado(Integer.parseInt(horas.getText()));
				practica.setNombre(nombre.getText());
				
				if(tipoResultadoGuardado == 1) {
					ValorDesdeHastaDTO valorCritico = new ValorDesdeHastaDTO();
					ValorDesdeHastaDTO valorReservado = new ValorDesdeHastaDTO();
					
					valorCritico.setValorDesde(Integer.parseInt(desdeCritico.getText()));
					valorCritico.setValorHasta(Integer.parseInt(hastaCritico.getText()));
					valorCritico.setCodigoPractica(textField.getText());
					
					valorReservado.setValorDesde(Integer.parseInt(desdeReservado.getText()));
					valorReservado.setValorHasta(Integer.parseInt(hastaReservado.getText()));
					valorReservado.setCodigoPractica(textField.getText());
					
					practica.setValoresCriticos(valorCritico);
					practica.setValoresReservados(valorReservado);
					
				}else {
					ValorPositivoNegativoDTO valorCritico = new ValorPositivoNegativoDTO();
					ValorPositivoNegativoDTO valorReservado = new ValorPositivoNegativoDTO();
					
					valorCritico.setValor(Boolean.FALSE);
					
					valorReservado.setValor(Boolean.TRUE);
					valorCritico.setCodigoPractica(textField.getText());
					valorReservado.setCodigoPractica(textField.getText());
					
					practica.setValoresCriticos(valorCritico);
					practica.setValoresReservados(valorReservado);
				}
				
				try {
					ControladorPractica.getInstancia().modificar(practica);
					mostrarOk();
					
					desdeCritico.setText("");
					hastaCritico.setText("");
					desdeReservado.setText("");
					hastaReservado.setText("");
					horas.setText("");
					nombre.setText("");
					textField.setText("");
					textField.enable();
					panel.setVisible(false);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnModificar.setBounds(6, 349, 117, 29);
		panel.add(btnModificar);
		
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(247, 7, 61, 16);
		panel.add(lblGrupo);
		
		tipoResultado = new JTextField();
		tipoResultado.setEditable(false);
		tipoResultado.setBounds(6, 249, 188, 26);
		panel.add(tipoResultado);
		tipoResultado.setColumns(10);
		
		JLabel lblTipoDeResultado = new JLabel("Tipo de resultado");
		lblTipoDeResultado.setBounds(6, 221, 162, 16);
		panel.add(lblTipoDeResultado);
		
		desdeCritico = new JTextField();
		desdeCritico.setVisible(false);
		desdeCritico.setBounds(250, 193, 130, 26);
		panel.add(desdeCritico);
		desdeCritico.setColumns(10);
		
		desdeReservado = new JTextField();
		desdeReservado.setVisible(false);
		desdeReservado.setBounds(247, 349, 130, 26);
		panel.add(desdeReservado);
		desdeReservado.setColumns(10);
		
		hastaReservado = new JTextField();
		hastaReservado.setVisible(false);
		hastaReservado.setBounds(409, 349, 130, 26);
		panel.add(hastaReservado);
		hastaReservado.setColumns(10);
		
		hastaCritico = new JTextField();
		hastaCritico.setVisible(false);
		hastaCritico.setBounds(409, 193, 130, 26);
		panel.add(hastaCritico);
		hastaCritico.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setVisible(false);
		lblDesde.setBounds(250, 165, 61, 16);
		panel.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setVisible(false);
		lblHasta.setBounds(409, 165, 61, 16);
		panel.add(lblHasta);
		
		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setVisible(false);
		lblDesde_1.setBounds(247, 321, 61, 16);
		panel.add(lblDesde_1);
		
		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setVisible(false);
		lblHasta_1.setBounds(409, 321, 61, 16);
		panel.add(lblHasta_1);
		
		JLabel lblValoresCriticos = new JLabel("Valores criticos");
		lblValoresCriticos.setVisible(false);
		lblValoresCriticos.setBounds(353, 129, 117, 16);
		panel.add(lblValoresCriticos);
		
		JLabel lblValoresReservados = new JLabel("Valores reservados");
		lblValoresReservados.setVisible(false);
		lblValoresReservados.setBounds(353, 294, 144, 16);
		panel.add(lblValoresReservados);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaDTO practica;
				try {
					practica = ControladorPractica.getInstancia().buscar(textField.getText());
					horas.setText(practica.getHorasResultado().toString());
					nombre.setText(practica.getNombre());
					tipoResultado.setText("Positivo/Negativo");
					habilitada.setSelected(practica.getHabilitada());
					
					tipoResultadoGuardado= practica.getTipoResultado();
					
					if(tipoResultadoGuardado == 1) {
						lblValoresReservados.setVisible(true);
						lblValoresCriticos.setVisible(true);
						lblHasta_1.setVisible(true);
						lblDesde_1.setVisible(true);
						lblHasta.setVisible(true);
						lblDesde.setVisible(true);
						hastaCritico.setVisible(true);
						hastaReservado.setVisible(true);
						desdeReservado.setVisible(true);
						desdeCritico.setVisible(true);
						
						hastaCritico.setText(((ValorDesdeHastaDTO)practica.getValoresCriticos()).getValorHasta().toString());
						hastaReservado.setText(((ValorDesdeHastaDTO)practica.getValoresReservados()).getValorHasta().toString());
						
						desdeReservado.setText(((ValorDesdeHastaDTO)practica.getValoresReservados()).getValorDesde().toString());
						desdeCritico.setText(((ValorDesdeHastaDTO)practica.getValoresCriticos()).getValorDesde().toString());

						tipoResultado.setText("Desde/Hasta");
					}
					
					for(ComboDTO grupo : ControladorPractica.getInstancia().buscarGruposPosibles()) {
						if(grupo.getCodigo() == practica.getGrupo()) {
							comboBox.setSelectedItem(grupo);
						}
					}
					
					textField.disable();
					panel.setVisible(true);
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnCargarDatos.setBounds(181, 37, 117, 29);
		getContentPane().add(btnCargarDatos);
		
		
	}
}
