package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class UntilBlock {
	Expression expr;
	
	public UntilBlock(Expression expr) {
		this.expr = expr;
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUntilBlock(this);
	}

	public Expression getExpr() {
		return expr;
	}
	
}
