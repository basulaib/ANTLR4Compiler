package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class Invariant {
	ArrayList<Expression> exprs;
	List<Expression> invariantList;

	public Invariant() {
		this.invariantList = new ArrayList<Expression>();
		exprs = new ArrayList<>();

	}
	
	public Invariant(Invariant invariant) {
		this.invariantList = invariant.getInvariantList();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitInvariant(this);
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
	
	public List<Expression> getInvariantList() {
		return this.invariantList;
	}
}
