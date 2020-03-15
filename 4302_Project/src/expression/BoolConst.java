package expression;

import expression.Constant.Type;

public class BoolConst extends Constant {
	public BoolConst(boolean value) {
		this.type = Type.bool;
		this.boolValue = value;
	}

	public boolean getValue() {
		return this.boolValue;
	}
}
