package ar.com.IOO.SGP.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ar.com.IOO.SGP.modelo.Paciente;

public abstract class BaseDAO {
	
	protected String rutaArchivo;
	
	public BaseDAO(String nombreArchivo) {
		this.rutaArchivo = "./datos/"+nombreArchivo;
	}

	protected void insertar(Object unObjeto){
		File archivo = new File(this.rutaArchivo);
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(unObjeto);
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
	
	protected List<Object> traerRegistros(Object unObjeto){
		String cadena;
        File archivo = new File(this.rutaArchivo);
        FileReader f;
		try {
			f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        cadena = b.readLine();
	        System.out.println(cadena);
	        JsonParser parser = new JsonParser();
	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
	        Gson g = new Gson();
	        List<Object> datos = new ArrayList<Object>();
	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
	        	datos.add(g.fromJson(js, Paciente.class));
	        
	        b.close();
	        
	        return datos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
