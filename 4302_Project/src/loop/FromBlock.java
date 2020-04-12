package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import expression.NumConst;
import function.Assignment;
import program.Declaration;
import visitor.Visitor;

public class FromBlock {
	//from block will contain a regular assignment, until block will contain 
	//thinking to maybe have a joint from until block, not sure though
	//pros of having it joint: one point for initialization and verification of from and until blocks
	//cons: easier for initialization by having them seperate
	
	ArrayList<Assignment> assignments;
	
	public FromBlock() {
		assignments = new ArrayList<>();
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitFromBlock(this);
	}
	
	public void addAssignment(Assignment a) {
		if (!assignments.contains(a)) {
			assignments.add(a);
		}
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assgnmnts) {
		this.assignments = assgnmnts;
	}

}
