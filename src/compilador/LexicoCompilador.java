package compilador;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicoCompilador {
	ArrayList<String> palabrasReservadas = new ArrayList<String>();
	ArrayList<String> cadena = new ArrayList<String>();
	ArrayList<String> tipoDato = new ArrayList<>();

	public LexicoCompilador() {

		palabrasReservadas.addAll(Arrays.asList("Si", "Entonces", "FinSi", "Para", "FinPara", "Mientras", "FinMientras",
				"Funcion", "FinFuncion", "Retorno", "Mostrar"));
		tipoDato.addAll(Arrays.asList("Entero", "Decimal", "Cadena", "Verdadero", "Falso"));

	}

	public boolean isKeyword(String word) {
		return palabrasReservadas.contains(word);
	}
	public boolean isDataType(String word) {
		return tipoDato.contains(word);
	}

	public boolean isIdentifier(String word) {
		Pattern patron = Pattern.compile("^[a-z][a-zA-Z0-9]*");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isComparador(String word) {
		Pattern patron = Pattern.compile("[<|>|=|==|=>|<=]");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isDelimitador(String word) {
		Pattern patron = Pattern.compile("[{|}|\\[?|\\]?|\\/(|\\)]");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isEntero(String word) {
		Pattern patron = Pattern.compile("[0-9]+");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isOperador(String word) {
		Pattern patron = Pattern.compile("[\\%?|\\*?|\\+?|\\-?]");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isCaracterEspecial(String word) {
		Pattern patron = Pattern.compile("[:|;|\\||\\|||\\&|\\&&|\\.|,]");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isComentario(String word) {
		Pattern patron = Pattern.compile("//[\\.]*");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isCadena(String word) {
		Pattern patron = Pattern.compile("\".*?\"");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}

	public boolean isSuma(String word) {
		Pattern patron = Pattern.compile("^[0-9]\\+?[0-9]");
		Matcher matcher = patron.matcher(word);
		return matcher.find();
	}
}
