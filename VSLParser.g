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
    : v=variable i=instruction EOF { $out = new ASD.Program($v.out, $i.out); } // TODO : change when you extend the language
    ;

bloc returns [ASD.bloc out]
    : v=variable i=instruction { $out = new ASD.Bloc($v.out, $i.out); }
    ;

variable returns [List<ASD.Variable> out]
    : { $out = new ArrayList<ASD.Variable>(); } (INT (IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })
                                                    (COMMA IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })*)*
    ;

instruction returns [List<ASD.Instruction> out]
    : { $out = new ArrayList<ASD.Instruction>(); } (IDENT AFF e=expression { $out = new ASD.AffInstruction($IDENT.text, $e.out); })*
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
