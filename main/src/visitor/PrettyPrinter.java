package visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.SortedMap;

import expression.*;
import expression.binary.BiAddition;
import expression.binary.BiConjunction;
import expression.binary.BiDisjunction;
import expression.binary.BiDivision;
import expression.binary.BiEqual;
import expression.binary.BiEquivalence;
import expression.binary.BiImplication;
import expression.binary.BiLarger;
import expression.binary.BiLargerOrEqual;
import expression.binary.BiMultiplication;
import expression.binary.BiNotEqual;
import expression.binary.BiSmaller;
import expression.binary.BiSmallerOrEqual;
import expression.binary.BiSubtraction;
import expression.binary.BinaryOperation;
import function.Assignment;
import function.Conditional;
import function.Function;
import function.FunctionCall;
import function.Parameter;
import function.PostCondition;
import function.PreCondition;
import loop.FromBlock;
import loop.Invariant;
import loop.Loop;
import loop.UntilBlock;
import loop.Variant;
import program.*;
import program.Class;

public class PrettyPrinter implements Visitor {

    @Override
    public void visitLoop(Loop loop) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitFromBlock(FromBlock fromBlock) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitUntilBlock(UntilBlock untilBlock) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitInvariant(Invariant invariant) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitVariant(Variant variant) {
        // TODO Auto-generated method stub

    }

    private String printResult;
    private String prefix; // the prefix for all variables, eg. x => n.x
    private String currentClass;
    private HashSet<String> parameters; // if the variable is a parameter, don't add prefix.
    private TypeChecker typeChecker;
    private List<Expression> invariants;

    private PrettyPrinter printer;// we can reuse the same printer

    public PrettyPrinter() {
        printResult = "";
        prefix = "";
    }

    // must be accepted before calling this
    public String getPrintResult() {
        return this.printResult;
    }

    public String getPrintResult(Program program) {
        this.visitProgram(program);
        return this.printResult;
    }

    public String getPrintResult(Expression expr) {
        expr.accept(this);
        return this.printResult;
    }

    public String getPrintResult(Declaration decl) {
        decl.accept(this);
        return this.printResult;
    }

    public String getPrintResult(Function fun) {
        fun.accept(this);
        return this.printResult;
    }

    public String getPrintResult(Class cla) {
        cla.accept(this);
        return this.printResult;
    }

    public void reset() {
//		if (this.printer == null)
        printer = new PrettyPrinter();
        printer.invariants = invariants;
        printer.prefix = prefix;
        printer.currentClass = currentClass;
        printer.parameters = parameters;

        if (typeChecker == null)
            typeChecker = new TypeChecker();
        this.printResult = "";
    }

    @Override
    public void visitConjunction(BiConjunction conjunc) {
        this.visitBinaryOp(conjunc, "and");
    }

    @Override
    public void visitDisjunction(BiDisjunction disjunct) {
        this.visitBinaryOp(disjunct, "or");
    }

    @Override
    public void visitImplication(BiImplication imply) {
        this.visitBinaryOp(imply, "=>");
    }

    @Override
    public void visitEquivalence(BiEquivalence equal) {
        this.visitBinaryOp(equal, "<=>");
    }

    @Override
    public void visitNegation(Negation neg) {
        reset();
        neg.expr.accept(printer);
        this.printResult = "not " + "(" + printer.printResult + ")";

//		this.addParenthesis();
    }

    private void visitBinaryOp(BinaryOperation binary, String keyword) {
        reset();
        String left, right;
        binary.getLeft().accept(printer);
        left = printer.printResult;
        reset();

        binary.getRight().accept(printer);
        right = printer.printResult;
        reset();

        this.printResult = "(" + left + ")" + " " + keyword + " " + "(" + right + ")";

//		this.addParenthesis();
    }

    @Override
    public void visitMult(BiMultiplication mult) {
        reset();
        this.printResult = "mul[" + printer.getPrintResult(mult.getLeft()) + "]["
                + printer.getPrintResult(mult.getRight()) + "]";
    }

    @Override
    public void visitDiv(BiDivision div) {
        reset();
        this.printResult = "div[" + printer.getPrintResult(div.getLeft()) + "]["
                + printer.getPrintResult(div.getRight()) + "]";
    }

    @Override
    public void visitAdd(BiAddition add) {
        reset();
        this.printResult = "plus[" + printer.getPrintResult(add.getLeft()) + "]["
                + printer.getPrintResult(add.getRight()) + "]";
    }

    @Override
    public void visitSub(BiSubtraction sub) {
        reset();
        this.printResult = "minus[" + printer.getPrintResult(sub.getLeft()) + "]["
                + printer.getPrintResult(sub.getRight()) + "]";
    }

    @Override
    public void visitLarger(BiLarger lar) {
        this.visitBinaryOp(lar, ">");
    }

    @Override
    public void visitSmaller(BiSmaller sma) {
        this.visitBinaryOp(sma, "<");
    }

