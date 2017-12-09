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
		DONE=20, PROTO=21, VOID=22, FUNC=23, RETURN=24, LB=25, RB=26, PRINT=27, 
		READ=28, IDENT=29, TEXT=30, INTEGER=31;
	public static final int
		RULE_program = 0, RULE_prototype = 1, RULE_function = 2, RULE_bloc = 3, 
		RULE_variable = 4, RULE_instruction = 5, RULE_expression = 6, RULE_factor = 7, 
		RULE_primary = 8;
	public static final String[] ruleNames = {
		"program", "prototype", "function", "bloc", "variable", "instruction", 
		"expression", "factor", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'INT'", "','", 
		"':='", "'{'", "'}'", "'IF'", "'THEN'", "'ELSE'", "'FI'", "'WHILE'", "'DO'", 
		"'DONE'", "'PROTO'", "'VOID'", "'FUNC'", "'RETURN'", "'['", "']'", "'PRINT'", 
		"'READ'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LP", "RP", "PLUS", "MINUS", "TIMES", "DIV", "INT", 
		"COMMA", "AFF", "LCB", "RCB", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", 
		"DONE", "PROTO", "VOID", "FUNC", "RETURN", "LB", "RB", "PRINT", "READ", 
		"IDENT", "TEXT", "INTEGER"
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
		public FunctionContext f;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public PrototypeContext prototype() {
			return getRuleContext(PrototypeContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
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
			setState(18);
			((ProgramContext)_localctx).p = prototype();
			setState(19);
			((ProgramContext)_localctx).f = function();
			setState(20);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new ASD.Program(((ProgramContext)_localctx).p.out, ((ProgramContext)_localctx).f.out); 
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROTO) {
				{
				{
				 ((PrototypeContext)_localctx).attr =  new ArrayList<String>(); 
				setState(65);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(25);
					match(PROTO);
					setState(26);
					match(INT);
					setState(27);
					((PrototypeContext)_localctx).IDENT = match(IDENT);
					 ((PrototypeContext)_localctx).nom =  (((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null); 
					setState(29);
					match(LP);
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(30);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						}
						setState(38);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(33);
							match(COMMA);
							setState(34);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(40);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(43);
					match(RP);
					 _localctx.out.add(new ASD.IntPrototype(_localctx.nom, _localctx.attr)); 
					}
					break;
				case 2:
					{
					setState(45);
					match(PROTO);
					setState(46);
					match(VOID);
					setState(47);
					((PrototypeContext)_localctx).IDENT = match(IDENT);
					 ((PrototypeContext)_localctx).nom =  (((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null); 
					setState(49);
					match(LP);
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(50);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						}
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(53);
							match(COMMA);
							setState(54);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(60);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(63);
					match(RP);
					 _localctx.out.add(new ASD.VoidPrototype(_localctx.nom, _localctx.attr)); 
					}
					break;
				}
				}
				}
				setState(71);
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

	public static class FunctionContext extends ParserRuleContext {
		public List<ASD.Function> out;
		public List<String> attr;
		public String nom;
		public String type;
		public Token IDENT;
		public BlocContext b;
		public List<TerminalNode> FUNC() { return getTokens(VSLParser.FUNC); }
		public TerminalNode FUNC(int i) {
			return getToken(VSLParser.FUNC, i);
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
		public List<BlocContext> bloc() {
			return getRuleContexts(BlocContext.class);
		}
		public BlocContext bloc(int i) {
			return getRuleContext(BlocContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionContext)_localctx).out =  new ArrayList<ASD.Function>(); 
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				 ((FunctionContext)_localctx).attr =  new ArrayList<String>(); 
				setState(118);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(74);
					match(FUNC);
					setState(75);
					match(INT);
					setState(76);
					((FunctionContext)_localctx).IDENT = match(IDENT);
					((FunctionContext)_localctx).nom =  (((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null); 
					setState(78);
					match(LP);
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(79);
						((FunctionContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(82);
							match(COMMA);
							setState(83);
							((FunctionContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(89);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(92);
					match(RP);
					setState(93);
					((FunctionContext)_localctx).b = bloc();
					 _localctx.out.add(new ASD.IntFunction(_localctx.nom, _localctx.attr, ((FunctionContext)_localctx).b.out)); 
					}
					break;
				case 2:
					{
					setState(96);
					match(FUNC);
					setState(97);
					match(VOID);
					setState(98);
					((FunctionContext)_localctx).IDENT = match(IDENT);
					((FunctionContext)_localctx).nom =  (((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null); 
					setState(100);
					match(LP);
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(101);
						((FunctionContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
						}
						setState(109);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(104);
							match(COMMA);
							setState(105);
							((FunctionContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(111);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(114);
					match(RP);
					setState(115);
					((FunctionContext)_localctx).b = bloc();
					 _localctx.out.add(new ASD.VoidFunction(_localctx.nom, _localctx.attr, ((FunctionContext)_localctx).b.out)); 
					}
					break;
				}
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNC );
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
		enterRule(_localctx, 6, RULE_bloc);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case INT:
			case IF:
			case ELSE:
			case FI:
			case WHILE:
			case DONE:
			case FUNC:
			case RETURN:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				((BlocContext)_localctx).v = variable();
				setState(125);
				((BlocContext)_localctx).i = instruction();
				 ((BlocContext)_localctx).out =  new ASD.Bloc(((BlocContext)_localctx).v.out, ((BlocContext)_localctx).i.out); 
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(LCB);
				setState(129);
				((BlocContext)_localctx).v = variable();
				setState(130);
				((BlocContext)_localctx).i = instruction();
				setState(131);
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
		public Token INTEGER;
		public List<TerminalNode> INT() { return getTokens(VSLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(VSLParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> LB() { return getTokens(VSLParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(VSLParser.LB, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(VSLParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(VSLParser.INTEGER, i);
		}
		public List<TerminalNode> RB() { return getTokens(VSLParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(VSLParser.RB, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((VariableContext)_localctx).out =  new ArrayList<ASD.Variable>(); 
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(137);
				match(INT);
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					{
					setState(138);
					((VariableContext)_localctx).IDENT = match(IDENT);
					 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
					}
					}
					break;
				case 2:
					{
					{
					setState(140);
					((VariableContext)_localctx).IDENT = match(IDENT);
					setState(141);
					match(LB);
					setState(142);
					((VariableContext)_localctx).INTEGER = match(INTEGER);
					setState(143);
					match(RB);
					 _localctx.out.add(new ASD.ArrayVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null), Integer.parseInt((((VariableContext)_localctx).INTEGER!=null?((VariableContext)_localctx).INTEGER.getText():null)))); 
					}
					}
					break;
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(155);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						{
						setState(148);
						((VariableContext)_localctx).IDENT = match(IDENT);
						 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
						}
						}
						break;
					case 2:
						{
						{
						setState(150);
						((VariableContext)_localctx).IDENT = match(IDENT);
						setState(151);
						match(LB);
						setState(152);
						((VariableContext)_localctx).INTEGER = match(INTEGER);
						setState(153);
						match(RB);
						 _localctx.out.add(new ASD.ArrayVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null), Integer.parseInt((((VariableContext)_localctx).INTEGER!=null?((VariableContext)_localctx).INTEGER.getText():null)))); 
						}
						}
						break;
					}
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(166);
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
		public List<ASD.Expression> attr;
		public String nom;
		public Token IDENT;
		public ExpressionContext e;
		public BlocContext b;
		public BlocContext b1;
		public BlocContext b2;
		public ExpressionContext e1;
		public ExpressionContext e2;
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
		public List<TerminalNode> RETURN() { return getTokens(VSLParser.RETURN); }
		public TerminalNode RETURN(int i) {
			return getToken(VSLParser.RETURN, i);
		}
		public List<TerminalNode> LP() { return getTokens(VSLParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(VSLParser.LP, i);
		}
		public List<TerminalNode> RP() { return getTokens(VSLParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(VSLParser.RP, i);
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
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InstructionContext)_localctx).out =  new ArrayList<ASD.Instruction>(); 
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << IDENT))) != 0)) {
				{
				setState(219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(168);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					setState(169);
					match(AFF);
					setState(170);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.AffInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 2:
					{
					setState(173);
					match(IF);
					setState(174);
					((InstructionContext)_localctx).e = expression();
					setState(175);
					match(THEN);
					setState(176);
					((InstructionContext)_localctx).b = bloc();
					setState(177);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out, null)); 
					}
					break;
				case 3:
					{
					setState(180);
					match(IF);
					setState(181);
					((InstructionContext)_localctx).e = expression();
					setState(182);
					match(THEN);
					setState(183);
					((InstructionContext)_localctx).b1 = bloc();
					setState(184);
					match(ELSE);
					setState(185);
					((InstructionContext)_localctx).b2 = bloc();
					setState(186);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b1.out, ((InstructionContext)_localctx).b2.out)); 
					}
					break;
				case 4:
					{
					setState(189);
					match(WHILE);
					setState(190);
					((InstructionContext)_localctx).e = expression();
					setState(191);
					match(DO);
					setState(192);
					((InstructionContext)_localctx).b = bloc();
					setState(193);
					match(DONE);
					 _localctx.out.add(new ASD.WhileInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out)); 
					}
					break;
				case 5:
					{
					setState(196);
					match(RETURN);
					setState(197);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.ReturnInstruction(((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 6:
					{
					 ((InstructionContext)_localctx).attr =  new ArrayList<ASD.Expression>(); 
					setState(201);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					 ((InstructionContext)_localctx).nom =  (((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null); 
					setState(203);
					match(LP);
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
						{
						setState(204);
						((InstructionContext)_localctx).e1 = expression();
						 _localctx.attr.add(((InstructionContext)_localctx).e1.out); 
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(206);
							match(COMMA);
							setState(207);
							((InstructionContext)_localctx).e2 = expression();
							 _localctx.attr.add(((InstructionContext)_localctx).e2.out); 
							}
							}
							setState(214);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(217);
					match(RP);
					 _localctx.out.add(new ASD.FunctionInstruction(_localctx.nom, _localctx.attr)); 
					}
					break;
				}
				}
				setState(223);
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
		enterRule(_localctx, 12, RULE_expression);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				((ExpressionContext)_localctx).l = factor();
				setState(225);
				match(PLUS);
				setState(226);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				((ExpressionContext)_localctx).l = factor();
				setState(230);
				match(MINUS);
				setState(231);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
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
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((FactorContext)_localctx).l = primary();
				setState(240);
				match(TIMES);
				setState(241);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.MulExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				((FactorContext)_localctx).l = primary();
				setState(245);
				match(DIV);
				setState(246);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.DivExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
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
		public List<ASD.Expression> attr;
		public String nom;
		public Token INTEGER;
		public Token IDENT;
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public TerminalNode LB() { return getToken(VSLParser.LB, 0); }
		public TerminalNode RB() { return getToken(VSLParser.RB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LP() { return getToken(VSLParser.LP, 0); }
		public TerminalNode RP() { return getToken(VSLParser.RP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(VSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VSLParser.COMMA, i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primary);
		int _la;
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).out =  new ASD.VariableExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				setState(259);
				match(LB);
				setState(260);
				((PrimaryContext)_localctx).e = expression();
				setState(261);
				match(RB);
				 ((PrimaryContext)_localctx).out =  new ASD.ArrayExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null), ((PrimaryContext)_localctx).e.out); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				 ((PrimaryContext)_localctx).attr =  new ArrayList<ASD.Expression>(); 
				setState(265);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).nom =  (((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null); 
				setState(267);
				match(LP);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
					{
					setState(268);
					((PrimaryContext)_localctx).e1 = expression();
					 _localctx.attr.add(((PrimaryContext)_localctx).e1.out); 
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(270);
						match(COMMA);
						setState(271);
						((PrimaryContext)_localctx).e2 = expression();
						 _localctx.attr.add(((PrimaryContext)_localctx).e2.out); 
						}
						}
						setState(278);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(281);
				match(RP);
				 ((PrimaryContext)_localctx).out =  new ASD.FunctionExpression(_localctx.nom, _localctx.attr); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				match(LP);
				setState(284);
				((PrimaryContext)_localctx).e = expression();
				setState(285);
				match(RP);
				 ((PrimaryContext)_localctx).out =  ((PrimaryContext)_localctx).e.out; 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\'"+
		"\n\3\f\3\16\3*\13\3\5\3,\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3;\n\3\f\3\16\3>\13\3\5\3@\n\3\3\3\3\3\5\3D\n\3\7\3F\n\3"+
		"\f\3\16\3I\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4X\n\4\f\4\16\4[\13\4\5\4]\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\5\4s\n\4\3\4\3\4\3\4\3"+
		"\4\5\4y\n\4\6\4{\n\4\r\4\16\4|\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u0089\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0094\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009e\n\6\7\6\u00a0\n\6\f\6\16\6\u00a3"+
		"\13\6\7\6\u00a5\n\6\f\6\16\6\u00a8\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7\u00d5\n\7\f\7\16\7\u00d8\13\7\5\7\u00da\n\7\3\7\3\7\7\7\u00de\n"+
		"\7\f\7\16\7\u00e1\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u00f0\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u00ff\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0115\n\n\f\n\16\n\u0118\13\n\5\n\u011a\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0123\n\n\3\n\2\2\13\2\4\6\b\n\f\16"+
		"\20\22\2\2\2\u013e\2\24\3\2\2\2\4\31\3\2\2\2\6J\3\2\2\2\b\u0088\3\2\2"+
		"\2\n\u008a\3\2\2\2\f\u00a9\3\2\2\2\16\u00ef\3\2\2\2\20\u00fe\3\2\2\2\22"+
		"\u0122\3\2\2\2\24\25\5\4\3\2\25\26\5\6\4\2\26\27\7\2\2\3\27\30\b\2\1\2"+
		"\30\3\3\2\2\2\31G\b\3\1\2\32C\b\3\1\2\33\34\7\27\2\2\34\35\7\13\2\2\35"+
		"\36\7\37\2\2\36\37\b\3\1\2\37+\7\5\2\2 !\7\37\2\2!\"\b\3\1\2\"(\3\2\2"+
		"\2#$\7\f\2\2$%\7\37\2\2%\'\b\3\1\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3"+
		"\2\2\2),\3\2\2\2*(\3\2\2\2+ \3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\6\2\2.D\b"+
		"\3\1\2/\60\7\27\2\2\60\61\7\30\2\2\61\62\7\37\2\2\62\63\b\3\1\2\63?\7"+
		"\5\2\2\64\65\7\37\2\2\65\66\b\3\1\2\66<\3\2\2\2\678\7\f\2\289\7\37\2\2"+
		"9;\b\3\1\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2?\64\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\6\2\2BD\b\3\1\2C\33\3\2\2\2C/\3"+
		"\2\2\2DF\3\2\2\2E\32\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\5\3\2\2\2"+
		"IG\3\2\2\2Jz\b\4\1\2Kx\b\4\1\2LM\7\31\2\2MN\7\13\2\2NO\7\37\2\2OP\b\4"+
		"\1\2P\\\7\5\2\2QR\7\37\2\2RS\b\4\1\2SY\3\2\2\2TU\7\f\2\2UV\7\37\2\2VX"+
		"\b\4\1\2WT\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\"+
		"Q\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\6\2\2_`\5\b\5\2`a\b\4\1\2ay\3\2\2\2"+
		"bc\7\31\2\2cd\7\30\2\2de\7\37\2\2ef\b\4\1\2fr\7\5\2\2gh\7\37\2\2hi\b\4"+
		"\1\2io\3\2\2\2jk\7\f\2\2kl\7\37\2\2ln\b\4\1\2mj\3\2\2\2nq\3\2\2\2om\3"+
		"\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rg\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7"+
		"\6\2\2uv\5\b\5\2vw\b\4\1\2wy\3\2\2\2xL\3\2\2\2xb\3\2\2\2y{\3\2\2\2zK\3"+
		"\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\7\3\2\2\2~\177\5\n\6\2\177\u0080"+
		"\5\f\7\2\u0080\u0081\b\5\1\2\u0081\u0089\3\2\2\2\u0082\u0083\7\16\2\2"+
		"\u0083\u0084\5\n\6\2\u0084\u0085\5\f\7\2\u0085\u0086\7\17\2\2\u0086\u0087"+
		"\b\5\1\2\u0087\u0089\3\2\2\2\u0088~\3\2\2\2\u0088\u0082\3\2\2\2\u0089"+
		"\t\3\2\2\2\u008a\u00a6\b\6\1\2\u008b\u0093\7\13\2\2\u008c\u008d\7\37\2"+
		"\2\u008d\u0094\b\6\1\2\u008e\u008f\7\37\2\2\u008f\u0090\7\33\2\2\u0090"+
		"\u0091\7!\2\2\u0091\u0092\7\34\2\2\u0092\u0094\b\6\1\2\u0093\u008c\3\2"+
		"\2\2\u0093\u008e\3\2\2\2\u0094\u00a1\3\2\2\2\u0095\u009d\7\f\2\2\u0096"+
		"\u0097\7\37\2\2\u0097\u009e\b\6\1\2\u0098\u0099\7\37\2\2\u0099\u009a\7"+
		"\33\2\2\u009a\u009b\7!\2\2\u009b\u009c\7\34\2\2\u009c\u009e\b\6\1\2\u009d"+
		"\u0096\3\2\2\2\u009d\u0098\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u0095\3\2"+
		"\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u008b\3\2\2\2\u00a5\u00a8\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\13\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9\u00df\b\7\1\2\u00aa\u00ab\7\37\2\2\u00ab\u00ac\7\r\2\2"+
		"\u00ac\u00ad\5\16\b\2\u00ad\u00ae\b\7\1\2\u00ae\u00de\3\2\2\2\u00af\u00b0"+
		"\7\20\2\2\u00b0\u00b1\5\16\b\2\u00b1\u00b2\7\21\2\2\u00b2\u00b3\5\b\5"+
		"\2\u00b3\u00b4\7\23\2\2\u00b4\u00b5\b\7\1\2\u00b5\u00de\3\2\2\2\u00b6"+
		"\u00b7\7\20\2\2\u00b7\u00b8\5\16\b\2\u00b8\u00b9\7\21\2\2\u00b9\u00ba"+
		"\5\b\5\2\u00ba\u00bb\7\22\2\2\u00bb\u00bc\5\b\5\2\u00bc\u00bd\7\23\2\2"+
		"\u00bd\u00be\b\7\1\2\u00be\u00de\3\2\2\2\u00bf\u00c0\7\24\2\2\u00c0\u00c1"+
		"\5\16\b\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3\5\b\5\2\u00c3\u00c4\7\26\2"+
		"\2\u00c4\u00c5\b\7\1\2\u00c5\u00de\3\2\2\2\u00c6\u00c7\7\32\2\2\u00c7"+
		"\u00c8\5\16\b\2\u00c8\u00c9\b\7\1\2\u00c9\u00de\3\2\2\2\u00ca\u00cb\b"+
		"\7\1\2\u00cb\u00cc\7\37\2\2\u00cc\u00cd\b\7\1\2\u00cd\u00d9\7\5\2\2\u00ce"+
		"\u00cf\5\16\b\2\u00cf\u00d6\b\7\1\2\u00d0\u00d1\7\f\2\2\u00d1\u00d2\5"+
		"\16\b\2\u00d2\u00d3\b\7\1\2\u00d3\u00d5\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00ce\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\7\6\2\2\u00dc\u00de\b\7\1\2\u00dd\u00aa\3\2"+
		"\2\2\u00dd\u00af\3\2\2\2\u00dd\u00b6\3\2\2\2\u00dd\u00bf\3\2\2\2\u00dd"+
		"\u00c6\3\2\2\2\u00dd\u00ca\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\r\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3"+
		"\5\20\t\2\u00e3\u00e4\7\7\2\2\u00e4\u00e5\5\16\b\2\u00e5\u00e6\b\b\1\2"+
		"\u00e6\u00f0\3\2\2\2\u00e7\u00e8\5\20\t\2\u00e8\u00e9\7\b\2\2\u00e9\u00ea"+
		"\5\16\b\2\u00ea\u00eb\b\b\1\2\u00eb\u00f0\3\2\2\2\u00ec\u00ed\5\20\t\2"+
		"\u00ed\u00ee\b\b\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00e2\3\2\2\2\u00ef\u00e7"+
		"\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\17\3\2\2\2\u00f1\u00f2\5\22\n\2\u00f2"+
		"\u00f3\7\t\2\2\u00f3\u00f4\5\20\t\2\u00f4\u00f5\b\t\1\2\u00f5\u00ff\3"+
		"\2\2\2\u00f6\u00f7\5\22\n\2\u00f7\u00f8\7\n\2\2\u00f8\u00f9\5\20\t\2\u00f9"+
		"\u00fa\b\t\1\2\u00fa\u00ff\3\2\2\2\u00fb\u00fc\5\22\n\2\u00fc\u00fd\b"+
		"\t\1\2\u00fd\u00ff\3\2\2\2\u00fe\u00f1\3\2\2\2\u00fe\u00f6\3\2\2\2\u00fe"+
		"\u00fb\3\2\2\2\u00ff\21\3\2\2\2\u0100\u0101\7!\2\2\u0101\u0123\b\n\1\2"+
		"\u0102\u0103\7\37\2\2\u0103\u0123\b\n\1\2\u0104\u0105\7\37\2\2\u0105\u0106"+
		"\7\33\2\2\u0106\u0107\5\16\b\2\u0107\u0108\7\34\2\2\u0108\u0109\b\n\1"+
		"\2\u0109\u0123\3\2\2\2\u010a\u010b\b\n\1\2\u010b\u010c\7\37\2\2\u010c"+
		"\u010d\b\n\1\2\u010d\u0119\7\5\2\2\u010e\u010f\5\16\b\2\u010f\u0116\b"+
		"\n\1\2\u0110\u0111\7\f\2\2\u0111\u0112\5\16\b\2\u0112\u0113\b\n\1\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u010e\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\6"+
		"\2\2\u011c\u0123\b\n\1\2\u011d\u011e\7\5\2\2\u011e\u011f\5\16\b\2\u011f"+
		"\u0120\7\6\2\2\u0120\u0121\b\n\1\2\u0121\u0123\3\2\2\2\u0122\u0100\3\2"+
		"\2\2\u0122\u0102\3\2\2\2\u0122\u0104\3\2\2\2\u0122\u010a\3\2\2\2\u0122"+
		"\u011d\3\2\2\2\u0123\23\3\2\2\2\34(+<?CGY\\orx|\u0088\u0093\u009d\u00a1"+
		"\u00a6\u00d6\u00d9\u00dd\u00df\u00ef\u00fe\u0116\u0119\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}