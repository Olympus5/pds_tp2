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
		DONE=20, PROTO=21, VOID=22, IDENT=23, TEXT=24, INTEGER=25;
	public static final int
		RULE_program = 0, RULE_prototype = 1, RULE_bloc = 2, RULE_variable = 3, 
		RULE_instruction = 4, RULE_expression = 5, RULE_factor = 6, RULE_primary = 7;
	public static final String[] ruleNames = {
		"program", "prototype", "bloc", "variable", "instruction", "expression", 
		"factor", "primary"
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
		public PrototypeContext p;
		public BlocContext b;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public PrototypeContext prototype() {
			return getRuleContext(PrototypeContext.class,0);
		}
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
			setState(16);
			((ProgramContext)_localctx).p = prototype();
			setState(17);
			((ProgramContext)_localctx).b = bloc();
			setState(18);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new ASD.Program(((ProgramContext)_localctx).p.out, ((ProgramContext)_localctx).b.out); 
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

	public static class PrototypeContext extends ParserRuleContext {
		public List<ASD.Prototype> out;
		public List<String> attr;
		public String nom;
		public Token IDENT;
		public List<TerminalNode> PROTO() { return getTokens(VSLParser.PROTO); }
		public TerminalNode PROTO(int i) {
			return getToken(VSLParser.PROTO, i);
		}
		public List<TerminalNode> INT() { return getTokens(VSLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(VSLParser.INT, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> LP() { return getTokens(VSLParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(VSLParser.LP, i);
		}
		public List<TerminalNode> RP() { return getTokens(VSLParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(VSLParser.RP, i);
		}
		public List<TerminalNode> VOID() { return getTokens(VSLParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(VSLParser.VOID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public PrototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prototype; }
	}

	public final PrototypeContext prototype() throws RecognitionException {
		PrototypeContext _localctx = new PrototypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prototype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PrototypeContext)_localctx).out =  new ArrayList(); 
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROTO) {
				{
				{
				 ((PrototypeContext)_localctx).attr =  new ArrayList<String>(); 
				setState(63);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(23);
					match(PROTO);
					setState(24);
					match(INT);
					setState(25);
					((PrototypeContext)_localctx).IDENT = match(IDENT);
					 ((PrototypeContext)_localctx).nom =  (((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null); 
					setState(27);
					match(LP);
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(28);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						}
						setState(36);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(31);
							match(COMMA);
							setState(32);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(38);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(41);
					match(RP);
					 _localctx.out.add(new ASD.IntPrototype(_localctx.nom, _localctx.attr)); 
					}
					break;
				case 2:
					{
					setState(43);
					match(PROTO);
					setState(44);
					match(VOID);
					setState(45);
					((PrototypeContext)_localctx).IDENT = match(IDENT);
					 ((PrototypeContext)_localctx).nom =  (((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null); 
					setState(47);
					match(LP);
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(48);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						}
						setState(56);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(51);
							match(COMMA);
							setState(52);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(58);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(61);
					match(RP);
					 _localctx.out.add(new ASD.VoidPrototype(_localctx.nom, _localctx.attr)); 
					}
					break;
				}
				}
				}
				setState(69);
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
		enterRule(_localctx, 4, RULE_bloc);
		try {
			setState(80);
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
				setState(70);
				((BlocContext)_localctx).v = variable();
				setState(71);
				((BlocContext)_localctx).i = instruction();
				 ((BlocContext)_localctx).out =  new ASD.Bloc(((BlocContext)_localctx).v.out, ((BlocContext)_localctx).i.out); 
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(LCB);
				setState(75);
				((BlocContext)_localctx).v = variable();
				setState(76);
				((BlocContext)_localctx).i = instruction();
				setState(77);
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
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((VariableContext)_localctx).out =  new ArrayList<ASD.Variable>(); 
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(83);
				match(INT);
				{
				setState(84);
				((VariableContext)_localctx).IDENT = match(IDENT);
				 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(87);
					match(COMMA);
					setState(88);
					((VariableContext)_localctx).IDENT = match(IDENT);
					 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(99);
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
		enterRule(_localctx, 8, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InstructionContext)_localctx).out =  new ArrayList<ASD.Instruction>(); 
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENT))) != 0)) {
				{
				setState(129);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(101);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					setState(102);
					match(AFF);
					setState(103);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.AffInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 2:
					{
					setState(106);
					match(IF);
					setState(107);
					((InstructionContext)_localctx).e = expression();
					setState(108);
					match(THEN);
					setState(109);
					((InstructionContext)_localctx).b = bloc();
					setState(110);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out, null)); 
					}
					break;
				case 3:
					{
					setState(113);
					match(IF);
					setState(114);
					((InstructionContext)_localctx).e = expression();
					setState(115);
					match(THEN);
					setState(116);
					((InstructionContext)_localctx).b1 = bloc();
					setState(117);
					match(ELSE);
					setState(118);
					((InstructionContext)_localctx).b2 = bloc();
					setState(119);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b1.out, ((InstructionContext)_localctx).b2.out)); 
					}
					break;
				case 4:
					{
					setState(122);
					match(WHILE);
					setState(123);
					((InstructionContext)_localctx).e = expression();
					setState(124);
					match(DO);
					setState(125);
					((InstructionContext)_localctx).b = bloc();
					setState(126);
					match(DONE);
					 _localctx.out.add(new ASD.WhileInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out)); 
					}
					break;
				}
				}
				setState(133);
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
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((ExpressionContext)_localctx).l = factor();
				setState(135);
				match(PLUS);
				setState(136);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				((ExpressionContext)_localctx).l = factor();
				setState(140);
				match(MINUS);
				setState(141);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
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
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				((FactorContext)_localctx).l = primary();
				setState(150);
				match(TIMES);
				setState(151);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.MulExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				((FactorContext)_localctx).l = primary();
				setState(155);
				match(DIV);
				setState(156);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.DivExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
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
		enterRule(_localctx, 14, RULE_primary);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).out =  new ASD.VariableExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(LP);
				setState(169);
				((PrimaryContext)_localctx).e = expression();
				setState(170);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00b2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3%\n\3\f"+
		"\3\16\3(\13\3\5\3*\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\3\3\3\5\3B\n\3\7\3D\n\3\f\3\16"+
		"\3G\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4S\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\7\5b\n\5\f\5\16\5e\13\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0084\n\6\f\6\16\6\u0087"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0096\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a5\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b0\n\t\3\t\2\2\n\2\4\6\b\n\f"+
		"\16\20\2\2\2\u00bc\2\22\3\2\2\2\4\27\3\2\2\2\6R\3\2\2\2\bT\3\2\2\2\nf"+
		"\3\2\2\2\f\u0095\3\2\2\2\16\u00a4\3\2\2\2\20\u00af\3\2\2\2\22\23\5\4\3"+
		"\2\23\24\5\6\4\2\24\25\7\2\2\3\25\26\b\2\1\2\26\3\3\2\2\2\27E\b\3\1\2"+
		"\30A\b\3\1\2\31\32\7\27\2\2\32\33\7\13\2\2\33\34\7\31\2\2\34\35\b\3\1"+
		"\2\35)\7\5\2\2\36\37\7\31\2\2\37 \b\3\1\2 &\3\2\2\2!\"\7\f\2\2\"#\7\31"+
		"\2\2#%\b\3\1\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'*\3\2\2\2(&\3"+
		"\2\2\2)\36\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\6\2\2,B\b\3\1\2-.\7\27\2\2"+
		"./\7\30\2\2/\60\7\31\2\2\60\61\b\3\1\2\61=\7\5\2\2\62\63\7\31\2\2\63\64"+
		"\b\3\1\2\64:\3\2\2\2\65\66\7\f\2\2\66\67\7\31\2\2\679\b\3\1\28\65\3\2"+
		"\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=\62\3\2\2\2=>\3"+
		"\2\2\2>?\3\2\2\2?@\7\6\2\2@B\b\3\1\2A\31\3\2\2\2A-\3\2\2\2BD\3\2\2\2C"+
		"\30\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\5\3\2\2\2GE\3\2\2\2HI\5\b\5"+
		"\2IJ\5\n\6\2JK\b\4\1\2KS\3\2\2\2LM\7\16\2\2MN\5\b\5\2NO\5\n\6\2OP\7\17"+
		"\2\2PQ\b\4\1\2QS\3\2\2\2RH\3\2\2\2RL\3\2\2\2S\7\3\2\2\2Tc\b\5\1\2UV\7"+
		"\13\2\2VW\7\31\2\2WX\b\5\1\2X^\3\2\2\2YZ\7\f\2\2Z[\7\31\2\2[]\b\5\1\2"+
		"\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2aU\3\2\2"+
		"\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\t\3\2\2\2ec\3\2\2\2f\u0085\b\6\1\2g"+
		"h\7\31\2\2hi\7\r\2\2ij\5\f\7\2jk\b\6\1\2k\u0084\3\2\2\2lm\7\20\2\2mn\5"+
		"\f\7\2no\7\21\2\2op\5\6\4\2pq\7\23\2\2qr\b\6\1\2r\u0084\3\2\2\2st\7\20"+
		"\2\2tu\5\f\7\2uv\7\21\2\2vw\5\6\4\2wx\7\22\2\2xy\5\6\4\2yz\7\23\2\2z{"+
		"\b\6\1\2{\u0084\3\2\2\2|}\7\24\2\2}~\5\f\7\2~\177\7\25\2\2\177\u0080\5"+
		"\6\4\2\u0080\u0081\7\26\2\2\u0081\u0082\b\6\1\2\u0082\u0084\3\2\2\2\u0083"+
		"g\3\2\2\2\u0083l\3\2\2\2\u0083s\3\2\2\2\u0083|\3\2\2\2\u0084\u0087\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\13\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0089\5\16\b\2\u0089\u008a\7\7\2\2\u008a\u008b\5\f\7\2"+
		"\u008b\u008c\b\7\1\2\u008c\u0096\3\2\2\2\u008d\u008e\5\16\b\2\u008e\u008f"+
		"\7\b\2\2\u008f\u0090\5\f\7\2\u0090\u0091\b\7\1\2\u0091\u0096\3\2\2\2\u0092"+
		"\u0093\5\16\b\2\u0093\u0094\b\7\1\2\u0094\u0096\3\2\2\2\u0095\u0088\3"+
		"\2\2\2\u0095\u008d\3\2\2\2\u0095\u0092\3\2\2\2\u0096\r\3\2\2\2\u0097\u0098"+
		"\5\20\t\2\u0098\u0099\7\t\2\2\u0099\u009a\5\16\b\2\u009a\u009b\b\b\1\2"+
		"\u009b\u00a5\3\2\2\2\u009c\u009d\5\20\t\2\u009d\u009e\7\n\2\2\u009e\u009f"+
		"\5\16\b\2\u009f\u00a0\b\b\1\2\u00a0\u00a5\3\2\2\2\u00a1\u00a2\5\20\t\2"+
		"\u00a2\u00a3\b\b\1\2\u00a3\u00a5\3\2\2\2\u00a4\u0097\3\2\2\2\u00a4\u009c"+
		"\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\17\3\2\2\2\u00a6\u00a7\7\33\2\2\u00a7"+
		"\u00b0\b\t\1\2\u00a8\u00a9\7\31\2\2\u00a9\u00b0\b\t\1\2\u00aa\u00ab\7"+
		"\5\2\2\u00ab\u00ac\5\f\7\2\u00ac\u00ad\7\6\2\2\u00ad\u00ae\b\t\1\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00a6\3\2\2\2\u00af\u00a8\3\2\2\2\u00af\u00aa\3\2"+
		"\2\2\u00b0\21\3\2\2\2\20&):=AER^c\u0083\u0085\u0095\u00a4\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}