package expression;

import visitor.Visitor;

public class StringVariable extends Variable {

    public StringVariable(String ID) {
        this.ID = ID;
    }

    public StringVariable(String ID, Constant value) {
        super();
        this.ID = ID;
//        this.valueDefined = true;
//        this.value = value;
    }

//    public String getStringValue() {
//        return ((StringConst) value).strValue;
//    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visitStrVar(this);
    }
}
