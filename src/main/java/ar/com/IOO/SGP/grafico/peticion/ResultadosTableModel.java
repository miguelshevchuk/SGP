package ar.com.IOO.SGP.grafico.peticion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ar.com.IOO.SGP.controlador.ControladorPractica;
import ar.com.IOO.SGP.dto.PracticaDTO;
import ar.com.IOO.SGP.dto.PracticaPeticionDTO;
import ar.com.IOO.SGP.excepcion.BaseException;

public class ResultadosTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2101015666457448797L;
	ArrayList<PracticaPeticionDTO> lista = new ArrayList<PracticaPeticionDTO>();
	protected String[] columnNames = new String[] { "Practica", "Valor"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class}; 
	
	public ResultadosTableModel() throws BaseException
	{
//		this.lista.addAll(ControladorPractica.getInstancia().buscarPracticas());
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
			case 0: return lista.get(rowIndex).getPractica().getNombre(); 
			case 1: 
				if(lista.get(rowIndex).getResultado() != null) {
					if(lista.get(rowIndex).getPractica().getTipoResultado()== 1) {
						return lista.get(rowIndex).getResultado();
					}else {
						if((Boolean)lista.get(rowIndex).getResultado()) {
							return "Positivo";
						}else {
							return "Negativo";
						}
					}
				}else {
					return "Sin resultados";
				}
			default: return null; 
		} 
	}
	public PracticaPeticionDTO getSeleccionado(int rowIndex) {
		return lista.get(rowIndex);
	}
	
	public void agregar(PracticaPeticionDTO practica)
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
	
	public void setLista(ArrayList<PracticaPeticionDTO> practicas) {
		lista = practicas;
	}
	public List<PracticaPeticionDTO> getLista() {
		return lista;
	}
}
