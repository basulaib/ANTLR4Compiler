package visitor;

import java.util.HashSet;

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
import function.Parameter;
import function.PostCondition;
import function.PreCondition;
import program.*;
import program.Class;

public class PrettyPrinter implements Visitor {

	private String printResult;
	private String prefix; // the prefix for all variables, eg. x => n.x
	private String currentClass;
	private HashSet<String> parameters; // if the variable is a parameter, don't add prefix.

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

	private PrettyPrinter(String prefix, String currentClass, HashSet<String> parameters) {
		this.printResult = "";
		this.prefix = prefix;
		this.currentClass = currentClass;
		this.parameters = parameters;
	}

	// must be accepted before calling this
	public String getPrintResult() {
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
		printer = new PrettyPrinter(this.prefix, this.currentClass, this.parameters);
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
		this.printResult = (prefix.isEmpty() || (parameters != null && parameters.contains(bool.getID())))
				? bool.getID()
				: prefix + "." + bool.getID();
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// we don't need to add prefix in declaration
		if (decl.getConst() != null) {
			reset();
			this.printResult = decl.getID() + ":" + this.printer.getPrintResult(decl.getConst());
		} else {
			this.printResult = decl.getID() + ":";
			switch (decl.getType()) {
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
		WPCalculator wpCal = new WPCalculator();
		Expression pred = wpCal.getPred(func);

		StringBuilder result = new StringBuilder();

		if (pred != null) {
			// all n: Class | n.x ........
			result.append("\n\npred " + func.getId() + "Check");

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
			result.append("all " + this.prefix + ": " + this.currentClass + "| ");

			result.append(this.printer.getPrintResult(pred));

			this.printResult = result.toString();
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
		// add all signatures
		StringBuilder result = new StringBuilder();
		result.append("open util/boolean\n\n");
		this.currentClass = cla.getName();

		result.append("sig " + this.currentClass + "{");

		for (Declaration decl : cla.getDeclarations()) {
			reset();
			result.append("\n\t");
			result.append(this.printer.getPrintResult(decl) + ',');
		}

		result.deleteCharAt(result.length() - 1);
		result.append("\n}");
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

		// add all assertions

		result.append("\n\nassert " + this.currentClass + "Assert {");

		for (Assertion ass : cla.getAssertions()) {
			for (Expression expr : ass.getExprs()) {
				this.prefix = "n";
				reset();
				result.append("\n\tall n: " + this.currentClass + "| ");
				result.append(this.printer.getPrintResult(expr));
			}
		}

		result.append("\n}");

		// add all predicates
		for (Function func : cla.getFunctions()) {

			this.prefix = "n";
			this.reset();
			result.append(this.printer.getPrintResult(func));

			result.append("\n}");
		}

		this.printResult = result.toString();

	}

//	private void addParenthesis() {
//		this.printResult = "(" + this.printResult + ")";
//	}

}
