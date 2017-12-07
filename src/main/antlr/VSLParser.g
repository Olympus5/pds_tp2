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
    : p=prototype f=function EOF { $out = new ASD.Program($p.out, $f.out); } // TODO : change when you extend the language
    ;

prototype returns [List<ASD.Prototype> out] locals [List<String> attr, String nom]
    : { $out = new ArrayList(); } ({ $attr = new ArrayList<String>(); } (PROTO INT IDENT { $nom = $IDENT.text; } LP ((IDENT { $attr.add($IDENT.text); }) (COMMA IDENT { $attr.add($IDENT.text); })*)? RP { $out.add(new ASD.IntPrototype($nom, $attr)); }//TODO: Ajouter variable
                                                | PROTO VOID IDENT { $nom = $IDENT.text; } LP ((IDENT { $attr.add($IDENT.text); }) (COMMA IDENT { $attr.add($IDENT.text); })*)? RP { $out.add(new ASD.VoidPrototype($nom, $attr)); }))*
    ;

function returns [List<ASD.Function> out] locals [List<String> attr, String nom, String type]
    : {$out = new ArrayList<ASD.Function>(); }
    ( { $attr = new ArrayList<String>(); }
    ( FUNC INT IDENT {$nom = $IDENT.text; } LP ((IDENT { $attr.add($IDENT.text); }) (COMMA IDENT { $attr.add($IDENT.text); })*)? RP b=bloc { $out.add(new ASD.IntFunction($nom, $attr, $b.out)); }
    | FUNC VOID IDENT {$nom = $IDENT.text; } LP ((IDENT { $attr.add($IDENT.text); }) (COMMA IDENT { $attr.add($IDENT.text); })*)? RP b=bloc { $out.add(new ASD.VoidFunction($nom, $attr, $b.out)); }))+
    ;

bloc returns [ASD.Bloc out]
    : v=variable i=instruction { $out = new ASD.Bloc($v.out, $i.out); }
    | LCB v=variable i=instruction RCB { $out = new ASD.Bloc($v.out, $i.out); }
    ;

variable returns [List<ASD.Variable> out]
    : { $out = new ArrayList<ASD.Variable>(); } (INT (IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })
                                                     (COMMA IDENT { $out.add(new ASD.IntegerVariable($IDENT.text)); })*)*
    ;

instruction returns [List<ASD.Instruction> out] locals [List<ASD.Expression> attr, String nom]
    : { $out = new ArrayList<ASD.Instruction>(); } (IDENT AFF e=expression { $out.add(new ASD.AffInstruction($IDENT.text, $e.out)); }//Affectation
                                                    | IF e=expression THEN b=bloc FI { $out.add(new ASD.IfElseInstruction($e.out, $b.out, null)); }//If
                                                    | IF e=expression THEN b1=bloc ELSE b2=bloc FI { $out.add(new ASD.IfElseInstruction($e.out, $b1.out, $b2.out)); }//If Else
                                                    | WHILE e=expression DO b=bloc DONE { $out.add(new ASD.WhileInstruction($e.out, $b.out)); }//While
                                                    | RETURN e=expression { $out.add(new ASD.ReturnInstruction($e.out)); }//Return
                                                    | { $attr = new ArrayList<ASD.Expression>(); } IDENT { $nom = $IDENT.text; } LP (e1=expression { $attr.add($e1.out); } (COMMA e2=expression { $attr.add($e2.out); })*)? RP { $out.add(new ASD.FunctionInstruction($nom, $attr)); }//Fonction
                                                    )*
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

primary returns [ASD.Expression out] locals [List<ASD.Expression> attr, String nom]
    : INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }//Constante dans une expression
    | IDENT { $out = new ASD.VariableExpression($IDENT.text); }//Variable dans une expression
    | { $attr = new ArrayList<ASD.Expression>(); } IDENT { $nom = $IDENT.text; } LP (e1=expression { $attr.add($e1.out); } (COMMA e2=expression { $attr.add($e2.out); })*)? RP { $out = new ASD.FunctionExpression($nom, $attr); }//Fonction dans une expression)*
    | LP e=expression RP { $out = $e.out; }//Expression entre parenthèses
    ;
