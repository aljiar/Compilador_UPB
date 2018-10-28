package compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainCompilador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		test();
	}

	public static void test() throws FileNotFoundException, IOException {
		AnalizadorSintactico sintactico = new AnalizadorSintactico();
		LexicoCompilador tknCS;
		tknCS = new LexicoCompilador();
		ArrayList<String> cadena = new ArrayList<String>();
		String txt;
		String toSintactico = "";
		txt = readfile("example_code.txt");
		StringTokenizer tkn = new StringTokenizer(txt);
		while (tkn.hasMoreTokens()) {
			String i = tkn.nextToken();
			cadena.add(i);
		}
		int j = 0;
		while (j < cadena.size()) {
			if (tknCS.isKeyword(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es palabra reservada");
				toSintactico = toSintactico + "system";
			} else if (tknCS.isComparador(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Comparador");
				toSintactico = toSintactico + cadena.get(j);
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
				toSintactico = toSintactico + cadena.get(j);
			} else if (tknCS.isEntero(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Entero");
				toSintactico = toSintactico + "N";
			} else {
				System.out.println(cadena.get(j) + " Definicion invalida");
			}
			j = j + 1;
		}
		System.out.println(toSintactico);
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