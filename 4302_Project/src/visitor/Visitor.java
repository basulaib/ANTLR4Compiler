package visitor;

import expression.*;
import function.*;

public interface Visitor {
	public void visitConjunction(BiConjunction conjunc);

	public void visitDisjunction(BiDisjunction disjunct);

	public void visitImplication(BiImplication imply);

	public void visitEquivalence(BiEquivalence equal);

	public void visitBoolVariable(BoolVariable bool);

	public void visitDeclaration(Declaration decl);

	public void visitNegation(Negation neg);
	
	public void visitFunction(Function func);
	
	public void visitConditional(Conditional cond);
	
	public void visitAssignment(Assignment assign);
	
	public void visitPreCondition(PreCondition preCond);
	
	public void visitPostCondition(PostCondition postCond);
	
}
