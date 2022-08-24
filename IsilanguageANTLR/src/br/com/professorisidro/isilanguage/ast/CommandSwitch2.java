package br.com.professorisidro.isilanguage.ast;

public class CommandSwitch2 extends AbstractCommand {
	@Override
	public String generateJavaCode() {
		return "}\n";
	}
	
	public String toString() {
		return "CommandSwitch - FechaSwitch";
	}
}
