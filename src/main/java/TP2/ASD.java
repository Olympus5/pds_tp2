package TP2;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 */
public class ASD {

    /**
     * Représentation sous forme de classe interne du Variant/Constructeur Program
     */
    static public class Program {
        Expression e; // What a program contains. TODO : change when you extend the language

        /**
         * Constructor
         */
        public Program(Expression e) {
            this.e = e;
        }

        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'un programme VSL+
         */
        public String pp() {
            return e.pp();
        }

        /**
         * Générateur d'un ensemble d'instructions LLVM
         * @return Ensemble d'instructions LLVM
         */
        public Llvm.IR toIR() throws TypeException {
            // TODO : change when you extend the language

            // computes the IR of the expression
            Expression.RetExpression retExpr = e.toIR();
            // add a return instruction
            Llvm.Instruction ret = new Llvm.Return(retExpr.type.toLlvmType(), retExpr.result);
            retExpr.ir.appendCode(ret);

            return retExpr.ir;
        }
    }

    // TODO: All toIR methods returns the IR, plus extra information (synthesized attributes)
    // TODO: They can take extra arguments (inherited attributes)

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
        public abstract RetExpression toIR() throws TypeException;

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
        public RetExpression toIR() throws TypeException {
            RetExpression leftRet = left.toIR();
            RetExpression rightRet = right.toIR();

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
        public RetExpression toIR() throws TypeException {
            RetExpression leftRet = left.toIR();
            RetExpression rightRet = right.toIR();

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
            return "" + value;
        }

        @Override
        public RetExpression toIR() {
            // Here we simply return an empty IR
            // the `result' of this expression is the integer itself (as string)
            return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), "" + value);
        }
    }

    /**
     * Représentation du type entier coté ASD (Attention: ne pas confondre avec les types LLVM)
     */
    static public abstract class Type {
        /**
         * Pretty-Printer
         * @return Représentation sous forme de chaine de caractère d'une expression VSL+
         */
        public abstract String pp();

        /**
         * Transforme un type ASD en type LLVM
         * @return Le type LLVM
         */
        public abstract Llvm.Type toLlvmType();
    }

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
}
