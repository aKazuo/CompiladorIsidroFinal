// Generated from IsiLang.g4 by ANTLR 4.4

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, TEXTO=16, AP=17, 
		FP=18, SC=19, OPSOM=20, OPSUB=21, OPMUL=22, OPDIV=23, ATTR=24, VIR=25, 
		ACH=26, FCH=27, DPT=28, OPREL=29, ID=30, NUMBER=31, WS=32;
	public static final String[] tokenNames = {
		"<INVALID>", "'se'", "'senao'", "'testa'", "'numero'", "'log'", "'programa'", 
		"'escreva'", "'caso'", "'enquanto'", "'fimprog.'", "'entao'", "'exp'", 
		"'raiz'", "'leia'", "'texto'", "TEXTO", "'('", "')'", "'.'", "'+'", "'-'", 
		"'*'", "'/'", "':='", "','", "'{'", "'}'", "':'", "OPREL", "ID", "NUMBER", 
		"WS"
	};
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdexp = 10, RULE_cmdraiz = 11, RULE_cmdlog = 12, 
		RULE_cmdtesta = 13, RULE_cmdenq = 14, RULE_expr = 15, RULE_termo = 16, 
		RULE_fator = 17;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdexp", "cmdraiz", "cmdlog", "cmdtesta", 
		"cmdenq", "expr", "termo", "fator"
	};

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
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
			setState(36); match(T__9);
			setState(37); decl();
			setState(38); bloco();
			setState(39); match(T__5);
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
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
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
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42); declaravar();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 || _la==T__0 );
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
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
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
			setState(47); tipo();
			setState(48); match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(50); match(VIR);
				setState(51); match(ID);

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
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(SC);
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
			setState(64);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(T__11);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); match(T__0);
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
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
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
			          
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67); cmd();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << ID))) != 0) );
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
		public CmdraizContext cmdraiz() {
			return getRuleContext(CmdraizContext.class,0);
		}
		public CmdenqContext cmdenq() {
			return getRuleContext(CmdenqContext.class,0);
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
		public CmdexpContext cmdexp() {
			return getRuleContext(CmdexpContext.class,0);
		}
		public CmdlogContext cmdlog() {
			return getRuleContext(CmdlogContext.class,0);
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
			setState(81);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72); cmdleitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(74); cmdattrib();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(75); cmdselecao();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(76); cmdexp();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(77); cmdraiz();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 7);
				{
				setState(78); cmdlog();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 8);
				{
				setState(79); cmdtesta();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 9);
				{
				setState(80); cmdenq();
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
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
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
			setState(83); match(T__1);
			setState(84); match(AP);
			setState(85); match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(87); match(FP);
			setState(88); match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
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
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
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
			setState(91); match(T__8);
			setState(92); match(AP);
			setState(97);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(93); match(ID);
				 verificaID(_input.LT(-1).getText());
					                       _writeID = _input.LT(-1).getText();
				                         
				}
				break;
			case TEXTO:
				{
				setState(95); match(TEXTO);
				 _writeID = _input.LT(-1).getText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(99); match(FP);
			setState(100); match(SC);

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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
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
			setState(103); match(ID);
			 verificaID(_input.LT(-1).getText());
			                      _exprID = _input.LT(-1).getText();
			                    
			setState(105); match(ATTR);
			 _exprContent = ""; 
			setState(107); expr(0);
			setState(108); match(SC);

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
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
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
			setState(111); match(T__14);
			setState(112); match(AP);
			setState(113); match(ID);
			 verificaID(_input.LT(-1).getText()); 
			                    	    _exprDecision = _input.LT(-1).getText();
			                          
			setState(115); match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(121);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(117); match(ID);
				 verificaID(_input.LT(-1).getText());
				                    		_exprDecision += _input.LT(-1).getText();
				                          
				}
				break;
			case NUMBER:
				{
				setState(119); match(NUMBER);
				}
				break;
			case TEXTO:
				{
				setState(120); match(TEXTO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123); match(FP);
			setState(124); match(T__4);
			setState(125); match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127); cmd();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << ID))) != 0) );
			setState(132); match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(145);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(134); match(T__13);
				setState(135); match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137); cmd();
					}
					}
					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << ID))) != 0) );
				}
				setState(142); match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
				}
			}

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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
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
		enterRule(_localctx, 20, RULE_cmdexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(T__3);
			setState(148); match(AP);
			setState(149); expr(0);
			System.out.println("Exponencial");
			setState(151); match(FP);
			setState(152); match(SC);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
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
		enterRule(_localctx, 22, RULE_cmdraiz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(T__2);
			setState(155); match(AP);
			setState(156); expr(0);
			System.out.println("Raiz");
			setState(158); match(FP);
			setState(159); match(SC);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
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
		enterRule(_localctx, 24, RULE_cmdlog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(T__10);
			setState(162); match(AP);
			setState(163); expr(0);
			System.out.println("Logaritmo");
			setState(165); match(FP);
			setState(166); match(SC);
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
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public TerminalNode TEXTO(int i) {
			return getToken(IsiLangParser.TEXTO, i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode DPT(int i) {
			return getToken(IsiLangParser.DPT, i);
		}
		public List<TerminalNode> DPT() { return getTokens(IsiLangParser.DPT); }
		public List<TerminalNode> TEXTO() { return getTokens(IsiLangParser.TEXTO); }
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
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
		enterRule(_localctx, 26, RULE_cmdtesta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(T__12);
			setState(169); match(AP);
			setState(170); match(ID);
			  verificaID(_input.LT(-1).getText());
			 			  	
			 			  
			setState(172); match(FP);
			setState(173); match(ACH);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174); match(T__7);
				setState(175);
				_la = _input.LA(1);
				if ( !(_la==TEXTO || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(176); match(DPT);
				setState(177); match(ACH);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178); cmd();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << ID))) != 0) );
				setState(183); match(FCH);
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 );
			setState(189); match(FCH);
			System.out.println("Testa Caso");
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
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
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
		enterRule(_localctx, 28, RULE_cmdenq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(T__6);
			setState(193); match(AP);
			setState(194); match(ID);
			 verificaID(_input.LT(-1).getText()); 
			setState(196); match(OPREL);
			setState(201);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(197); match(ID);
				 verificaID(_input.LT(-1).getText());
				 			  	
				 			  
				}
				break;
			case NUMBER:
				{
				setState(199); match(NUMBER);
				}
				break;
			case TEXTO:
				{
				setState(200); match(TEXTO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(203); match(FP);
			setState(204); match(ACH);
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(205); cmd();
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__12) | (1L << T__10) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << ID))) != 0) );
			setState(210); match(FCH);
			System.out.println("Enquanto");
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPSOM() { return getToken(IsiLangParser.OPSOM, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(214); termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(216);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(217);
					_la = _input.LA(1);
					if ( !(_la==OPSOM || _la==OPSUB) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					 _exprContent += _input.LT(-1).getText();
					setState(219); termo(0);
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TerminalNode OPDIV() { return getToken(IsiLangParser.OPDIV, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode OPMUL() { return getToken(IsiLangParser.OPMUL, 0); }
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_termo, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(226); fator();
			}
			_ctx.stop = _input.LT(-1);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termo);
					setState(228);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(229);
					_la = _input.LA(1);
					if ( !(_la==OPMUL || _la==OPDIV) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					 _exprContent += _input.LT(-1).getText();
					setState(231); fator();
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
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
		enterRule(_localctx, 34, RULE_fator);
		try {
			setState(247);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(239); match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(241); match(AP);
				setState(242); expr(0);
				setState(243); match(FP);
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(245); match(TEXTO);

				            	_exprContent += _input.LT(-1).getText();
				            
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
		case 15: return expr_sempred((ExprContext)_localctx, predIndex);
		case 16: return termo_sempred((TermoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00fc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3.\n\3\r\3\16\3/\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5C\n\5"+
		"\3\6\3\6\6\6G\n\6\r\6\16\6H\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7T\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13|\n\13\3\13\3\13\3\13\3\13\3\13\6\13\u0083"+
		"\n\13\r\13\16\13\u0084\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u008d\n\13\r"+
		"\13\16\13\u008e\3\13\3\13\3\13\5\13\u0094\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00b6\n\17"+
		"\r\17\16\17\u00b7\3\17\3\17\6\17\u00bc\n\17\r\17\16\17\u00bd\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cc\n\20\3\20"+
		"\3\20\3\20\6\20\u00d1\n\20\r\20\16\20\u00d2\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\7\21\u00df\n\21\f\21\16\21\u00e2\13\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u00eb\n\22\f\22\16\22\u00ee\13\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fa\n\23\3\23"+
		"\2\4 \"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\4\2\22\22!!"+
		"\3\2\26\27\3\2\30\31\u0105\2&\3\2\2\2\4-\3\2\2\2\6\61\3\2\2\2\bB\3\2\2"+
		"\2\nD\3\2\2\2\fS\3\2\2\2\16U\3\2\2\2\20]\3\2\2\2\22i\3\2\2\2\24q\3\2\2"+
		"\2\26\u0095\3\2\2\2\30\u009c\3\2\2\2\32\u00a3\3\2\2\2\34\u00aa\3\2\2\2"+
		"\36\u00c2\3\2\2\2 \u00d7\3\2\2\2\"\u00e3\3\2\2\2$\u00f9\3\2\2\2&\'\7\b"+
		"\2\2\'(\5\4\3\2()\5\n\6\2)*\7\f\2\2*+\b\2\1\2+\3\3\2\2\2,.\5\6\4\2-,\3"+
		"\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61\62\5\b\5\2\62\63"+
		"\7 \2\2\639\b\4\1\2\64\65\7\33\2\2\65\66\7 \2\2\668\b\4\1\2\67\64\3\2"+
		"\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\25\2\2=\7"+
		"\3\2\2\2>?\7\6\2\2?C\b\5\1\2@A\7\21\2\2AC\b\5\1\2B>\3\2\2\2B@\3\2\2\2"+
		"C\t\3\2\2\2DF\b\6\1\2EG\5\f\7\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2I\13\3\2\2\2JT\5\16\b\2KT\5\20\t\2LT\5\22\n\2MT\5\24\13\2NT\5\26\f\2"+
		"OT\5\30\r\2PT\5\32\16\2QT\5\34\17\2RT\5\36\20\2SJ\3\2\2\2SK\3\2\2\2SL"+
		"\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T"+
		"\r\3\2\2\2UV\7\20\2\2VW\7\23\2\2WX\7 \2\2XY\b\b\1\2YZ\7\24\2\2Z[\7\25"+
		"\2\2[\\\b\b\1\2\\\17\3\2\2\2]^\7\t\2\2^c\7\23\2\2_`\7 \2\2`d\b\t\1\2a"+
		"b\7\22\2\2bd\b\t\1\2c_\3\2\2\2ca\3\2\2\2de\3\2\2\2ef\7\24\2\2fg\7\25\2"+
		"\2gh\b\t\1\2h\21\3\2\2\2ij\7 \2\2jk\b\n\1\2kl\7\32\2\2lm\b\n\1\2mn\5 "+
		"\21\2no\7\25\2\2op\b\n\1\2p\23\3\2\2\2qr\7\3\2\2rs\7\23\2\2st\7 \2\2t"+
		"u\b\13\1\2uv\7\37\2\2v{\b\13\1\2wx\7 \2\2x|\b\13\1\2y|\7!\2\2z|\7\22\2"+
		"\2{w\3\2\2\2{y\3\2\2\2{z\3\2\2\2|}\3\2\2\2}~\7\24\2\2~\177\7\r\2\2\177"+
		"\u0080\7\34\2\2\u0080\u0082\b\13\1\2\u0081\u0083\5\f\7\2\u0082\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\7\35\2\2\u0087\u0093\b\13\1\2\u0088\u0089\7"+
		"\4\2\2\u0089\u008a\7\34\2\2\u008a\u008c\b\13\1\2\u008b\u008d\5\f\7\2\u008c"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\35\2\2\u0091\u0092\b\13\1\2\u0092"+
		"\u0094\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u0094\3\2\2\2\u0094\25\3\2\2"+
		"\2\u0095\u0096\7\16\2\2\u0096\u0097\7\23\2\2\u0097\u0098\5 \21\2\u0098"+
		"\u0099\b\f\1\2\u0099\u009a\7\24\2\2\u009a\u009b\7\25\2\2\u009b\27\3\2"+
		"\2\2\u009c\u009d\7\17\2\2\u009d\u009e\7\23\2\2\u009e\u009f\5 \21\2\u009f"+
		"\u00a0\b\r\1\2\u00a0\u00a1\7\24\2\2\u00a1\u00a2\7\25\2\2\u00a2\31\3\2"+
		"\2\2\u00a3\u00a4\7\7\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00a6\5 \21\2\u00a6"+
		"\u00a7\b\16\1\2\u00a7\u00a8\7\24\2\2\u00a8\u00a9\7\25\2\2\u00a9\33\3\2"+
		"\2\2\u00aa\u00ab\7\5\2\2\u00ab\u00ac\7\23\2\2\u00ac\u00ad\7 \2\2\u00ad"+
		"\u00ae\b\17\1\2\u00ae\u00af\7\24\2\2\u00af\u00bb\7\34\2\2\u00b0\u00b1"+
		"\7\n\2\2\u00b1\u00b2\t\2\2\2\u00b2\u00b3\7\36\2\2\u00b3\u00b5\7\34\2\2"+
		"\u00b4\u00b6\5\f\7\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\35\2\2"+
		"\u00ba\u00bc\3\2\2\2\u00bb\u00b0\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\35\2\2"+
		"\u00c0\u00c1\b\17\1\2\u00c1\35\3\2\2\2\u00c2\u00c3\7\13\2\2\u00c3\u00c4"+
		"\7\23\2\2\u00c4\u00c5\7 \2\2\u00c5\u00c6\b\20\1\2\u00c6\u00cb\7\37\2\2"+
		"\u00c7\u00c8\7 \2\2\u00c8\u00cc\b\20\1\2\u00c9\u00cc\7!\2\2\u00ca\u00cc"+
		"\7\22\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\24\2\2\u00ce\u00d0\7\34\2\2\u00cf\u00d1"+
		"\5\f\7\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\35\2\2\u00d5\u00d6\b"+
		"\20\1\2\u00d6\37\3\2\2\2\u00d7\u00d8\b\21\1\2\u00d8\u00d9\5\"\22\2\u00d9"+
		"\u00e0\3\2\2\2\u00da\u00db\f\4\2\2\u00db\u00dc\t\3\2\2\u00dc\u00dd\b\21"+
		"\1\2\u00dd\u00df\5\"\22\2\u00de\u00da\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1!\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e3\u00e4\b\22\1\2\u00e4\u00e5\5$\23\2\u00e5\u00ec\3\2\2\2\u00e6\u00e7"+
		"\f\4\2\2\u00e7\u00e8\t\4\2\2\u00e8\u00e9\b\22\1\2\u00e9\u00eb\5$\23\2"+
		"\u00ea\u00e6\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed#\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7 \2\2\u00f0\u00fa"+
		"\b\23\1\2\u00f1\u00f2\7!\2\2\u00f2\u00fa\b\23\1\2\u00f3\u00f4\7\23\2\2"+
		"\u00f4\u00f5\5 \21\2\u00f5\u00f6\7\24\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00f8"+
		"\7\22\2\2\u00f8\u00fa\b\23\1\2\u00f9\u00ef\3\2\2\2\u00f9\u00f1\3\2\2\2"+
		"\u00f9\u00f3\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa%\3\2\2\2\23/9BHSc{\u0084"+
		"\u008e\u0093\u00b7\u00bd\u00cb\u00d2\u00e0\u00ec\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}