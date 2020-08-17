package function;

import java.util.ArrayList;
import java.util.List;

import expression.Expression;
import visitor.Visitor;

public class PostCondition {
	private List<Expression> postConditions;
	
	public PostCondition() {
		this.postConditions = new ArrayList<Expression>();
	}
	
	public PostCondition(PostCondition postCondition) {
		this.postConditions = postCondition.getPostConditions();
	}
	
	public void addPostCondition(Expression preCondition) {
		this.postConditions.add(preCondition);
	}
	
	public List<Expression> getPostConditions(){
		return this.postConditions;
	}
	
	public void accept(Visitor visitor) {
		visitor.visitPostCondition(this);
	}
}
