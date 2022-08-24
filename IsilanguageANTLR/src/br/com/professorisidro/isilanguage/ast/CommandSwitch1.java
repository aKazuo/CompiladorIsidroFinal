package br.com.professorisidro.isilanguage.ast;

public class CommandSwitch1 extends AbstractCommand {
	
	private String condition;
	public CommandSwitch1 (String condition) {
		this.condition = condition;
	}
	@Override
	public String generateJavaCode() {
		
		return "\n      switch (" +condition+") {";
	}
	
	@Override
	public String toString() {
		return "CommandSwitch [condition=" + condition + "]";
	}
}
