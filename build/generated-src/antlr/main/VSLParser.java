// Generated from VSLParser.g by ANTLR 4.7

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LP=3, RP=4, PLUS=5, MINUS=6, TIMES=7, DIV=8, INT=9, COMMA=10, 
		AFF=11, LCB=12, RCB=13, IDENT=14, TEXT=15, INTEGER=16;
	public static final int
		RULE_program = 0, RULE_bloc = 1, RULE_variable = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_factor = 5, RULE_primary = 6;
	public static final String[] ruleNames = {
		"program", "bloc", "variable", "instruction", "expression", "factor", 
		"primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IDENT", "TEXT", "INTEGER"
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
	public String getGrammarFileName() { return "VSLParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ASD.Program out;
		public BlocContext b;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((ProgramContext)_localctx).b = bloc();
			setState(15);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new ASD.Program(((ProgramContext)_localctx).b.out); 
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

	public static class BlocContext extends ParserRuleContext {
		public ASD.Bloc out;
		public VariableContext v;
		public InstructionContext i;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public TerminalNode LCB() { return getToken(VSLParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(VSLParser.RCB, 0); }
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloc);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case INT:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				((BlocContext)_localctx).v = variable();
				setState(19);
				((BlocContext)_localctx).i = instruction();
				 ((BlocContext)_localctx).out =  new ASD.Bloc(((BlocContext)_localctx).v.out, ((BlocContext)_localctx).i.out); 
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(LCB);
				setState(23);
				((BlocContext)_localctx).v = variable();
				setState(24);
				((BlocContext)_localctx).i = instruction();
				setState(25);
				match(RCB);
				 ((BlocContext)_localctx).out =  new ASD.Bloc(((BlocContext)_localctx).v.out, ((BlocContext)_localctx).i.out); 
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

	public static class VariableContext extends ParserRuleContext {
		public List<ASD.Variable> out;
		public Token IDENT;
		public List<TerminalNode> INT() { return getTokens(VSLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(VSLParser.INT, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((VariableContext)_localctx).out =  new ArrayList<ASD.Variable>(); 
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(31);
				match(INT);
				{
				setState(32);
				((VariableContext)_localctx).IDENT = match(IDENT);
				 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(35);
					match(COMMA);
					setState(36);
					((VariableContext)_localctx).IDENT = match(IDENT);
					 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class InstructionContext extends ParserRuleContext {
		public List<ASD.Instruction> out;
		public Token IDENT;
		public ExpressionContext e;
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> AFF() { return getTokens(VSLParser.AFF); }
		public TerminalNode AFF(int i) {
			return getToken(VSLParser.AFF, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InstructionContext)_localctx).out =  new ArrayList<ASD.Instruction>(); 
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(49);
				((InstructionContext)_localctx).IDENT = match(IDENT);
				setState(50);
				match(AFF);
				setState(51);
				((InstructionContext)_localctx).e = expression();
				 _localctx.out.add(new ASD.AffInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e.out)); 
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ASD.Expression out;
		public FactorContext l;
		public ExpressionContext r;
		public FactorContext f;
		public TerminalNode PLUS() { return getToken(VSLParser.PLUS, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(VSLParser.MINUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((ExpressionContext)_localctx).l = factor();
				setState(60);
				match(PLUS);
				setState(61);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				((ExpressionContext)_localctx).l = factor();
				setState(65);
				match(MINUS);
				setState(66);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				((ExpressionContext)_localctx).f = factor();
				 ((ExpressionContext)_localctx).out =  ((ExpressionContext)_localctx).f.out; 
				}
				break;
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

	public static class FactorContext extends ParserRuleContext {
		public ASD.Expression out;
		public PrimaryContext l;
		public FactorContext r;
		public PrimaryContext p;
		public TerminalNode TIMES() { return getToken(VSLParser.TIMES, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode DIV() { return getToken(VSLParser.DIV, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				((FactorContext)_localctx).l = primary();
				setState(75);
				match(TIMES);
				setState(76);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.MulExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				((FactorContext)_localctx).l = primary();
				setState(80);
				match(DIV);
				setState(81);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.DivExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				((FactorContext)_localctx).p = primary();
				 ((FactorContext)_localctx).out =  ((FactorContext)_localctx).p.out; 
				}
				break;
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

	public static class PrimaryContext extends ParserRuleContext {
		public ASD.Expression out;
		public Token INTEGER;
		public Token IDENT;
		public ExpressionContext e;
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public TerminalNode LP() { return getToken(VSLParser.LP, 0); }
		public TerminalNode RP() { return getToken(VSLParser.RP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).out =  new ASD.VariableExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(LP);
				setState(94);
				((PrimaryContext)_localctx).e = expression();
				setState(95);
				match(RP);
				 ((PrimaryContext)_localctx).out =  ((PrimaryContext)_localctx).e.out; 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4)\n\4\f\4\16\4,\13\4\7\4.\n\4\f\4\16\4\61\13\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b\3\b\2\2\t\2"+
		"\4\6\b\n\f\16\2\2\2i\2\20\3\2\2\2\4\36\3\2\2\2\6 \3\2\2\2\b\62\3\2\2\2"+
		"\nJ\3\2\2\2\fY\3\2\2\2\16d\3\2\2\2\20\21\5\4\3\2\21\22\7\2\2\3\22\23\b"+
		"\2\1\2\23\3\3\2\2\2\24\25\5\6\4\2\25\26\5\b\5\2\26\27\b\3\1\2\27\37\3"+
		"\2\2\2\30\31\7\16\2\2\31\32\5\6\4\2\32\33\5\b\5\2\33\34\7\17\2\2\34\35"+
		"\b\3\1\2\35\37\3\2\2\2\36\24\3\2\2\2\36\30\3\2\2\2\37\5\3\2\2\2 /\b\4"+
		"\1\2!\"\7\13\2\2\"#\7\20\2\2#$\b\4\1\2$*\3\2\2\2%&\7\f\2\2&\'\7\20\2\2"+
		"\')\b\4\1\2(%\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*\3\2\2"+
		"\2-!\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\7\3\2\2\2\61/\3\2\2"+
		"\2\62:\b\5\1\2\63\64\7\20\2\2\64\65\7\r\2\2\65\66\5\n\6\2\66\67\b\5\1"+
		"\2\679\3\2\2\28\63\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\t\3\2\2\2<:"+
		"\3\2\2\2=>\5\f\7\2>?\7\7\2\2?@\5\n\6\2@A\b\6\1\2AK\3\2\2\2BC\5\f\7\2C"+
		"D\7\b\2\2DE\5\n\6\2EF\b\6\1\2FK\3\2\2\2GH\5\f\7\2HI\b\6\1\2IK\3\2\2\2"+
		"J=\3\2\2\2JB\3\2\2\2JG\3\2\2\2K\13\3\2\2\2LM\5\16\b\2MN\7\t\2\2NO\5\f"+
		"\7\2OP\b\7\1\2PZ\3\2\2\2QR\5\16\b\2RS\7\n\2\2ST\5\f\7\2TU\b\7\1\2UZ\3"+
		"\2\2\2VW\5\16\b\2WX\b\7\1\2XZ\3\2\2\2YL\3\2\2\2YQ\3\2\2\2YV\3\2\2\2Z\r"+
		"\3\2\2\2[\\\7\22\2\2\\e\b\b\1\2]^\7\20\2\2^e\b\b\1\2_`\7\5\2\2`a\5\n\6"+
		"\2ab\7\6\2\2bc\b\b\1\2ce\3\2\2\2d[\3\2\2\2d]\3\2\2\2d_\3\2\2\2e\17\3\2"+
		"\2\2\t\36*/:JYd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}