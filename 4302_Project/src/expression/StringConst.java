package expression;

import expression.Constant.Type;

public class StringConst extends Constant {
	public StringConst(String value) {
		this.type = Type.string;
		this.strValue = value;
	}

	public String getValue() {
		return this.strValue;
	}
}
