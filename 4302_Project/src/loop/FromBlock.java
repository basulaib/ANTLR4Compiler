package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import program.Declaration;
import visitor.Visitor;

public class FromBlock {
	//from block will contain a regular assignment, until block will contain 
	//thinking to maybe have a joint from until block, not sure though
	//pros of having it joint: one point for initialization and verification of from and until blocks
	//cons: easier for initialization by having them seperate
	
	ArrayList<Declaration> decs;
	
	public FromBlock() {
		decs = new ArrayList<>();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitFromBlock(this);
	}
	
	public void addDeclaration(Declaration d) {
		if (!decs.contains(d)) {
			decs.add(d);
		}
	}

	public ArrayList<Declaration> getDecs() {
		return decs;
	}

	public void setDecs(ArrayList<Declaration> decs) {
		this.decs = decs;
	}

}
