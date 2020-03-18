package function;

import expression.Expression;
import visitor.Visitor;

public class Assignment extends FuncStatement {
	String id;
	Expression value;

	public Assignment(String id, Expression value) {
		this.id = id;
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitAssignment(this);
	}

	public String getID() {
		return this.id;
	}

	public Expression getExpr() {
		return this.value;
	}
}
