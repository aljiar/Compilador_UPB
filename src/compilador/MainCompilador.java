package compilador;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import UI.JSintactico;
import UI.JTextAreaOutputStream;
import UI.Jlexico;

public class MainCompilador {

	
	public static Jlexico uilex;
	public static String d;
	public static String txt;

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
	
		test();
	}
	
	
	  public static synchronized void getDato()throws InterruptedException,FileNotFoundException, IOException 
	   {
	      if (d.length()==0)
	      Thread.sleep(5000);
	      
	    	  
	    	  System.out.println("entre");
	      txt=readfile(d);
	      System.out.println(txt);
	  	AnalizadorSintactico sintactico = new AnalizadorSintactico();
		
	      LexicoCompilador tknCS;
			tknCS = new LexicoCompilador();
			ArrayList<String> cadena = new ArrayList<String>();
			
	      StringTokenizer tkn = new StringTokenizer(txt);
			while (tkn.hasMoreTokens()) {
				String i = tkn.nextToken();
				cadena.add(i);
			}
			
			uilex.btnValidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String toSintactico = "";
					JTextAreaOutputStream out = new JTextAreaOutputStream (uilex.textArea_1);
					System.setOut (new PrintStream (out));
					int j = 0;
					while (j < cadena.size()) {
						if (tknCS.isKeyword(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es palabra reservada");
							toSintactico = toSintactico + "system";
						} else if (tknCS.isComparador(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Comparador");
							toSintactico = toSintactico + "comp";
						} else if (tknCS.isDataType(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Tipo de Dato");
							toSintactico = toSintactico + "tipo";
						} else if (tknCS.isDelimitador(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Delimitador");
							toSintactico = toSintactico + cadena.get(j);
						} else if (tknCS.isCaracterEspecial(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Caracter Especial");
						} else if (tknCS.isComentario(cadena.get(j))) {
							System.out.println("");
						} else if (tknCS.isCadena(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Cadena");
						} else if (tknCS.isIdentifier(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Identificador");
							toSintactico = toSintactico + "ident";
						} else if (tknCS.isOperador(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Operador");
							toSintactico = toSintactico + "oper";
						} else if (tknCS.isEntero(cadena.get(j))) {
							System.out.println(cadena.get(j) + " Es Entero");
							toSintactico = toSintactico + "ent";
						} else {
							System.out.println(cadena.get(j) + " Definicion invalida");
						}
						j = j + 1;
					}
					System.out.println(toSintactico);
					sintactico.validateRule(toSintactico);
					
				}
			});
			
			uilex.btnSintactico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					

					// timer.start();

					uilex.setVisible(false);
					uilex.dispose();
					
					JSintactico sintac =new JSintactico();
					sintac.pack();
					sintac.setLocationRelativeTo(null);
					sintac.setVisible(true);

				}
			});
			
	      
	   } 
	

	public static void test() throws FileNotFoundException, IOException, InterruptedException {
	
		
		uilex= new Jlexico();
		uilex.setVisible(true);
		 
		Thread.sleep(20000);
		d = uilex.direccion;
		Thread.sleep(7000);
		System.out.println("soy"+d);
		
		
		
		
		getDato();
		
		
		
	}

	public static String readfile(String path) throws FileNotFoundException, IOException {

		StringBuilder content_file = new StringBuilder();
		String path_file = path;
		String line;
		FileReader file = new FileReader(path_file);
		BufferedReader buffer = new BufferedReader(file);
		line = buffer.readLine();
		while (line != null) {
			content_file.append(line);
			content_file.append("\n");
			line = buffer.readLine();
		}
		buffer.close();
		return content_file.toString();
	}
}