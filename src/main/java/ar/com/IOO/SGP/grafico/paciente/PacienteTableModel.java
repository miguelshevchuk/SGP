package ar.com.IOO.SGP.grafico.paciente;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ar.com.IOO.SGP.controlador.ControladorPaciente;
import ar.com.IOO.SGP.dto.PacienteDTO;
import ar.com.IOO.SGP.excepcion.BaseException;

public class PacienteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2101015666457448797L;
	ArrayList<PacienteDTO> lista = new ArrayList<PacienteDTO>();
	protected String[] columnNames = new String[] { "DNI", "Nombre"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class}; 
	
	public PacienteTableModel() throws BaseException
	{
		
		this.lista.addAll(ControladorPaciente.getInstancia().buscarPacientes());
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
			default: return null; 
		} 
	}
	
	public void agregar(PacienteDTO paciente)
	{
		lista.add(paciente);
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
}
