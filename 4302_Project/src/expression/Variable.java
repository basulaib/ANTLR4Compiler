package expression;

public abstract class Variable extends Expression {

	protected String ID; // name of the variable
	protected Boolean valueDefined; // is the value defined? This is determined during parsing.
	protected Constant value; // the value assigned to this variable

//	public Variable() {
//		// TODO Auto-generated constructor stub
//	}

	public String getID() {
		return this.ID;
	}

	public Boolean getValueDefined() {
		return valueDefined;
	}

	public void setValueDefined(Boolean valueDefined) {
		this.valueDefined = valueDefined;
	}

	public void setValue(Constant value) {
		this.value = value;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Constant getValue() {
		return value;
	}

}
