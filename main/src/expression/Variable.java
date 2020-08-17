package expression;

public abstract class Variable extends Expression {

    protected String ID; // name of the variable
    //    protected boolean valueDefined; // is the value defined? This is determined during parsing.
//    protected Constant value; // the value assigned to this variable
    protected boolean free; //only free variables can be replaced with expression during wp calculation.

    protected Variable() {
        free = true;
    }

//	public Variable() {
//		// TODO Auto-generated constructor stub
//	}

    public String getID() {
        return this.ID;
    }

//    public boolean getValueDefined() {
//        return valueDefined;
//    }

//    public void setValueDefined(Boolean valueDefined) {
//        this.valueDefined = valueDefined;
//    }
//
//    public void setValue(Constant value) {
//        this.value = value;
//    }

    public void setID(String iD) {
        ID = iD;
    }

//    public Constant getValue() {
//        return value;
//    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
