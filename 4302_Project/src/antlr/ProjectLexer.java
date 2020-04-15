// Generated from Project.g4 by ANTLR 4.8

	package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProjectLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, TYPE=41, VAR=42, ID=43, BOOL=44, COMMENT=45, WS=46, 
		UNARY_OP=47, LINE_END=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "TYPE", 
			"VAR", "STRING", "NUM", "ID", "BOOL", "COMMENT", "WS", "UNARY_OP", "LINE_END"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'declare'", "'='", "'assume'", "'('", 
			"')'", "'*'", "'/'", "'+'", "'-'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'=>'", "'<=>'", "'func'", "'void'", "','", "'require'", 
			"'ensure'", "'assert'", "'if'", "'else if'", "'else'", "'loop'", "'from'", 
			"'until'", "'invariant'", "'do'", "'variant'", "'switch'", "'case:'", 
			"'default:'", null, null, null, null, null, null, "'!'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "TYPE", "VAR", "ID", "BOOL", "COMMENT", 
			"WS", "UNARY_OP", "LINE_END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ProjectLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Project.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u016d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\5*\u0126\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0132\n+\3,\7,\u0135\n"+
		",\f,\16,\u0138\13,\3-\3-\5-\u013c\n-\3-\5-\u013f\n-\3-\6-\u0142\n-\r-"+
		"\16-\u0143\5-\u0146\n-\3.\6.\u0149\n.\r.\16.\u014a\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\5/\u0156\n/\3\60\3\60\3\60\3\60\7\60\u015c\n\60\f\60\16\60\u015f"+
		"\13\60\3\60\3\60\3\61\6\61\u0164\n\61\r\61\16\61\u0165\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[-]._/a\60c\61e"+
		"\62\3\2\b\7\2\"\"\62;C\\aac|\3\2\63;\3\2\62;\6\2\62;C\\aac|\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\2\u0178\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\t"+
		"q\3\2\2\2\13y\3\2\2\2\r{\3\2\2\2\17\u0082\3\2\2\2\21\u0084\3\2\2\2\23"+
		"\u0086\3\2\2\2\25\u0088\3\2\2\2\27\u008a\3\2\2\2\31\u008c\3\2\2\2\33\u008e"+
		"\3\2\2\2\35\u0090\3\2\2\2\37\u0092\3\2\2\2!\u0095\3\2\2\2#\u0098\3\2\2"+
		"\2%\u009b\3\2\2\2\'\u009e\3\2\2\2)\u00a1\3\2\2\2+\u00a4\3\2\2\2-\u00a7"+
		"\3\2\2\2/\u00ab\3\2\2\2\61\u00b0\3\2\2\2\63\u00b5\3\2\2\2\65\u00b7\3\2"+
		"\2\2\67\u00bf\3\2\2\29\u00c6\3\2\2\2;\u00cd\3\2\2\2=\u00d0\3\2\2\2?\u00d8"+
		"\3\2\2\2A\u00dd\3\2\2\2C\u00e2\3\2\2\2E\u00e7\3\2\2\2G\u00ed\3\2\2\2I"+
		"\u00f7\3\2\2\2K\u00fa\3\2\2\2M\u0102\3\2\2\2O\u0109\3\2\2\2Q\u010f\3\2"+
		"\2\2S\u0125\3\2\2\2U\u0131\3\2\2\2W\u0136\3\2\2\2Y\u0145\3\2\2\2[\u0148"+
		"\3\2\2\2]\u0155\3\2\2\2_\u0157\3\2\2\2a\u0163\3\2\2\2c\u0169\3\2\2\2e"+
		"\u016b\3\2\2\2gh\7e\2\2hi\7n\2\2ij\7c\2\2jk\7u\2\2kl\7u\2\2l\4\3\2\2\2"+
		"mn\7}\2\2n\6\3\2\2\2op\7\177\2\2p\b\3\2\2\2qr\7f\2\2rs\7g\2\2st\7e\2\2"+
		"tu\7n\2\2uv\7c\2\2vw\7t\2\2wx\7g\2\2x\n\3\2\2\2yz\7?\2\2z\f\3\2\2\2{|"+
		"\7c\2\2|}\7u\2\2}~\7u\2\2~\177\7w\2\2\177\u0080\7o\2\2\u0080\u0081\7g"+
		"\2\2\u0081\16\3\2\2\2\u0082\u0083\7*\2\2\u0083\20\3\2\2\2\u0084\u0085"+
		"\7+\2\2\u0085\22\3\2\2\2\u0086\u0087\7,\2\2\u0087\24\3\2\2\2\u0088\u0089"+
		"\7\61\2\2\u0089\26\3\2\2\2\u008a\u008b\7-\2\2\u008b\30\3\2\2\2\u008c\u008d"+
		"\7/\2\2\u008d\32\3\2\2\2\u008e\u008f\7@\2\2\u008f\34\3\2\2\2\u0090\u0091"+
		"\7>\2\2\u0091\36\3\2\2\2\u0092\u0093\7@\2\2\u0093\u0094\7?\2\2\u0094 "+
		"\3\2\2\2\u0095\u0096\7>\2\2\u0096\u0097\7?\2\2\u0097\"\3\2\2\2\u0098\u0099"+
		"\7?\2\2\u0099\u009a\7?\2\2\u009a$\3\2\2\2\u009b\u009c\7#\2\2\u009c\u009d"+
		"\7?\2\2\u009d&\3\2\2\2\u009e\u009f\7(\2\2\u009f\u00a0\7(\2\2\u00a0(\3"+
		"\2\2\2\u00a1\u00a2\7~\2\2\u00a2\u00a3\7~\2\2\u00a3*\3\2\2\2\u00a4\u00a5"+
		"\7?\2\2\u00a5\u00a6\7@\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9"+
		"\7?\2\2\u00a9\u00aa\7@\2\2\u00aa.\3\2\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad"+
		"\7w\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7e\2\2\u00af\60\3\2\2\2\u00b0\u00b1"+
		"\7x\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7f\2\2\u00b4"+
		"\62\3\2\2\2\u00b5\u00b6\7.\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7t\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00ba\7s\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7k\2\2"+
		"\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be\66\3\2\2\2\u00bf\u00c0\7"+
		"g\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4"+
		"\7t\2\2\u00c4\u00c5\7g\2\2\u00c58\3\2\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8"+
		"\7u\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7t\2\2\u00cb"+
		"\u00cc\7v\2\2\u00cc:\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7h\2\2\u00cf"+
		"<\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7u\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4\u00d5\7\"\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7h\2"+
		"\2\u00d7>\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7"+
		"u\2\2\u00db\u00dc\7g\2\2\u00dc@\3\2\2\2\u00dd\u00de\7n\2\2\u00de\u00df"+
		"\7q\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7r\2\2\u00e1B\3\2\2\2\u00e2\u00e3"+
		"\7h\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7o\2\2\u00e6"+
		"D\3\2\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7v\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7n\2\2\u00ecF\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee"+
		"\u00ef\7p\2\2\u00ef\u00f0\7x\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7t\2\2"+
		"\u00f2\u00f3\7k\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6"+
		"\7v\2\2\u00f6H\3\2\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9\7q\2\2\u00f9J\3"+
		"\2\2\2\u00fa\u00fb\7x\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7k\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7v\2\2"+
		"\u0101L\3\2\2\2\u0102\u0103\7u\2\2\u0103\u0104\7y\2\2\u0104\u0105\7k\2"+
		"\2\u0105\u0106\7v\2\2\u0106\u0107\7e\2\2\u0107\u0108\7j\2\2\u0108N\3\2"+
		"\2\2\u0109\u010a\7e\2\2\u010a\u010b\7c\2\2\u010b\u010c\7u\2\2\u010c\u010d"+
		"\7g\2\2\u010d\u010e\7<\2\2\u010eP\3\2\2\2\u010f\u0110\7f\2\2\u0110\u0111"+
		"\7g\2\2\u0111\u0112\7h\2\2\u0112\u0113\7c\2\2\u0113\u0114\7w\2\2\u0114"+
		"\u0115\7n\2\2\u0115\u0116\7v\2\2\u0116\u0117\7<\2\2\u0117R\3\2\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7p\2\2\u011a\u0126\7v\2\2\u011b\u011c\7u\2\2"+
		"\u011c\u011d\7v\2\2\u011d\u011e\7t\2\2\u011e\u011f\7k\2\2\u011f\u0120"+
		"\7p\2\2\u0120\u0126\7i\2\2\u0121\u0122\7d\2\2\u0122\u0123\7q\2\2\u0123"+
		"\u0124\7q\2\2\u0124\u0126\7n\2\2\u0125\u0118\3\2\2\2\u0125\u011b\3\2\2"+
		"\2\u0125\u0121\3\2\2\2\u0126T\3\2\2\2\u0127\u0132\5Y-\2\u0128\u0132\5"+
		"]/\2\u0129\u012a\7$\2\2\u012a\u012b\5W,\2\u012b\u012c\7$\2\2\u012c\u0132"+
		"\3\2\2\2\u012d\u012e\7$\2\2\u012e\u012f\5[.\2\u012f\u0130\7$\2\2\u0130"+
		"\u0132\3\2\2\2\u0131\u0127\3\2\2\2\u0131\u0128\3\2\2\2\u0131\u0129\3\2"+
		"\2\2\u0131\u012d\3\2\2\2\u0132V\3\2\2\2\u0133\u0135\t\2\2\2\u0134\u0133"+
		"\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"X\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u0146\7\62\2\2\u013a\u013c\7/\2\2"+
		"\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013f"+
		"\t\3\2\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140"+
		"\u0142\t\4\2\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0139\3\2\2\2\u0145"+
		"\u013b\3\2\2\2\u0146Z\3\2\2\2\u0147\u0149\t\5\2\2\u0148\u0147\3\2\2\2"+
		"\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\\\3"+
		"\2\2\2\u014c\u014d\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f\7w\2\2\u014f"+
		"\u0156\7g\2\2\u0150\u0151\7h\2\2\u0151\u0152\7c\2\2\u0152\u0153\7n\2\2"+
		"\u0153\u0154\7u\2\2\u0154\u0156\7g\2\2\u0155\u014c\3\2\2\2\u0155\u0150"+
		"\3\2\2\2\u0156^\3\2\2\2\u0157\u0158\7\61\2\2\u0158\u0159\7\61\2\2\u0159"+
		"\u015d\3\2\2\2\u015a\u015c\n\6\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0161\b\60\2\2\u0161`\3\2\2\2\u0162\u0164\t\7\2\2"+
		"\u0163\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b\61\2\2\u0168b\3\2\2\2\u0169"+
		"\u016a\7#\2\2\u016ad\3\2\2\2\u016b\u016c\7=\2\2\u016cf\3\2\2\2\16\2\u0125"+
		"\u0131\u0136\u013b\u013e\u0143\u0145\u014a\u0155\u015d\u0165\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}