package function;

import java.util.ArrayList;
import java.util.List;

import expression.Expression;
import visitor.Visitor;

public class PreCondition {
	private List<Expression> preConditions;
	
	public PreCondition() {
		this.preConditions = new ArrayList<Expression>();
	}
	
	public PreCondition(PreCondition preCondition) {
		this.preConditions = preCondition.getPreConditions();
	}
	
	public void addPreCondition(Expression preCondition) {
		this.preConditions.add(preCondition);
	}
	
	public List<Expression> getPreConditions(){
		return this.preConditions;
	}
	
	public void accept(Visitor visitor) {
		visitor.visitPreCondition(this);
	}
}