    @Override
    public void visitLargerOrEqual(BiLargerOrEqual loe) {
        this.visitBinaryOp(loe, ">=");
    }

    @Override
    public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
        this.visitBinaryOp(soe, "<=");
    }

    @Override
    public void visitEqual(BiEqual equ) {
        reset();
        if (typeChecker.getTypeResult(equ.getLeft()) == TypeChecker.Type.bool) {
            this.visitBinaryOp(equ, "<=>");
        } else {
            this.visitBinaryOp(equ, "=");
        }
    }

    @Override
    public void visitNotEqual(BiNotEqual neq) {
        reset();
        if (typeChecker.getTypeResult(neq.getRight()) == TypeChecker.Type.bool) {
            this.visitBinaryOp(neq, "<=> not");
        } else {
            this.visitBinaryOp(neq, "!=");
        }
    }

    @Override
    public void visitBoolConst(BoolConst con) {
        this.printResult = con.getBoolValue() ? "1=1" : "1=0";
        // this will translate true/false into primitive type boolean value in alloy
    }

    @Override
    public void visitNumConst(NumConst con) {
        this.printResult = ((Integer) con.getNumValue()).toString();
    }

    @Override
    public void visitStrConst(StringConst str) {
        this.printResult = str.getStrValue().isEmpty() ? "none" : '"' + str.getStrValue() + '"';
    }

    @Override
    public void visitStrVar(StringVariable str) {

        this.printResult = (prefix.isEmpty() || (parameters != null && parameters.contains(str.getID()))) ? str.getID()
                : prefix + "." + str.getID();
    }

    @Override
    public void visitNumVar(NumVariable num) {

        this.printResult = (prefix.isEmpty() || (parameters != null && parameters.contains(num.getID()))) ? num.getID()
                : prefix + "." + num.getID();
    }

    @Override
    public void visitBoolVar(BoolVariable bool) {
        this.printResult = ((prefix.isEmpty() || (parameters != null && parameters.contains(bool.getID())))
                ? bool.getID()
                : prefix + "." + bool.getID()) + " = True";
        // this will translate it into primitive type boolean in Alloy
    }

    @Override
    public void visitArrayVar(ArrayVariable arr) {
        //currently array reference cannot be a parameter type
        reset();
        this.printResult = (prefix.isEmpty() ? arr.getID() : prefix + "." + arr.getID())
                + "[" + printer.getPrintResult(arr.getIndex()) + "]" + (arr.getType() == Constant.Type.bool ? " = True" : "");
        //if the array is an array of boolean, also translate that
    }

    @Override
    public void visitDeclaration(Declaration decl) {
        // we don't need to add prefix in declaration
        if (decl.getConst() != null && !decl.isArrayDeclaration()) {
            reset();
            if (decl.getType() != Constant.Type.bool)
                this.printResult = decl.getID() + ":" + this.printer.getPrintResult(decl.getConst());
            else
                this.printResult = decl.getID() + ":" + (decl.getConst().getBoolValue() ? "True" : "False");
        } else {
            this.printResult = decl.getID() + ":";
            switch (decl.getType()) {
                case bool:
                    if (decl.isArrayDeclaration()) this.printResult = this.printResult + "seq Bool";
                    else this.printResult = this.printResult + "Bool";
                    break;
                case string:
                    if (decl.isArrayDeclaration()) this.printResult = this.printResult + "seq String";
                    else this.printResult = this.printResult + "String";
                    break;
                case num:
                    if (decl.isArrayDeclaration()) this.printResult = this.printResult + "seq Int";
                    else this.printResult = this.printResult + "Int";
                    break;
            }
        }
    }

    @Override
    public void visitFunction(Function func) {
        // each function is a predicate
        WPCalculator wpCal = new WPCalculator();
        Expression pred = wpCal.getHoareTriple(func, invariants);

        StringBuilder result = new StringBuilder();

        if (pred != null) {
            // all n: Class | n.x ........
            String predicateName = func.getId() + "Check";
            result.append("\n\n" + "pred " + predicateName);

            if (!func.getParameters().isEmpty()) {
                result.append("[");
                for (Parameter p : func.getParameters()) {
                    result.append(p.getID() + ":");
                    switch (p.getType()) {
                        case string:
                            result.append("String, ");
                            break;
                        case num:
                            result.append("Int, ");
                            break;
                        case bool:
                            result.append("Bool, ");
                            break;
                    }
                }

                result.deleteCharAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                result.append("]");
            }
            result.append("{\n\t");

            this.prefix = "n";
            HashSet<String> pars = new HashSet<String>();
            for (Parameter p : func.getParameters()) {
                pars.add(p.getID());
            }
            this.parameters = pars;
            reset();
            result.append("some " + this.prefix + ": " + this.currentClass + "| ");

            // try to find an instance of the negation of that
            result.append(this.printer.getPrintResult(new Negation(pred)));

            result.append("\n}\n\n" + runPred(func.getParameterList(), predicateName));

            this.printResult = result.toString();
        }
    }

    private String runPred(List<Parameter> pars, String predName) {
        StringBuilder result = new StringBuilder();

        result.append("//The post-condition/class-invariant/loop-correctness of function (" + predName.substring(0, predName.length() - 5));
        result.append(") is only valid when this is inconsistent.\n");

        if (pars == null || pars.isEmpty()) {
            result.append("run " + predName);
        } else {
            result.append("run {\n\t");
            for (Parameter p : pars) {
                result.append("some " + p.getID() + ": ");
                switch (p.getType()) {
                    case string:
                        result.append("String| ");
                        break;
                    case bool:
                        result.append("Bool| ");
                        break;
                    case num:
                        result.append("Int| ");
                        break;
                }
            }
            result.append(predName + "[");

            for (Parameter p : pars) {
                result.append(p.getID() + ", ");
            }

            // delete the last 2 character ", "
            result.deleteCharAt(result.length() - 1);
            result.deleteCharAt(result.length() - 1);

            result.append("]\n}");
        }
        result.append(" for 8 but 8 int, 2 Bool, exactly 32 String");
        return result.toString();
    }

    @Override
    public void visitConditional(Conditional cond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitAssignment(Assignment assign) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPreCondition(PreCondition preCond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPostCondition(PostCondition postCond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitProgram(Program program) {
        StringBuilder result = new StringBuilder();
        result.append("open util/boolean");
        result.append("\nopen util/sequniv");
        for (Class c : program.getClasses()) {
            result.append("\n\n//==============" + c.getName() + "==============\n");
            this.printer = new PrettyPrinter();
            result.append(printer.getPrintResult(c));
        }

        this.printResult = result.toString();
    }

    @Override
    public void visitClass(Class cla) {
        // add all signatures
        StringBuilder result = new StringBuilder();
        this.currentClass = cla.getName();

        // some keyword is a must!
        result.append("some sig " + this.currentClass + "{");

        List<Declaration> arrayDecls = new ArrayList<>();
        for (Declaration decl : cla.getDeclarations()) {
            reset();
            result.append("\n\t");
            result.append(this.printer.getPrintResult(decl) + ',');
            if (decl.isArrayDeclaration()) arrayDecls.add(decl);
        }

        result.deleteCharAt(result.length() - 1);
        result.append("\n}");

//  We should NOT have this because we can't assume the initial value of any variable when verifying the functions
//        if (!arrayDecls.isEmpty()) {
//            result.append("{");
//            for (Declaration decl : arrayDecls) {
//                int counter = 0;
//                for (Constant constant : decl.getConstantArray()) {
//                    reset();
//                    if (decl.getType() != Constant.Type.bool) {
//                        result.append("\n\t");
//                        result.append(decl.getID() + "[" + counter + "] = " + this.printer.getPrintResult(constant));
//                    } else {
//                        result.append("\n\t");
//                        result.append(decl.getID() + "[" + counter + "] = " + (constant.getBoolValue() ? "True" : "False"));
//                    }
//                    counter++;
//                }
//            }
//            result.append("\n}");
//        }

        // add all assumptions
        result.append("\n\nfact " + this.currentClass + "Fact {");

        for (Assumption fact : cla.getAssumptions()) {
            for (Expression expr : fact.getExprs()) {
                this.prefix = "n";
                reset();
                result.append("\n\tall n: " + this.currentClass + "| ");
                result.append(this.printer.getPrintResult(expr));
            }
        }

        result.append("\n}");

//		this.printResult = result.toString();

        // add all assertions, assertion should appear in the form of hoare triple for all funcitons

        invariants = new ArrayList<>();
        for (Assertion ass : cla.getAssertions()) {
            for (Expression expr : ass.getExprs()) {
                invariants.add(expr);
            }
        }

//		result.append("\n\nassert " + this.currentClass + "Assert {");
//
//		for (Assertion ass : cla.getAssertions()) {
//			for (Expression expr : ass.getExprs()) {
//				this.prefix = "n";
//				reset();
//				result.append("\n\tall n: " + this.currentClass + "| ");
//				result.append(this.printer.getPrintResult(expr));
//			}
//		}
//
//		result.append("\n}\n\n");
//
//		result.append("//the class invariant for class (" + this.currentClass);
//		result.append(") is only valid if this check is valid");
//
//		result.append("\ncheck " + this.currentClass + "Assert");

        // add all predicates
        for (Function func : cla.getFunctions()) {
            this.prefix = "n";
            this.reset();
            result.append(this.printer.getPrintResult(func));
        }

        this.printResult = result.toString();

    }

    @Override
    public void visitFunctionCall(FunctionCall funcCall) {
        // TODO Auto-generated method stub

    }

//	private void addParenthesis() {
//		this.printResult = "(" + this.printResult + ")";
//	}

}
