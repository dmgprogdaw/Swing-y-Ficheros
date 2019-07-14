package AgendaGrafica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import java.util.Map.Entry;

public class Agenda {
	static Map<String, String> agenda = new TreeMap<String, String>();
	static String nombre = null, token = null;
	static String telefono;
	public static String miAgenda (String comando) {
		String resultado = null;
		Scanner s = new Scanner(comando);
		String estado2 = null;
		int estado = 0;
		
		while (estado != 6) {
			switch(estado) {
				case 0:
					try {
						token = s.skip("buscar|borrar|limpiar|\\p{L}+(\\s+\\p{L}+)*").match().group();
						if (token.equals("buscar")) {
							estado2 = "buscar";
							estado = 3;
						}
						else if (token.equals("borrar")) {
							estado2 = "borrar";
							estado = 3;											
						}
						else if (token.equals("limpiar")) {
							estado = 5;
						}
						else {
							nombre = token;
							estado = 1;
						} 			
					}catch (NoSuchElementException e) {
						resultado = "Se esperaba buscar o borrar o limpiar o un nombre";
						estado = 6;
					}		
					break;
				case 1:
					try {
						s.skip("-");
						estado = 2;		
					}catch (NoSuchElementException e) {
						resultado = "Se esperaba un '-'";
						estado = 6;
					}
					break;
				case 2:
					try {
						token = s.skip("\\d{9}").match().group();
						if (agenda.containsKey(nombre)) {	
							agenda.put(nombre, token);
							resultado = "Se ha actualizado el telefono de " + nombre;
						}
						else {
							agenda.put(nombre, token);
							resultado = "Se ha registrado a " + nombre + " en la agenda";
						}
						estado = 6;		
					}catch (NoSuchElementException e) {
						resultado = "Se esperaba un número de telefono";
						estado = 6;
					}
					break;
				case 3:
					try {
						s.skip(":");
						estado = 4;
					}catch (NoSuchElementException e) {
						resultado = "Se esperaba ':'";
						estado = 6;
					}
					break;
				case 4:
					try {
						token = s.skip("[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
						telefono = agenda.get(token);
						if (telefono != null) {
							if (estado2.equals("buscar")) {
								resultado = token + " -> " + telefono;
							}
							else if (estado2.equals("borrar")) {
								agenda.remove(token);
								resultado = "Contacto eliminado: " + token + " -> " + telefono;
							}
						}
						else {
							resultado = token + " no se encuentra en la agenda";
						}
						estado = 6;		
					}catch (NoSuchElementException e) {
						resultado = "Se esperaba un nombre";
						estado = 6;
					}
					break;
				case 5:
					Main.Borrar();
					estado = 6;
					break;
			}
		}
		s.close();
		return resultado;
	}
	
	static String absoluto = null;
	public void cargarFichero(File fichero) {
		FileReader fr = null;
		absoluto = fichero.getAbsolutePath(); 
		try {
			fr = new FileReader(absoluto);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String linea = null;
		try {
			while ((linea = br.readLine()) != null) {	
				String[] contactos = linea.split("-");
				if (contactos[0].equals(nombre)) {
					int cargar = JOptionPane.showConfirmDialog(null, "¿Desea sustituirlo?", "El contacto " + nombre + " ya existe en la agenda", JOptionPane.YES_NO_OPTION);
					if (cargar == JOptionPane.YES_OPTION)
						agenda.put(contactos[0], contactos[1]);
				}
				else {
					agenda.put(contactos[0], contactos[1]);
				}
			}
			br.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public void guardarFichero(File file) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			if (absoluto != null)
				fw = new FileWriter(absoluto);
			else 
				fw = new FileWriter(file);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		Iterator<Entry<String, String>> contactos = Agenda.agenda.entrySet().iterator();
		while (contactos.hasNext()) {
			Map.Entry<String,String> entrada = contactos.next();
			pw.println(entrada.getKey() + "-" + entrada.getValue());	
		}
		pw.close();
	}
}

