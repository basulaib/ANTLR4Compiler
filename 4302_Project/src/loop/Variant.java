package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class Variant {
	List<Expression> variantList;
	
	public Variant() {
		this.variantList = new ArrayList<Expression>();
	}
	
	public Variant(Variant variant) {
		this.variantList = variant.getVariantList();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitVariant(this);
	}

	public List<Expression> getVariantList() {
		return this.variantList;
	}
}
