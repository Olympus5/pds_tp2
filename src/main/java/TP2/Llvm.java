package TP2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
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
                "declare i32 @printf(i8* nocapture, ...)\n" +
                "; External declaration of the scanf function\n" +
                "declare i32 @scanf(i8* nocapture, ...)\n" +
                "\n; Actual code begins\n\n");

            for (Instruction inst: header)
                r.append(inst);

            r.append("; ModuleID = ’main’");

            r.append("\n\n");

            // We create the function main
            // TODO : remove this when you extend the language
            //r.append("define i32 @main() {\n");


            //On déclare ici les fonctions externes: PRINTF et SCANF

            for (Instruction inst: code)
                r.append(inst);

            // TODO : remove this when you extend the language
            //r.append("}\n");

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

    /**
     * Représentation sous forme de class interne du type INT Llvm
     */
    static public class IntType extends Type {
        public String toString() {
            return "i32";
        }
    }

    /**
     * Représentation sous forme de class interne du type Void Llvm
     */
    static public class VoidType extends Type {
        public String toString() {
            return "void";
        }
    }

    /**
     * Représentation sous forme de class interne du type Array Llvm
     */
    static public class ArrayType extends Type {

        /**
         * Type Llvm des éléments du tableau
         */
        Type type;

        /**
         * Taille du tableau
         */
        int size;

        /**
         * Constructeur
         * @param type Type Llvm des éléments du tableau
         * @param size Taille des éléments du tableau
         */
        public ArrayType(Type type, int size) {
            this.type = type;
            this.size = size;
        }

        @Override
        public String toString() {
            return this.type + "*";
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
            String ret = this.ident + " = alloca ";

            ret += (this.type instanceof ArrayType) ? ((ArrayType) this.type).type + ", " + ((ArrayType) this.type).type + " " + ((ArrayType) this.type).size : "" + this.type;

            return ret + "\n";
        }
    }

    /**
     * Représentation de l'instruction Store sous la forme d'une classe interne
     */
    static public class Store extends Instruction {
        /**
         * Type de la valeur gauche
         */
        Type typeValue;

        /**
         * Valeur à affecter
         */
        String value;

        /**
         * Type de la variable d'affection
         */
        Type typePtr;

        /**
         * Variable d'affectation
         */
        String ptr;

        /**
         * Constructeur
         */
        public Store(Type typeValue, String value, Type typePtr, String ptr) {
            this.typeValue = typeValue;
            this.value = value;
            this.typePtr = typePtr;
            this.ptr = ptr;
        }

        @Override
        public String toString() {
            return "store " + this.typeValue + " " + this.value + ", " + this.typePtr + "* " + this.ptr + "\n";
        }
    }

    /**
     * Représentation de l'instruction Load sous la forme d'une classe interne
     */
    static public class Load extends Instruction {

        /**
         * Variable intermediaire
         */
        String lvalue;

        /**
        * Type de la variable intermediaire
        */
        Type typeLValue;

        /**
         * Type de la variable
         */
        Type typePtr;

        /**
         * Variable
         */
        String ptr;

        /**
         * Constructeur
         */
        public Load(String lvalue, Type typeLValue, Type typePtr, String ptr) {
            this.lvalue = lvalue;
            this.typeLValue = typeLValue;
            this.typePtr = typePtr;
            this.ptr = ptr;
        }

        @Override
        public String toString() {
            return this.lvalue + " = load " + this.typeLValue + ", " + this.typePtr + "* " + this.ptr + "\n";
        }
    }

    /**
     * Représentation de l'instruction GetElementPtr sous la forme d'une classe interne
     */
    static public class GetElementPtr extends Instruction {

        /**
         * Variable intermediaire
         */
        String lvalue;

        /**
        * Type de la variable intermediaire
        */
        Type typeArray;

        /**
         * Nom de tableau
         */
        String array;

        /**
         * Type de la variable
         */
        Type type;

        /**
         * Variable
         */
        String index;

        /**
         * Constructeur
         */
        public GetElementPtr(String lvalue,  Type typeArray, String array, Type type, String index) {
            this.lvalue = lvalue;
            this.typeArray = typeArray;
            this.array = array;
            this.type = type;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.lvalue + " = getelementptr " + this.typeArray + "," + this.typeArray + "* " + this.array + ", " + this.type + " " + this.index + "\n";
        }
    }

    /**
     * Représentation de l'instruction Icmp sous la forme d'une classe interne
     */
    static public class Icmp extends Instruction {
        /**
         * Resultat de la comparaison
         */
        String lvalue;

        /**
         * Type de la comparaison
         */
        Type type;

        /**
         * Valeur à comparer à 0
         */
        String op;

        /**
         * Constructeur
         */
        public Icmp(String lvalue, Type type, String op) {
            this.lvalue = lvalue;
            this.type = type;
            this.op = op;
        }

        @Override
        public String toString() {
            return this.lvalue + " = icmp ne " + this.type + " " + this.op + ", 0\n";
        }
    }

    /**
     * Représentation de l'instruction Br (conditionel) sous forme de classe interne
     */
    static public class BrCond extends Instruction {
        /**
         * Condition de branchement
         */
        String cond;

        /**
         * Label si cond est vrai
         */
        String si;

        /**
         * Label si cond est faux
         */
        String sinon;


        /**
         * Constructeur
         */
        public BrCond(String cond, String si, String sinon) {
            this.cond = cond;
            this.si = si;
            this.sinon = sinon;
        }

        @Override
        public String toString() {
            return "br i1 " + this.cond + ", label " + this.si + ", label " + this.sinon + "\n";
        }
    }

    /**
     * Représentation de l'instruction Br (inconditionnel) sous forme de classe interne
     */
    static public class BrUncond extends Instruction {
        /**
         * Nom du label où on se branche
         */
        String label;

        /**
         * Constructeur
         */
        public BrUncond(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "br label " + label + "\n";
        }
    }

    /**
     * Représentation de la création de Label sous forme de classe interne
     */
    static public class Label extends Instruction {
        /**
         * Nom du label
         */
        String name;

        /**
         * Constructeur
         */
        public Label(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + ": \n";
        }
    }

    /**
     * Représentation de l'instruction define sous forme de classe interne
     */
    static public class Define extends Instruction {
        /**
         * Type de retour de la fonction
         */
        Type type;

        /**
         * Nom de la fonction
         */
        String name;

        /**
         * Liste des attributs de la fonction
         */
        List<String> attributs;

        /**
         * Table des types des attributs
         */
        Hashtable<String, Type> typeAttributs;

        /**
         * Constructeur
         * @param type Type de la fonction
         * @param name nom de la fonction
         * @param attributs Liste des attributs de la fonction
         * @param typeAttributs Table des types des attributs
         */
        public Define(Type type, String name, List<String> attributs, Hashtable<String, Type> typeAttributs) {
            this.type = type;
            this.name = name;
            this.attributs = attributs;
            this.typeAttributs = typeAttributs;
        }

        @Override
        public String toString() {
            String ret = "define " + this.type + " " + this.name + "(";

            if(!attributs.isEmpty()) {
                Iterator<String> it = attributs.iterator();
                String attribut = it.next();

                ret += this.typeAttributs.get(attribut) + " %" + attribut;

                while(it.hasNext()) {
                    attribut = it.next();
                    ret += ", " + this.typeAttributs.get(attribut) + " %" + attribut;
                }
            }

            return ret + "){\n";
        }
    }

    /**
     * Représentation de l'instruction Return sous forme de la classe interne
     */
    static public class Call extends Instruction {
        /**
         * La valeur retournée par la fonction
         */
        String lvalue;

        /**
         * le type de la fonction
         */
        Type returnType;

        /**
         * Le nom de la fonction
         */
        String name;

        /**
         * Liste d'attributs de la fonction
         */
        List<String> attributs;

        /**
         * Table des types des attributs
         */
        Hashtable<String, Type> types;

        /**
         * Constructeur
         * @param lvalue Valeur retournée par la fonction
         * @param returnType Type de la fonction
         * @param name Nom de la fonction
         * @param attributs Liste d'attributs de la fonction
         * @param types Table des types (un types par nom d'attribut)
         */
        public Call(String lvalue, Type returnType, String name, List<String> attributs, Hashtable types) {
            this.lvalue = lvalue;
            this.returnType = returnType;
            this.name = name;
            this.attributs = attributs;
            this.types = types;
        }

        @Override
        public String toString() {
            String attributs = null;
            String ret = (this.lvalue.length() > 0) ? this.lvalue + " = " : "" ;

            for(String attribut : this.attributs) {
                if(attributs == null) attributs = this.types.get(attribut) + " " + attribut;
                else attributs += ", " + this.types.get(attribut) + " " + attribut;
            }

            return ret + "call " + this.returnType + " " + this.name + "(" + attributs + ")\n";
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
            return "ret " + type + " " + value + "\n}\n\n";
        }
    }

    // TODO : other instructions
}
