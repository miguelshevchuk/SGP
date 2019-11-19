package ar.com.IOO.SGP.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import ar.com.IOO.SGP.excepcion.ErrorGenericoException;

public class LoginDAO {
	
	private static LoginDAO instancia;
	
	public static LoginDAO getInstancia() {
		if(instancia == null) {
			instancia = new LoginDAO();
		}
		return instancia;
	}

	public void loguear(String unRol) {
		File archivo = new File("./datos/usuarioLogueado.txt");
		FileWriter fileWriter;
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(unRol);
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
	
	public String getTipoUsuarioLogueado() throws ErrorGenericoException {
		String cadena;
		File archivo = new File("./datos/usuarioLogueado.txt");
		FileReader f;
		try {
			f = new FileReader(archivo);
			BufferedReader b = new BufferedReader(f);
			cadena = b.readLine();
			
			return cadena;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
	}
	
}
