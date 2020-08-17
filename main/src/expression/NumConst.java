package expression;

import expression.Constant.Type;
import visitor.Visitor;

public class NumConst extends Constant {
	public NumConst(int value) {
		this.type = Type.num;
		this.numValue = value;
	}

	public int getValue() {
		return this.numValue;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitNumConst(this);
	}
}
