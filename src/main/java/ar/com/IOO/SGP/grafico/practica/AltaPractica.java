package ar.com.IOO.SGP.grafico.practica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.dto.ComboDTO;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.ValorDesdeHastaDTO;
import ar.com.IOO.SGP.dto.ValorPositivoNegativoDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class AltaPractica extends BasePanel {
	private JTextField codigoPractica;
	private JTextField horasResultado;
	private JTextField nombrePractica;
	private JTextField desdeReservado;
	private JTextField hastaReservado;
	private JTextField desdeCritico;
	private JTextField hastaCritico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPractica frame = new AltaPractica();
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
	public AltaPractica() {
		setBounds(100, 100, 573, 456);
		getContentPane().setLayout(null);
		
		codigoPractica = new JTextField();
		codigoPractica.setBounds(6, 47, 130, 26);
		getContentPane().add(codigoPractica);
		codigoPractica.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(321, 19, 61, 16);
		getContentPane().add(lblNombre);
		
		horasResultado = new JTextField();
		horasResultado.setBounds(321, 121, 130, 26);
		getContentPane().add(horasResultado);
		horasResultado.setColumns(10);
		
		JLabel lblHorasParaEl = new JLabel("Horas para el resultado");
		lblHorasParaEl.setBounds(321, 93, 180, 16);
		getContentPane().add(lblHorasParaEl);
		
		JComboBox grupoPractica = new JComboBox();
		grupoPractica.setBounds(6, 122, 206, 27);
		
		for(ComboDTO grupo : ControladorPractica.getInstancia().buscarGruposPosibles()) {
			grupoPractica.addItem(grupo);
		}
		
		getContentPane().add(grupoPractica);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(6, 94, 61, 16);
		getContentPane().add(lblGrupo);
		
		nombrePractica = new JTextField();
		nombrePractica.setBounds(321, 47, 130, 26);
		getContentPane().add(nombrePractica);
		nombrePractica.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(6, 19, 61, 16);
		getContentPane().add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Tipo resultado");
		lblNewLabel.setBounds(6, 254, 120, 16);
		getContentPane().add(lblNewLabel);
		
		desdeReservado = new JTextField();
//		desdeReservado.setVisible(false);
		desdeReservado.setBounds(209, 360, 130, 26);
		getContentPane().add(desdeReservado);
		desdeReservado.setColumns(10);
		
		hastaReservado = new JTextField();
//		hastaReservado.setVisible(false);
		hastaReservado.setBounds(378, 360, 130, 26);
		getContentPane().add(hastaReservado);
		hastaReservado.setColumns(10);
		
		desdeCritico = new JTextField();
		desdeCritico.setBounds(209, 256, 130, 26);
//		desdeCritico.setVisible(false);
		getContentPane().add(desdeCritico);
		desdeCritico.setColumns(10);
		
		hastaCritico = new JTextField();
		hastaCritico.setBounds(378, 256, 130, 26);
//		hastaCritico.setVisible(false);
		getContentPane().add(hastaCritico);
		hastaCritico.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde");
//		lblDesde.setVisible(false);
		lblDesde.setBounds(209, 332, 61, 16);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
//		lblHasta.setVisible(false);
		lblHasta.setBounds(380, 332, 61, 16);
		getContentPane().add(lblHasta);
		
		JLabel lblDesde_1 = new JLabel("Desde");
//		lblDesde_1.setVisible(false);
		lblDesde_1.setBounds(209, 227, 61, 16);
		getContentPane().add(lblDesde_1);
		
		JLabel lblHasta_1 = new JLabel("Hasta");
//		lblHasta_1.setVisible(false);
		lblHasta_1.setBounds(378, 227, 61, 16);
		getContentPane().add(lblHasta_1);
		
		JLabel lblMensajePositivo = new JLabel("Positivo sera un valor reservado");
		lblMensajePositivo.setVisible(false);
		lblMensajePositivo.setBounds(16, 332, 206, 16);
		getContentPane().add(lblMensajePositivo);
		
		JLabel lblValoresCriticos = new JLabel("Valores criticos");
		lblValoresCriticos.setBounds(311, 195, 130, 16);
		getContentPane().add(lblValoresCriticos);
		
		JLabel lblValoresReservados = new JLabel("Valores reservados");
		lblValoresReservados.setBounds(311, 304, 130, 16);
		getContentPane().add(lblValoresReservados);
		
		JComboBox tipoResultado = new JComboBox();
		for(ComboDTO grupo : ControladorPractica.getInstancia().buscarTiposDeResultadosPosibles()) {
			tipoResultado.addItem(grupo);
		}
		tipoResultado.setBounds(6, 282, 180, 27);
		getContentPane().add(tipoResultado);
		tipoResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboDTO seleccionado = (ComboDTO) tipoResultado.getSelectedItem();
				
				if(seleccionado.getCodigo() == 1) {
					hastaReservado.setVisible(true);
					desdeReservado.setVisible(true);
					lblDesde.setVisible(true);
					lblHasta.setVisible(true);
					hastaCritico.setVisible(true);
					desdeCritico.setVisible(true);
					lblDesde_1.setVisible(true);
					lblHasta_1.setVisible(true);
					lblValoresCriticos.setVisible(true);
					lblValoresReservados.setVisible(true);
					lblMensajePositivo.setVisible(false);
				}else {
					hastaReservado.setVisible(false);
					desdeReservado.setVisible(false);
					lblDesde.setVisible(false);
					lblHasta.setVisible(false);
					hastaCritico.setVisible(false);
					desdeCritico.setVisible(false);
					lblDesde_1.setVisible(false);
					lblHasta_1.setVisible(false);
					lblValoresCriticos.setVisible(false);
					lblValoresReservados.setVisible(false);
					lblMensajePositivo.setVisible(true);
				}
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComboDTO tipoResultadoSeleccionado = (ComboDTO) tipoResultado.getSelectedItem();
				ComboDTO grupoSeleccionado = (ComboDTO) grupoPractica.getSelectedItem();
				
				PracticaDTO practica = new PracticaDTO();
				practica.setCodigo(codigoPractica.getText());
				practica.setHabilitada(Boolean.TRUE);
				practica.setHorasResultado(Integer.parseInt(horasResultado.getText()));
				practica.setTipoResultado(tipoResultadoSeleccionado.getCodigo());
				practica.setNombre(nombrePractica.getText());
				
				if(tipoResultadoSeleccionado.getCodigo() == 1) {
					ValorDesdeHastaDTO valorCritico = new ValorDesdeHastaDTO();
					ValorDesdeHastaDTO valorReservado = new ValorDesdeHastaDTO();
					
					valorCritico.setValorDesde(Integer.parseInt(desdeCritico.getText()));
					valorCritico.setValorHasta(Integer.parseInt(hastaCritico.getText()));
					
					valorReservado.setValorDesde(Integer.parseInt(desdeReservado.getText()));
					valorReservado.setValorHasta(Integer.parseInt(hastaReservado.getText()));
					
					practica.setValoresCriticos(valorCritico);
					practica.setValoresReservados(valorReservado);
					
				}else {
					ValorPositivoNegativoDTO valorCritico = new ValorPositivoNegativoDTO();
					ValorPositivoNegativoDTO valorReservado = new ValorPositivoNegativoDTO();
					
					valorCritico.setValor(Boolean.FALSE);
					
					valorReservado.setValor(Boolean.TRUE);
					
					practica.setValoresCriticos(valorCritico);
					practica.setValoresReservados(valorReservado);
				}
				
				try {
					ControladorPractica.getInstancia().alta(practica);
					mostrarOk();
					
					desdeCritico.setText("");
					hastaCritico.setText("");
					desdeReservado.setText("");
					hastaReservado.setText("");
					horasResultado.setText("");
					nombrePractica.setText("");
					codigoPractica.setText("");
				} catch (BaseException e1) {
					mostrarError(e1);
				}
			}
		});
		btnAgregar.setBounds(6, 360, 117, 29);
		getContentPane().add(btnAgregar);
		
		
		
	}
}
