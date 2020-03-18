package expression.binary;

import expression.Expression;
import visitor.Visitor;

public class BiDivision extends BinaryOperation {

	public BiDivision(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitDiv(this);
	}

}
