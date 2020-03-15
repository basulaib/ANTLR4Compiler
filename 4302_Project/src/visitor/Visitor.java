package visitor;

import expression.*;
import function.*;
import program.*;

public interface Visitor {
	// binary operation
	// Boolean operation
	public void visitConjunction(BiConjunction conjunc);

	public void visitDisjunction(BiDisjunction disjunct);

	public void visitImplication(BiImplication imply);

	public void visitEquivalence(BiEquivalence equal);

	public void visitBoolVariable(BoolVariable bool);

	public void visitDeclaration(Declaration decl);

	public void visitNegation(Negation neg);

	// Numeric operation
	public void visitMult(BiMultiplication mult);

	public void visitDiv(BiDivision div);

	public void visitAdd(BiAddition add);

	public void visitSub(BiSubtraction sub);

	public void visitLarger(BiLarger lar);

	public void visitSmaller(BiSmaller sma);

	public void visitLargerOrEqual(BiLargerOrEqual loe);

	public void visitSmallerOrEqual(BiSmallerOrEqual soe);

	public void visitEqual(BiEqual equ);

	public void visitNotEqual(BiNotEqual neq);

	// function cluster
	public void visitFunction(Function func);

	public void visitConditional(Conditional cond);

	public void visitAssignment(Assignment assign);

	public void visitPreCondition(PreCondition preCond);

	public void visitPostCondition(PostCondition postCond);

}
