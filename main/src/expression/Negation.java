package expression;

import visitor.Visitor;

public class Negation extends Expression {

    public Expression expr;

    public Negation(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visitNegation(this);
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

}
