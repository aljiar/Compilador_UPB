package compilador;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorSintactico {
	private ArrayList<Rule> rules = new ArrayList<Rule>();

	public AnalizadorSintactico() {

		rules.add(new Rule("identoperident", "oprcn"));
		rules.add(new Rule("tipoidentcompent", "asig"));
		rules.add(new Rule("identcompsent", "asig"));
		rules.add(new Rule("identcompoprcn", "sent"));
		rules.add(new Rule("asigsent", "sent"));
		rules.add(new Rule("identsent", "sent"));
		rules.add(new Rule("systemsentsystem", "valido"));

	}

	public String validateRule(String toAnalize) {
		String res = toAnalize;
		if (!res.equals("valido")) {
			boolean band = true;
			int index = 0;
			while (index < rules.size()) {
				Pattern patron = Pattern.compile(rules.get(index).getKey());
				Matcher matcher = patron.matcher(res);
				if (matcher.find()) {
					res = res.replace(rules.get(index).getKey(), rules.get(index).getValue());
					System.out.println(res);
				} else {
					index++;
				}
			}
			validateRule(res);
		}
		return res;
	}
}
