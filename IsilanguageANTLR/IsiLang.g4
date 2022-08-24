grammar IsiLang;

@header{
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String _exprEnquanto;
	private String _exprTesta;
	private String _exprCaso;
	private String _expoente;
	private String _exprMat;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> listaWhile;
	private ArrayList<AbstractCommand> listaSwitch;
	private ArrayList<AbstractCommand> listaCase;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
	
}

prog	: 'programa' decl bloco  'fimprog.'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao  
 		|  cmdtesta
 		|  cmdenq
		;
	
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP       { _exprContent ="";}
                 (ID      { verificaID(_input.LT(-1).getText());
	                        _writeID = _input.LT(-1).getText();
                          }
                 | TEXTO  { _writeID = _input.LT(-1).getText();}
                 | cmdmat { _writeID = _exprContent;}
                 ) 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID   { verificaID(_input.LT(-1).getText());
                      _exprID = _input.LT(-1).getText();
                    } 
               ATTR { _exprContent = ""; } 
               (expr
                | TEXTO {  _exprContent += _input.LT(-1).getText(); }
               ) 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'se' AP	  { listaTrue = new ArrayList<AbstractCommand>();
							listaFalse = new ArrayList<AbstractCommand>();
						  }
                    ID    { verificaID(_input.LT(-1).getText()); 
                    	    _exprDecision = _input.LT(-1).getText();
                          }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID   { verificaID(_input.LT(-1).getText());
                    		_exprDecision += _input.LT(-1).getText();
                          }
                    | NUMBER { _exprDecision += _input.LT(-1).getText();}
                    | TEXTO  { _exprDecision += _input.LT(-1).getText();}
                    | cmdmat { _exprDecision += _exprContent;}
                    )
                    FP 
                    'entao'
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		
                   	}
                   )?{
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   }
            ;
            
cmdmat		:  cmdexp
 			|  cmdraiz
 			|  cmdlog
 			;
 			            
cmdexp		: 'exp'
 			  AP  {_exprMat = "";}
 			  (ID {
 			  		verificaID(_input.LT(-1).getText());
 			  	    _exprMat += _input.LT(-1).getText();
 			  }
 			  | NUMBER{ _exprMat += _input.LT(-1).getText();
 			  	
 			  } )
 			  VIR
 			  NUMBER {_expoente = _input.LT(-1).getText();}
 			  FP
 			  {
 			  	CommandExponencial cmd = new CommandExponencial(_exprMat, _expoente);
 			  	_exprContent += cmd.toString();
 			  }
 			;
 			
 cmdraiz    : 'raiz'
 			  AP {_exprMat = "";}
 			  (ID { 
 			  		verificaID(_input.LT(-1).getText());
 			  	    _exprMat = _input.LT(-1).getText();
 			  }
 			  | NUMBER{ _exprMat = _input.LT(-1).getText();
 			  	
 			  })
 			  FP
 			  {
 			  	CommandRaiz cmd = new CommandRaiz(_exprMat);
 			  	_exprContent += cmd.toString();
 			  }
 			;
 			
 cmdlog		: 'log'
 			  AP {_exprMat = "";}
 			  (ID { 
 			  		verificaID(_input.LT(-1).getText());
 			  	    _exprMat = _input.LT(-1).getText();
 			  }
 			  | NUMBER{ _exprMat = _input.LT(-1).getText();
 			  	
 			  } )
 			  FP
 			  {
 			  	CommandLog cmd = new CommandLog(_exprMat);
 			  	_exprContent += cmd.toString();
 			  }
 			;
 			
 cmdtesta	: 'testa'
 			  AP      { listaSwitch = new ArrayList<AbstractCommand>();
 			  		
				      }
 			  ID      { verificaID(_input.LT(-1).getText());
 			  	        _exprTesta = _input.LT(-1).getText();
 			          }
 			  FP      { CommandSwitch1 cmd = new CommandSwitch1(_exprTesta);
 			  		    stack.peek().add(cmd);}
 			  ACH 	  
 			  (cmdcaso)+
 			  FCH     { CommandSwitch2 cmd2 = new CommandSwitch2();
 			  		    stack.peek().add(cmd2);
 			  		  }
 			 ;

 cmdcaso   : 'caso'   { listaCase = new ArrayList<AbstractCommand>();
 			  	      }
 			  (NUMBER  | TEXTO ){ _exprCaso = _input.LT(-1).getText();} 
 			  DPT     
 			  ACH     { curThread = new ArrayList<AbstractCommand>(); 
                        stack.push(curThread);
                      }
 			  (cmd)+
 			  FCH     { listaCase = stack.pop();
 			  			CommandCase cmd = new CommandCase (_exprCaso, listaCase);
 			  		    stack.peek().add(cmd);
 			  		  }
 		   ;
 			 
 cmdenq 	: 'enquanto'
 			  AP       { listaWhile = new ArrayList<AbstractCommand>();
 			  		     _exprEnquanto = "";
					   }
 			  ID       { verificaID(_input.LT(-1).getText());
 			  		     _exprEnquanto += _input.LT(-1).getText();
 			  }
 			  OPREL    { _exprEnquanto += _input.LT(-1).getText();} 
 			  ( ID     { verificaID(_input.LT(-1).getText());
 			  	         _exprEnquanto += _input.LT(-1).getText();
 			  } 
 			  | NUMBER { _exprEnquanto += _input.LT(-1).getText();}
 			  | TEXTO  { _exprEnquanto += _input.LT(-1).getText();}
 			  )  
 			  FP
 			  ACH      { curThread = new ArrayList<AbstractCommand>(); 
                         stack.push(curThread);
                       }
 			  (cmd)+   
 			  FCH      { 
                   		 listaWhile = stack.pop();
                   		 CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaWhile);
                   		 stack.peek().add(cmd);
                 	   }
 			  ;
			
expr		: expr  
	          (OPSOM|OPSUB)  { _exprContent += _input.LT(-1).getText();}
	          termo
	        | termo
			;
			
termo       : termo
			  (OPMUL|OPDIV) { _exprContent += _input.LT(-1).getText();}
			  fator
			| fator
			;

fator		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER {
              	_exprContent += _input.LT(-1).getText();
              }
            | cmdmat
            | AP expr FP 
            
			;
			
TEXTO       : '"' (~'"')* '"'
			;
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: '.'
	;
	
OPSOM	: '+'
	;

OPSUB   : '-'
	;
	
OPMUL	: '*'
	;
	
OPDIV	: '/'
	;
	
ATTR : ':='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
     
DPT  : ':'
     ;
 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: ([a-z]|[A-Z]) ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;