import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexico_Compilador {
	int tamPR;
	ArrayList<String> palabrasReservadas = new ArrayList<String>();
	ArrayList<String> cadena = new ArrayList<String>();
	public Lexico_Compilador(){
		
		palabrasReservadas.addAll(Arrays.asList(
				"Si", "Entonces", "FinSi",
				"Para", "FinPara", "Mientras", "FinMientras",
				"Entero", "Decimal", "Cadena", "Funcion", 
				"FinFuncion", "Retorno", "Mostrar", "Verdadero", "sFalso"));
		tamPR=palabrasReservadas.size();
		
	}
	public boolean isKeyword(String word) {
		return palabrasReservadas.contains(word);
	}
	public boolean isSystemKeyWord(String word) {
		 Pattern patron = Pattern.compile("System\\.[a-zA-Z0-9]");
        Matcher matcher = patron.matcher(word);
        return matcher.find();
	}
	public boolean isIdentifier(String word) {
		 Pattern patron = Pattern.compile("[_a-zA-Z][a-zA-Z0-9]*");
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
	public boolean isComentario2(String word) {
		 Pattern patron = Pattern.compile("/*[^/]*/");
  Matcher matcher = patron.matcher(word);
  return matcher.find();
	}
}
