package ar.com.IOO.SGP.grafico.usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ar.com.IOO.SGP.controlador.ControladorUsuario;
import ar.com.IOO.SGP.dto.UsuarioDTO;
import ar.com.IOO.SGP.excepcion.BaseException;
import ar.com.IOO.SGP.grafico.BasePanel;

public class PanelBajaUsuario extends BasePanel {

	/**
	 * 
	 */
	private UsuarioTableModel FUsuarioModel;
	
	private static final long serialVersionUID = -5291893986739050156L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelBajaUsuario() {
		
		try {
			this.FUsuarioModel = new UsuarioTableModel();
		} catch (BaseException e) {
			this.mostrarError(e);
		}
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 111);
		scrollPane.setSize(587, 194);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(FUsuarioModel);
		table.setBounds(6, 6, 689, 260);
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDTO usuarioBaja = new UsuarioDTO();
				usuarioBaja.setDni(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				try {
					ControladorUsuario.getInstancia().eliminarUsuario(usuarioBaja);
					
					table.setModel(new UsuarioTableModel());
					
					mostrarOk();
				} catch (BaseException e1) {
					mostrarError(e1);
				}
				
			}
		});
		btnEliminar.setBounds(10, 317, 117, 29);
		getContentPane().add(btnEliminar);

	}
}
