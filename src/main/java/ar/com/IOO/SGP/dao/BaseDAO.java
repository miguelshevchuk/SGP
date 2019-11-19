package ar.com.IOO.SGP.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

public abstract class BaseDAO<TIPO> {
	
	final Class<TIPO> tipoDeDato;
	protected String rutaArchivo;
	protected String identificador;
	
	public BaseDAO(String nombreArchivo, Class<TIPO> typeParameterClass, String identificador) {
		this.rutaArchivo = "./datos/"+nombreArchivo;
		this.tipoDeDato = typeParameterClass;
		this.identificador = identificador;
	}

//	protected void insertar(TIPO unObjeto) throws ErrorGenericoException, RegistroExistenteException{
////		try {
////			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
////			List<TIPO> registrosGuardados = this.traerRegistros();
////			
////			if(registrosGuardados.stream().anyMatch(registro -> tienenElMismoId(unObjeto, registro, getterId))) {
////				throw new RegistroExistenteException();
////			}
////			
////			registrosGuardados.add(unObjeto);
////			escribirEnArchivo(registrosGuardados);
////		} catch (NoSuchMethodException e) {
////			e.printStackTrace();
////			throw new ErrorGenericoException();
////		} catch (SecurityException e) {
////			e.printStackTrace();
////			throw new ErrorGenericoException();
////		}
//		this.insertar(unObjeto);
//	}
	
	protected <T> void insertar(T unObjeto) throws ErrorGenericoException, RegistroExistenteException{
		try {
			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
			@SuppressWarnings("unchecked")
			List<T> registrosGuardados = (List<T>) this.traerRegistros(unObjeto.getClass());
			
			if(registrosGuardados.stream().anyMatch(registro -> tienenElMismoId(unObjeto, registro, getterId))) {
				throw new RegistroExistenteException();
			}
			
			registrosGuardados.add(unObjeto);
			escribirEnArchivo(registrosGuardados);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
		
	}

	private <T> Boolean tienenElMismoId(T unObjeto, T registro, Method getterId){
		
		Boolean esElMismo = Boolean.FALSE;
		
		try {
			esElMismo= getterId.invoke(registro).equals(getterId.invoke(unObjeto));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return esElMismo;
	}

	private <T> void escribirEnArchivo(List<T> registrosGuardados) {
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
	
	protected List<TIPO> traerRegistros() throws ErrorGenericoException{
//		String cadena;
//        File archivo = new File(this.rutaArchivo);
//        FileReader f;
//		try {
//			f = new FileReader(archivo);
//	        BufferedReader b = new BufferedReader(f);
//	        cadena = b.readLine();
//	        cadena = (cadena == null)? "[]" : cadena;
//	        JsonParser parser = new JsonParser();
//	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
//	        Gson g = new Gson();
//	        List<TIPO> datos = new ArrayList<TIPO>();
//	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
//	        		datos.add(g.fromJson(js, this.tipoDeDato));
//	        
//	        b.close();
//	        
//	        return datos;
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		}
		return this.traerRegistros(this.tipoDeDato);
	}
	
	protected <T> List<T> traerRegistros(Class<T> tipo) throws ErrorGenericoException{
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
			List<T> datos = new ArrayList<T>();
			for(JsonElement js : gsonArr) //System.out.println(js.toString());
				datos.add(g.fromJson(js, tipo));
			
			b.close();
			
			return datos;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
	}
	
	protected void eliminarRegistro(String idRegistro) throws ErrorGenericoException{
		try {
			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
			
			List<TIPO> registrosGuardados = this.traerRegistros();
			
			registrosGuardados.removeIf(registro -> this.esElMismoRegistro(registro, idRegistro, getterId));
			
			escribirEnArchivo(registrosGuardados);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
		
	}
	
	protected <T> void eliminarRegistro(String idRegistro, Class<T> tipo) throws ErrorGenericoException{
		try {
			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
			
			List<T> registrosGuardados = this.traerRegistros(tipo);
			
			registrosGuardados.removeIf(registro -> this.esElMismoRegistro(registro, idRegistro, getterId));
			
			escribirEnArchivo(registrosGuardados);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
		
	}
	
	protected Object traerRegistroPor(String id) throws ErrorGenericoException, RegistroInexistenteException {
		
//		try {
//			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
//			List<TIPO> registrosGuardados = this.traerRegistros();
//			
//			List<TIPO> resultados = registrosGuardados.stream().filter(registro -> esElMismoRegistro(registro, id, getterId)).collect(Collectors.toList());
//				
//			if(resultados.isEmpty()) {
//				throw new RegistroInexistenteException();
//			}else {
//				return resultados.get(0);
//			}
//			
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		}
		
		return this.traerRegistroPor(id, this.tipoDeDato);
	}
	
	protected <T> Object traerRegistroPor(String id, Class<T> tipo) throws ErrorGenericoException, RegistroInexistenteException {
		
		try {
			Method getterId = tipoDeDato.getMethod("get"+this.identificador);
			List<T> registrosGuardados = this.traerRegistros(tipo);
			
			List<T> resultados = registrosGuardados.stream().filter(registro -> esElMismoRegistro(registro, id, getterId)).collect(Collectors.toList());
			
			if(resultados.isEmpty()) {
				throw new RegistroInexistenteException();
			}else {
				return resultados.get(0);
			}
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
	}
	
	private Boolean esElMismoRegistro(Object registro, String idRegistro, Method getterId) {
		Boolean esElMismo = Boolean.FALSE;
		try {
			esElMismo = ((String) getterId.invoke(registro)).equals(idRegistro);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return esElMismo;
	}
//	
//	@SuppressWarnings("unchecked")
//	protected void modificar(Object unObjeto) throws ErrorGenericoException {
//		Method getterId;
//		try {
//			getterId = tipoDeDato.getMethod("get"+this.identificador);
//		
//			List<TIPO> registrosGuardados = this.traerRegistros();
//			
//			String idObjeto = (String) getterId.invoke(unObjeto);
//			
//			List<TIPO> resultados = registrosGuardados.stream().filter(registro -> !esElMismoRegistro(registro, idObjeto, getterId)).collect(Collectors.toList());
//	
//			resultados.add((TIPO)unObjeto);
//
//			escribirEnArchivo(resultados);
//			
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//			throw new ErrorGenericoException();
//		}
//		
//	}
	@SuppressWarnings("unchecked")
	protected <T> void modificar(T unObjeto) throws ErrorGenericoException {
		Method getterId;
		try {
			getterId = tipoDeDato.getMethod("get"+this.identificador);
			
			List<T> registrosGuardados = (List<T>) this.traerRegistros(unObjeto.getClass());
			
			String idObjeto = (String) getterId.invoke(unObjeto);
			
			List<T> resultados = registrosGuardados.stream().filter(registro -> !esElMismoRegistro(registro, idObjeto, getterId)).collect(Collectors.toList());
			
			resultados.add((T)unObjeto);
			
			escribirEnArchivo(resultados);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new ErrorGenericoException();
		}
		
	}
}
