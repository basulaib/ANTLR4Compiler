package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class Variant {
	ArrayList<Expression> exprs;
	Expression variant;

	
	public Variant() {
		exprs = new ArrayList<>();
	}
	
	public Variant(Variant variant) {
		this.variant = variant.getVariant();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitVariant(this);
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
	public Expression getVariant() {
		return this.variant;
	}	
}
