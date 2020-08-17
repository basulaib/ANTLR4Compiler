package function;

import expression.Expression;
import expression.Variable;
import visitor.Visitor;

public class Assignment extends FuncStatement {
    Variable variable;
    //    String id;
    Expression value;

    public Assignment(Variable variable, Expression value) {
//        this.id = id;
        this.variable = variable;
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visitAssignment(this);
    }

    public Variable getVariable() {
        return variable;
    }

    public String getID() {
        return this.variable.getID();
    }

    public Expression getExpr() {
        return this.value;
    }
}
