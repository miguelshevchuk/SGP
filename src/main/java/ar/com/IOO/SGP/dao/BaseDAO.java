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

public abstract class BaseDAO<TIPO> {
	
	final Class<TIPO> tipoDeDato;
	protected String rutaArchivo;
	
	public BaseDAO(String nombreArchivo, Class<TIPO> typeParameterClass) {
		this.rutaArchivo = "./datos/"+nombreArchivo;
		this.tipoDeDato = typeParameterClass;
	}

	protected void insertar(TIPO unObjeto){
		File archivo = new File(this.rutaArchivo);
		FileWriter fileWriter; 
		
		List<TIPO> registrosGuardados = this.traerRegistros();
		registrosGuardados.add(unObjeto);
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
	
	protected List<TIPO> traerRegistros(){
		String cadena;
        File archivo = new File(this.rutaArchivo);
        FileReader f;
		try {
			f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        cadena = b.readLine();
	        JsonParser parser = new JsonParser();
	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
	        Gson g = new Gson();
	        List<TIPO> datos = new ArrayList<TIPO>();
	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
	        		datos.add(g.fromJson(js, this.tipoDeDato));
	        
	        b.close();
	        
	        return datos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
