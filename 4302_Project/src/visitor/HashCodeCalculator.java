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
import function.Assignment;
import function.Conditional;
import function.Function;
import function.FunctionCall;
import function.PostCondition;
import function.PreCondition;
import loop.FromBlock;
import loop.Invariant;
import loop.Loop;
import loop.UntilBlock;
import loop.Variant;
import program.Declaration;
import program.Program;
import program.Class;

public class HashCodeCalculator implements Visitor {
@Override
	public void visitFunctionCall(FunctionCall funcCall) {
		// TODO Auto-generated method stub
		
	}

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

	//this might not be a very eifficient way of geting hash code
	private int hashCode;
	private HashCodeCalculator calculator;

	public int getHashCode() {
		return this.hashCode;
	}

	// by doing this, you don't have to accept the visitor manually
	public int getHashCode(Expression expr) {
		// this is just doing the work for the user.
		expr.accept(this);
		return this.hashCode;
	}

	public HashCodeCalculator() {
	}

	private void reset() {
		if (calculator == null)
			calculator = new HashCodeCalculator();
	}

	@Override
	public void visitMult(BiMultiplication mult) {
		reset();
		this.hashCode = 2 + calculator.getHashCode(mult.getLeft()) + calculator.getHashCode(mult.getRight());
	}

	@Override
	public void visitDiv(BiDivision div) {
		reset();
		this.hashCode = 3 + calculator.getHashCode(div.getLeft()) + calculator.getHashCode(div.getRight());
	}

	@Override
	public void visitAdd(BiAddition add) {
		reset();
		this.hashCode = 5 + calculator.getHashCode(add.getLeft()) + calculator.getHashCode(add.getRight());
	}

	@Override
	public void visitSub(BiSubtraction sub) {
		reset();
		this.hashCode = 7 + calculator.getHashCode(sub.getLeft()) + calculator.getHashCode(sub.getRight());
	}

	@Override
	public void visitLarger(BiLarger lar) {
		reset();
		this.hashCode = 11 + calculator.getHashCode(lar.getLeft()) + calculator.getHashCode(lar.getRight());
	}

	@Override
	public void visitSmaller(BiSmaller sma) {
		reset();
		this.hashCode = 13 + calculator.getHashCode(sma.getLeft()) + calculator.getHashCode(sma.getRight());
	}

	@Override
	public void visitLargerOrEqual(BiLargerOrEqual loe) {
		reset();
		this.hashCode = 17 + calculator.getHashCode(loe.getLeft()) + calculator.getHashCode(loe.getRight());
	}

	@Override
	public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
		reset();
		this.hashCode = 19 + calculator.getHashCode(soe.getLeft()) + calculator.getHashCode(soe.getRight());
	}

	@Override
	public void visitEqual(BiEqual equ) {
		reset();
		this.hashCode = 23 + calculator.getHashCode(equ.getLeft()) + calculator.getHashCode(equ.getRight());
	}

	@Override
	public void visitNotEqual(BiNotEqual neq) {
		reset();
		this.hashCode = 29 + calculator.getHashCode(neq.getLeft()) + calculator.getHashCode(neq.getRight());
	}

	@Override
	public void visitConjunction(BiConjunction conjunc) {
		reset();
		this.hashCode = 31 + calculator.getHashCode(conjunc.getLeft()) + calculator.getHashCode(conjunc.getRight());
	}

	@Override
	public void visitDisjunction(BiDisjunction disjunct) {
		reset();
		this.hashCode = 37 + calculator.getHashCode(disjunct.getLeft()) + calculator.getHashCode(disjunct.getRight());
	}

	@Override
	public void visitImplication(BiImplication imply) {
		reset();
		this.hashCode = 41 + calculator.getHashCode(imply.getLeft()) + calculator.getHashCode(imply.getRight());
	}

	@Override
	public void visitEquivalence(BiEquivalence equal) {
		reset();
		this.hashCode = 43 + calculator.getHashCode(equal.getLeft()) + calculator.getHashCode(equal.getRight());
	}

	@Override
	public void visitNegation(Negation neg) {
		reset();
		this.hashCode = 47 + calculator.getHashCode(neg.expr);
	}

	@Override
	public void visitBoolConst(BoolConst con) {
		this.hashCode = ((Boolean) (con.getBoolValue())).hashCode();
	}

	@Override
	public void visitNumConst(NumConst con) {
		this.hashCode = ((Integer) (con.getNumValue())).hashCode();
	}

	@Override
	public void visitStrConst(StringConst str) {
		this.hashCode = (str.getStrValue()).hashCode();
	}

	@Override
	public void visitStrVar(StringVariable str) {
		this.hashCode = str.getID().hashCode();
	}

	@Override
	public void visitBoolVar(BoolVariable boo) {
		this.hashCode = boo.getID().hashCode();
	}

	@Override
	public void visitNumVar(NumVariable num) {
		this.hashCode = num.getID().hashCode();
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFunction(Function func) {
		// TODO Auto-generated method stub

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

}
