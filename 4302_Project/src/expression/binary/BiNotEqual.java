package expression.binary;

import expression.Expression;
import visitor.Visitor;

public class BiNotEqual extends BinaryOperation {

	public BiNotEqual(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitNotEqual(this);
	}

}
