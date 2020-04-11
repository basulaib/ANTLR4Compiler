package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import function.FuncStatement;
import visitor.Visitor;

public class Loop {
	FromBlock fromBlock;
	UntilBlock untilBlock;
	Invariant invariant;
	Variant variant;
	List<FuncStatement> statementList;
	
//	public Loop() {
//		this.fromBlock = new FromBlock();
//		this.untilBlock = new UntilBlock();
//		this.invariant = new Invariant();
//		this.variant = new Variant();
//		this.statementList = new ArrayList<FuncStatement>();
//	}
	
	public Loop(FromBlock fromBlock, UntilBlock untilBlock, Invariant invariant, Variant variant, List<FuncStatement> statementList) {
		this.fromBlock = fromBlock;
		this.untilBlock = untilBlock;
		this.invariant = invariant;
		this.variant = variant;
		this.statementList = statementList;
	}
	
	public Loop() {
	}
	
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitLoop(this);
	}
	
	public FromBlock getFromBlock() {
		return fromBlock;
	}

	public void setFromBlock(FromBlock fromBlock) {
		this.fromBlock = fromBlock;
	}

	public UntilBlock getUntilBlock() {
		return untilBlock;
	}

	public void setUntilBlock(UntilBlock untilBlock) {
		this.untilBlock = untilBlock;
	}

	public Invariant getInvariant() {
		return invariant;
	}

	public void setInvariant(Invariant invariant) {
		this.invariant = invariant;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	public List<FuncStatement> getStatementList() {
		return statementList;
	}

	public void setStatementList(List<FuncStatement> statementList) {
		this.statementList = statementList;
	}
	
	
}
