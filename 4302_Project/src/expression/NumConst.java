package expression;

import expression.Constant.Type;

public class NumConst extends Constant {
	public NumConst(int value) {
		this.type = Type.num;
		this.numValue = value;
	}

	public int getValue() {
		return this.numValue;
	}
}
