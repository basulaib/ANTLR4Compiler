package expression.binary;

import expression.Expression;
import visitor.Visitor;

public class BiEqual extends BinaryOperation {

	public BiEqual(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitEqual(this);
	}
}
