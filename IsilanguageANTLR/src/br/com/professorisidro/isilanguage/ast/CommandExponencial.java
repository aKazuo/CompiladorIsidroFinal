package br.com.professorisidro.isilanguage.ast;

public class CommandExponencial {
	
	private String base, expoente;
	
	public CommandExponencial (String base, String expoente) {
		this.base = base;
		this.expoente = expoente;
	}
	
	@Override
	public String toString() {
		//return "CommandExponencial [base=" + base + ", expoente=" + expoente + "]";
		return "Math.pow("+ base +", "+expoente+ ")";
	}

}
