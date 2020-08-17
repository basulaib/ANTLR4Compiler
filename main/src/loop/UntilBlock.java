package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class UntilBlock {
	ArrayList<Expression> exprs;
	
	public UntilBlock() {
		exprs = new ArrayList<>();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUntilBlock(this);
	}

	public void addExpr(Expression e) {
		if (!exprs.contains(e)) {
			exprs.add(e);
		}
	}
	
	public ArrayList<Expression> getExprs() {
		return exprs;
	}

	public void setExprs(ArrayList<Expression> exprs) {
		this.exprs = exprs;
	}
	
	
}
