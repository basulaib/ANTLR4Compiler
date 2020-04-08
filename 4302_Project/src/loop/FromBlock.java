package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import visitor.Visitor;

public class FromBlock {
	//from block will contain a regular assignment, until block will contain 
	//thinking to maybe have a joint from until block, not sure though
	//pros of having it joint: one point for initialization and verification of from and until blocks
	//cons: easier for initialization by having them seperate
	
	String id;
	NumConst value;
	
	public FromBlock(String id, NumConst value) {
		this.id = id;
		this.value = value;
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitFromBlock(this);
	}

	public String getId() {
		return id;
	}

	public NumConst getValue() {
		return value;
	}
	
}
