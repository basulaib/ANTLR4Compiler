package expression;

import visitor.Visitor;

public class Declaration extends Expression {
	public String ID;
	public Boolean valueDefined;
	public Boolean value;

	public Declaration(String ID) {
		this.ID = ID;
		this.valueDefined = false;
	}

	public Declaration(String ID, Boolean value) {
		this.ID = ID;
		this.value = value;
		this.valueDefined = true;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitDeclaration(this);
	}

}
