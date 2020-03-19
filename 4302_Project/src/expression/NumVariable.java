package expression;

import visitor.Visitor;

public class NumVariable extends Variable {

	public NumVariable(String ID) {
		this.ID = ID;
	}

	public NumVariable(String ID, Constant value) {
		this.ID = ID;
		this.valueDefined = true;
		this.value = value;
	}

	public int getValue() {
		return ((NumConst) value).numValue;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitNumVar(this);
	}
}