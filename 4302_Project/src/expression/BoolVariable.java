package expression;

import visitor.Visitor;

public class BoolVariable extends Variable {

	public BoolVariable(String ID) {
		this.ID = ID;
	}

	public BoolVariable(String ID, Constant value) {
		this.ID = ID;
		this.valueDefined = true;
		this.value = value;
	}

	public boolean getBoolValue() {
		return ((BoolConst) value).boolValue;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitBoolVar(this);
	}
}
