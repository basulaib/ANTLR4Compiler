package expression;

public abstract class Variable extends Expression {

	public String ID; // name of the variable
	public Boolean valueDefined; // is the value defined? This is determined during parsing.
	public Constant value; // the value assigned to this variable

//	public Variable() {
//		// TODO Auto-generated constructor stub
//	}

}
