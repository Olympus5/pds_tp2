package TP2;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 */
public class ASD {
    public static int level = 0;

    /**
     * Représentation sous forme de classe interne du Variant/Constructeur Program
     */
    static public class Program {
        Bloc b;// What a program contains. TODO : change when you extend the language

        /**
         * Constructor
         */
        public Program(Bloc b) {
            this.b = b;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un programme VSL+
         */
        public String pp() {
            return this.b.pp();
        }

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @return Ensemble d'instructions LLVM
         */
        public Llvm.IR toIR() throws TypeException {
            SymbolTable st = new SymbolTable();
            // TODO : change when you extend the language

            return b.toIR(st);
        }
    }

    // TODO: All toIR methods returns the IR, plus extra information (synthesized attributes)
    // TODO: They can take extra arguments (inherited attributes)

    /**
     * Représentation sous forme de classe interne du Variant/Constructeur Program
     */
    static public class Bloc {
        List<Variable> variables;
        List<Instruction> instructions; // What a program contains. TODO : change when you extend the language

        /**
         * Constructor
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

            ret += Utils.indent(level) + "INT ";

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
         * Générateur d'un ensemble d'instructions LLVM
         * @return Ensemble d'instructions LLVM
         */
        public Llvm.IR toIR(SymbolTable st) throws TypeException {
            SymbolTable scope = new SymbolTable(st);
            Llvm.IR retIr = new Llvm.IR(Llvm.empty() , Llvm.empty());

            Variable.RetVariable retVar = null;

            for(Variable variable : this.variables) {
                if(retVar == null) retVar = variable.toIR(scope);
                else retVar.ir.append(variable.toIR(scope).ir);
            }

            if(retVar != null) retIr.append(retVar.ir);

            // computes the IR of the instruction
            Instruction.RetInstruction retInst = null;

            for(Instruction instruction : this.instructions) {
                if(retInst == null) retInst = instruction.toIR(scope);
                else retInst.ir.append(instruction.toIR(scope).ir);
            }

            if(retInst != null) retIr.append(retInst.ir);

            // add a return instruction
            if(level == 0) {
                Llvm.Instruction ret = new Llvm.Return(new IntType().toLlvmType(), "0");//TODO: Modifier "0" quand les retours seront pris en compte
                retIr.appendCode(ret);
            }

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
         * * @return Ensemble d'instructions LLVM
         */
        public abstract RetExpression toIR(SymbolTable st) throws TypeException;

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
        public RetExpression toIR(SymbolTable st) throws TypeException {
            RetExpression leftRet = left.toIR(st);
            RetExpression rightRet = right.toIR(st);

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
        public RetExpression toIR(SymbolTable st) throws TypeException {
            RetExpression leftRet = left.toIR(st);
            RetExpression rightRet = right.toIR(st);

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
        public RetExpression toIR(SymbolTable st) throws TypeException {
            RetExpression leftRet = left.toIR(st);
            RetExpression rightRet = right.toIR(st);

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
        public RetExpression toIR(SymbolTable st) throws TypeException {
            RetExpression leftRet = left.toIR(st);
            RetExpression rightRet = right.toIR(st);

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
         */
        public IntegerExpression(int value) {
            this.value = value;
        }

        @Override
        public String pp() {
            return "" + this.value;
        }

        @Override
        public RetExpression toIR(SymbolTable st) {
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
         */
        public VariableExpression(String ident) {
            this.ident = ident;
        }

        @Override
        public String pp() {
            return "" + this.ident;
        }

        @Override
        public RetExpression toIR(SymbolTable st) {
            SymbolTable.VariableSymbol identSymbol = (SymbolTable.VariableSymbol) st.lookup(this.ident);

            if(identSymbol == null) {
                System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the symbol table.");
                System.exit(0);
            }

            String result = Utils.newtmp();

            RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), identSymbol.type, result);

            Llvm.Instruction store = new Llvm.Load(result, identSymbol.type.toLlvmType(), identSymbol.type.toLlvmType(), "%" + identSymbol.ident);

            ret.ir.appendCode(store);

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
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetVariable toIR(SymbolTable st) throws TypeException;

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
         */
        public IntegerVariable(String ident) {
            super(ident);
        }

        @Override
        public String pp() {
            return "" + super.ident;
        }

        @Override
        public RetVariable toIR(SymbolTable st) {
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
         * @return Ensemble d'instructions LLVM
         */
        public abstract RetInstruction toIR(SymbolTable st) throws TypeException;

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
        public RetInstruction toIR(SymbolTable st) throws TypeException {
            SymbolTable.VariableSymbol identSymbol = (SymbolTable.VariableSymbol) st.lookup(this.ident);

            if(identSymbol == null) {
                System.err.println("Error: the symbol '" + this.ident + "' doesn't exist in the symbol table.");
                System.exit(0);
            }

            String result = "%" + identSymbol.ident;

            RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()), result);
            Expression.RetExpression retExpr = expression.toIR(st);

            ret.ir.append(retExpr.ir);

            Llvm.Instruction store = new Llvm.Store(retExpr.type.toLlvmType(), retExpr.result, identSymbol.type.toLlvmType(), result);

            ret.ir.appendCode(store);

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
    static class IntPtrType extends Type {
        @Override
        public String pp() {
            return "INT";
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof IntPtrType;
        }

        @Override
        public Llvm.Type toLlvmType() {
            return new Llvm.IntPtrType();
        }
    }
}
