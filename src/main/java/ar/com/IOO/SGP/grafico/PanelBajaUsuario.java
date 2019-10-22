package ar.com.IOO.SGP.grafico;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelBajaUsuario extends BasePanel {

	/**
	 * 
	 */
	private UsuarioTableModel FUsuarioModel = new UsuarioTableModel();
	
	private static final long serialVersionUID = -5291893986739050156L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelBajaUsuario() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 111);
		scrollPane.setSize(587, 194);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(FUsuarioModel);
		table.setBounds(6, 6, 689, 260);
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 317, 117, 29);
		add(btnEliminar);

	}
}
