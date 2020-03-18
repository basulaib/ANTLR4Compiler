package function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expression.*;
import visitor.Visitor;

public class Conditional extends FuncStatement {
	// TODO: MUST OVERRIDE equal() and hashCode() for this to work!!!
	HashMap<Expression, List<FuncStatement>> exprBlocks;
	List<Expression> order;
//	List<FuncStatement>conditionalStatements;

	public Conditional() {
		this.exprBlocks = new HashMap<Expression, List<FuncStatement>>();
		this.order = new ArrayList<Expression>();
	}

	public Conditional(HashMap<Expression, List<FuncStatement>> exprBlocks) {
		this.exprBlocks = exprBlocks;
	}

	public void addConditionalStatement(Expression condition, FuncStatement statement) {
		if (this.exprBlocks.containsKey(condition)) {
			exprBlocks.get(condition).add(statement);
		} else {
			List<FuncStatement> statements = new ArrayList<FuncStatement>();
			statements.add(statement);
			exprBlocks.put(condition, statements);
			this.order.add(condition);
		}
	}

	public void addConditionalStatement(FuncStatement statement) {
		// make sure you do it for else only
		BoolConst boolTrue = new BoolConst(true);
		if (this.exprBlocks.containsKey(boolTrue)) {
			exprBlocks.get(boolTrue).add(statement);
		} else {
			List<FuncStatement> statements = new ArrayList<FuncStatement>();
			statements.add(statement);
			exprBlocks.put(boolTrue, statements);
			this.order.add(boolTrue);
		}
	}

	public List<Expression> getOrder() {
		return this.order;
	}

	public List<FuncStatement> getStatements(Expression expr) {
		return this.exprBlocks.get(expr);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitConditional(this);
	}
}
