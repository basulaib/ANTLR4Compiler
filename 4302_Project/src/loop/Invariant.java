package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class Invariant {
	List<Expression> invariantList;
	
	public Invariant() {
		this.invariantList = new ArrayList<Expression>();
	}
	
	public Invariant(Invariant invariant) {
		this.invariantList = invariant.getInvariantList();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitInvariant(this);
	}

	public List<Expression> getInvariantList() {
		return this.invariantList;
	}
}
