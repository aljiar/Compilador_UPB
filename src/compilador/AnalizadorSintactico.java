package compilador;

import java.util.*;

public class AnalizadorSintactico {
	private ArrayList<Rule> rules = new ArrayList<Rule>();
	public AnalizadorSintactico()
	{
		
		rules.add(new Rule("M","(M)"));
		rules.add(new Rule("M","M^N"));
		rules.add(new Rule("M","M*N"));
		rules.add(new Rule("M","M/N"));
		rules.add(new Rule("M","E+M"));
		rules.add(new Rule("M","E-M"));
		rules.add(new Rule("E","M"));
		rules.add(new Rule("M","N"));
		
	}
	public boolean validateRule(String toAnalize)
	{
		String aux="";
		boolean res= false;
		for(int index=0; index<toAnalize.length();index++)
		{
			aux=aux+toAnalize.charAt(index);
			for(int r_index=0;r_index<rules.size();r_index++){
				System.out.println(aux);
				if(aux.equals(rules.get(r_index).getValue()))
				{
					res=true;
					}
				else {
					
					res=false;
				}
			}
		}
		
		return res;
	}
	public String changeString(String toAnalize)
	{
		String res="";
		for(int index=0;index<rules.size();index++)
		{
			//for(int ind_r=) {
			//if(toAnalize.charAt(index).equals())
			//}
		}
		return res;
		
	}

}
