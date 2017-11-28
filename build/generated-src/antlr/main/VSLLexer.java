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
		DONE=20, PROTO=21, VOID=22, IDENT=23, TEXT=24, INTEGER=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "LP", "RP", "PLUS", "MINUS", 
		"TIMES", "DIV", "INT", "COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", 
		"FI", "WHILE", "DO", "DONE", "PROTO", "VOID", "IDENT", "TEXT", "INTEGER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", "'DO'", 
		"'DONE'", "'PROTO'", "'VOID'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", 
		"DONE", "PROTO", "VOID", "IDENT", "TEXT", "INTEGER"
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
		case 26:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\7\3D\n\3\f\3\16\3G\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u0096\n\33\f\33\16"+
		"\33\u0099\13\33\3\34\3\34\7\34\u009d\n\34\f\34\16\34\u00a0\13\34\3\34"+
		"\3\34\3\34\3\35\6\35\u00a6\n\35\r\35\16\35\u00a7\2\2\36\3\3\5\4\7\2\t"+
		"\2\13\2\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21"+
		"\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33\3\2\5\4\2\13\f\"\"\3"+
		"\2\f\f\4\2\f\f$$\2\u00aa\2\3\3\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5?\3\2"+
		"\2\2\7J\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21T\3\2"+
		"\2\2\23V\3\2\2\2\25X\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33`\3\2\2\2\35b"+
		"\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#i\3\2\2\2%l\3\2\2\2\'q\3\2\2\2)v\3\2\2"+
		"\2+y\3\2\2\2-\177\3\2\2\2/\u0082\3\2\2\2\61\u0087\3\2\2\2\63\u008d\3\2"+
		"\2\2\65\u0092\3\2\2\2\67\u009a\3\2\2\29\u00a5\3\2\2\2;<\t\2\2\2<=\3\2"+
		"\2\2=>\b\2\2\2>\4\3\2\2\2?@\7\61\2\2@A\7\61\2\2AE\3\2\2\2BD\n\3\2\2CB"+
		"\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\b\3\2\2I"+
		"\6\3\2\2\2JK\4c|\2K\b\3\2\2\2LM\4\62;\2M\n\3\2\2\2NO\n\4\2\2O\f\3\2\2"+
		"\2PQ\7*\2\2Q\16\3\2\2\2RS\7+\2\2S\20\3\2\2\2TU\7-\2\2U\22\3\2\2\2VW\7"+
		"/\2\2W\24\3\2\2\2XY\7,\2\2Y\26\3\2\2\2Z[\7\61\2\2[\30\3\2\2\2\\]\7K\2"+
		"\2]^\7P\2\2^_\7V\2\2_\32\3\2\2\2`a\7.\2\2a\34\3\2\2\2bc\7<\2\2cd\7?\2"+
		"\2d\36\3\2\2\2ef\7}\2\2f \3\2\2\2gh\7\177\2\2h\"\3\2\2\2ij\7K\2\2jk\7"+
		"H\2\2k$\3\2\2\2lm\7V\2\2mn\7J\2\2no\7G\2\2op\7P\2\2p&\3\2\2\2qr\7G\2\2"+
		"rs\7N\2\2st\7U\2\2tu\7G\2\2u(\3\2\2\2vw\7H\2\2wx\7K\2\2x*\3\2\2\2yz\7"+
		"Y\2\2z{\7J\2\2{|\7K\2\2|}\7N\2\2}~\7G\2\2~,\3\2\2\2\177\u0080\7F\2\2\u0080"+
		"\u0081\7Q\2\2\u0081.\3\2\2\2\u0082\u0083\7F\2\2\u0083\u0084\7Q\2\2\u0084"+
		"\u0085\7P\2\2\u0085\u0086\7G\2\2\u0086\60\3\2\2\2\u0087\u0088\7R\2\2\u0088"+
		"\u0089\7T\2\2\u0089\u008a\7Q\2\2\u008a\u008b\7V\2\2\u008b\u008c\7Q\2\2"+
		"\u008c\62\3\2\2\2\u008d\u008e\7X\2\2\u008e\u008f\7Q\2\2\u008f\u0090\7"+
		"K\2\2\u0090\u0091\7F\2\2\u0091\64\3\2\2\2\u0092\u0097\5\7\4\2\u0093\u0096"+
		"\5\7\4\2\u0094\u0096\5\t\5\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\66\3\2\2"+
		"\2\u0099\u0097\3\2\2\2\u009a\u009e\7$\2\2\u009b\u009d\5\13\6\2\u009c\u009b"+
		"\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7$\2\2\u00a2\u00a3\b\34"+
		"\3\2\u00a38\3\2\2\2\u00a4\u00a6\5\t\5\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8:\3\2\2\2\b\2E\u0095"+
		"\u0097\u009e\u00a7\4\b\2\2\3\34\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}