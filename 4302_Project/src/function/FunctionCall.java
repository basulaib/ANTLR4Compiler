package function;

import expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends FuncStatement {
    private Function target;
    private List<Expression> parameters;

    public FunctionCall(Function target) {
        this.target = target;
        this.parameters = new ArrayList<>();
    }

    public FunctionCall(Function target, List<Expression> parameters) {
        this.target = target;
        this.parameters = parameters;
    }

    public Function getTarget() {
        return target;
    }

    public void setTarget(Function target) {
        this.target = target;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    public void setParameters(List<Expression> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Expression expression) {
        this.parameters.add(expression);
    }
}
