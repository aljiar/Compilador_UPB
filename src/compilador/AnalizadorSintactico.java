package compilador;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import compilador.Rule;

public class AnalizadorSintactico {
	private ArrayList<Rule> rules = new ArrayList<Rule>();

	public AnalizadorSintactico() {

		rules.add(new Rule("M", "(M)"));
		rules.add(new Rule("M", "M^N"));
		rules.add(new Rule("M", "M*N"));
		rules.add(new Rule("M", "M/N"));
		rules.add(new Rule("M", "E+M"));
		rules.add(new Rule("M", "E-M"));
		rules.add(new Rule("M", "N"));
		rules.add(new Rule("E", "M"));

	}

	public void validateRule(String toAnalize) {
		
	}
}
