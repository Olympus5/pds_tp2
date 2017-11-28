parser grammar VSLParser;

options {
  language = Java;
  tokenVocab = VSLLexer;
}

@header {
  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
}


// TODO : other rules

program returns [ASD.Program out]
    : b=bloc EOF { $out = new ASD.Program($b.out); } // TODO : change when you extend the language
    ;

bloc returns [ASD.Bloc out]
    : v=variable i=instruction { $out = new ASD.Bloc($v.out, $i.out); }
    | LCB v=variable i=instruction RCB { $out = new ASD.Bloc($v.out, $i.out); }
    ;

variable returns [List<ASD.Variable> out]
    : { $out = new ArrayList<ASD.Variable>(); } (INT (IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })
                                                     (COMMA IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })*)*
    ;

instruction returns [List<ASD.Instruction> out]
    : { $out = new ArrayList<ASD.Instruction>(); } (IDENT AFF e=expression { $out.add(new ASD.AffInstruction($IDENT.text, $e.out)); }
                                                    | IF e=expression THEN b=bloc FI { $out.add(new ASD.IfElseInstruction($e.out, $b.out, null)); }
                                                    | IF e=expression THEN b1=bloc ELSE b2=bloc FI { $out.add(new ASD.IfElseInstruction($e.out, $b1.out, $b2.out)); })*
    ;

expression returns [ASD.Expression out]
    : l=factor PLUS r=expression  { $out = new ASD.AddExpression($l.out, $r.out); }
    | l=factor MINUS r=expression { $out = new ASD.SubExpression($l.out, $r.out); }
    | f=factor { $out = $f.out; }
    ;

factor returns [ASD.Expression out]
    : l=primary TIMES r=factor { $out = new ASD.MulExpression($l.out, $r.out); }
    | l=primary DIV r=factor { $out = new ASD.DivExpression($l.out, $r.out); }
    | p=primary { $out = $p.out; }
    ;

primary returns [ASD.Expression out]
    : INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }//Constante dans une expression
    | IDENT { $out = new ASD.VariableExpression($IDENT.text); }//Variable dans une expression
    | LP e=expression RP { $out = $e.out; }//Expression entre parenthèses
    ;
