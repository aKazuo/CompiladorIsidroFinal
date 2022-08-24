package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {
 
	private String condition;
	private ArrayList<AbstractCommand> listaWhile;
	
	public CommandEnquanto(String condition, ArrayList<AbstractCommand> lw) {
		this.condition = condition;
		this.listaWhile = lw;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("\n      while ("+condition+") {\n");
		for (AbstractCommand cmd: listaWhile) {
			str.append("      	"+cmd.generateJavaCode()+"\n");
		}
		str.append("      }\n");
		
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandEnquanto [condition=" + condition + ", listaWhile=" + listaWhile
				+ "]";
	}
	
}
