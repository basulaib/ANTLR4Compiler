package program;

import java.util.*;

import expression.*;
import expression.binary.*;
import function.*;
import visitor.*;

public class WPCalculator {

	public WPCalculator() {
	}

	public Expression getPred(Function func) {
		if (func.getPostCondition().isEmpty())
			return null;
		Expression wp = getWP(func);
		Expression precond = this.conjunctAll(func.getPreCondition(), 0, func.getPreCondition().size() - 1);

		return precond == null ? wp : new BiImplication(precond, wp);
	}

	// passing in the function, it will return the weakest precondition for that
	// function
	private Expression getWP(Function func) {
		Expression postCond = this.conjunctAll(func.getPostCondition(), 0, func.getPostCondition().size() - 1);
		return sequentialCase(func.getStatements(), postCond);
	}

	// the rule for a single statement
	private Expression singleStatement(FuncStatement statement, Expression postCond) {
		if (statement instanceof Assignment) {
			return baseCase((Assignment) statement, postCond);
		} else {
			// conditio
			return conditionalCase((Conditional) statement, postCond);
		}
	}

	// condition rule
	private Expression conditionalCase(Conditional condition, Expression postCond) {
		Expression result;
		List<Expression> originConditions = condition.getOrder();
		// must pre-process the conditions, negate all the previous conditions.
		List<Expression> processedConditions = processCondition(originConditions);

		// must conjunct all of these later
		List<Expression> conjunctPrecond = new ArrayList<Expression>();

		for (int i = 0; i < originConditions.size(); i++) {
			List<FuncStatement> statements = condition.getStatements(originConditions.get(i));
			BiImplication imply = new BiImplication(processedConditions.get(i), sequentialCase(statements, postCond));
			conjunctPrecond.add(imply);
		}

		result = conjunctAll(conjunctPrecond, 0, conjunctPrecond.size() - 1);

		return result;
	}

	// for each conditions, negate all the previous conditions and conjunct them all
	// with it self.
	private List<Expression> processCondition(List<Expression> conditions) {
		List<Expression> result = new ArrayList<Expression>();
		for (int i = 0; i < conditions.size(); i++) {
			List<Expression> currentCondition = new ArrayList<Expression>();
			for (int j = 0; j <= i; j++) {
				if (j == i)
					currentCondition.add(conditions.get(i));
				else
					currentCondition.add(new Negation(conditions.get(j)));
			}
			result.add(conjunctAll(currentCondition, 0, i));
		}
		return result;
	}

	private Expression conjunctAll(List<Expression> exprs, int start, int end) {
		// return the conjunction of all the expression passed in, start, end inclusive
		// lets divide and conquer !!

		if (exprs.isEmpty())
			return null;

		if (end - start == 0) {
			return exprs.get(start);
		} else {
			int mid = (start + end) / 2;
			return new BiConjunction(conjunctAll(exprs, start, mid), conjunctAll(exprs, mid + 1, end));
		}

	}

	// sequential rule
	private Expression sequentialCase(List<FuncStatement> statements, Expression postCond) {
		// we can actually do a loop here

		int current = statements.size() - 1;
		Expression currentPostCond = postCond;

		while (current >= 0) {
			currentPostCond = singleStatement(statements.get(current), currentPostCond);
			current--;
		}

		return currentPostCond;
	}

	// this is the case for only one assignment
	private Expression baseCase(Assignment ass, Expression postCond) {
		String name = ass.getID();
		Expression expr = ass.getExpr();

		// now replace all free occurrences of variable x in postCond with expr

		// make a deep copy of the post condition so we can modify it freely
		DeepCopyMaker copyMaker = new DeepCopyMaker();
		postCond.accept(copyMaker);
		Expression wp = copyMaker.getExprCopy();

		this.replace(name, expr, wp);

		return wp;
	}

	// replace all occurrences of x in R with e.
	private void replace(String x, Expression e, Expression R) {
		// base case
		if (R instanceof Constant)
			return;

		if (R instanceof Negation) {
			replace(x, e, ((Negation) R).expr);
			return;
		}

		if (R instanceof BinaryOperation) {
			Expression left = ((BinaryOperation) R).getLeft();
			Expression right = ((BinaryOperation) R).getRight();

			if (left instanceof Variable) {
				if (((Variable) left).getID().equals(x))
					((BinaryOperation) R).setLeft(e);
			} else {
				// recursive case
				replace(x, e, left);
			}

			if (right instanceof Variable) {
				if (((Variable) right).getID().equals(x))
					((BinaryOperation) R).setRight(e);
			} else {
				// recursive case
				replace(x, e, right);
			}
		} else {
			PrettyPrinter printer = new PrettyPrinter();
			System.err.print("The post condition is neither binary operation nor negation:\n");
			System.err.print(printer.getPrintResult(R) + "\n");
		}

	}

}
