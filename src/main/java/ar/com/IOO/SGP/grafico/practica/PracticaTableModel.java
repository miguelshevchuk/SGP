package ar.com.IOO.SGP.grafico.practica;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.excepcion.BaseException;

public class PracticaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2101015666457448797L;
	ArrayList<PracticaDTO> lista = new ArrayList<PracticaDTO>();
	protected String[] columnNames = new String[] { "Codigo", "Nombre", "Estado", "Tipo de resultado"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class}; 
	
	public PracticaTableModel() throws BaseException
	{
		
		this.lista.addAll(ControladorPractica.getInstancia().buscarPracticas());
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
			case 0: return lista.get(rowIndex).getCodigo(); 
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getHabilitada();
			case 3: return lista.get(rowIndex).getTipoResultado();
			default: return null; 
		} 
	}
	
	public void agregar(PracticaDTO practica)
	{
		lista.add(practica);
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
}
