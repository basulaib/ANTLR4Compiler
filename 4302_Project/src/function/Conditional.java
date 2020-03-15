package function;

import java.util.ArrayList;
import java.util.List;

import visitor.Visitor;

public class Conditional extends FuncStatement {
	List<FuncStatement> conditionalStatements;
	
	public Conditional() {
		this.conditionalStatements = new ArrayList<FuncStatement>();
	}
	
	public Conditional(List<FuncStatement> conditionalStatements) {
		this.conditionalStatements = conditionalStatements;
	}
	
	public void addConditionalStatement(FuncStatement statement) {
		this.conditionalStatements.add(statement);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitConditional(this);
	}
}
