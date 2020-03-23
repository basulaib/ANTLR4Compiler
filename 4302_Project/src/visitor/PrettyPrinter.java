package visitor;

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
import function.PostCondition;
import function.PreCondition;
import program.*;
import program.Class;

public class PrettyPrinter implements Visitor {

	private String printResult;
	private String prefix; // the prefix for all variables, eg. x => n.x
	private String currentClass;

	private PrettyPrinter printer;// we can reuse the same printer

	public PrettyPrinter() {
		printResult = "";
		prefix = "";
	}

	// we need to add prefix for variables for identifying predicates
	public PrettyPrinter(String prefix) {
		printResult = "";
		this.prefix = prefix;
	}

	private PrettyPrinter(String prefix, String currentClass) {
		this.printResult = "";
		this.prefix = prefix;
		this.currentClass = currentClass;
	}

	// must be accepted before calling this
	public String getPrintResult() {
		return this.printResult;
	}

	public String getPrintResult(Expression expr) {
		expr.accept(this);
		return this.printResult;
	}

	public void reset() {
		if (this.printer == null)
			printer = new PrettyPrinter(this.prefix, this.currentClass);
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
		this.visitBinaryOp(equ, "=");
	}

	@Override
	public void visitNotEqual(BiNotEqual neq) {
		this.visitBinaryOp(neq, "!=");
	}

	@Override
	public void visitBoolConst(BoolConst con) {
		this.printResult = con.getBoolValue() ? "1 = 1" : "1 = 0";
	}

	@Override
	public void visitNumConst(NumConst con) {
		this.printResult = ((Integer) con.getNumValue()).toString();
	}

	@Override
	public void visitStrConst(StringConst str) {
		this.printResult = "'" + str.getStrValue() + "'";
	}

	@Override
	public void visitStrVar(StringVariable str) {
		this.printResult = prefix.isEmpty() ? str.getID() : prefix + "." + str.getID();
	}

	@Override
	public void visitNumVar(NumVariable num) {
		this.printResult = prefix.isEmpty() ? num.getID() : prefix + "." + num.getID();
	}

	@Override
	public void visitBoolVar(BoolVariable bool) {
		this.printResult = prefix.isEmpty() ? bool.getID() : prefix + "." + bool.getID();
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// we don't need to add prefix in declaration
		if (decl.getConst() != null) {
			reset();
			this.printResult = decl.getID() + ":" + this.printer.getPrintResult(decl.getConst());
		} else {
			this.printResult = decl.getID() + ":";
			switch (decl.getConst().type) {
			case bool:
				this.printResult = this.printResult + "Bool";
				break;
			case string:
				this.printResult = this.printResult + "String";
				break;
			case num:
				this.printResult = this.printResult + "Int";
				break;
			}
		}
	}

	@Override
	public void visitFunction(Function func) {
		// each function is a predicate
		this.printResult = "pred" + " functionName " + " {\n\t";
		WPCalculator wpCal = new WPCalculator();
		Expression pred = wpCal.getPred(func);

		if (pred != null) {
			// all n: Class | n.x ........
			this.prefix = "n";
			this.printResult = this.printResult + "all " + this.prefix + ": " + this.currentClass + " | ";
			reset();

			this.printResult = this.printResult + this.printer.getPrintResult(pred);
			this.printResult = this.printResult + '\n' + '}';
		}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void visitClass(Class cla) {
		// TODO Auto-generated method stub

	}

//	private void addParenthesis() {
//		this.printResult = "(" + this.printResult + ")";
//	}

}
