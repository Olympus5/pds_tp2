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
		DONE=20, PROTO=21, VOID=22, FUNC=23, RETURN=24, PRINT=25, READ=26, IDENT=27, 
		TEXT=28, INTEGER=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "LP", "RP", "PLUS", "MINUS", 
		"TIMES", "DIV", "INT", "COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", 
		"FI", "WHILE", "DO", "DONE", "PROTO", "VOID", "FUNC", "RETURN", "PRINT", 
		"READ", "IDENT", "TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", "'DO'", 
		"'DONE'", "'PROTO'", "'VOID'", "'FUNC'", "'RETURN'", "'PRINT'", "'READ'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", 
		"DONE", "PROTO", "VOID", "FUNC", "RETURN", "PRINT", "READ", "IDENT", "TEXT", 
		"INTEGER"
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
		case 30:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00c8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u00b5\n\37"+
		"\f\37\16\37\u00b8\13\37\3 \3 \7 \u00bc\n \f \16 \u00bf\13 \3 \3 \3 \3"+
		"!\6!\u00c5\n!\r!\16!\u00c6\2\2\"\3\3\5\4\7\2\t\2\13\2\r\5\17\6\21\7\23"+
		"\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61"+
		"\27\63\30\65\31\67\329\33;\34=\35?\36A\37\3\2\5\4\2\13\f\"\"\3\2\f\f\4"+
		"\2\f\f$$\2\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5G\3\2\2\2\7R\3\2\2\2\tT\3\2\2\2\13V\3\2"+
		"\2\2\rX\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2\2\27b\3"+
		"\2\2\2\31d\3\2\2\2\33h\3\2\2\2\35j\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#q\3\2"+
		"\2\2%t\3\2\2\2\'y\3\2\2\2)~\3\2\2\2+\u0081\3\2\2\2-\u0087\3\2\2\2/\u008a"+
		"\3\2\2\2\61\u008f\3\2\2\2\63\u0095\3\2\2\2\65\u009a\3\2\2\2\67\u009f\3"+
		"\2\2\29\u00a6\3\2\2\2;\u00ac\3\2\2\2=\u00b1\3\2\2\2?\u00b9\3\2\2\2A\u00c4"+
		"\3\2\2\2CD\t\2\2\2DE\3\2\2\2EF\b\2\2\2F\4\3\2\2\2GH\7\61\2\2HI\7\61\2"+
		"\2IM\3\2\2\2JL\n\3\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2"+
		"\2OM\3\2\2\2PQ\b\3\2\2Q\6\3\2\2\2RS\4c|\2S\b\3\2\2\2TU\4\62;\2U\n\3\2"+
		"\2\2VW\n\4\2\2W\f\3\2\2\2XY\7*\2\2Y\16\3\2\2\2Z[\7+\2\2[\20\3\2\2\2\\"+
		"]\7-\2\2]\22\3\2\2\2^_\7/\2\2_\24\3\2\2\2`a\7,\2\2a\26\3\2\2\2bc\7\61"+
		"\2\2c\30\3\2\2\2de\7K\2\2ef\7P\2\2fg\7V\2\2g\32\3\2\2\2hi\7.\2\2i\34\3"+
		"\2\2\2jk\7<\2\2kl\7?\2\2l\36\3\2\2\2mn\7}\2\2n \3\2\2\2op\7\177\2\2p\""+
		"\3\2\2\2qr\7K\2\2rs\7H\2\2s$\3\2\2\2tu\7V\2\2uv\7J\2\2vw\7G\2\2wx\7P\2"+
		"\2x&\3\2\2\2yz\7G\2\2z{\7N\2\2{|\7U\2\2|}\7G\2\2}(\3\2\2\2~\177\7H\2\2"+
		"\177\u0080\7K\2\2\u0080*\3\2\2\2\u0081\u0082\7Y\2\2\u0082\u0083\7J\2\2"+
		"\u0083\u0084\7K\2\2\u0084\u0085\7N\2\2\u0085\u0086\7G\2\2\u0086,\3\2\2"+
		"\2\u0087\u0088\7F\2\2\u0088\u0089\7Q\2\2\u0089.\3\2\2\2\u008a\u008b\7"+
		"F\2\2\u008b\u008c\7Q\2\2\u008c\u008d\7P\2\2\u008d\u008e\7G\2\2\u008e\60"+
		"\3\2\2\2\u008f\u0090\7R\2\2\u0090\u0091\7T\2\2\u0091\u0092\7Q\2\2\u0092"+
		"\u0093\7V\2\2\u0093\u0094\7Q\2\2\u0094\62\3\2\2\2\u0095\u0096\7X\2\2\u0096"+
		"\u0097\7Q\2\2\u0097\u0098\7K\2\2\u0098\u0099\7F\2\2\u0099\64\3\2\2\2\u009a"+
		"\u009b\7H\2\2\u009b\u009c\7W\2\2\u009c\u009d\7P\2\2\u009d\u009e\7E\2\2"+
		"\u009e\66\3\2\2\2\u009f\u00a0\7T\2\2\u00a0\u00a1\7G\2\2\u00a1\u00a2\7"+
		"V\2\2\u00a2\u00a3\7W\2\2\u00a3\u00a4\7T\2\2\u00a4\u00a5\7P\2\2\u00a58"+
		"\3\2\2\2\u00a6\u00a7\7R\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7K\2\2\u00a9"+
		"\u00aa\7P\2\2\u00aa\u00ab\7V\2\2\u00ab:\3\2\2\2\u00ac\u00ad\7T\2\2\u00ad"+
		"\u00ae\7G\2\2\u00ae\u00af\7C\2\2\u00af\u00b0\7F\2\2\u00b0<\3\2\2\2\u00b1"+
		"\u00b6\5\7\4\2\u00b2\u00b5\5\7\4\2\u00b3\u00b5\5\t\5\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7>\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bd\7$\2\2\u00ba"+
		"\u00bc\5\13\6\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3"+
		"\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c1\7$\2\2\u00c1\u00c2\b \3\2\u00c2@\3\2\2\2\u00c3\u00c5\5\t\5\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7B\3\2\2\2\b\2M\u00b4\u00b6\u00bd\u00c6\4\b\2\2\3 \2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}