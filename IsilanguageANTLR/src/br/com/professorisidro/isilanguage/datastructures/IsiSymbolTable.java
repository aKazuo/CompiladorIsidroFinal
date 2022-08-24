package br.com.professorisidro.isilanguage.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;

public class IsiSymbolTable {
	
	private HashMap<String, IsiSymbol> map;
	
	public IsiSymbolTable() {
		map = new HashMap<String, IsiSymbol>();
		
	}
	
	public void add(IsiSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public IsiSymbol get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<IsiSymbol> getAll(){
		ArrayList<IsiSymbol> lista = new ArrayList<IsiSymbol>();
		for (IsiSymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}

	public void checkType(int type) throws IsiSemanticException  {
		if (type == 1)
			return;
		else{
			throw new IsiSemanticException("A variável não é um texto");
		}
	}
	
}
