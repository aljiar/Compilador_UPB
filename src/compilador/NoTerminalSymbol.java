package compilador;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoTerminalSymbol {
	private String value;

	public NoTerminalSymbol() {
	}

	public boolean isNotTerminal(String value) {
		Pattern patron = Pattern.compile("[0-9]+");
		Matcher matcher = patron.matcher(value);
		return matcher.find();
	}

	public void setNotTerminal(String value) {
		this.value = value;
	}

}
