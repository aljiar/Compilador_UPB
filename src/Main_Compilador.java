import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Compilador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		test();
	}
	public static void test() throws FileNotFoundException, IOException {
		Lexico_Compilador tknCS;
		tknCS = new Lexico_Compilador();
		ArrayList<String> cadena = new ArrayList<String>();
		String txt;
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
			} else if (tknCS.isSystemKeyWord(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Pal.Res. Libreria System");
			} else if (tknCS.isComparador(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Comparador");
			} else if (tknCS.isDelimitador(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Delimitador");
			} else if (tknCS.isEntero(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Entero");
			} else if (tknCS.isCaracterEspecial(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Caracter Especial");
			} else if (tknCS.isComentario(cadena.get(j))) {
				System.out.println("");
			} else if (tknCS.isCadena(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Cadena");
			} else if (tknCS.isIdentifier(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Identificador");
			} else if (tknCS.isOperador(cadena.get(j))) {
				System.out.println(cadena.get(j) + " Es Operador");
			}
			j = j + 1;
		}
	}
	public static String readfile(String path) throws FileNotFoundException,IOException {
		
		StringBuilder content_file = new StringBuilder();
		String path_file=path;
		String line;
		FileReader file= new FileReader(path_file);
		BufferedReader buffer= new BufferedReader(file);
		line=buffer.readLine();
		while (line != null) {
	            content_file.append(line);
	            content_file.append("\n");
	            line = buffer.readLine();
		}
		buffer.close();
		return content_file.toString();
	}
}