package compilador;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorSintactico {
	private ArrayList<Rule> rules = new ArrayList<Rule>();

	public AnalizadorSintactico() {

		rules.add(new Rule("IdentificadorOperadorIdentificador", "Sentencia"));
		rules.add(new Rule("SystemIdentificadorComparadorEntero", "Asignacion"));
		rules.add(new Rule("IdentificadorComparadorSentencia", "Asignacion"));

	}

	public boolean validateRule(String toAnalize) {
		boolean valid = false;
		String aux = toAnalize;
		int index = 0;
		String res = "";
		while (index < rules.size()) {
			Pattern patron = Pattern.compile(rules.get(index).getKey());
			Matcher matcher = patron.matcher(aux);
			if (matcher.find()) {
				res = aux.replace(rules.get(index).getKey(), rules.get(index).getValue());
				System.out.println(res);
			}
			index++;
		}
		return valid;
	}
}
