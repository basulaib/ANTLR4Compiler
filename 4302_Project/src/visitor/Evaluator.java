package visitor;

import java.util.HashMap;

import expression.BiConjunction;
import expression.BiDisjunction;
import expression.BiEquivalence;
import expression.BiImplication;
import expression.BinaryOperation;
import expression.BoolVariable;
import expression.Declaration;
import expression.Negation;

public class Evaluator implements Visitor {

	public boolean value = false;
	public HashMap<String, Boolean> valueAssignment;
	private Evaluator evaluator;

	public Evaluator(HashMap<String, Boolean> valueAssignment) {
		this.valueAssignment = valueAssignment;
	}

	public void reset() {
		if (this.evaluator == null)
			evaluator = new Evaluator(this.valueAssignment);
		this.evaluator.value = false;
	}

	@Override
	public void visitConjunction(BiConjunction conjunc) {
		this.visitBinary(conjunc, "and");
	}

	@Override
	public void visitDisjunction(BiDisjunction disjunct) {
		this.visitBinary(disjunct, "or");
	}

	@Override
	public void visitImplication(BiImplication imply) {
		this.visitBinary(imply, "=>");
	}

	@Override
	public void visitEquivalence(BiEquivalence equal) {
		this.visitBinary(equal, "<=>");
	}

	@Override
	public void visitBoolVariable(BoolVariable bool) {
		this.value = this.valueAssignment.get(bool.ID);
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// TODO Auto-generated method stub
//not needed
	}

	@Override
	public void visitNegation(Negation neg) {
		// TODO Auto-generated method stub
		reset();
		neg.expr.accept(this.evaluator);
		this.value = !evaluator.value;
	}

	private void visitBinary(BinaryOperation binary, String type) {
		reset();
		binary.left.accept(this.evaluator);
		boolean left = evaluator.value;
		reset();
		binary.right.accept(this.evaluator);
		boolean right = evaluator.value;
		reset();

		switch (type) {
		case "and":
			this.value = left && right;
			break;
		case "or":
			this.value = left || right;
			break;
		case "=>":
			this.value = (!left) || right;
			break;
		case "<=>":
			this.value = left == right;
			break;
		}
	}
}
