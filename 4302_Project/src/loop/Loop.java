package loop;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import function.FuncStatement;
import visitor.Visitor;

public class Loop extends FuncStatement{
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
	
	public Loop(FromBlock fromBlock, UntilBlock untilBlock, Variant variant) {
		this.fromBlock = fromBlock;
		this.untilBlock = untilBlock;
		this.invariant = new Invariant();
		this.variant = variant;
		this.statementList = new ArrayList<FuncStatement>();
	}
	
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

	public Expression getUntilBlock() {
		return untilBlock.getExpr();
	}

	public void setUntilBlock(UntilBlock untilBlock) {
		this.untilBlock = untilBlock;
	}

	public List<Expression> getInvariant() {
		return invariant.getInvariantList();
	}

	public void setInvariant(Invariant invariant) {
		this.invariant = invariant;
	}

	public Expression getVariant() {
		return variant.getVariant();
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
