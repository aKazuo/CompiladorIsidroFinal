// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, TEXTO=16, AP=17, 
		FP=18, SC=19, OPSOM=20, OPSUB=21, OPMUL=22, OPDIV=23, ATTR=24, VIR=25, 
		ACH=26, FCH=27, DPT=28, OPREL=29, ID=30, NUMBER=31, WS=32;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdmat = 10, RULE_cmdexp = 11, RULE_cmdraiz = 12, 
		RULE_cmdlog = 13, RULE_cmdtesta = 14, RULE_cmdcaso = 15, RULE_cmdenq = 16, 
		RULE_expr = 17, RULE_termo = 18, RULE_fator = 19;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdmat", "cmdexp", "cmdraiz", "cmdlog", "cmdtesta", 
		"cmdcaso", "cmdenq", "expr", "termo", "fator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'entao'", "'senao'", "'exp'", "'raiz'", "'log'", "'testa'", "'caso'", 
		"'enquanto'", null, "'('", "')'", "'.'", "'+'", "'-'", "'*'", "'/'", "':='", 
		"','", "'{'", "'}'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "TEXTO", "AP", "FP", "SC", "OPSOM", "OPSUB", "OPMUL", 
		"OPDIV", "ATTR", "VIR", "ACH", "FCH", "DPT", "OPREL", "ID", "NUMBER", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		
		public void checkType(int i){
			symbolTable.checkType(i);
		}

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			decl();
			setState(42);
			bloco();
			setState(43);
			match(T__1);
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	 
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				declaravar();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			tipo();
			setState(52);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(54);
				match(VIR);
				setState(55);
				match(ID);

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
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__2);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__3);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				cmd();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdtestaContext cmdtesta() {
			return getRuleContext(CmdtestaContext.class,0);
		}
		public CmdenqContext cmdenq() {
			return getRuleContext(CmdenqContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				cmdselecao();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				cmdtesta();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				cmdenq();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__4);
			setState(85);
			match(AP);
			setState(86);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(88);
			match(FP);
			setState(89);
			match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
			                System.out.print(var);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public CmdmatContext cmdmat() {
			return getRuleContext(CmdmatContext.class,0);
		}
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__5);
			setState(93);
			match(AP);
			 _exprContent ="";
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(95);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					                        _writeID = _input.LT(-1).getText();
				                          
				}
				break;
			case TEXTO:
				{
				setState(97);
				match(TEXTO);
				 _writeID = _input.LT(-1).getText();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
				{
				setState(99);
				cmdmat();
				 _writeID = _exprContent;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104);
			match(FP);
			setState(105);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                      _exprID = _input.LT(-1).getText();
			                      
			                    
			setState(110);
			match(ATTR);
			 
			               		 
			               		  _exprContent = "";
			               
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
			case AP:
			case ID:
			case NUMBER:
				{
				setState(112);
				expr(0);
				}
				break;
			case TEXTO:
				{
				setState(113);
				match(TEXTO);
				   IsiVariable var = (IsiVariable)symbolTable.get(_exprID);
				                			if(var.getType() == 0)
				                				throw new IsiSemanticException("A variável "+ var.getName() +" não é um texto");
				                			_exprContent += _input.LT(-1).getText();
				                
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117);
			match(SC);

			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               	 stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public CmdmatContext cmdmat() {
			return getRuleContext(CmdmatContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__6);
			setState(121);
			match(AP);
			 listaTrue = new ArrayList<AbstractCommand>();
										listaFalse = new ArrayList<AbstractCommand>();
									  
			setState(123);
			match(ID);
			 verificaID(_input.LT(-1).getText()); 
			                    	    _exprDecision = _input.LT(-1).getText();
			                          
			setState(125);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(127);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    		_exprDecision += _input.LT(-1).getText();
				                          
				}
				break;
			case NUMBER:
				{
				setState(129);
				match(NUMBER);
				 _exprDecision += _input.LT(-1).getText();
				}
				break;
			case TEXTO:
				{
				setState(131);
				match(TEXTO);
				 _exprDecision += _input.LT(-1).getText();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
				{
				setState(133);
				cmdmat();
				 _exprDecision += _exprContent;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(138);
			match(FP);
			setState(139);
			match(T__7);
			setState(140);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				cmd();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << ID))) != 0) );
			setState(147);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(149);
				match(T__8);
				setState(150);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(152);
					cmd();
					}
					}
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << ID))) != 0) );
				}
				setState(157);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		
				                   	
				}
			}


			                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                   		stack.peek().add(cmd);
			                   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdmatContext extends ParserRuleContext {
		public CmdexpContext cmdexp() {
			return getRuleContext(CmdexpContext.class,0);
		}
		public CmdraizContext cmdraiz() {
			return getRuleContext(CmdraizContext.class,0);
		}
		public CmdlogContext cmdlog() {
			return getRuleContext(CmdlogContext.class,0);
		}
		public CmdmatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdmat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdmat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdmat(this);
		}
	}

	public final CmdmatContext cmdmat() throws RecognitionException {
		CmdmatContext _localctx = new CmdmatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdmat);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				cmdexp();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				cmdraiz();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				cmdlog();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdexpContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode VIR() { return getToken(IsiLangParser.VIR, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdexp(this);
		}
	}

	public final CmdexpContext cmdexp() throws RecognitionException {
		CmdexpContext _localctx = new CmdexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__9);
			setState(170);
			match(AP);
			_exprMat = "";
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(172);
				match(ID);

				 			  		verificaID(_input.LT(-1).getText());
				 			  	    _exprMat += _input.LT(-1).getText();
				 			  
				}
				break;
			case NUMBER:
				{
				setState(174);
				match(NUMBER);
				 _exprMat += _input.LT(-1).getText();
				 			  	
				 			  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(178);
			match(VIR);
			setState(179);
			match(NUMBER);
			_expoente = _input.LT(-1).getText();
			setState(181);
			match(FP);

			 			  	CommandExponencial cmd = new CommandExponencial(_exprMat, _expoente);
			 			  	_exprContent += cmd.toString();
			 			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdraizContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public CmdraizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdraiz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdraiz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdraiz(this);
		}
	}

	public final CmdraizContext cmdraiz() throws RecognitionException {
		CmdraizContext _localctx = new CmdraizContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdraiz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__10);
			setState(185);
			match(AP);
			_exprMat = "";
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(187);
				match(ID);
				 
				 			  		verificaID(_input.LT(-1).getText());
				 			  	    _exprMat = _input.LT(-1).getText();
				 			  
				}
				break;
			case NUMBER:
				{
				setState(189);
				match(NUMBER);
				 _exprMat = _input.LT(-1).getText();
				 			  	
				 			  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(193);
			match(FP);

			 			  	CommandRaiz cmd = new CommandRaiz(_exprMat);
			 			  	_exprContent += cmd.toString();
			 			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdlogContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public CmdlogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdlog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdlog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdlog(this);
		}
	}

	public final CmdlogContext cmdlog() throws RecognitionException {
		CmdlogContext _localctx = new CmdlogContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdlog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__11);
			setState(197);
			match(AP);
			_exprMat = "";
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(199);
				match(ID);
				 
				 			  		verificaID(_input.LT(-1).getText());
				 			  	    _exprMat = _input.LT(-1).getText();
				 			  
				}
				break;
			case NUMBER:
				{
				setState(201);
				match(NUMBER);
				 _exprMat = _input.LT(-1).getText();
				 			  	
				 			  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(205);
			match(FP);

			 			  	CommandLog cmd = new CommandLog(_exprMat);
			 			  	_exprContent += cmd.toString();
			 			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdtestaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdcasoContext> cmdcaso() {
			return getRuleContexts(CmdcasoContext.class);
		}
		public CmdcasoContext cmdcaso(int i) {
			return getRuleContext(CmdcasoContext.class,i);
		}
		public CmdtestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdtesta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdtesta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdtesta(this);
		}
	}

	public final CmdtestaContext cmdtesta() throws RecognitionException {
		CmdtestaContext _localctx = new CmdtestaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdtesta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__12);
			setState(209);
			match(AP);
			 listaSwitch = new ArrayList<AbstractCommand>();
			 			  		
							      
			setState(211);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			 			  	        _exprTesta = _input.LT(-1).getText();
			 			          
			setState(213);
			match(FP);
			 CommandSwitch1 cmd = new CommandSwitch1(_exprTesta);
			 			  		    stack.peek().add(cmd);
			setState(215);
			match(ACH);
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(216);
				cmdcaso();
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
			setState(221);
			match(FCH);
			 CommandSwitch2 cmd2 = new CommandSwitch2();
			 			  		    stack.peek().add(cmd2);
			 			  		  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdcasoContext extends ParserRuleContext {
		public TerminalNode DPT() { return getToken(IsiLangParser.DPT, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdcasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdcaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdcaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdcaso(this);
		}
	}

	public final CmdcasoContext cmdcaso() throws RecognitionException {
		CmdcasoContext _localctx = new CmdcasoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdcaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__13);
			 listaCase = new ArrayList<AbstractCommand>();
			 			  	      
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==TEXTO || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprCaso = _input.LT(-1).getText();
			setState(228);
			match(DPT);
			setState(229);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                        stack.push(curThread);
			                      
			setState(232); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(231);
				cmd();
				}
				}
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << ID))) != 0) );
			setState(236);
			match(FCH);
			 listaCase = stack.pop();
			 			  			CommandCase cmd = new CommandCase (_exprCaso, listaCase);
			 			  		    stack.peek().add(cmd);
			 			  		  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdenqContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdenq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdenq(this);
		}
	}

	public final CmdenqContext cmdenq() throws RecognitionException {
		CmdenqContext _localctx = new CmdenqContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cmdenq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__14);
			setState(240);
			match(AP);
			 listaWhile = new ArrayList<AbstractCommand>();
			 			  		     _exprEnquanto = "";
								   
			setState(242);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			 			  		     _exprEnquanto += _input.LT(-1).getText();
			 			  
			setState(244);
			match(OPREL);
			 _exprEnquanto += _input.LT(-1).getText();
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(246);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				 			  	         _exprEnquanto += _input.LT(-1).getText();
				 			  
				}
				break;
			case NUMBER:
				{
				setState(248);
				match(NUMBER);
				 _exprEnquanto += _input.LT(-1).getText();
				}
				break;
			case TEXTO:
				{
				setState(250);
				match(TEXTO);
				 _exprEnquanto += _input.LT(-1).getText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(254);
			match(FP);
			setState(255);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                         stack.push(curThread);
			                       
			setState(258); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(257);
				cmd();
				}
				}
				setState(260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << ID))) != 0) );
			setState(262);
			match(FCH);
			 
			                   		 listaWhile = stack.pop();
			                   		 CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaWhile);
			                   		 stack.peek().add(cmd);
			                 	   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPSOM() { return getToken(IsiLangParser.OPSOM, 0); }
		public TerminalNode OPSUB() { return getToken(IsiLangParser.OPSUB, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(266);
			termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(268);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(269);
					_la = _input.LA(1);
					if ( !(_la==OPSOM || _la==OPSUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					 _exprContent += _input.LT(-1).getText();
					setState(271);
					termo(0);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode OPMUL() { return getToken(IsiLangParser.OPMUL, 0); }
		public TerminalNode OPDIV() { return getToken(IsiLangParser.OPDIV, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		return termo(0);
	}

	private TermoContext termo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoContext _localctx = new TermoContext(_ctx, _parentState);
		TermoContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_termo, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(278);
			fator();
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termo);
					setState(280);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(281);
					_la = _input.LA(1);
					if ( !(_la==OPMUL || _la==OPDIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					 _exprContent += _input.LT(-1).getText();
					setState(283);
					fator();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public CmdmatContext cmdmat() {
			return getRuleContext(CmdmatContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fator);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				cmdmat();
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				match(AP);
				setState(295);
				expr(0);
				setState(296);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 18:
			return termo_sempred((TermoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u012f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\62\n\3"+
		"\r\3\16\3\63\3\4\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\5G\n\5\3\6\3\6\6\6K\n\6\r\6\16\6L\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7U\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\ti\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nv\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008b\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\6\13\u0092\n\13\r\13\16\13\u0093\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u009c"+
		"\n\13\r\13\16\13\u009d\3\13\3\13\3\13\5\13\u00a3\n\13\3\13\3\13\3\f\3"+
		"\f\3\f\5\f\u00aa\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b3\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c2\n\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00dc\n\20"+
		"\r\20\16\20\u00dd\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\6\21\u00eb\n\21\r\21\16\21\u00ec\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ff\n\22\3\22\3\22"+
		"\3\22\3\22\6\22\u0105\n\22\r\22\16\22\u0106\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\7\23\u0113\n\23\f\23\16\23\u0116\13\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u011f\n\24\f\24\16\24\u0122\13\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012d\n\25\3\25\2\4$"+
		"&\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\4\2\22\22!!\3\2"+
		"\26\27\3\2\30\31\2\u013b\2*\3\2\2\2\4\61\3\2\2\2\6\65\3\2\2\2\bF\3\2\2"+
		"\2\nH\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20^\3\2\2\2\22n\3\2\2\2\24z\3\2\2"+
		"\2\26\u00a9\3\2\2\2\30\u00ab\3\2\2\2\32\u00ba\3\2\2\2\34\u00c6\3\2\2\2"+
		"\36\u00d2\3\2\2\2 \u00e2\3\2\2\2\"\u00f1\3\2\2\2$\u010b\3\2\2\2&\u0117"+
		"\3\2\2\2(\u012c\3\2\2\2*+\7\3\2\2+,\5\4\3\2,-\5\n\6\2-.\7\4\2\2./\b\2"+
		"\1\2/\3\3\2\2\2\60\62\5\6\4\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\5\3\2\2\2\65\66\5\b\5\2\66\67\7 \2\2\67=\b\4\1\28"+
		"9\7\33\2\29:\7 \2\2:<\b\4\1\2;8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">@\3\2\2\2?=\3\2\2\2@A\7\25\2\2A\7\3\2\2\2BC\7\5\2\2CG\b\5\1\2DE\7\6\2"+
		"\2EG\b\5\1\2FB\3\2\2\2FD\3\2\2\2G\t\3\2\2\2HJ\b\6\1\2IK\5\f\7\2JI\3\2"+
		"\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NU\5\16\b\2OU\5\20\t\2P"+
		"U\5\22\n\2QU\5\24\13\2RU\5\36\20\2SU\5\"\22\2TN\3\2\2\2TO\3\2\2\2TP\3"+
		"\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\r\3\2\2\2VW\7\7\2\2WX\7\23\2\2X"+
		"Y\7 \2\2YZ\b\b\1\2Z[\7\24\2\2[\\\7\25\2\2\\]\b\b\1\2]\17\3\2\2\2^_\7\b"+
		"\2\2_`\7\23\2\2`h\b\t\1\2ab\7 \2\2bi\b\t\1\2cd\7\22\2\2di\b\t\1\2ef\5"+
		"\26\f\2fg\b\t\1\2gi\3\2\2\2ha\3\2\2\2hc\3\2\2\2he\3\2\2\2ij\3\2\2\2jk"+
		"\7\24\2\2kl\7\25\2\2lm\b\t\1\2m\21\3\2\2\2no\7 \2\2op\b\n\1\2pq\7\32\2"+
		"\2qu\b\n\1\2rv\5$\23\2st\7\22\2\2tv\b\n\1\2ur\3\2\2\2us\3\2\2\2vw\3\2"+
		"\2\2wx\7\25\2\2xy\b\n\1\2y\23\3\2\2\2z{\7\t\2\2{|\7\23\2\2|}\b\13\1\2"+
		"}~\7 \2\2~\177\b\13\1\2\177\u0080\7\37\2\2\u0080\u008a\b\13\1\2\u0081"+
		"\u0082\7 \2\2\u0082\u008b\b\13\1\2\u0083\u0084\7!\2\2\u0084\u008b\b\13"+
		"\1\2\u0085\u0086\7\22\2\2\u0086\u008b\b\13\1\2\u0087\u0088\5\26\f\2\u0088"+
		"\u0089\b\13\1\2\u0089\u008b\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0083\3"+
		"\2\2\2\u008a\u0085\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\7\24\2\2\u008d\u008e\7\n\2\2\u008e\u008f\7\34\2\2\u008f\u0091\b"+
		"\13\1\2\u0090\u0092\5\f\7\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\35"+
		"\2\2\u0096\u00a2\b\13\1\2\u0097\u0098\7\13\2\2\u0098\u0099\7\34\2\2\u0099"+
		"\u009b\b\13\1\2\u009a\u009c\5\f\7\2\u009b\u009a\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\7\35\2\2\u00a0\u00a1\b\13\1\2\u00a1\u00a3\3\2\2\2\u00a2\u0097\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\13\1\2\u00a5"+
		"\25\3\2\2\2\u00a6\u00aa\5\30\r\2\u00a7\u00aa\5\32\16\2\u00a8\u00aa\5\34"+
		"\17\2\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\27\3\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\7\23\2\2\u00ad\u00b2\b\r\1"+
		"\2\u00ae\u00af\7 \2\2\u00af\u00b3\b\r\1\2\u00b0\u00b1\7!\2\2\u00b1\u00b3"+
		"\b\r\1\2\u00b2\u00ae\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\7\33\2\2\u00b5\u00b6\7!\2\2\u00b6\u00b7\b\r\1\2\u00b7\u00b8\7\24"+
		"\2\2\u00b8\u00b9\b\r\1\2\u00b9\31\3\2\2\2\u00ba\u00bb\7\r\2\2\u00bb\u00bc"+
		"\7\23\2\2\u00bc\u00c1\b\16\1\2\u00bd\u00be\7 \2\2\u00be\u00c2\b\16\1\2"+
		"\u00bf\u00c0\7!\2\2\u00c0\u00c2\b\16\1\2\u00c1\u00bd\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\24\2\2\u00c4\u00c5\b\16\1\2"+
		"\u00c5\33\3\2\2\2\u00c6\u00c7\7\16\2\2\u00c7\u00c8\7\23\2\2\u00c8\u00cd"+
		"\b\17\1\2\u00c9\u00ca\7 \2\2\u00ca\u00ce\b\17\1\2\u00cb\u00cc\7!\2\2\u00cc"+
		"\u00ce\b\17\1\2\u00cd\u00c9\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00d0\7\24\2\2\u00d0\u00d1\b\17\1\2\u00d1\35\3\2\2\2\u00d2"+
		"\u00d3\7\17\2\2\u00d3\u00d4\7\23\2\2\u00d4\u00d5\b\20\1\2\u00d5\u00d6"+
		"\7 \2\2\u00d6\u00d7\b\20\1\2\u00d7\u00d8\7\24\2\2\u00d8\u00d9\b\20\1\2"+
		"\u00d9\u00db\7\34\2\2\u00da\u00dc\5 \21\2\u00db\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\7\35\2\2\u00e0\u00e1\b\20\1\2\u00e1\37\3\2\2\2\u00e2\u00e3\7\20"+
		"\2\2\u00e3\u00e4\b\21\1\2\u00e4\u00e5\t\2\2\2\u00e5\u00e6\b\21\1\2\u00e6"+
		"\u00e7\7\36\2\2\u00e7\u00e8\7\34\2\2\u00e8\u00ea\b\21\1\2\u00e9\u00eb"+
		"\5\f\7\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\35\2\2\u00ef\u00f0\b"+
		"\21\1\2\u00f0!\3\2\2\2\u00f1\u00f2\7\21\2\2\u00f2\u00f3\7\23\2\2\u00f3"+
		"\u00f4\b\22\1\2\u00f4\u00f5\7 \2\2\u00f5\u00f6\b\22\1\2\u00f6\u00f7\7"+
		"\37\2\2\u00f7\u00fe\b\22\1\2\u00f8\u00f9\7 \2\2\u00f9\u00ff\b\22\1\2\u00fa"+
		"\u00fb\7!\2\2\u00fb\u00ff\b\22\1\2\u00fc\u00fd\7\22\2\2\u00fd\u00ff\b"+
		"\22\1\2\u00fe\u00f8\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\7\24\2\2\u0101\u0102\7\34\2\2\u0102\u0104\b"+
		"\22\1\2\u0103\u0105\5\f\7\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\35"+
		"\2\2\u0109\u010a\b\22\1\2\u010a#\3\2\2\2\u010b\u010c\b\23\1\2\u010c\u010d"+
		"\5&\24\2\u010d\u0114\3\2\2\2\u010e\u010f\f\4\2\2\u010f\u0110\t\3\2\2\u0110"+
		"\u0111\b\23\1\2\u0111\u0113\5&\24\2\u0112\u010e\3\2\2\2\u0113\u0116\3"+
		"\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115%\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0118\b\24\1\2\u0118\u0119\5(\25\2\u0119\u0120\3\2\2\2"+
		"\u011a\u011b\f\4\2\2\u011b\u011c\t\4\2\2\u011c\u011d\b\24\1\2\u011d\u011f"+
		"\5(\25\2\u011e\u011a\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\'\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7 \2\2"+
		"\u0124\u012d\b\25\1\2\u0125\u0126\7!\2\2\u0126\u012d\b\25\1\2\u0127\u012d"+
		"\5\26\f\2\u0128\u0129\7\23\2\2\u0129\u012a\5$\23\2\u012a\u012b\7\24\2"+
		"\2\u012b\u012d\3\2\2\2\u012c\u0123\3\2\2\2\u012c\u0125\3\2\2\2\u012c\u0127"+
		"\3\2\2\2\u012c\u0128\3\2\2\2\u012d)\3\2\2\2\30\63=FLThu\u008a\u0093\u009d"+
		"\u00a2\u00a9\u00b2\u00c1\u00cd\u00dd\u00ec\u00fe\u0106\u0114\u0120\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}