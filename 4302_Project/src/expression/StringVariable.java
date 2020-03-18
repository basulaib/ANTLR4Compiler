package expression;

import visitor.Visitor;

public class StringVariable extends Variable {

	public StringVariable(String ID) {
		this.ID = ID;
	}

	public StringVariable(String ID, Constant value) {
		this.ID = ID;
		this.valueDefined = true;
		this.value = value;
	}

	public String getValue() {
		return ((StringConst) value).strValue;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitStrVar(this);
	}
}
