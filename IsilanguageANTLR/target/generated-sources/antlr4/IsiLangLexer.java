// Generated from IsiLang.g4 by ANTLR 4.4

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, TEXTO=16, AP=17, 
		FP=18, SC=19, OPSOM=20, OPSUB=21, OPMUL=22, OPDIV=23, ATTR=24, VIR=25, 
		ACH=26, FCH=27, DPT=28, OPREL=29, ID=30, NUMBER=31, WS=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TEXTO", "AP", "FP", "SC", 
		"OPSOM", "OPSUB", "OPMUL", "OPDIV", "ATTR", "VIR", "ACH", "FCH", "DPT", 
		"OPREL", "ID", "NUMBER", "WS"
	};


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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u00a2"+
		"\n\21\f\21\16\21\u00a5\13\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u00cb\n\36\3\37\5\37\u00ce\n\37\3\37\7\37\u00d1\n\37\f\37\16\37\u00d4"+
		"\13\37\3 \6 \u00d7\n \r \16 \u00d8\3 \3 \6 \u00dd\n \r \16 \u00de\5 \u00e1"+
		"\n \3!\3!\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"\3\2\b\3\2$$\4\2>>@@\4\2C\\c|\5\2\62;C\\c|"+
		"\3\2\62;\5\2\13\f\17\17\"\"\u00ee\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\3C\3\2\2\2\5F\3\2\2\2\7L\3\2\2\2\tR\3\2\2\2\13Y\3\2\2\2\r]\3\2\2\2"+
		"\17f\3\2\2\2\21n\3\2\2\2\23s\3\2\2\2\25|\3\2\2\2\27\u0085\3\2\2\2\31\u008b"+
		"\3\2\2\2\33\u008f\3\2\2\2\35\u0094\3\2\2\2\37\u0099\3\2\2\2!\u009f\3\2"+
		"\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00ac\3\2\2\2)\u00ae\3\2\2\2+\u00b0"+
		"\3\2\2\2-\u00b2\3\2\2\2/\u00b4\3\2\2\2\61\u00b6\3\2\2\2\63\u00b9\3\2\2"+
		"\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2\29\u00bf\3\2\2\2;\u00ca\3\2\2\2=\u00cd"+
		"\3\2\2\2?\u00d6\3\2\2\2A\u00e2\3\2\2\2CD\7u\2\2DE\7g\2\2E\4\3\2\2\2FG"+
		"\7u\2\2GH\7g\2\2HI\7p\2\2IJ\7c\2\2JK\7q\2\2K\6\3\2\2\2LM\7v\2\2MN\7g\2"+
		"\2NO\7u\2\2OP\7v\2\2PQ\7c\2\2Q\b\3\2\2\2RS\7p\2\2ST\7w\2\2TU\7o\2\2UV"+
		"\7g\2\2VW\7t\2\2WX\7q\2\2X\n\3\2\2\2YZ\7n\2\2Z[\7q\2\2[\\\7i\2\2\\\f\3"+
		"\2\2\2]^\7r\2\2^_\7t\2\2_`\7q\2\2`a\7i\2\2ab\7t\2\2bc\7c\2\2cd\7o\2\2"+
		"de\7c\2\2e\16\3\2\2\2fg\7g\2\2gh\7u\2\2hi\7e\2\2ij\7t\2\2jk\7g\2\2kl\7"+
		"x\2\2lm\7c\2\2m\20\3\2\2\2no\7e\2\2op\7c\2\2pq\7u\2\2qr\7q\2\2r\22\3\2"+
		"\2\2st\7g\2\2tu\7p\2\2uv\7s\2\2vw\7w\2\2wx\7c\2\2xy\7p\2\2yz\7v\2\2z{"+
		"\7q\2\2{\24\3\2\2\2|}\7h\2\2}~\7k\2\2~\177\7o\2\2\177\u0080\7r\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7q\2\2\u0082\u0083\7i\2\2\u0083\u0084\7\60\2"+
		"\2\u0084\26\3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088"+
		"\7v\2\2\u0088\u0089\7c\2\2\u0089\u008a\7q\2\2\u008a\30\3\2\2\2\u008b\u008c"+
		"\7g\2\2\u008c\u008d\7z\2\2\u008d\u008e\7r\2\2\u008e\32\3\2\2\2\u008f\u0090"+
		"\7t\2\2\u0090\u0091\7c\2\2\u0091\u0092\7k\2\2\u0092\u0093\7|\2\2\u0093"+
		"\34\3\2\2\2\u0094\u0095\7n\2\2\u0095\u0096\7g\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7c\2\2\u0098\36\3\2\2\2\u0099\u009a\7v\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7z\2\2\u009c\u009d\7v\2\2\u009d\u009e\7q\2\2\u009e \3\2\2\2\u009f"+
		"\u00a3\7$\2\2\u00a0\u00a2\n\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\7$\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7*\2\2\u00a9"+
		"$\3\2\2\2\u00aa\u00ab\7+\2\2\u00ab&\3\2\2\2\u00ac\u00ad\7\60\2\2\u00ad"+
		"(\3\2\2\2\u00ae\u00af\7-\2\2\u00af*\3\2\2\2\u00b0\u00b1\7/\2\2\u00b1,"+
		"\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3.\3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5"+
		"\60\3\2\2\2\u00b6\u00b7\7<\2\2\u00b7\u00b8\7?\2\2\u00b8\62\3\2\2\2\u00b9"+
		"\u00ba\7.\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7}\2\2\u00bc\66\3\2\2\2\u00bd"+
		"\u00be\7\177\2\2\u00be8\3\2\2\2\u00bf\u00c0\7<\2\2\u00c0:\3\2\2\2\u00c1"+
		"\u00cb\t\3\2\2\u00c2\u00c3\7@\2\2\u00c3\u00cb\7?\2\2\u00c4\u00c5\7>\2"+
		"\2\u00c5\u00cb\7?\2\2\u00c6\u00c7\7?\2\2\u00c7\u00cb\7?\2\2\u00c8\u00c9"+
		"\7#\2\2\u00c9\u00cb\7?\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca"+
		"\u00c4\3\2\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb<\3\2\2\2"+
		"\u00cc\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d2\3\2\2\2\u00cf\u00d1"+
		"\t\5\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3>\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\t\6\2\2"+
		"\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00e0\3\2\2\2\u00da\u00dc\7\60\2\2\u00db\u00dd\t\6\2\2"+
		"\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"@\3\2\2\2\u00e2\u00e3\t\7\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\b!\2\2\u00e5"+
		"B\3\2\2\2\13\2\u00a3\u00ca\u00cd\u00d0\u00d2\u00d8\u00de\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}