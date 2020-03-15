package visitor;

import expression.*;

public interface Visitor {
	public void visitConjunction(BiConjunction conjunc);

	public void visitDisjunction(BiDisjunction disjunct);

	public void visitImplication(BiImplication imply);

	public void visitEquivalence(BiEquivalence equal);

	public void visitBoolVariable(BoolVariable bool);

	public void visitDeclaration(Declaration decl);

	public void visitNegation(Negation neg);
}
