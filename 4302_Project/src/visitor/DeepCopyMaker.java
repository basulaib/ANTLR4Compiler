package visitor;

import expression.*;
import expression.binary.*;
import function.*;
import program.Declaration;

public class DeepCopyMaker implements Visitor {
//currently it can only make a deep-copy of binary expression
	private Expression copy;
	private DeepCopyMaker copyMaker;

	public Expression getExprCopy() {
		return this.copy;
	}

	public Expression getExprCopy(Expression expr) {
		expr.accept(this);
		return this.copy;
	}

	public DeepCopyMaker() {
	}

	private void reset() {
		if (copyMaker == null)
			this.copyMaker = new DeepCopyMaker();
	}

	private Expression leftCopy(BinaryOperation binary) {
		reset();
		binary.getLeft().accept(copyMaker);
		Expression left = copyMaker.copy;
		return left;
	}

	private Expression rightCopy(BinaryOperation binary) {
		reset();
		binary.getRight().accept(copyMaker);
		Expression right = copyMaker.copy;
		return right;
	}

	@Override
	public void visitMult(BiMultiplication mult) {
		// TODO Auto-generated method stub
		this.copy = new BiMultiplication(leftCopy(mult), rightCopy(mult));
	}

	@Override
	public void visitDiv(BiDivision div) {
		// TODO Auto-generated method stub
		this.copy = new BiDivision(leftCopy(div), rightCopy(div));
	}

	@Override
	public void visitAdd(BiAddition add) {
		// TODO Auto-generated method stub
		this.copy = new BiAddition(leftCopy(add), rightCopy(add));
	}

	@Override
	public void visitSub(BiSubtraction sub) {
		// TODO Auto-generated method stub
		this.copy = new BiSubtraction(leftCopy(sub), rightCopy(sub));
	}

	@Override
	public void visitLarger(BiLarger lar) {
		// TODO Auto-generated method stub
		this.copy = new BiLarger(leftCopy(lar), rightCopy(lar));
	}

	@Override
	public void visitSmaller(BiSmaller sma) {
		// TODO Auto-generated method stub
		this.copy = new BiSmaller(leftCopy(sma), rightCopy(sma));
	}

	@Override
	public void visitLargerOrEqual(BiLargerOrEqual loe) {
		// TODO Auto-generated method stub
		this.copy = new BiLargerOrEqual(leftCopy(loe), rightCopy(loe));
	}

	@Override
	public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
		// TODO Auto-generated method stub
		this.copy = new BiSmallerOrEqual(leftCopy(soe), rightCopy(soe));
	}

	@Override
	public void visitEqual(BiEqual equ) {
		// TODO Auto-generated method stub
		this.copy = new BiEqual(leftCopy(equ), rightCopy(equ));
	}

	@Override
	public void visitNotEqual(BiNotEqual neq) {
		// TODO Auto-generated method stub
		this.copy = new BiNotEqual(leftCopy(neq), rightCopy(neq));
	}

	@Override
	public void visitConjunction(BiConjunction conjunc) {
//		reset();
//		conjunc.getLeft().accept(copyMaker);
//		Expression left = copyMaker.copy;
//		conjunc.getRight().accept(copyMaker);
//		Expression right = copyMaker.copy;
		this.copy = new BiConjunction(leftCopy(conjunc), rightCopy(conjunc));
	}

	@Override
	public void visitDisjunction(BiDisjunction disjunct) {
		// TODO Auto-generated method stub
		this.copy = new BiDisjunction(leftCopy(disjunct), rightCopy(disjunct));
	}

	@Override
	public void visitImplication(BiImplication imply) {
		// TODO Auto-generated method stub
		this.copy = new BiImplication(leftCopy(imply), rightCopy(imply));
	}

	@Override
	public void visitEquivalence(BiEquivalence equal) {
		// TODO Auto-generated method stub
		this.copy = new BiEquivalence(leftCopy(equal), rightCopy(equal));
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitNegation(Negation neg) {
		// TODO Auto-generated method stub
		reset();
		neg.expr.accept(copyMaker);
		Expression copy = copyMaker.copy;
		this.copy = new Negation(copy);
	}

	@Override
	public void visitBoolConst(BoolConst con) {
		// TODO Auto-generated method stub
		this.copy = new BoolConst(con.getBoolValue());
	}

	@Override
	public void visitNumConst(NumConst con) {
		// TODO Auto-generated method stub
		this.copy = new NumConst(con.getNumValue());
	}

	@Override
	public void visitStrConst(StringConst str) {
		// TODO Auto-generated method stub
		this.copy = new StringConst(str.getStrValue());
	}

	private Constant getConstCopy(Constant con) {
		reset();
		con.accept(copyMaker);
		return (Constant) this.copyMaker.copy;
	}

	@Override
	public void visitStrVar(StringVariable str) {
		// TODO Auto-generated method stub
		if (str.valueDefined) {
			this.copy = new StringVariable(str.ID, getConstCopy(str.value));
		} else {
			this.copy = new StringVariable(str.ID);
		}
	}

	@Override
	public void visitBoolVar(BoolVariable boo) {
		// TODO Auto-generated method stub
		if (boo.valueDefined) {
			this.copy = new BoolVariable(boo.ID, getConstCopy(boo.value));
		} else {
			this.copy = new BoolVariable(boo.ID);
		}
	}

	@Override
	public void visitNumVar(NumVariable num) {
		// TODO Auto-generated method stub
		if (num.valueDefined) {
			this.copy = new NumVariable(num.ID, getConstCopy(num.value));
		} else {
			this.copy = new NumVariable(num.ID);
		}
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

}
