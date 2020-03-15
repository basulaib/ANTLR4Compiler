package visitor;

import java.util.ArrayList;
import java.util.HashSet;

import expression.BiConjunction;
import expression.BiDisjunction;
import expression.BiEquivalence;
import expression.BiImplication;
import expression.BoolVariable;
import expression.Declaration;
import expression.Negation;

//it finds all the variables of an expression
public class VariableFinder implements Visitor {

	private HashSet<String> variables;
	private ArrayList<String> sequence;
//	private VariableFinder finder;

	public VariableFinder() {
		this.variables = new HashSet<String>();
		this.sequence = new ArrayList<String>();
//		finder = new VariableFinder(this.variables);
	}

	public HashSet<String> getSet() {
		return this.variables;
	}

	public ArrayList<String> getSequence() {
		return this.sequence;
	}

	@Override
	public void visitConjunction(BiConjunction conjunc) {
		conjunc.left.accept(this);
		conjunc.right.accept(this);
	}

	@Override
	public void visitDisjunction(BiDisjunction disjunct) {
		disjunct.left.accept(this);
		disjunct.right.accept(this);
	}

	@Override
	public void visitImplication(BiImplication imply) {
		imply.left.accept(this);
		imply.right.accept(this);
	}

	@Override
	public void visitEquivalence(BiEquivalence equal) {
		equal.left.accept(this);
		equal.right.accept(this);
	}

	@Override
	public void visitBoolVariable(BoolVariable bool) {
		// base case
		if (!this.variables.contains(bool.ID)) {
			this.variables.add(bool.ID);
			this.sequence.add(bool.ID);
		}
	}

	@Override
	public void visitDeclaration(Declaration decl) {
		// this might not be needed
	}

	@Override
	public void visitNegation(Negation neg) {
		neg.expr.accept(this);
	}

}
