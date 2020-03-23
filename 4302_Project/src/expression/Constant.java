package expression;

public abstract class Constant extends Expression {
	public Type type;
	protected String strValue;
	protected int numValue;
	protected boolean boolValue;

// you need to set the value during initialization
//	public Constant() {
//		
//	}

//	public Constant(boolean value) {
//		this.type = Type.bool;
//		this.boolValue = value;
//	}

//	public Constant(int value) {
//		this.type = Type.num;
//		this.numValue = value;
//	}

	public boolean getBoolValue() {
		return this.boolValue;
	}

	public String getStrValue() {
		return this.strValue;
	}

	public int getNumValue() {
		return this.numValue;
	}

	public enum Type {
		string, bool, num
	}
}
