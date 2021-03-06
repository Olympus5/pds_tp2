// Generated from VSLParser.g by ANTLR 4.7

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
  import java.util.Hashtable;

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
		public Hashtable<String, ASD.Type> typeAttr;
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
		public List<TerminalNode> LB() { return getTokens(VSLParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(VSLParser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(VSLParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(VSLParser.RB, i);
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROTO) {
				{
				{
				 ((PrototypeContext)_localctx).attr =  new ArrayList<String>(); ((PrototypeContext)_localctx).typeAttr =  new Hashtable<String, ASD.Type>(); 
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
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
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(30);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						setState(36);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LB:
							{
							setState(32);
							match(LB);
							setState(33);
							match(RB);
							 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.ArrayType(new ASD.IntType())); 
							}
							break;
						case RP:
						case COMMA:
							{
							 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.IntType()); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(49);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(38);
							match(COMMA);
							setState(39);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							setState(45);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case LB:
								{
								setState(41);
								match(LB);
								setState(42);
								match(RB);
								 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.ArrayType(new ASD.IntType())); 
								}
								break;
							case RP:
							case COMMA:
								{
								 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.IntType()); 
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(51);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(54);
					match(RP);
					 _localctx.out.add(new ASD.IntPrototype(_localctx.nom, _localctx.attr, _localctx.typeAttr)); 
					}
					break;
				case 2:
					{
					setState(56);
					match(PROTO);
					setState(57);
					match(VOID);
					setState(58);
					((PrototypeContext)_localctx).IDENT = match(IDENT);
					 ((PrototypeContext)_localctx).nom =  (((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null); 
					setState(60);
					match(LP);
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(61);
						((PrototypeContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
						setState(67);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LB:
							{
							setState(63);
							match(LB);
							setState(64);
							match(RB);
							 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.ArrayType(new ASD.IntType())); 
							}
							break;
						case RP:
						case COMMA:
							{
							 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.IntType()); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(80);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(69);
							match(COMMA);
							setState(70);
							((PrototypeContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null)); 
							setState(76);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case LB:
								{
								setState(72);
								match(LB);
								setState(73);
								match(RB);
								 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.ArrayType(new ASD.IntType())); 
								}
								break;
							case RP:
							case COMMA:
								{
								 _localctx.typeAttr.put((((PrototypeContext)_localctx).IDENT!=null?((PrototypeContext)_localctx).IDENT.getText():null), new ASD.IntType()); 
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(82);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(85);
					match(RP);
					 _localctx.out.add(new ASD.VoidPrototype(_localctx.nom, _localctx.attr, _localctx.typeAttr)); 
					}
					break;
				}
				}
				}
				setState(93);
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
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				 ((FunctionContext)_localctx).attr =  new ArrayList<String>(); 
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(96);
					match(FUNC);
					setState(97);
					match(INT);
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
					 _localctx.out.add(new ASD.IntFunction(_localctx.nom, _localctx.attr, ((FunctionContext)_localctx).b.out)); 
					}
					break;
				case 2:
					{
					setState(118);
					match(FUNC);
					setState(119);
					match(VOID);
					setState(120);
					((FunctionContext)_localctx).IDENT = match(IDENT);
					((FunctionContext)_localctx).nom =  (((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null); 
					setState(122);
					match(LP);
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT) {
						{
						{
						setState(123);
						((FunctionContext)_localctx).IDENT = match(IDENT);
						 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(126);
							match(COMMA);
							setState(127);
							((FunctionContext)_localctx).IDENT = match(IDENT);
							 _localctx.attr.add((((FunctionContext)_localctx).IDENT!=null?((FunctionContext)_localctx).IDENT.getText():null)); 
							}
							}
							setState(133);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(136);
					match(RP);
					setState(137);
					((FunctionContext)_localctx).b = bloc();
					 _localctx.out.add(new ASD.VoidFunction(_localctx.nom, _localctx.attr, ((FunctionContext)_localctx).b.out)); 
					}
					break;
				}
				}
				}
				setState(144); 
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
			setState(156);
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
				setState(146);
				((BlocContext)_localctx).v = variable();
				setState(147);
				((BlocContext)_localctx).i = instruction();
				 ((BlocContext)_localctx).out =  new ASD.Bloc(((BlocContext)_localctx).v.out, ((BlocContext)_localctx).i.out); 
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(LCB);
				setState(151);
				((BlocContext)_localctx).v = variable();
				setState(152);
				((BlocContext)_localctx).i = instruction();
				setState(153);
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
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(159);
				match(INT);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					{
					setState(160);
					((VariableContext)_localctx).IDENT = match(IDENT);
					 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
					}
					}
					break;
				case 2:
					{
					{
					setState(162);
					((VariableContext)_localctx).IDENT = match(IDENT);
					setState(163);
					match(LB);
					setState(164);
					((VariableContext)_localctx).INTEGER = match(INTEGER);
					setState(165);
					match(RB);
					 _localctx.out.add(new ASD.ArrayVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null), Integer.parseInt((((VariableContext)_localctx).INTEGER!=null?((VariableContext)_localctx).INTEGER.getText():null)))); 
					}
					}
					break;
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(169);
					match(COMMA);
					setState(177);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						{
						setState(170);
						((VariableContext)_localctx).IDENT = match(IDENT);
						 _localctx.out.add(new ASD.IntegerVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null))); 
						}
						}
						break;
					case 2:
						{
						{
						setState(172);
						((VariableContext)_localctx).IDENT = match(IDENT);
						setState(173);
						match(LB);
						setState(174);
						((VariableContext)_localctx).INTEGER = match(INTEGER);
						setState(175);
						match(RB);
						 _localctx.out.add(new ASD.ArrayVariable((((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null), Integer.parseInt((((VariableContext)_localctx).INTEGER!=null?((VariableContext)_localctx).INTEGER.getText():null)))); 
						}
						}
						break;
					}
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(188);
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
		public ExpressionContext e1;
		public ExpressionContext e2;
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
		public List<TerminalNode> LB() { return getTokens(VSLParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(VSLParser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(VSLParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(VSLParser.RB, i);
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
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << IDENT))) != 0)) {
				{
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(190);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					setState(191);
					match(AFF);
					setState(192);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.AffInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 2:
					{
					setState(195);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					setState(196);
					match(LB);
					setState(197);
					((InstructionContext)_localctx).e1 = expression();
					setState(198);
					match(RB);
					setState(199);
					match(AFF);
					setState(200);
					((InstructionContext)_localctx).e2 = expression();
					 _localctx.out.add(new ASD.AffArrayInstruction((((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null), ((InstructionContext)_localctx).e2.out, ((InstructionContext)_localctx).e1.out)); 
					}
					break;
				case 3:
					{
					setState(203);
					match(IF);
					setState(204);
					((InstructionContext)_localctx).e = expression();
					setState(205);
					match(THEN);
					setState(206);
					((InstructionContext)_localctx).b = bloc();
					setState(207);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out, null)); 
					}
					break;
				case 4:
					{
					setState(210);
					match(IF);
					setState(211);
					((InstructionContext)_localctx).e = expression();
					setState(212);
					match(THEN);
					setState(213);
					((InstructionContext)_localctx).b1 = bloc();
					setState(214);
					match(ELSE);
					setState(215);
					((InstructionContext)_localctx).b2 = bloc();
					setState(216);
					match(FI);
					 _localctx.out.add(new ASD.IfElseInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b1.out, ((InstructionContext)_localctx).b2.out)); 
					}
					break;
				case 5:
					{
					setState(219);
					match(WHILE);
					setState(220);
					((InstructionContext)_localctx).e = expression();
					setState(221);
					match(DO);
					setState(222);
					((InstructionContext)_localctx).b = bloc();
					setState(223);
					match(DONE);
					 _localctx.out.add(new ASD.WhileInstruction(((InstructionContext)_localctx).e.out, ((InstructionContext)_localctx).b.out)); 
					}
					break;
				case 6:
					{
					setState(226);
					match(RETURN);
					setState(227);
					((InstructionContext)_localctx).e = expression();
					 _localctx.out.add(new ASD.ReturnInstruction(((InstructionContext)_localctx).e.out)); 
					}
					break;
				case 7:
					{
					 ((InstructionContext)_localctx).attr =  new ArrayList<ASD.Expression>(); 
					setState(231);
					((InstructionContext)_localctx).IDENT = match(IDENT);
					 ((InstructionContext)_localctx).nom =  (((InstructionContext)_localctx).IDENT!=null?((InstructionContext)_localctx).IDENT.getText():null); 
					setState(233);
					match(LP);
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
						{
						setState(234);
						((InstructionContext)_localctx).e1 = expression();
						 _localctx.attr.add(((InstructionContext)_localctx).e1.out); 
						setState(242);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(236);
							match(COMMA);
							setState(237);
							((InstructionContext)_localctx).e2 = expression();
							 _localctx.attr.add(((InstructionContext)_localctx).e2.out); 
							}
							}
							setState(244);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(247);
					match(RP);
					 _localctx.out.add(new ASD.FunctionInstruction(_localctx.nom, _localctx.attr)); 
					}
					break;
				}
				}
				setState(253);
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
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((ExpressionContext)_localctx).l = factor();
				setState(255);
				match(PLUS);
				setState(256);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((ExpressionContext)_localctx).l = factor();
				setState(260);
				match(MINUS);
				setState(261);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).out =  new ASD.SubExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
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
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				((FactorContext)_localctx).l = primary();
				setState(270);
				match(TIMES);
				setState(271);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.MulExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				((FactorContext)_localctx).l = primary();
				setState(275);
				match(DIV);
				setState(276);
				((FactorContext)_localctx).r = factor();
				 ((FactorContext)_localctx).out =  new ASD.DivExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(279);
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
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new ASD.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).out =  new ASD.VariableExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				setState(289);
				match(LB);
				setState(290);
				((PrimaryContext)_localctx).e = expression();
				setState(291);
				match(RB);
				 ((PrimaryContext)_localctx).out =  new ASD.ArrayExpression((((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null), ((PrimaryContext)_localctx).e.out); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				 ((PrimaryContext)_localctx).attr =  new ArrayList<ASD.Expression>(); 
				setState(295);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				 ((PrimaryContext)_localctx).nom =  (((PrimaryContext)_localctx).IDENT!=null?((PrimaryContext)_localctx).IDENT.getText():null); 
				setState(297);
				match(LP);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
					{
					setState(298);
					((PrimaryContext)_localctx).e1 = expression();
					 _localctx.attr.add(((PrimaryContext)_localctx).e1.out); 
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(300);
						match(COMMA);
						setState(301);
						((PrimaryContext)_localctx).e2 = expression();
						 _localctx.attr.add(((PrimaryContext)_localctx).e2.out); 
						}
						}
						setState(308);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(311);
				match(RP);
				 ((PrimaryContext)_localctx).out =  new ASD.FunctionExpression(_localctx.nom, _localctx.attr); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				match(LP);
				setState(314);
				((PrimaryContext)_localctx).e = expression();
				setState(315);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0143\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\'"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\7\3\62\n\3\f\3\16\3\65\13"+
		"\3\5\3\67\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"F\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3O\n\3\7\3Q\n\3\f\3\16\3T\13\3\5\3"+
		"V\n\3\3\3\3\3\5\3Z\n\3\7\3\\\n\3\f\3\16\3_\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\5\4s\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0084\n\4\f"+
		"\4\16\4\u0087\13\4\5\4\u0089\n\4\3\4\3\4\3\4\3\4\5\4\u008f\n\4\6\4\u0091"+
		"\n\4\r\4\16\4\u0092\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009f"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00aa\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00b4\n\6\7\6\u00b6\n\6\f\6\16\6\u00b9\13\6\7\6\u00bb"+
		"\n\6\f\6\16\6\u00be\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7\u00f3\n\7\f\7\16\7\u00f6\13\7\5\7\u00f8\n\7\3\7"+
		"\3\7\7\7\u00fc\n\7\f\7\16\7\u00ff\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u010e\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u011d\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0133\n\n\f\n\16\n\u0136"+
		"\13\n\5\n\u0138\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0141\n\n\3\n\2\2"+
		"\13\2\4\6\b\n\f\16\20\22\2\2\2\u0161\2\24\3\2\2\2\4\31\3\2\2\2\6`\3\2"+
		"\2\2\b\u009e\3\2\2\2\n\u00a0\3\2\2\2\f\u00bf\3\2\2\2\16\u010d\3\2\2\2"+
		"\20\u011c\3\2\2\2\22\u0140\3\2\2\2\24\25\5\4\3\2\25\26\5\6\4\2\26\27\7"+
		"\2\2\3\27\30\b\2\1\2\30\3\3\2\2\2\31]\b\3\1\2\32Y\b\3\1\2\33\34\7\27\2"+
		"\2\34\35\7\13\2\2\35\36\7\37\2\2\36\37\b\3\1\2\37\66\7\5\2\2 !\7\37\2"+
		"\2!&\b\3\1\2\"#\7\33\2\2#$\7\34\2\2$\'\b\3\1\2%\'\b\3\1\2&\"\3\2\2\2&"+
		"%\3\2\2\2\'\63\3\2\2\2()\7\f\2\2)*\7\37\2\2*/\b\3\1\2+,\7\33\2\2,-\7\34"+
		"\2\2-\60\b\3\1\2.\60\b\3\1\2/+\3\2\2\2/.\3\2\2\2\60\62\3\2\2\2\61(\3\2"+
		"\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2"+
		"\2\2\66 \3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\6\2\29Z\b\3\1\2:;\7\27"+
		"\2\2;<\7\30\2\2<=\7\37\2\2=>\b\3\1\2>U\7\5\2\2?@\7\37\2\2@E\b\3\1\2AB"+
		"\7\33\2\2BC\7\34\2\2CF\b\3\1\2DF\b\3\1\2EA\3\2\2\2ED\3\2\2\2FR\3\2\2\2"+
		"GH\7\f\2\2HI\7\37\2\2IN\b\3\1\2JK\7\33\2\2KL\7\34\2\2LO\b\3\1\2MO\b\3"+
		"\1\2NJ\3\2\2\2NM\3\2\2\2OQ\3\2\2\2PG\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2"+
		"\2\2SV\3\2\2\2TR\3\2\2\2U?\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\6\2\2XZ\b\3"+
		"\1\2Y\33\3\2\2\2Y:\3\2\2\2Z\\\3\2\2\2[\32\3\2\2\2\\_\3\2\2\2][\3\2\2\2"+
		"]^\3\2\2\2^\5\3\2\2\2_]\3\2\2\2`\u0090\b\4\1\2a\u008e\b\4\1\2bc\7\31\2"+
		"\2cd\7\13\2\2de\7\37\2\2ef\b\4\1\2fr\7\5\2\2gh\7\37\2\2hi\b\4\1\2io\3"+
		"\2\2\2jk\7\f\2\2kl\7\37\2\2ln\b\4\1\2mj\3\2\2\2nq\3\2\2\2om\3\2\2\2op"+
		"\3\2\2\2ps\3\2\2\2qo\3\2\2\2rg\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\6\2\2u"+
		"v\5\b\5\2vw\b\4\1\2w\u008f\3\2\2\2xy\7\31\2\2yz\7\30\2\2z{\7\37\2\2{|"+
		"\b\4\1\2|\u0088\7\5\2\2}~\7\37\2\2~\177\b\4\1\2\177\u0085\3\2\2\2\u0080"+
		"\u0081\7\f\2\2\u0081\u0082\7\37\2\2\u0082\u0084\b\4\1\2\u0083\u0080\3"+
		"\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0088}\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008b\7\6\2\2\u008b\u008c\5\b\5\2\u008c\u008d"+
		"\b\4\1\2\u008d\u008f\3\2\2\2\u008eb\3\2\2\2\u008ex\3\2\2\2\u008f\u0091"+
		"\3\2\2\2\u0090a\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\7\3\2\2\2\u0094\u0095\5\n\6\2\u0095\u0096\5\f\7\2"+
		"\u0096\u0097\b\5\1\2\u0097\u009f\3\2\2\2\u0098\u0099\7\16\2\2\u0099\u009a"+
		"\5\n\6\2\u009a\u009b\5\f\7\2\u009b\u009c\7\17\2\2\u009c\u009d\b\5\1\2"+
		"\u009d\u009f\3\2\2\2\u009e\u0094\3\2\2\2\u009e\u0098\3\2\2\2\u009f\t\3"+
		"\2\2\2\u00a0\u00bc\b\6\1\2\u00a1\u00a9\7\13\2\2\u00a2\u00a3\7\37\2\2\u00a3"+
		"\u00aa\b\6\1\2\u00a4\u00a5\7\37\2\2\u00a5\u00a6\7\33\2\2\u00a6\u00a7\7"+
		"!\2\2\u00a7\u00a8\7\34\2\2\u00a8\u00aa\b\6\1\2\u00a9\u00a2\3\2\2\2\u00a9"+
		"\u00a4\3\2\2\2\u00aa\u00b7\3\2\2\2\u00ab\u00b3\7\f\2\2\u00ac\u00ad\7\37"+
		"\2\2\u00ad\u00b4\b\6\1\2\u00ae\u00af\7\37\2\2\u00af\u00b0\7\33\2\2\u00b0"+
		"\u00b1\7!\2\2\u00b1\u00b2\7\34\2\2\u00b2\u00b4\b\6\1\2\u00b3\u00ac\3\2"+
		"\2\2\u00b3\u00ae\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00ab\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00a1\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\13\3\2\2\2\u00be\u00bc\3\2\2"+
		"\2\u00bf\u00fd\b\7\1\2\u00c0\u00c1\7\37\2\2\u00c1\u00c2\7\r\2\2\u00c2"+
		"\u00c3\5\16\b\2\u00c3\u00c4\b\7\1\2\u00c4\u00fc\3\2\2\2\u00c5\u00c6\7"+
		"\37\2\2\u00c6\u00c7\7\33\2\2\u00c7\u00c8\5\16\b\2\u00c8\u00c9\7\34\2\2"+
		"\u00c9\u00ca\7\r\2\2\u00ca\u00cb\5\16\b\2\u00cb\u00cc\b\7\1\2\u00cc\u00fc"+
		"\3\2\2\2\u00cd\u00ce\7\20\2\2\u00ce\u00cf\5\16\b\2\u00cf\u00d0\7\21\2"+
		"\2\u00d0\u00d1\5\b\5\2\u00d1\u00d2\7\23\2\2\u00d2\u00d3\b\7\1\2\u00d3"+
		"\u00fc\3\2\2\2\u00d4\u00d5\7\20\2\2\u00d5\u00d6\5\16\b\2\u00d6\u00d7\7"+
		"\21\2\2\u00d7\u00d8\5\b\5\2\u00d8\u00d9\7\22\2\2\u00d9\u00da\5\b\5\2\u00da"+
		"\u00db\7\23\2\2\u00db\u00dc\b\7\1\2\u00dc\u00fc\3\2\2\2\u00dd\u00de\7"+
		"\24\2\2\u00de\u00df\5\16\b\2\u00df\u00e0\7\25\2\2\u00e0\u00e1\5\b\5\2"+
		"\u00e1\u00e2\7\26\2\2\u00e2\u00e3\b\7\1\2\u00e3\u00fc\3\2\2\2\u00e4\u00e5"+
		"\7\32\2\2\u00e5\u00e6\5\16\b\2\u00e6\u00e7\b\7\1\2\u00e7\u00fc\3\2\2\2"+
		"\u00e8\u00e9\b\7\1\2\u00e9\u00ea\7\37\2\2\u00ea\u00eb\b\7\1\2\u00eb\u00f7"+
		"\7\5\2\2\u00ec\u00ed\5\16\b\2\u00ed\u00f4\b\7\1\2\u00ee\u00ef\7\f\2\2"+
		"\u00ef\u00f0\5\16\b\2\u00f0\u00f1\b\7\1\2\u00f1\u00f3\3\2\2\2\u00f2\u00ee"+
		"\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00ec\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7\6\2\2\u00fa\u00fc\b\7\1\2\u00fb"+
		"\u00c0\3\2\2\2\u00fb\u00c5\3\2\2\2\u00fb\u00cd\3\2\2\2\u00fb\u00d4\3\2"+
		"\2\2\u00fb\u00dd\3\2\2\2\u00fb\u00e4\3\2\2\2\u00fb\u00e8\3\2\2\2\u00fc"+
		"\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\r\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u0100\u0101\5\20\t\2\u0101\u0102\7\7\2\2\u0102\u0103"+
		"\5\16\b\2\u0103\u0104\b\b\1\2\u0104\u010e\3\2\2\2\u0105\u0106\5\20\t\2"+
		"\u0106\u0107\7\b\2\2\u0107\u0108\5\16\b\2\u0108\u0109\b\b\1\2\u0109\u010e"+
		"\3\2\2\2\u010a\u010b\5\20\t\2\u010b\u010c\b\b\1\2\u010c\u010e\3\2\2\2"+
		"\u010d\u0100\3\2\2\2\u010d\u0105\3\2\2\2\u010d\u010a\3\2\2\2\u010e\17"+
		"\3\2\2\2\u010f\u0110\5\22\n\2\u0110\u0111\7\t\2\2\u0111\u0112\5\20\t\2"+
		"\u0112\u0113\b\t\1\2\u0113\u011d\3\2\2\2\u0114\u0115\5\22\n\2\u0115\u0116"+
		"\7\n\2\2\u0116\u0117\5\20\t\2\u0117\u0118\b\t\1\2\u0118\u011d\3\2\2\2"+
		"\u0119\u011a\5\22\n\2\u011a\u011b\b\t\1\2\u011b\u011d\3\2\2\2\u011c\u010f"+
		"\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u0119\3\2\2\2\u011d\21\3\2\2\2\u011e"+
		"\u011f\7!\2\2\u011f\u0141\b\n\1\2\u0120\u0121\7\37\2\2\u0121\u0141\b\n"+
		"\1\2\u0122\u0123\7\37\2\2\u0123\u0124\7\33\2\2\u0124\u0125\5\16\b\2\u0125"+
		"\u0126\7\34\2\2\u0126\u0127\b\n\1\2\u0127\u0141\3\2\2\2\u0128\u0129\b"+
		"\n\1\2\u0129\u012a\7\37\2\2\u012a\u012b\b\n\1\2\u012b\u0137\7\5\2\2\u012c"+
		"\u012d\5\16\b\2\u012d\u0134\b\n\1\2\u012e\u012f\7\f\2\2\u012f\u0130\5"+
		"\16\b\2\u0130\u0131\b\n\1\2\u0131\u0133\3\2\2\2\u0132\u012e\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0138\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137\u012c\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013a\7\6\2\2\u013a\u0141\b\n\1\2\u013b\u013c\7\5"+
		"\2\2\u013c\u013d\5\16\b\2\u013d\u013e\7\6\2\2\u013e\u013f\b\n\1\2\u013f"+
		"\u0141\3\2\2\2\u0140\u011e\3\2\2\2\u0140\u0120\3\2\2\2\u0140\u0122\3\2"+
		"\2\2\u0140\u0128\3\2\2\2\u0140\u013b\3\2\2\2\u0141\23\3\2\2\2 &/\63\66"+
		"ENRUY]or\u0085\u0088\u008e\u0092\u009e\u00a9\u00b3\u00b7\u00bc\u00f4\u00f7"+
		"\u00fb\u00fd\u010d\u011c\u0134\u0137\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}