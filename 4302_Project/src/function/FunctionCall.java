package function;

import expression.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends FuncStatement {
    private String target;
    private List<Expression> parameters;

    public FunctionCall(String target) {
        this.target = target;
        this.parameters = new ArrayList<>();
    }

    public FunctionCall(String target, List<Expression> parameters) {
        this.target = target;
        this.parameters = parameters;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
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
    
	@Override
	public void accept(Visitor visitor) {
		visitor.visitFunctionCall(this);
	}
}
