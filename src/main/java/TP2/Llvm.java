package TP2;

import java.util.ArrayList;
import java.util.List;

// This file contains a simple LLVM IR representation
// and methods to generate its string representation

/**
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 */
public class Llvm {
    /**
     * Représentation sous forme de classe interne d'un ensemble d'instructions
     */
    static public class IR {
        /**
         * Ensemble d'instructions de l'en-tête (variable global)
         */
        List < Instruction > header; // IR instructions to be placed before the code (global definitions)

        /**
         * Ensemble d'instructions du corps du programme
         */
        List < Instruction > code;

        /**
         * Constructeur
         */
        public IR(List < Instruction > header, List < Instruction > code) {
            this.header = header;
            this.code = code;
        }

        /**
         * Attache une liste d'instruction
         * @param other L'ensemble d'instructions à attacher
         * @return Le nouvel ensemble d'instructions
         */
        public IR append(IR other) {
            header.addAll(other.header);
            code.addAll(other.code);
            return this;
        }

        /**
         * Attache une instruction au corps du programme
         * @param other L'instruction à attacher
         * @return Le nouvel ensemble d'instructions
         */
        public IR appendCode(Instruction inst) {
            code.add(inst);
            return this;
        }

        /**
         * Attache une instruction à l'en-tête
         * @param other L'instruction à attacher
         * @return Le nouvel ensemble d'instructions
         */
        public IR appendHeader(Instruction inst) {
            header.add(inst);
            return this;
        }

        @Override// Final string generation
        public String toString() {
            // This header describe to LLVM the target
            // and declare the external function printf
            StringBuilder r = new StringBuilder("; Target\n" +
                "target triple = \"x86_64-unknown-linux-gnu\"\n" +
                "; External declaration of the printf function\n" +
                "declare i32 @printf(i8* noalias nocapture, ...)\n" +
                "\n; Actual code begins\n\n");

            for (Instruction inst: header)
                r.append(inst);

            r.append("\n\n");

            // We create the function main
            // TODO : remove this when you extend the language
            r.append("define i32 @main() {\n");


            for (Instruction inst: code)
                r.append(inst);

            // TODO : remove this when you extend the language
            r.append("}\n");

            return r.toString();
        }
    }

    /**
     * Renvoie une liste vide d'instructions
     * @return La liste vide
     */
    static public List < Instruction > empty() {
        return new ArrayList < Instruction > ();
    }


    // LLVM Types
    static public abstract class Type {
        public abstract String toString();
    }

    static public class IntType extends Type {
        public String toString() {
            return "i32";
        }
    }

    // TODO : other types


    /**
     * Représentation abstraite d'une instruction
     */
    static public abstract class Instruction {
        /**
         * Convertis l'instruction LLVM sous forme de chaine de caractères
         * @return L'instruction LLVM 
         */
        public abstract String toString();
    }

    /**
     * Représentation de l'instruction Add sous forme de la classe interne
     */
    static public class Add extends Instruction {
        /**
         * Type de l'addition
         */
        Type type;

        /**
         * Partie gauche de l'addition
         */
        String left;

        /**
         * Partie droite de l'addition
         */
        String right;

        /**
         * Résultat de l'addition
         */
        String lvalue;

        /**
         * Constructeur
         */
        public Add(Type type, String left, String right, String lvalue) {
            this.type = type;
            this.left = left;
            this.right = right;
            this.lvalue = lvalue;
        }

        @Override
        public String toString() {
            return this.lvalue + " = add " + this.type + " " + this.left + ", " + this.right + "\n";
        }
    }

    /**
     * Représentation de l'instruction Sub sous forme de la classe interne
     */
    static public class Sub extends Instruction {
        /**
         * Type de la soustraction
         */
        Type type;

        /**
         * Partie gauche de la soustraction
         */
        String left;

        /**
         * Partie droite de la soustraction
         */
        String right;

        /**
         * Résultat de la soustraction
         */
        String lvalue;

        /**
         * Constructeur
         */
        public Sub(Type type, String left, String right, String lvalue) {
            this.type = type;
            this.left = left;
            this.right = right;
            this.lvalue = lvalue;
        }

        @Override
        public String toString() {
            return this.lvalue + " = sub " + this.type + " " + this.left + ", " + this.right + "\n";
        }
    }

    /**
     * Représentation de l'instruction Mul sous forme de la classe interne
     */
    static public class Mul extends Instruction {
        /**
         * Type de la multiplication
         */
        Type type;

        /**
         * Partie gauche de la multiplication
         */
        String left;

        /**
         * Partie droite de la multiplication
         */
        String right;

        /**
         * Résultat de la multiplication
         */
        String lvalue;

        /**
         * Constructeur
         */
        public Mul(Type type, String left, String right, String lvalue) {
            this.type = type;
            this.left = left;
            this.right = right;
            this.lvalue = lvalue;
        }

        @Override
        public String toString() {
            return this.lvalue + " = mul " + this.type + " " + this.left + ", " + this.right + "\n";
        }
    }

    /**
     * Représentation de l'instruction Div sous forme de la classe interne
     */
    static public class Div extends Instruction {
        /**
         * Type de la division
         */
        Type type;

        /**
         * Partie gauche de la division
         */
        String left;

        /**
         * Partie droite de la division
         */
        String right;

        /**
         * Résultat de la division
         */
        String lvalue;

        /**
         * Constructeur
         */
        public Div(Type type, String left, String right, String lvalue) {
            this.type = type;
            this.left = left;
            this.right = right;
            this.lvalue = lvalue;
        }

        @Override
        public String toString() {
            return this.lvalue + " = udiv " + this.type + " " + this.left + ", " + this.right + "\n";
        }
    }

    /**
     * Représentation de l'instruction Alloca sous la forme d'une classe interne
     */
    static public class Alloca extends Instruction {
        /**
         * Type de la variable
         */
        Type type;

        /**
         * Nom de la variable
         */
        String ident;

        /**
         * Constructeur
         */
        public Alloca(Type type, String ident) {
            this.type = type;
            this.ident = ident;
        }

        @Override
        public String toString() {
            return this.ident + " = alloca " + this.type + "\n";
        }
    }

    /**
     * Représentation de l'instruction Return sous forme de la classe interne
     */
    static public class Return extends Instruction {
        /**
         * Type du retour
         */
        Type type;

        /**
         * Valeur à retourner
         */
        String value;

        /**
         * Constructeur
         */
        public Return(Type type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "ret " + type + " " + value + "\n";
        }
    }

    // TODO : other instructions
}
