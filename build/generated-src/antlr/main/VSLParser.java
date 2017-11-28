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
		AFF=11, LCB=12, RCB=13, IF=14, THEN=15, ELSE=16, FI=17, WHILE=18, DO=19, 
		DONE=20, IDENT=21, TEXT=22, INTEGER=23;
	public static final int
		RULE_program = 0, RULE_bloc = 1, RULE_variable = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_factor = 5, RULE_primary = 6;
	public static final String[] ruleNames = {
		"program", "bloc", "variable", "instruction", "expression", "factor", 
		"primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", "'DO'", 
		"'DONE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", 
		"DONE", "IDENT", "TEXT", "INTEGER"
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
			case IF:
			case ELSE:
			case FI:
			case WHILE:
			case DONE:
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
		public BlocContext b;
		public BlocContext b1;
		public BlocContext b2;
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> AFF() { return getTokens(VSLParser.AFF); }
		public TerminalNode AFF(int i) {
			return getToken(VSLParser.AFF, i);
		}
		public List<TerminalNode> IF() { return getTokens(VSLParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(VSLParser.IF, i);
		}
		public List<TerminalNode> THEN() { return getTokens(VSLParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(VSLParser.THEN, i);
		}
		public List<TerminalNode> FI() { return getTokens(VSLParser.FI); }
		public TerminalNode FI(int i) {
			return getToken(VSLParser.FI, i);
		}
		public List<TerminalNode> ELSE() { return getTokens(VSLParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(VSLParser.ELSE, i);
		}
		public List<TerminalNode> WHILE() { return getTokens(VSLParser.WHILE); }
		public TerminalNode WHILE(int i) {
			return getToken(VSLParser.WHILE, i);
		}
		public List<TerminalNode> DO() { return getTokens(VSLParser.DO); }
		public TerminalNode DO(int i) {
			return getToken(VSLParser.DO, i);
		}
		public List<TerminalNode> DONE() { return getTokens(VSLParser.DONE); }
		public TerminalNode DONE(int i) {
			return getToken(VSLParser.DONE, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlocContext> bloc() {
			return getRuleContexts(BlocContext.class);
		}
		public BlocContext bloc(int i) {
			return getRuleContext(BlocContext.class,i);
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENT))) != 0)) {
				{
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(49);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					setState(50);
					match(AFF);
					setState(51);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.AffInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 2:
					{
					setState(54);
					match(IF);
					setState(55);
					((InstructionContext)_localctx).e = expression();
					setState(56);
					match(THEN);
					setState(57);
					((InstructionContext)_localctx).b = bloc();
					setState(58);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out, null)); 
					}
					break;
				case 3:
					{
					setState(61);
					match(IF);
					setState(62);
					((InstructionContext)_localctx).e = expression();
					setState(63);
					match(THEN);
					setState(64);
					((InstructionContext)_localctx).b1 = bloc();
					setState(65);
					match(ELSE);
					setState(66);
					((InstructionContext)_localctx).b2 = bloc();
					setState(67);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b1.out, ((InstructionContext)_localctx).b2.out)); 
					}
					break;
				case 4:
					{
					setState(70);
					match(WHILE);
					setState(71);
					((InstructionContext)_localctx).e = expression();
					setState(72);
					match(DO);
					setState(73);
					((InstructionContext)_localctx).b = bloc();
					setState(74);
					match(DONE);
					 _localctx.out.add(new ASD.WhileInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out)); 
					}
					break;
				}
				}
				setState(81);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((ExpressionContext)_localctx).l = factor();
				setState(83);
				match(PLUS);
				setState(84);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				((ExpressionContext)_localctx).l = factor();
				setState(88);
				match(MINUS);
				setState(89);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((FactorContext)_localctx).l = primary();
				setState(98);
				match(TIMES);
				setState(99);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.MulExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((FactorContext)_localctx).l = primary();
				setState(103);
				match(DIV);
				setState(104);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.DivExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).out =  new ASD.VariableExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(LP);
				setState(117);
				((PrimaryContext)_localctx).e = expression();
				setState(118);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4)\n\4\f\4\16\4,\13\4\7\4.\n\4\f\4\16\4\61\13\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6b\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b|\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\u0083\2\20\3\2\2\2\4\36\3\2"+
		"\2\2\6 \3\2\2\2\b\62\3\2\2\2\na\3\2\2\2\fp\3\2\2\2\16{\3\2\2\2\20\21\5"+
		"\4\3\2\21\22\7\2\2\3\22\23\b\2\1\2\23\3\3\2\2\2\24\25\5\6\4\2\25\26\5"+
		"\b\5\2\26\27\b\3\1\2\27\37\3\2\2\2\30\31\7\16\2\2\31\32\5\6\4\2\32\33"+
		"\5\b\5\2\33\34\7\17\2\2\34\35\b\3\1\2\35\37\3\2\2\2\36\24\3\2\2\2\36\30"+
		"\3\2\2\2\37\5\3\2\2\2 /\b\4\1\2!\"\7\13\2\2\"#\7\27\2\2#$\b\4\1\2$*\3"+
		"\2\2\2%&\7\f\2\2&\'\7\27\2\2\')\b\4\1\2(%\3\2\2\2),\3\2\2\2*(\3\2\2\2"+
		"*+\3\2\2\2+.\3\2\2\2,*\3\2\2\2-!\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\60\7\3\2\2\2\61/\3\2\2\2\62Q\b\5\1\2\63\64\7\27\2\2\64\65\7\r\2\2"+
		"\65\66\5\n\6\2\66\67\b\5\1\2\67P\3\2\2\289\7\20\2\29:\5\n\6\2:;\7\21\2"+
		"\2;<\5\4\3\2<=\7\23\2\2=>\b\5\1\2>P\3\2\2\2?@\7\20\2\2@A\5\n\6\2AB\7\21"+
		"\2\2BC\5\4\3\2CD\7\22\2\2DE\5\4\3\2EF\7\23\2\2FG\b\5\1\2GP\3\2\2\2HI\7"+
		"\24\2\2IJ\5\n\6\2JK\7\25\2\2KL\5\4\3\2LM\7\26\2\2MN\b\5\1\2NP\3\2\2\2"+
		"O\63\3\2\2\2O8\3\2\2\2O?\3\2\2\2OH\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2"+
		"\2R\t\3\2\2\2SQ\3\2\2\2TU\5\f\7\2UV\7\7\2\2VW\5\n\6\2WX\b\6\1\2Xb\3\2"+
		"\2\2YZ\5\f\7\2Z[\7\b\2\2[\\\5\n\6\2\\]\b\6\1\2]b\3\2\2\2^_\5\f\7\2_`\b"+
		"\6\1\2`b\3\2\2\2aT\3\2\2\2aY\3\2\2\2a^\3\2\2\2b\13\3\2\2\2cd\5\16\b\2"+
		"de\7\t\2\2ef\5\f\7\2fg\b\7\1\2gq\3\2\2\2hi\5\16\b\2ij\7\n\2\2jk\5\f\7"+
		"\2kl\b\7\1\2lq\3\2\2\2mn\5\16\b\2no\b\7\1\2oq\3\2\2\2pc\3\2\2\2ph\3\2"+
		"\2\2pm\3\2\2\2q\r\3\2\2\2rs\7\31\2\2s|\b\b\1\2tu\7\27\2\2u|\b\b\1\2vw"+
		"\7\5\2\2wx\5\n\6\2xy\7\6\2\2yz\b\b\1\2z|\3\2\2\2{r\3\2\2\2{t\3\2\2\2{"+
		"v\3\2\2\2|\17\3\2\2\2\n\36*/OQap{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}