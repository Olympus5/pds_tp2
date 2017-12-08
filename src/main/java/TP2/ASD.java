package TP2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

//TODO: Ne pas oublier les précondtions !!!!

/**
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 */
public class ASD {
    public static int level = 0;

    /**
     * Représentation sous forme de classe interne du Variant/Constructeur Program
     */
    static public class Program {
        List<Prototype> p;
        List<Function> f;// What a program contains. TODO : change when you extend the language

        /**
         * Constructor
         */
        public Program(List<Prototype> p, List<Function> f) {
            this.p = p;
            this.f = f;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un programme VSL+
         */
        public String pp() {
            String ret = "";

            for(Prototype prototype : this.p) {
                ret += prototype.pp();
            }

            for(Function func : this.f) {
                ret += func.pp();
            }

            return ret + "\n";
        }

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @return Ensemble d'instructions LLVM
         */
        public Llvm.IR toIR() throws TypeException {
            SymbolTable st = new SymbolTable();
            // TODO : change when you extend the language

            for(Prototype prototype : this.p) {
                prototype.toIR(st);
            }

            Function.RetFunction ret = null;

            for(Function func : this.f) {
                if(ret == null) ret = func.toIR(st);
                else ret.ir.append(func.toIR(st).ir);
            }

            return ret.ir;
        }
    }

    // TODO: All toIR methods returns the IR, plus extra information (synthesized attributes)
    // TODO: They can take extra arguments (inherited attributes)

    /**
     * Représentation sous forme de classe interne du Variant Prototype
     */
    static public abstract class Prototype {
        /**
         * Nom de la fonction
         */
        String ident;

