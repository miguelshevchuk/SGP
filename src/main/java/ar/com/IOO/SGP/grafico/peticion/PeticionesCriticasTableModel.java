package ar.com.IOO.SGP.grafico.peticion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ar.com.IOO.SGP.controlador.ControladorPeticion;
import ar.com.IOO.SGP.dto.PeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;

public class PeticionesCriticasTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2101015666457448797L;
	ArrayList<PeticionDTO> lista = new ArrayList<PeticionDTO>();
	protected String[] columnNames = new String[] { "Codigo", "Paciente", "Sucursal"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class}; 
	
	public PeticionesCriticasTableModel() throws BaseException
	{
		this.lista.addAll(ControladorPeticion.getInstancia().buscarPeticionesConValoresCriticos());
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
			case 0: return lista.get(rowIndex).getIdPeticion(); 
			case 1: return lista.get(rowIndex).getPaciente().toString(); 
			case 2: return lista.get(rowIndex).getSucursal().toString();
			default: return null; 
		} 
	}
	public PeticionDTO getSeleccionado(int rowIndex) {
		return lista.get(rowIndex);
	}
	
	public void agregar(PeticionDTO practica)
	{
		lista.add(practica);
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void limpiarTabla() {
		lista.clear();
		fireTableDataChanged();
	}
	
	public void setLista(ArrayList<PeticionDTO> practicas) {
		lista = practicas;
	}
	public List<PeticionDTO> getLista() {
		return lista;
	}
}
