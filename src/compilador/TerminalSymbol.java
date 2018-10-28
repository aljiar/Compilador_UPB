package compilador;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalSymbol {
	private String value;
	public TerminalSymbol()
	{
	}
	public boolean validateTerminal(String value)
	{
		Pattern patron = Pattern.compile("^[A-Z]*");
		Matcher matcher = patron.matcher(value);
		return matcher.find();
	}
	public void setTerminal(String value)
	{
		this.value=value;
	}
}
