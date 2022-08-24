package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandCase extends AbstractCommand {
 
	private String caso;
	private ArrayList<AbstractCommand> listaCase;
	
	public CommandCase(String caso, ArrayList<AbstractCommand> lc) {
		this.caso = caso;
		this.listaCase = lc;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("	case " +caso+ " :{\n");
		for (AbstractCommand cmd: listaCase) {
			str.append("			"+cmd.generateJavaCode()+"\n");
		}
		str.append("		}\n");
		
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandCaso [caso=" + caso + ", listaCase=" + listaCase
				+ "]";
	}
	
}
