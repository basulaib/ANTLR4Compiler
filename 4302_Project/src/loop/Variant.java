package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class Variant {
	Expression variant;
	
	public Variant(Variant variant) {
		this.variant = variant.getVariant();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitVariant(this);
	}

	public Expression getVariant() {
		return this.variant;
	}
}
