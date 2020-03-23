package function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expression.*;
import program.WPCalculator;
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

	public void addConditionalStatement(Expression condition) {
		if (this.exprBlocks.containsKey(condition)) {
		} else {
			List<FuncStatement> statements = new ArrayList<FuncStatement>();
			exprBlocks.put(condition, statements);
			this.order.add(condition);
		}
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
		List<Expression> conditions = new ArrayList<Expression>();
		for (Expression expr : this.exprBlocks.keySet()) {
			conditions.add(new Negation(expr));
		}
		Expression defaultCondition = WPCalculator.conjunctAll(conditions, 0, conditions.size() - 1);
		if (this.exprBlocks.containsKey(defaultCondition)) {

			if (statement != null)
				exprBlocks.get(defaultCondition).add(statement);
		} else {
			List<FuncStatement> statements = new ArrayList<FuncStatement>();

			if (statement != null)
				statements.add(statement);

			exprBlocks.put(defaultCondition, statements);
			this.order.add(defaultCondition);
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
