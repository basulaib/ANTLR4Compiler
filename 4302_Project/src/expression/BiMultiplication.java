package expression;

import visitor.*;

public class BiMultiplication extends BinaryOperation {

	public BiMultiplication(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public void accept(Visitor v) {
		v.visitMult(this);
	}

}
