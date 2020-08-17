package expression;

import expression.Constant.Type;
import visitor.Visitor;

public class StringConst extends Constant {
	public StringConst(String value) {
		this.type = Type.string;
		this.strValue = value;
	}

	public String getValue() {
		return this.strValue;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitStrConst(this);
	}
}
