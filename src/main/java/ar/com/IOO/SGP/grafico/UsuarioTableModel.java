package ar.com.IOO.SGP.grafico;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ar.com.IOO.SGP.dto.UsuarioDTO;

public class UsuarioTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2101015666457448797L;
	ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
	protected String[] columnNames = new String[] { "DNI", "Nombre", "Rol"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class}; 
	
	public UsuarioTableModel()
	{
		UsuarioDTO unUsuario = new UsuarioDTO();
		unUsuario.setDni("37558355");
		unUsuario.setNombre("Miguel Shevchuk");
		unUsuario.setRol("Administrador");
		
		this.lista.add(unUsuario);
		this.lista.add(unUsuario);
		this.lista.add(unUsuario);
	}
	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.length;
	}

//	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stubç
		switch(columnIndex) 
		{ 
			case 0: return lista.get(rowIndex).getDni(); 
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getRol();
			default: return null; 
		} 
	}
	
	public void agregar(UsuarioDTO usuario)
	{
		lista.add(usuario);
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}

	
}
