// Generated from VSLLexer.g by ANTLR 4.7

  package TP2;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LP=3, RP=4, PLUS=5, MINUS=6, TIMES=7, DIV=8, INT=9, COMMA=10, 
		AFF=11, LCB=12, RCB=13, IF=14, THEN=15, ELSE=16, FI=17, WHILE=18, DO=19, 
		DONE=20, PROTO=21, VOID=22, FUNC=23, RETURN=24, IDENT=25, TEXT=26, INTEGER=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "LP", "RP", "PLUS", "MINUS", 
		"TIMES", "DIV", "INT", "COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", 
		"FI", "WHILE", "DO", "DONE", "PROTO", "VOID", "FUNC", "RETURN", "IDENT", 
		"TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", "'DO'", 
		"'DONE'", "'PROTO'", "'VOID'", "'FUNC'", "'RETURN'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", 
		"DONE", "PROTO", "VOID", "FUNC", "RETURN", "IDENT", "TEXT", "INTEGER"
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


	public VSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VSLLexer.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 28:
			TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setText(getText().substring(1, getText().length() - 1)); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u00a6\n\35"+
		"\f\35\16\35\u00a9\13\35\3\36\3\36\7\36\u00ad\n\36\f\36\16\36\u00b0\13"+
		"\36\3\36\3\36\3\36\3\37\6\37\u00b6\n\37\r\37\16\37\u00b7\2\2 \3\3\5\4"+
		"\7\2\t\2\13\2\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#"+
		"\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35\3\2\5"+
		"\4\2\13\f\"\"\3\2\f\f\4\2\f\f$$\2\u00ba\2\3\3\2\2\2\2\5\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5C\3\2\2\2\7N\3\2\2\2\tP\3\2\2\2\13R\3"+
		"\2\2\2\rT\3\2\2\2\17V\3\2\2\2\21X\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27"+
		"^\3\2\2\2\31`\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#m"+
		"\3\2\2\2%p\3\2\2\2\'u\3\2\2\2)z\3\2\2\2+}\3\2\2\2-\u0083\3\2\2\2/\u0086"+
		"\3\2\2\2\61\u008b\3\2\2\2\63\u0091\3\2\2\2\65\u0096\3\2\2\2\67\u009b\3"+
		"\2\2\29\u00a2\3\2\2\2;\u00aa\3\2\2\2=\u00b5\3\2\2\2?@\t\2\2\2@A\3\2\2"+
		"\2AB\b\2\2\2B\4\3\2\2\2CD\7\61\2\2DE\7\61\2\2EI\3\2\2\2FH\n\3\2\2GF\3"+
		"\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\b\3\2\2M\6"+
		"\3\2\2\2NO\4c|\2O\b\3\2\2\2PQ\4\62;\2Q\n\3\2\2\2RS\n\4\2\2S\f\3\2\2\2"+
		"TU\7*\2\2U\16\3\2\2\2VW\7+\2\2W\20\3\2\2\2XY\7-\2\2Y\22\3\2\2\2Z[\7/\2"+
		"\2[\24\3\2\2\2\\]\7,\2\2]\26\3\2\2\2^_\7\61\2\2_\30\3\2\2\2`a\7K\2\2a"+
		"b\7P\2\2bc\7V\2\2c\32\3\2\2\2de\7.\2\2e\34\3\2\2\2fg\7<\2\2gh\7?\2\2h"+
		"\36\3\2\2\2ij\7}\2\2j \3\2\2\2kl\7\177\2\2l\"\3\2\2\2mn\7K\2\2no\7H\2"+
		"\2o$\3\2\2\2pq\7V\2\2qr\7J\2\2rs\7G\2\2st\7P\2\2t&\3\2\2\2uv\7G\2\2vw"+
		"\7N\2\2wx\7U\2\2xy\7G\2\2y(\3\2\2\2z{\7H\2\2{|\7K\2\2|*\3\2\2\2}~\7Y\2"+
		"\2~\177\7J\2\2\177\u0080\7K\2\2\u0080\u0081\7N\2\2\u0081\u0082\7G\2\2"+
		"\u0082,\3\2\2\2\u0083\u0084\7F\2\2\u0084\u0085\7Q\2\2\u0085.\3\2\2\2\u0086"+
		"\u0087\7F\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7P\2\2\u0089\u008a\7G\2\2"+
		"\u008a\60\3\2\2\2\u008b\u008c\7R\2\2\u008c\u008d\7T\2\2\u008d\u008e\7"+
		"Q\2\2\u008e\u008f\7V\2\2\u008f\u0090\7Q\2\2\u0090\62\3\2\2\2\u0091\u0092"+
		"\7X\2\2\u0092\u0093\7Q\2\2\u0093\u0094\7K\2\2\u0094\u0095\7F\2\2\u0095"+
		"\64\3\2\2\2\u0096\u0097\7H\2\2\u0097\u0098\7W\2\2\u0098\u0099\7P\2\2\u0099"+
		"\u009a\7E\2\2\u009a\66\3\2\2\2\u009b\u009c\7T\2\2\u009c\u009d\7G\2\2\u009d"+
		"\u009e\7V\2\2\u009e\u009f\7W\2\2\u009f\u00a0\7T\2\2\u00a0\u00a1\7P\2\2"+
		"\u00a18\3\2\2\2\u00a2\u00a7\5\7\4\2\u00a3\u00a6\5\7\4\2\u00a4\u00a6\5"+
		"\t\5\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8:\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00aa\u00ae\7$\2\2\u00ab\u00ad\5\13\6\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7$\2\2\u00b2\u00b3\b\36\3\2\u00b3<\3\2\2\2"+
		"\u00b4\u00b6\5\t\5\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8>\3\2\2\2\b\2I\u00a5\u00a7\u00ae\u00b7"+
		"\4\b\2\2\3\36\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}