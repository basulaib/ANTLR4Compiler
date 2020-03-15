package expression;

import visitor.Visitor;

public class BoolVariable extends Expression {
	public String ID;
	public Boolean valueDefined;
	public Boolean value;

	public BoolVariable(String ID) {
		this.ID = ID;
		this.valueDefined = false;
	}

	public BoolVariable(String ID, Boolean value) {
		this.ID = ID;
		this.valueDefined = true;
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitBoolVariable(this);
	}

}
