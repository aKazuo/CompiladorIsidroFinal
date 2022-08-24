package br.com.professorisidro.isilanguage.ast;

public class CommandLog {
	private String num;
	
	public CommandLog (String num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		//return "CommandExponencial [base=" + base + ", expoente=" + expoente + "]";
		return "Math.log("+ num +")";
	}
}