        /**
         * Liste des attributs
         */
        List<String> attributs;

        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attrs Liste des attributs
         */
        public Prototype(String ident, List<String> attributs) {
            this.ident = ident;
            this.attributs = attributs;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un programme VSL+
         */
        public abstract String pp();

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetPrototype toIR(SymbolTable st) throws TypeException;

        /**
         * Représentation de l'état d'une instruction sous forme de classe interne
         */
        static public class RetPrototype {
            /**
             * Instruction LLVM
             */
            public Llvm.IR ir;

            /**
             * Type de la fonction (synthesized)
             */
            public Type type;

            /**
             * Identifiant de la fonction (synthesized)
             */
            public String result;

            /**
             * table des symboles contenant les attributs de la fonction (synthetized)
             */
            public SymbolTable attributsST;

            /**
             * Constructeur
             * @param ir Instruction LLVM
             * @param type Type de la fonction
             * @param result identifiant de la fonction
             * @param attributsST table des symboles contenant les attributs
             */
            public RetPrototype(Llvm.IR ir, Type type, String result, SymbolTable attributsST) {
                this.ir = ir;
                this.type = type;
                this.result = result;
                this.attributsST = attributsST;
            }
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur IntPrototype
     */
    static public class IntPrototype extends Prototype {
        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attrs Liste des attributs
         */
        public IntPrototype(String ident, List<String> attributs) {
            super(ident, attributs);
        }

        @Override
        public String pp() {
            String ret = "PROTO INT " + this.ident + "(";

            for(String attribut : this.attributs) {
                ret += attribut + ", ";
            }

            return ret + ")\n";
        }

        @Override
        public RetPrototype toIR(SymbolTable st) {
            //Ajout des attributs dans une table des symboles
            SymbolTable attributsST = new SymbolTable();

            SymbolTable.VariableSymbol symbolAttr = null;

            for(String attribut : super.attributs) {
                symbolAttr = new SymbolTable.VariableSymbol(new IntType(), attribut);

                if(!attributsST.add(symbolAttr)) {
                    System.err.println("Warning: the symbol '" + attribut + "' has already exist in SymbolTable in this scope.");
                }
            }

            SymbolTable.FunctionSymbol symbol = new SymbolTable.FunctionSymbol(new IntType(), super.ident, attributsST, true);
            String result = "%" + super.ident;//TODO: à enlever si cela ne sert à rien

            RetPrototype ret = new RetPrototype(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), result, attributsST);//TODO: à enlever si cela ne sert à rien

            if(!st.add(symbol)) {
                System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
            }

            //TODO: supprimer lors de la mise en production (rendu final)
            if(!symbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur VoidPrototype
     */
    static public class VoidPrototype extends Prototype {
        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attrs Liste des attributs
         */
        public VoidPrototype(String ident, List<String> attributs) {
            super(ident, attributs);
        }

        @Override
        public String pp() {
            String ret = "PROTO VOID " + this.ident + "(";

            for(String attribut : this.attributs) {
                ret += attribut + ", ";
            }

            return ret + ")\n";
        }

        @Override
        public RetPrototype toIR(SymbolTable st) {
            //Ajout des attributs dans une table des symboles
            SymbolTable attributsST = new SymbolTable();

            SymbolTable.VariableSymbol symbolAttr = null;

            for(String attribut : super.attributs) {
                symbolAttr = new SymbolTable.VariableSymbol(new IntType(), attribut);

                if(!attributsST.add(symbolAttr)) {
                    System.err.println("Warning: the symbol '" + attribut + "' has already exist in SymbolTable in this scope.");
                }
            }

            SymbolTable.FunctionSymbol symbol = new SymbolTable.FunctionSymbol(new VoidType(), super.ident, attributsST, true);
            String result = "%" + super.ident;//TODO: à enlever si cela ne sert à rien

            RetPrototype ret = new RetPrototype(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), result, attributsST);//TODO: à enlever si cela ne sert à rien

            if(!st.add(symbol)) {
                System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
            }

            //TODO: supprimer lors de la mise en production (rendu final)
            if(!symbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Variant Function
     */
    static public abstract class Function {
        /**
         * Nom de la fonction
         */
        String ident;

        /**
         * Liste des attributs
         */
        List<String> attributs;

        /**
         * Corps de la fonction
         */
        Bloc bloc;

        /**
         * Constructeurr
         * @param ident Nom de la fonction
         * @param attributs Liste des attributs
         * @param bloc Corps de la fonction
         */
        public Function(String ident, List<String> attributs, Bloc bloc) {
            this.ident = ident;
            this.attributs = attributs;
            this.bloc = bloc;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un programme VSL+
         */
        public abstract String pp();

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @param st Table des symboles principale
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetFunction toIR(SymbolTable st) throws TypeException;

        /**
         * Représentation de l'état d'une instruction sous forme de classe interne
         */
        static public class RetFunction {
            /**
             * Instruction LLVM
             */
            public Llvm.IR ir;

            /**
             * Type de la fonction (synthesized)
             */
            public Type type;

            /**
             * Identifiant de la fonction (synthesized)
             */
            public String name;

            /**
             * Constructeur
             * @param ir Instruction LLVM
             * @param type Type de la fonction
             * @param name Nom de la fonction
             */
            public RetFunction(Llvm.IR ir, Type type, String name) {
                this.ir = ir;
                this.type = type;
                this.name = name;
            }
        }
    }

    /**
     * Représentation sous forme de classe interne d'un Constructeur IntFunction
     */
    static public class IntFunction extends Function {

        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attributs Liste des attributs de la fonction
         * @param bloc Bloc principal de la fonction
         */
        public IntFunction(String ident, List<String> attributs, Bloc bloc) {
            super(ident, attributs, bloc);
        }

        @Override
        public String pp() {
            String ret = "FUNC INT " + super.ident + "(";

            for(String attribut : this.attributs) {
                ret += attribut + ", ";
            }

            return ret + ")\n" + super.bloc.pp();
        }

        @Override
        public RetFunction toIR(SymbolTable st) throws TypeException {
            SymbolTable.FunctionSymbol symbol = (SymbolTable.FunctionSymbol) st.lookup(super.ident);

            if(!super.ident.equals("main")) {//On verifie bien que la fonction est dans la table des symboles sauf pour le main
                if(symbol == null) {
                    System.err.println("Error: the symbol '" + super.ident + "' doesn't exist in the symbol table.");
                    System.exit(0);
                } else {
                    if (!new IntType().equals(symbol.returnType)) {//On verifie que le type est toujours le même
                        throw new TypeException("type mismatch: have " + symbol.returnType + " and " + new IntType());
                    }

                    for(String attribut : this.attributs) {//Maintenant on verifie que les attributs
                        if(symbol.arguments.lookup(attribut) == null) {
                            System.err.println("Error: the symbol '" + attribut + "' doesn't exist in the attribut symbol table.");
                            System.exit(0);
                        }
                    }
                }
            } else {
                SymbolTable.FunctionSymbol mainSymbol = new SymbolTable.FunctionSymbol(new IntType(), super.ident, new SymbolTable(), true);
                if(!st.add(mainSymbol)) {
                    System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
                }

                //TODO: supprimer lors de la mise en production (rendu final)
                if(!mainSymbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");
            }

            String name = "@" + super.ident;
            String result = "%return";
            String entryLabel = Utils.newlab("entry");
            String tmpRetour = Utils.newtmp();

            RetFunction ret = new RetFunction((new Llvm.IR(Llvm.empty(), Llvm.empty())), new IntType(), name);

            Llvm.Instruction decl = new Llvm.Define(ret.type.toLlvmType(), ret.name, this.attributs);
            Llvm.Instruction entry = new Llvm.Label(entryLabel);
            Llvm.Instruction allocaRetour = new Llvm.Alloca(ret.type.toLlvmType(), result);
            Llvm.Instruction  loadRetour = new Llvm.Load(tmpRetour, ret.type.toLlvmType(), ret.type.toLlvmType(), result);

            List<Llvm.Instruction> allocaAttributs = new ArrayList<Llvm.Instruction>();

            for(String attribut : super.attributs) {
                allocaAttributs.add(new Llvm.Alloca(new IntType().toLlvmType(), "%" + attribut + "1"));
            }

            Llvm.Instruction retour = new Llvm.Return(ret.type.toLlvmType(), tmpRetour);

            ret.ir.appendCode(decl);
            ret.ir.appendCode(entry);
            ret.ir.appendCode(allocaRetour);//TODO la gestion de l'instruction retour (Quand on rencontre une ligne du type "RETURN n")

            for(Llvm.Instruction attribut : allocaAttributs) {
                ret.ir.appendCode(attribut);
            }

            ret.ir.append(super.bloc.toIR(st, super.ident));
            ret.ir.appendCode(loadRetour);
            ret.ir.appendCode(retour);

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne d'un Constructeur VoidFunction
     */
    static public class VoidFunction extends Function {

        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attributs Liste des attributs de la fonction
         * @param bloc Bloc principal de la fonction
         */
        public VoidFunction(String ident, List<String> attributs, Bloc bloc) {
            super(ident, attributs, bloc);
        }

        @Override
        public String pp() {
            String ret = "FUNC VOID " + super.ident + "(";

            for(String attribut : this.attributs) {
                ret += attribut + ", ";
            }

            return ret + ")\n" + super.bloc.pp();
        }

        @Override
        public RetFunction toIR(SymbolTable st) throws TypeException {
            SymbolTable.FunctionSymbol symbol = (SymbolTable.FunctionSymbol) st.lookup(super.ident);

            if(!super.ident.equals("main")) {//On verifie bien que la fonction est dans la table des symboles sauf pour le main
                if(symbol == null) {
                    System.err.println("Error: the symbol '" + super.ident + "' doesn't exist in the symbol table.");
                    System.exit(0);
                } else {
                    if (!new VoidType().equals(symbol.returnType)) {//On verifie que le type est toujours le même
                        throw new TypeException("type mismatch: have " + symbol.returnType + " and " + new VoidType());
                    }

                    for(String attribut : this.attributs) {//Maintenant on verifie que les attributs
                        if(symbol.arguments.lookup(attribut) == null) {
                            System.err.println("Error: the symbol '" + super.ident + "' doesn't exist in the attribut symbol table.");
                            System.exit(0);
                        }
                    }
                }
            } else {
                SymbolTable.FunctionSymbol mainSymbol = new SymbolTable.FunctionSymbol(new VoidType(), super.ident, new SymbolTable(), true);
                if(!st.add(mainSymbol)) {
                    System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
                }

                //TODO: supprimer lors de la mise en production (rendu final)
                if(!mainSymbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");
            }

            String name = "@" + super.ident;
            String entryLabel = Utils.newlab("entry");

            RetFunction ret = new RetFunction((new Llvm.IR(Llvm.empty(), Llvm.empty())), new VoidType(), name);

            Llvm.Instruction decl = new Llvm.Define(ret.type.toLlvmType(), ret.name, this.attributs);
            Llvm.Instruction entry = new Llvm.Label(entryLabel);

            List<Llvm.Instruction> varAttributs = new ArrayList<Llvm.Instruction>();

            for(String attribut : super.attributs) {
                varAttributs.add(new Llvm.Alloca(new IntType().toLlvmType(), "%" + attribut + "1"));
            }

            Llvm.Instruction retour = new Llvm.Return(ret.type.toLlvmType(), "");

            ret.ir.appendCode(decl);
            ret.ir.appendCode(entry);

            for(Llvm.Instruction attribut : varAttributs) {
                ret.ir.appendCode(attribut);
            }

            ret.ir.append(super.bloc.toIR(st, super.ident));
            ret.ir.appendCode(retour);

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Variant/Constructeur Program
     */
    static public class Bloc {
        List<Variable> variables;
        List<Instruction> instructions; // What a program contains. TODO : change when you extend the language

        /**
         * Constructor
         * @param variables Liste des variables déclaré dans le bloc
         * @param instructions Liste des instructions du bloc
         */
        public Bloc(List<Variable> variables, List<Instruction> instructions) {
            this.variables = variables;
            this.instructions = instructions;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un bloc VSL+
         */
        public String pp() {
            String ret = Utils.indent(level) + "{\n";

            level++;

            if(!this.variables.isEmpty()) ret += Utils.indent(level) + "INT ";

            for(Variable variable : this.variables) {
                ret += variable.pp() + ", ";
            }

            ret += "\n";

            for(Instruction instruction : this.instructions) {
                ret += Utils.indent(level) + instruction.pp() + "\n";
            }

            level--;

            return ret + Utils.indent(level) + "\n}\n";
        }

        /**
         * Générateur d'un ensemble d'instructions LLVM (autre bloc)
         * @param st Table des symboles du scope précédent
         * @param func Nom de la fonction où on se situe
         * @return Ensemble d'instructions LLVM
         */
        public Llvm.IR toIR(SymbolTable st, String func) throws TypeException {
            SymbolTable scope = new SymbolTable(st);
            Llvm.IR retIr = new Llvm.IR(Llvm.empty() , Llvm.empty());

            Variable.RetVariable retVar = null;

            for(Variable variable : this.variables) {
                if(retVar == null) retVar = variable.toIR(scope, func);
                else retVar.ir.append(variable.toIR(scope, func).ir);
            }

            if(retVar != null) retIr.append(retVar.ir);

            // computes the IR of the instruction
            Instruction.RetInstruction retInst = null;

            for(Instruction instruction : this.instructions) {
                if(retInst == null) retInst = instruction.toIR(scope, func);
                else retInst.ir.append(instruction.toIR(scope, func).ir);
            }

            if(retInst != null) retIr.append(retInst.ir);

            return retIr;
        }
    }

    /**
     * Représentation sous forme de classe interne du Variant Expression
     */
    static public abstract class Expression {
        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'une expression VSL+
         */
        public abstract String pp();

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @param st Table des symboles du scope
         * @param func Nom de la fonction où on se situe
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetExpression toIR(SymbolTable st, String func) throws TypeException;

        // TODO: Object returned by toIR on expressions, with IR + synthesized attributes
        /**
         * Représentation de l'état d'une instruction sous forme de classe interne
         */
        static public class RetExpression {
            /**
             * LLVM instruction
             */
            public Llvm.IR ir;

            /**
             * Type de l'expression (synthesized)
             */
            public Type type;

            /**
             * Resultat de l'expression (synthesized)
             * La valeur est soit un ident ou une valeur "immediate"
             */
            public String result;

            /**
             * Constructeur
             * @param ir Instruction LLVM
             * @param type Type de l'expression
             * @param result Resultat de l'expression
             */
            public RetExpression(Llvm.IR ir, Type type, String result) {
                this.ir = ir;
                this.type = type;
                this.result = result;
            }
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur AddExpression
     */
    static public class AddExpression extends Expression {
        /**
         * Expression gauche
         */
        Expression left;

        /**
         * Expression droite
         */
        Expression right;

        /**
         * Constructeur
         * @param left Partie gauche de l'addition
         * @param right Partie droite de l'addition
         */
        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String pp() {
            return "(" + left.pp() + " + " + right.pp() + ")";
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) throws TypeException {
            RetExpression leftRet = left.toIR(st, func);
            RetExpression rightRet = right.toIR(st, func);

            // We check if the types mismatches
            if (!leftRet.type.equals(rightRet.type)) {
                throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
            }

            // We base our build on the left generated IR:
            // append right code
            leftRet.ir.append(rightRet.ir);

            // allocate a new identifier for the result
            String result = Utils.newtmp();

            // new add instruction result = left + right
            Llvm.Instruction add = new Llvm.Add(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

            // append this instruction
            leftRet.ir.appendCode(add);

            // return the generated IR, plus the type of this expression
            // and where to find its result
            return new RetExpression(leftRet.ir, leftRet.type, result);
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur SubExpression
     */
    static public class SubExpression extends Expression {
        /**
         * Expression gauche
         */
        Expression left;

        /**
         * Expression droite
         */
        Expression right;

        /**
         * Constructeur
         * @param left Partie gauche de la soustraction
         * @param right Partie droite de la soustraction
         */
        public SubExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String pp() {
            return "(" + left.pp() + " - " + right.pp() + ")";
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) throws TypeException {
            RetExpression leftRet = left.toIR(st, func);
            RetExpression rightRet = right.toIR(st, func);

            if (!leftRet.type.equals(rightRet.type)) {
                throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
            }

            leftRet.ir.append(rightRet.ir);

            String result = Utils.newtmp();

            Llvm.Instruction sub = new Llvm.Sub(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

            leftRet.ir.appendCode(sub);

            return new RetExpression(leftRet.ir, leftRet.type, result);
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur MulExpression
     */
    static public class MulExpression extends Expression {
        /**
         * Expression gauche
         */
        Expression left;

        /**
         * Expression droite
         */
        Expression right;

        /**
         * Constructeur
         * @param left Partie gauche de la multiplication
         * @param right Partie droite de la multiplication
         */
        public MulExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String pp() {
            return "(" + left.pp() + " * " + right.pp() + ")";
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) throws TypeException {
            RetExpression leftRet = left.toIR(st, func);
            RetExpression rightRet = right.toIR(st, func);

            if (!leftRet.type.equals(rightRet.type)) {
                throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
            }

            leftRet.ir.append(rightRet.ir);

            String result = Utils.newtmp();

            Llvm.Instruction mul = new Llvm.Mul(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

            leftRet.ir.appendCode(mul);

            return new RetExpression(leftRet.ir, leftRet.type, result);
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur DivExpression
     */
    static public class DivExpression extends Expression {
        /**
         * Expression gauche
         */
        Expression left;

        /**
         * Expression droite
         */
        Expression right;

        /**
         * Constructeur
         * @param left Partie gauche de la division
         * @param right Partie droite de la division
         */
        public DivExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String pp() {
            return "(" + left.pp() + " / " + right.pp() + ")";
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) throws TypeException {
            RetExpression leftRet = left.toIR(st, func);
            RetExpression rightRet = right.toIR(st, func);

            if (!leftRet.type.equals(rightRet.type)) {
                throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
            }

            leftRet.ir.append(rightRet.ir);

            String result = Utils.newtmp();

            Llvm.Instruction div = new Llvm.Div(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

            leftRet.ir.appendCode(div);

            return new RetExpression(leftRet.ir, leftRet.type, result);
        }
    }

    // Concrete class for Expression: constant (integer) case
    /**
     * Représentation sous forme de classe interne du Constructeur IntegerExpression
     */
    static public class IntegerExpression extends Expression {
        /**
         * Valeur de l'entier
         */
        int value;

        /**
         * Constructeur
         * @param value Valeur de la constante
         */
        public IntegerExpression(int value) {
            this.value = value;
        }

        @Override
        public String pp() {
            return "" + this.value;
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) {
            // Here we simply return an empty IR
            // the `result' of this expression is the integer itself (as string)
            return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), "" + this.value);
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur VariableExpression
     */
    static public class VariableExpression extends Expression {
        /**
         * Nom de la variable
         */
        String ident;

        /**
         * Constructeur
         * @param ident Nom de la variable dans l'expression
         */
        public VariableExpression(String ident) {
            this.ident = ident;
        }

        @Override
        public String pp() {
            return "" + this.ident;
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) {
            SymbolTable.VariableSymbol identSymbol = (SymbolTable.VariableSymbol) st.lookup(this.ident);
            String ident = "";

            if(identSymbol == null) {// On check si on trouve la variable dans la table des symboles
                SymbolTable.FunctionSymbol funcSymbol = (SymbolTable.FunctionSymbol) st.lookup(func);//Si pas trouvé, on récupère la fonction dans la table des symboles

                if(funcSymbol != null) {//Je dois renvoyer une erreur ???
                    identSymbol = (SymbolTable.VariableSymbol) funcSymbol.arguments.lookup(this.ident);//On check dans sa table des attributs

                    if(identSymbol == null) {//Message d'erreur si vrai
                        System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the arguments table.");//TODO: si il n'est pas dans la table symb ça se peut que ce soit un attribut d'une fonction
                        System.exit(0);
                    } else {
                        ident = "%" + identSymbol.ident;
                        ident += "1";//On récupère un argument (cf. poly TP2: code LLVM) !!!!
                    }
                }
            } else {
                ident = "%" + identSymbol.ident;
            }

            String result = Utils.newtmp();

            RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), identSymbol.type, result);

            Llvm.Instruction load = new Llvm.Load(result, identSymbol.type.toLlvmType(), identSymbol.type.toLlvmType(), ident);

            ret.ir.appendCode(load);

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur FonctionExpression
     */
    static public class FunctionExpression extends Expression {
        /**
         * Nom de la fonction
         */
        String ident;

        /**
         * Valeurs des attributs
         */
        List<Expression> attributs;

        /**
         * Constructeur
         * @param ident Nom de la fonction dans l'expression
         * @param attributs Valeurs des attributs
         */
        public FunctionExpression(String ident, List<Expression> attributs) {
            this.ident = ident;
            this.attributs = attributs;
        }

        @Override
        public String pp() {
            String ret = this.ident + "(";

            for(Expression attribut : this.attributs) {
                ret += attribut.pp() + ", ";
            }

            return ret + ")";
        }

        @Override
        public RetExpression toIR(SymbolTable st, String func) throws TypeException {
            SymbolTable.FunctionSymbol identSymbol = (SymbolTable.FunctionSymbol) st.lookup(this.ident);
            String ident = "";

            if(identSymbol == null) {// On check si on trouve la variable dans la table des symboles
                System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the symbol table.");//TODO: si il n'est pas dans la table symb ça se peut que ce soit un attribut d'une fonction
                System.exit(0);
            }

            if(this.attributs.size() != identSymbol.arguments.size()) {
                System.err.println("Error: ");
                System.exit(0);
            }//Gestion des arguments de la fonction

            Hashtable<String, Llvm.Type> attrTypes = new Hashtable<String, Llvm.Type>();
            List<String> attr = new ArrayList<String>();

            String result = Utils.newtmp();

            RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), identSymbol.returnType, result);
            RetExpression tmp = null;

            for(Expression attribut : this.attributs) {
                tmp = attribut.toIR(st, func);
                ret.ir.append(tmp.ir);
                attr.add(tmp.result);
                attrTypes.put(tmp.result, tmp.type.toLlvmType());
            }

            Llvm.Instruction call = new Llvm.Call(result, identSymbol.returnType.toLlvmType(), "@" + this.ident, attr, attrTypes);

            ret.ir.appendCode(call);

            return ret;
        }
    }

    /**
     * Représenation sous forme de classe interne du variant Variable
     */
    static public abstract class Variable {
        /**
         * Nom de la variable
         */
        String ident;

        public Variable(String ident) {
            if(ident.equals("return")) {
                System.err.println("Warning: '"+ ident +"' is a reserved keyword.");
            }

            this.ident = ident;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'une variable VSL+
         */
        public abstract String pp();

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @param st Table des symboles du scope
         * @param func Nom de la fonction où on se situe
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetVariable toIR(SymbolTable st, String func) throws TypeException;

        /**
         * Représentation de l'état d'une instruction sous forme de classe interne
         */
        static public class RetVariable {
            /**
             * LLVM instruction
             */
            public Llvm.IR ir;

            /**
             * Type de la variable (synthesized)
             */
            public Type type;

            /**
             * Identifiant de la variable (synthesized)
             */
            public String result;

            /**
             * Constructeur
             * @param ir L'instruction LLVM
             * @param type Le type de la variable
             * @param result Le nom de la variable
             */
            public RetVariable(Llvm.IR ir, Type type, String result) {
                this.ir = ir;
                this.type = type;
                this.result = result;
            }
        }
    }

    /**
     * Représenation sous forme de classe interne du Constructeur IntegerVariable
     */
    static public class IntegerVariable extends Variable {
        /**
         * Constructeur
         * @param ident Le nom de la variable
         */
        public IntegerVariable(String ident) {
            super(ident);
        }

        @Override
        public String pp() {
            return "" + super.ident;
        }

        @Override
        public RetVariable toIR(SymbolTable st, String func) {
            SymbolTable.FunctionSymbol funcSymbol = (SymbolTable.FunctionSymbol) st.lookup(func);

            if(funcSymbol != null) {
                if(funcSymbol.arguments.lookup(super.ident) != null) {
                    System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable of attributs.");
                }
            }

            SymbolTable.VariableSymbol symbol = new SymbolTable.VariableSymbol(new IntType(), super.ident);
            String result = "%" + super.ident;

            RetVariable ret = new RetVariable(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), result);

            if(!st.add(symbol)) {
                System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
            }

            Llvm.Instruction alloca = new Llvm.Alloca(new IntType().toLlvmType(), result);

            ret.ir.appendCode(alloca);

            //TODO: supprimer lors de la mise en production (rendu final)
            if(!symbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");

            return ret;
        }
    }

    /**
     * Représenation sous forme de classe interne du Constructeur ArrayVariable
     */
    static public class ArrayVariable extends Variable {
        /**
         * Taille du tableau
         */
        int size;

        /**
         * Constructeur
         * @param ident Le nom de la variable
         * @param size Taille du tableau
         */
        public ArrayVariable(String ident, int size) {
            super(ident);
            this.size = size;
        }

        @Override
        public String pp() {
            return "" + super.ident + "[" + this.size + "]";
        }

        @Override
        public RetVariable toIR(SymbolTable st, String func) {
            SymbolTable.FunctionSymbol funcSymbol = (SymbolTable.FunctionSymbol) st.lookup(func);

            if(funcSymbol != null) {
                if(funcSymbol.arguments.lookup(super.ident) != null) {
                    System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable of attributs.");
                }
            }

            SymbolTable.VariableSymbol symbol = new SymbolTable.VariableSymbol(new IntType(), super.ident);
            String result = "%" + super.ident;

            RetVariable ret = new RetVariable(new Llvm.IR(Llvm.empty(), Llvm.empty()), new ArrayType(new IntType(), this.size), result);

            if(!st.add(symbol)) {
                System.err.println("Warning: the symbol '" + super.ident + "' has already exist in SymbolTable in this scope.");
            }

            Llvm.Instruction alloca = new Llvm.Alloca(new ArrayType(new IntType(), this.size).toLlvmType(), result);

            ret.ir.appendCode(alloca);

            //TODO: supprimer lors de la mise en production (rendu final)
            if(!symbol.equals(st.lookup(super.ident))) System.err.println("La variable '" + super.ident + "' doit être dans la table des symboles");

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Variant Instruction
     */
    static public abstract class Instruction {
        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'une instruction VSL+
         */
        public abstract String pp();

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @param st Table des symboles du scope
         * @param func Nom de la fonction où on se situe
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetInstruction toIR(SymbolTable st, String func) throws TypeException;

        /**
         * Représentation de l'état d'une instruction sous forme de classe interne
         */
        static public class RetInstruction {
            /**
             * LLVM instruction
             */
            public Llvm.IR ir;

            /**
             * Resultat de l'instruction (synthetized)
             */
            public String result;

            /**
             * Constructeur
             * @param ir L'instruction LLVM
             * @param result Le resultat de l'instruction
             */
            public RetInstruction(Llvm.IR ir, String result) {
                this.ir = ir;
                this.result = result;
            }
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur AffInstruction
     */
    static public class AffInstruction extends Instruction {
        /**
         * Nom de la variable à qui on affecte la partie droite de l'instruction
         */
        String ident;

        /**
         * Partie droite de l'affectation
         */
        Expression expression;

        /**
         * Constructeur
         * @param ident Le nom de la variable à qui on affection expression
         * @param expression L'expression à affecter
         */
        public AffInstruction(String ident, Expression expression) {
            this.ident = ident;
            this.expression = expression;
        }

        @Override
        public String pp() {
            return this.ident + " := " + this.expression.pp();
        }

        @Override
        public RetInstruction toIR(SymbolTable st, String func) throws TypeException {
            //TODO: gérer le principe qu'une variable peut avoir le même nom qu'une fonction
            //TODO: gérer un bloc imbriqué dans un bloc
            SymbolTable.VariableSymbol identSymbol = (SymbolTable.VariableSymbol) st.lookup(this.ident);
            String ident = "";

            if(identSymbol == null) {// On check si on trouve la variable dans la table des symboles
                SymbolTable.FunctionSymbol funcSymbol = (SymbolTable.FunctionSymbol) st.lookup(func);//Si pas trouvé, on récupère la fonction dans la table des symboles

                if(funcSymbol != null) {//Je dois renvoyer une erreur ???
                    identSymbol = (SymbolTable.VariableSymbol) funcSymbol.arguments.lookup(this.ident);//On check dans sa table des attributs

                    if(identSymbol == null) {//Message d'erreur si vrai
                        System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the symbol table.");//si il n'est pas dans la table symb ça se peut que ce soit un attribut d'une fonction
                        System.exit(0);
                    } else {
                        ident = "%" + identSymbol.ident;
                        ident += "1"; // On récupère un argument (cf. poly TP2: code LLVM) !!!!
                    }
                }
            } else {
                ident = "%" + identSymbol.ident;
            }

            Expression.RetExpression retExpr = expression.toIR(st, func);

            if (!identSymbol.type.equals(retExpr.type)) {
                throw new TypeException("type mismatch: have " + identSymbol.type + " and " + retExpr.type);
            }

            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), ident);

            ret.ir.append(retExpr.ir);

            Llvm.Instruction store = new Llvm.Store(retExpr.type.toLlvmType(), retExpr.result, identSymbol.type.toLlvmType(), ident);

            ret.ir.appendCode(store);

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur IfElseInstruction
     */
    static public class IfElseInstruction extends Instruction {
        /**
         * Condition
         */
        Expression expression;

        /**
         * Bloc du if
         */
        Bloc bloc1;

        /**
         * Bloc du else
         */
        Bloc bloc2;

        /**
         * Constructeur
         * @param expression La condition
         * @param bloc1 Le bloc du if
         * @param bloc2 Si différents de null bloc du else, sinon rien
         */
        public IfElseInstruction(Expression expression, Bloc bloc1, Bloc bloc2) {
            this.expression = expression;
            this.bloc1 = bloc1;
            this.bloc2 = bloc2;
        }

        @Override
        public String pp() {
            String ret = Utils.indent(level) + "IF " + this.expression.pp() + "\n";
            ret += Utils.indent(level) + "THEN\n";
            ret += this.bloc1.pp();

            if(bloc2 != null) {//Si il y a un else
                ret += Utils.indent(level) + "ELSE\n";
                ret += this.bloc2.pp();
            }

            return ret + Utils.indent(level) + "\nFI";
        }

        @Override
        public RetInstruction toIR(SymbolTable st, String func) throws TypeException {
            Expression.RetExpression cond = this.expression.toIR(st, func);

            if (!cond.type.equals(new IntType())) {
                throw new TypeException("type mismatch: have " + cond.type + " and " + new IntType());
            }

            String result = Utils.newtmp();
            String si = Utils.newlab("if");
            String sinon = Utils.newlab("else");
            String finsi = Utils.newlab("fi");

            Llvm.Instruction icmp = new Llvm.Icmp(result, cond.type.toLlvmType(), cond.result);
            Llvm.Instruction brCond = null;

            if(this.bloc2 != null) {//Si il y a un else
                brCond = new Llvm.BrCond(result, "%" + si, "%" + sinon);
            } else {
                brCond = new Llvm.BrCond(result, "%" + si, "%" + finsi);
            }

            Llvm.Instruction brUncond = new Llvm.BrUncond("%" + finsi);

            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), result);

            ret.ir.append(cond.ir);
            ret.ir.appendCode(icmp);
            ret.ir.appendCode(brCond);
            ret.ir.appendCode(new Llvm.Label(si));
            ret.ir.append(this.bloc1.toIR(st, func));
            ret.ir.appendCode(brUncond);

            if(this.bloc2 != null) {//Si il y a un else
                ret.ir.appendCode(new Llvm.Label(sinon));
                ret.ir.append(this.bloc2.toIR(st, func));
                ret.ir.appendCode(brUncond);
            }

            ret.ir.appendCode(new Llvm.Label(finsi));

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur WhileInstruction
     */
    static public class WhileInstruction extends Instruction {
        /**
         * Condition
         */
        Expression expression;

        /**
         * Bloc de la boucle
         */
        Bloc bloc;

        /**
         * Constructeur
         * @param expression La condition
         * @param bloc Le corps de la boucle
         */
        public WhileInstruction(Expression expression, Bloc bloc) {
            this.expression = expression;
            this.bloc = bloc;
        }

        @Override
        public String pp() {
            String ret = Utils.indent(level) + "WHILE " + this.expression.pp() + "\n";

            ret += Utils.indent(level) + "DO\n";
            ret += this.bloc.pp();

            return ret + Utils.indent(level) + "DONE\n";
        }

        @Override
        public RetInstruction toIR(SymbolTable st, String func) throws TypeException {
            Expression.RetExpression cond = this.expression.toIR(st, func);

            if (!cond.type.equals(new IntType())) {
                throw new TypeException("type mismatch: have " + cond.type + " and " + new IntType());
            }

            String result = Utils.newtmp();
            String tantque = Utils.newlab("while");
            String faire = Utils.newlab("do");
            String fait = Utils.newlab("done");

            Llvm.Instruction icmp = new Llvm.Icmp(result, cond.type.toLlvmType(), cond.result);
            Llvm.Instruction brCond = new Llvm.BrCond(result, "%" + faire, "%" + fait);
            Llvm.Instruction brUncond = new Llvm.BrUncond("%" + tantque);

            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), result);

            ret.ir.appendCode(brUncond);
            ret.ir.appendCode(new Llvm.Label(tantque));
            ret.ir.append(cond.ir);
            ret.ir.appendCode(icmp);
            ret.ir.appendCode(brCond);
            ret.ir.appendCode(new Llvm.Label(faire));
            ret.ir.append(this.bloc.toIR(st, func));
            ret.ir.appendCode(brUncond);
            ret.ir.appendCode(new Llvm.Label(fait));

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur WhileInstruction
     */
    static public class ReturnInstruction extends Instruction {

        /**
         * Expression à retourner
         */
        Expression expression;

        /**
         * Constructeur
         * @param expression Expression à retourner
         */
        public ReturnInstruction(Expression expression) {
            this.expression = expression;
        }

        @Override
        public String pp() {
            return Utils.indent(level) + "RETURN " + this.expression.pp();
        }

        @Override
        public RetInstruction toIR(SymbolTable st, String func) throws TypeException {
            Expression.RetExpression retExpr = this.expression.toIR(st, func);
            SymbolTable.FunctionSymbol funcSymbol = (SymbolTable.FunctionSymbol) st.lookup(func);

            if(funcSymbol == null) {//On regarde que la fonction est bien déclaré dans la table des symboles
                System.err.println("Error: the symbol '" + func + "' doesn't exist in the symbol table.");//si il n'est pas dans la table symb ça se peut que ce soit un attribut d'une fonction
                System.exit(0);
            }

            System.err.println(func);

            if(!retExpr.type.equals(funcSymbol.returnType)) {//Maintenant on check si le type de l'expression à retourner est égale au type de retour de la fonction
                throw new TypeException("type mismatch: have " + retExpr.type + " and " + funcSymbol.returnType);
            }

            String result = "%return";
            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), result);

            //TODO: Affecter le résultat de l'expression à %return
            Llvm.Instruction store = new Llvm.Store(retExpr.type.toLlvmType(), retExpr.result, funcSymbol.returnType.toLlvmType(), result);

            ret.ir.append(retExpr.ir);
            ret.ir.appendCode(store);

            return ret;
        }
    }

    /**
     * Représentation sous forme de classe interne du Constructeur FonctionInstruction
     */
    static public class FunctionInstruction extends Instruction {
        /**
         * Nom de la fonction
         */
        String ident;

        /**
         * Valeurs des attributs
         */
        List<Expression> attributs;

        /**
         * Constructeur
         * @param ident Nom de la fonction
         * @param attributs Valeurs des attributs
         */
        public FunctionInstruction(String ident, List<Expression> attributs) {
            this.ident = ident;
            this.attributs = attributs;
        }

        @Override
        public String pp() {
            String ret = this.ident + "(";

            for(Expression attribut : this.attributs) {
                ret += attribut.pp() + ", ";
            }

            return ret + ")";
        }

        @Override
        public RetInstruction toIR(SymbolTable st, String func) throws TypeException {
            SymbolTable.FunctionSymbol identSymbol = (SymbolTable.FunctionSymbol) st.lookup(this.ident);
            String ident = "";

            if(identSymbol == null) {// On check si on trouve la variable dans la table des symboles
                System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the symbol table.");//TODO: si il n'est pas dans la table symb ça se peut que ce soit un attribut d'une fonction
                System.exit(0);
            }

            if(this.attributs.size() != identSymbol.arguments.size()) {
                System.err.println("Error: number of parameters.");
                System.exit(0);
            }//Gestion des arguments de la fonction

            Hashtable<String, Llvm.Type> attrTypes = new Hashtable<String, Llvm.Type>();
            List<String> attr = new ArrayList<String>();

            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), "");
            Expression.RetExpression tmp = null;

            for(Expression attribut : this.attributs) {
                tmp = attribut.toIR(st, func);
                ret.ir.append(tmp.ir);
                attr.add(tmp.result);
                attrTypes.put(tmp.result, tmp.type.toLlvmType());
            }

            Llvm.Instruction call = new Llvm.Call("", identSymbol.returnType.toLlvmType(), "@" + this.ident, attr, attrTypes);

            ret.ir.appendCode(call);

            return ret;
        }
    }


    /**
     * Représentation du type entier coté ASD (Attention: ne pas confondre avec les types LLVM)
     */
    static public abstract class Type {
        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un type VSL+
         */
        public abstract String pp();

        /**
         * Transforme un type ASD en type LLVM
         * @return Le type LLVM
         */
        public abstract Llvm.Type toLlvmType();
    }

    /**
     * Représentation du type entier coté ASD (Attention: ne pas confondre avec les types LLVM)
     */
    static class IntType extends Type {
        @Override
        public String pp() {
            return "INT";
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof IntType;
        }

        @Override
        public Llvm.Type toLlvmType() {
            return new Llvm.IntType();
        }
    }

    /**
     * Représentation du type entier coté ASD (Attention: ne pas confondre avec les types LLVM)
     */
    static class VoidType extends Type {
        @Override
        public String pp() {
            return "VOID";
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof VoidType;
        }

        @Override
        public Llvm.Type toLlvmType() {
            return new Llvm.VoidType();
        }
    }

    /**
     * Représentation du type tableau coté ASD (Attention: ne pas confondre avec les types LLVM)
     */
    static class ArrayType extends Type {
        /**
         * Type des éléments du tableau
         */
        Type type;

        /**
         * Taille du tableau
         */
        int size;

        /**
         * Constructeur
         * @param type Type des éléments du tableau
         * @param size Taille des éléments du tableau
         */
        public ArrayType(Type type, int size) {
            this.type = type;
            this.size = size;
        }

        @Override
        public String pp() {
            return "";
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof ArrayType) {
                return ((ArrayType) obj).type.equals(this.type);
            }

            return false;
        }

        @Override
        public Llvm.Type toLlvmType() {
            return new Llvm.ArrayType(this.type.toLlvmType(), this.size);
        }
    }
}
