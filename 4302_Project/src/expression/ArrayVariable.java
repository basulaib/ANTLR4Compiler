package expression;

import visitor.Visitor;

public class ArrayVariable extends Variable {
    private Expression index;
    private Constant.Type type;

    public ArrayVariable(String ID, Constant.Type type, Expression index) {
        super();
        this.ID = ID;
        this.index = index;
        this.type = type;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    public Constant.Type getType() {
        return type;
    }

    public void setType(Constant.Type type) {
        this.type = type;
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visitArrayVar(this);
    }
}
