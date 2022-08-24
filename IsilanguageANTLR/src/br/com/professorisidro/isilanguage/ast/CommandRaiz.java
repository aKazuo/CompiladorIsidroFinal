package br.com.professorisidro.isilanguage.ast;

public class CommandRaiz {
	private String num;
	
	public CommandRaiz (String num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		//return "CommandExponencial [base=" + base + ", expoente=" + expoente + "]";
		return "Math.sqrt("+ num +")";
	}
}
