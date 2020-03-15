package program;

import java.util.ArrayList;
import java.util.List;

import expression.*;

public class Assumption {
	private List<Expression> exprs;

	public Assumption() {
		this.exprs = new ArrayList<Expression>();
	}

	public Assumption(List<Expression> exprs) {
		this.exprs = exprs;
	}

	public void addExpr(Expression e) {
		this.exprs.add(e);
	}

	public List<Expression> getExprs() {
		return this.exprs;
	}

}
