package program;

import java.util.ArrayList;
import java.util.List;

import expression.*;

public class Assertion {
	private List<Expression> exprs;

	public Assertion() {
		this.exprs = new ArrayList<Expression>();
	}

	public Assertion(List<Expression> exprs) {
		this.exprs = exprs;
	}

	public List<Expression> getExprs() {
		return this.exprs;
	}

	public void addExpression(Expression e) {
		this.exprs.add(e);
	}

}
