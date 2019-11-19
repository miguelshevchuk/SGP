package ar.com.IOO.SGP.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;
import ar.com.IOO.SGP.excepcion.RegistroExistenteException;
import ar.com.IOO.SGP.excepcion.RegistroInexistenteException;
import ar.com.IOO.SGP.modelo.Practica;
import ar.com.IOO.SGP.modelo.ValorDesdeHasta;
import ar.com.IOO.SGP.modelo.ValorPositivoNegativo;
import ar.com.IOO.SGP.modelo.ValorResultado;

public abstract class ValorResultadoDAO{
	
	protected String rutaArchivo;
	
	public ValorResultadoDAO(String nombreArchivo) {
		this.rutaArchivo = "./datos/"+nombreArchivo;
	}

	public void insertar(ValorResultado unValor) throws ErrorGenericoException, RegistroExistenteException {
		List<ValorResultado> registrosGuardados = (List<ValorResultado>) this.traerRegistros();
			
		if(registrosGuardados.stream().anyMatch(registro -> unValor.getCodigoPractica().equals(registro.getCodigoPractica()))) {
			throw new RegistroExistenteException();
		}
		registrosGuardados.add(unValor);
		escribirEnArchivo(registrosGuardados);
	}
	
	private void escribirEnArchivo(List<ValorResultado> registrosGuardados) {
		File archivo = new File(this.rutaArchivo);
		FileWriter fileWriter;
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(registrosGuardados);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}	
	
	protected List<ValorResultado> traerRegistros() throws ErrorGenericoException{
		String cadena;
		File archivo = new File(this.rutaArchivo);
		FileReader f;
		try {
			f = new FileReader(archivo);
			BufferedReader b = new BufferedReader(f);
			cadena = b.readLine();
			cadena = (cadena == null)? "[]" : cadena;
			JsonParser parser = new JsonParser();
			JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
			Gson g = new Gson();
			List<ValorResultado> datos = new ArrayList<ValorResultado>();
			for(JsonElement js : gsonArr) { //System.out.println(js.toString());
				ValorPositivoNegativo valor = g.fromJson(js, ValorPositivoNegativo.class);
				if(valor.getValor() == null) {
					datos.add(g.fromJson(js, ValorDesdeHasta.class));
				}else {
					datos.add(valor);
				}	
			}
			b.close();
			
			return datos;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
	}
	
	public void eliminar(Practica unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		
		List<ValorResultado> registrosGuardados = this.traerRegistros();
			
		registrosGuardados.removeIf(registro -> unaPractica.getCodigo().equals(registro.getCodigoPractica()));
		
		escribirEnArchivo(registrosGuardados);
		
	}
	
	public void modificar(ValorResultado unValor) throws ErrorGenericoException, RegistroInexistenteException {
		

		List<ValorResultado> registrosGuardados = (List<ValorResultado>) this.traerRegistros();
		
		List<ValorResultado> resultados = registrosGuardados.stream().filter(registro -> !registro.getCodigoPractica().equals(unValor.getCodigoPractica())).collect(Collectors.toList());
		
		resultados.add(unValor);
		
		escribirEnArchivo(resultados);
		
	}
	
	
	
	
	public ValorResultado buscarPorPractica(Practica unaPractica) throws ErrorGenericoException, RegistroInexistenteException {
		
		List<ValorResultado> registrosGuardados = this.traerRegistros();
		
		List<ValorResultado> resultados = registrosGuardados.stream().filter(registro -> unaPractica.getCodigo().equals(registro.getCodigoPractica())).collect(Collectors.toList());
		
		if(resultados.isEmpty()) {
			throw new RegistroInexistenteException();
		}else {
			return resultados.get(0);
		}
		
	}
	
	
	
}
