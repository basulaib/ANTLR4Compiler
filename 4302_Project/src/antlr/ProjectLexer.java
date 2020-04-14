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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, TYPE=38, VAR=39, 
		ID=40, BOOL=41, COMMENT=42, WS=43, UNARY_OP=44, LINE_END=45;
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
			"T__33", "T__34", "T__35", "T__36", "TYPE", "VAR", "STRING", "NUM", "ID", 
			"BOOL", "COMMENT", "WS", "UNARY_OP", "LINE_END"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'declare'", "'='", "'assume'", "'('", 
			"')'", "'*'", "'/'", "'+'", "'-'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'=>'", "'<=>'", "'func'", "'void'", "','", "'require'", 
			"'ensure'", "'assert'", "'if'", "'else if'", "'else'", "'loop'", "'from'", 
			"'until'", "'invariant'", "'do'", "'variant'", null, null, null, null, 
			null, null, "'!'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TYPE", "VAR", "ID", "BOOL", "COMMENT", "WS", "UNARY_OP", 
			"LINE_END"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0151\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u010a\n\'\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\5(\u0116\n(\3)\7)\u0119\n)\f)\16)\u011c\13)\3*\3*"+
		"\5*\u0120\n*\3*\5*\u0123\n*\3*\6*\u0126\n*\r*\16*\u0127\5*\u012a\n*\3"+
		"+\6+\u012d\n+\r+\16+\u012e\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u013a\n,\3-\3"+
		"-\3-\3-\7-\u0140\n-\f-\16-\u0143\13-\3-\3-\3.\6.\u0148\n.\r.\16.\u0149"+
		"\3.\3.\3/\3/\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U*W+Y,[-]._/"+
		"\3\2\b\7\2\"\"\62;C\\aac|\3\2\63;\3\2\62;\6\2\62;C\\aac|\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u015c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\3a\3\2\2\2\5g\3\2\2\2\7i\3\2\2\2\tk\3\2\2\2\13s\3\2\2\2\ru\3\2\2\2\17"+
		"|\3\2\2\2\21~\3\2\2\2\23\u0080\3\2\2\2\25\u0082\3\2\2\2\27\u0084\3\2\2"+
		"\2\31\u0086\3\2\2\2\33\u0088\3\2\2\2\35\u008a\3\2\2\2\37\u008c\3\2\2\2"+
		"!\u008f\3\2\2\2#\u0092\3\2\2\2%\u0095\3\2\2\2\'\u0098\3\2\2\2)\u009b\3"+
		"\2\2\2+\u009e\3\2\2\2-\u00a1\3\2\2\2/\u00a5\3\2\2\2\61\u00aa\3\2\2\2\63"+
		"\u00af\3\2\2\2\65\u00b1\3\2\2\2\67\u00b9\3\2\2\29\u00c0\3\2\2\2;\u00c7"+
		"\3\2\2\2=\u00ca\3\2\2\2?\u00d2\3\2\2\2A\u00d7\3\2\2\2C\u00dc\3\2\2\2E"+
		"\u00e1\3\2\2\2G\u00e7\3\2\2\2I\u00f1\3\2\2\2K\u00f4\3\2\2\2M\u0109\3\2"+
		"\2\2O\u0115\3\2\2\2Q\u011a\3\2\2\2S\u0129\3\2\2\2U\u012c\3\2\2\2W\u0139"+
		"\3\2\2\2Y\u013b\3\2\2\2[\u0147\3\2\2\2]\u014d\3\2\2\2_\u014f\3\2\2\2a"+
		"b\7e\2\2bc\7n\2\2cd\7c\2\2de\7u\2\2ef\7u\2\2f\4\3\2\2\2gh\7}\2\2h\6\3"+
		"\2\2\2ij\7\177\2\2j\b\3\2\2\2kl\7f\2\2lm\7g\2\2mn\7e\2\2no\7n\2\2op\7"+
		"c\2\2pq\7t\2\2qr\7g\2\2r\n\3\2\2\2st\7?\2\2t\f\3\2\2\2uv\7c\2\2vw\7u\2"+
		"\2wx\7u\2\2xy\7w\2\2yz\7o\2\2z{\7g\2\2{\16\3\2\2\2|}\7*\2\2}\20\3\2\2"+
		"\2~\177\7+\2\2\177\22\3\2\2\2\u0080\u0081\7,\2\2\u0081\24\3\2\2\2\u0082"+
		"\u0083\7\61\2\2\u0083\26\3\2\2\2\u0084\u0085\7-\2\2\u0085\30\3\2\2\2\u0086"+
		"\u0087\7/\2\2\u0087\32\3\2\2\2\u0088\u0089\7@\2\2\u0089\34\3\2\2\2\u008a"+
		"\u008b\7>\2\2\u008b\36\3\2\2\2\u008c\u008d\7@\2\2\u008d\u008e\7?\2\2\u008e"+
		" \3\2\2\2\u008f\u0090\7>\2\2\u0090\u0091\7?\2\2\u0091\"\3\2\2\2\u0092"+
		"\u0093\7?\2\2\u0093\u0094\7?\2\2\u0094$\3\2\2\2\u0095\u0096\7#\2\2\u0096"+
		"\u0097\7?\2\2\u0097&\3\2\2\2\u0098\u0099\7(\2\2\u0099\u009a\7(\2\2\u009a"+
		"(\3\2\2\2\u009b\u009c\7~\2\2\u009c\u009d\7~\2\2\u009d*\3\2\2\2\u009e\u009f"+
		"\7?\2\2\u009f\u00a0\7@\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7>\2\2\u00a2\u00a3"+
		"\7?\2\2\u00a3\u00a4\7@\2\2\u00a4.\3\2\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7"+
		"\7w\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7e\2\2\u00a9\60\3\2\2\2\u00aa\u00ab"+
		"\7x\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7f\2\2\u00ae"+
		"\62\3\2\2\2\u00af\u00b0\7.\2\2\u00b0\64\3\2\2\2\u00b1\u00b2\7t\2\2\u00b2"+
		"\u00b3\7g\2\2\u00b3\u00b4\7s\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7k\2\2"+
		"\u00b6\u00b7\7t\2\2\u00b7\u00b8\7g\2\2\u00b8\66\3\2\2\2\u00b9\u00ba\7"+
		"g\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be"+
		"\7t\2\2\u00be\u00bf\7g\2\2\u00bf8\3\2\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2"+
		"\7u\2\2\u00c2\u00c3\7u\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7t\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7h\2\2\u00c9"+
		"<\3\2\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\u00cf\7\"\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7h\2"+
		"\2\u00d1>\3\2\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7"+
		"u\2\2\u00d5\u00d6\7g\2\2\u00d6@\3\2\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9"+
		"\7q\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7r\2\2\u00dbB\3\2\2\2\u00dc\u00dd"+
		"\7h\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7o\2\2\u00e0"+
		"D\3\2\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7v\2\2\u00e4"+
		"\u00e5\7k\2\2\u00e5\u00e6\7n\2\2\u00e6F\3\2\2\2\u00e7\u00e8\7k\2\2\u00e8"+
		"\u00e9\7p\2\2\u00e9\u00ea\7x\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7t\2\2"+
		"\u00ec\u00ed\7k\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0"+
		"\7v\2\2\u00f0H\3\2\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7q\2\2\u00f3J\3"+
		"\2\2\2\u00f4\u00f5\7x\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7t\2\2\u00f7"+
		"\u00f8\7k\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7v\2\2"+
		"\u00fbL\3\2\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u010a\7v\2"+
		"\2\u00ff\u0100\7u\2\2\u0100\u0101\7v\2\2\u0101\u0102\7t\2\2\u0102\u0103"+
		"\7k\2\2\u0103\u0104\7p\2\2\u0104\u010a\7i\2\2\u0105\u0106\7d\2\2\u0106"+
		"\u0107\7q\2\2\u0107\u0108\7q\2\2\u0108\u010a\7n\2\2\u0109\u00fc\3\2\2"+
		"\2\u0109\u00ff\3\2\2\2\u0109\u0105\3\2\2\2\u010aN\3\2\2\2\u010b\u0116"+
		"\5S*\2\u010c\u0116\5W,\2\u010d\u010e\7$\2\2\u010e\u010f\5Q)\2\u010f\u0110"+
		"\7$\2\2\u0110\u0116\3\2\2\2\u0111\u0112\7$\2\2\u0112\u0113\5U+\2\u0113"+
		"\u0114\7$\2\2\u0114\u0116\3\2\2\2\u0115\u010b\3\2\2\2\u0115\u010c\3\2"+
		"\2\2\u0115\u010d\3\2\2\2\u0115\u0111\3\2\2\2\u0116P\3\2\2\2\u0117\u0119"+
		"\t\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011bR\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u012a\7\62\2\2"+
		"\u011e\u0120\7/\2\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122"+
		"\3\2\2\2\u0121\u0123\t\3\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0126\t\4\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129"+
		"\u011d\3\2\2\2\u0129\u011f\3\2\2\2\u012aT\3\2\2\2\u012b\u012d\t\5\2\2"+
		"\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012fV\3\2\2\2\u0130\u0131\7v\2\2\u0131\u0132\7t\2\2\u0132\u0133"+
		"\7w\2\2\u0133\u013a\7g\2\2\u0134\u0135\7h\2\2\u0135\u0136\7c\2\2\u0136"+
		"\u0137\7n\2\2\u0137\u0138\7u\2\2\u0138\u013a\7g\2\2\u0139\u0130\3\2\2"+
		"\2\u0139\u0134\3\2\2\2\u013aX\3\2\2\2\u013b\u013c\7\61\2\2\u013c\u013d"+
		"\7\61\2\2\u013d\u0141\3\2\2\2\u013e\u0140\n\6\2\2\u013f\u013e\3\2\2\2"+
		"\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144"+
		"\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\b-\2\2\u0145Z\3\2\2\2\u0146\u0148"+
		"\t\7\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b.\2\2\u014c\\\3\2\2\2"+
		"\u014d\u014e\7#\2\2\u014e^\3\2\2\2\u014f\u0150\7=\2\2\u0150`\3\2\2\2\16"+
		"\2\u0109\u0115\u011a\u011f\u0122\u0127\u0129\u012e\u0139\u0141\u0149\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}