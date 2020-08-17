package expression;

import expression.Constant.Type;
import visitor.Visitor;

public class BoolConst extends Constant {
	public BoolConst(boolean value) {
		this.type = Type.bool;
		this.boolValue = value;
	}

	public boolean getValue() {
		return this.boolValue;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitBoolConst(this);
	}
}
