package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import expression.*;
import visitor.*;

public class Program {
	// done: make the varaible appear in order of declaration
	// done: if something is a tautology, also display it
	// TODO: print out the semantic error list
	// done: add round bracket to everything
	public List<Expression> expressions;// the expression can be declaration expression or constrains
	public List<Expression> constraints;

	public List<String> semanticErrors;

	public HashMap<String, Boolean> declaredBools;

	private StringBuilder tautologyResult;

	public Program(List<String> semanticErrors) {
		this.expressions = new ArrayList<Expression>();
		this.semanticErrors = semanticErrors;
		this.constraints = new ArrayList<Expression>();
		tautologyResult = new StringBuilder();
	}

	public void addExpression(Expression e) {
		if (e.constraint)
			this.constraints.add(e);
		else
			this.expressions.add(e);
	}

	public String GetTautologyResult() {
		if (!this.semanticErrors.isEmpty()) {
			StringBuilder errors = new StringBuilder();
			for (String err : semanticErrors) {
				errors.append(err + "\n");
			}
			return errors.toString();
		}

		this.tautologyResult = new StringBuilder();
		for (Expression expr : constraints) {
			testTautology(expr);
		}

		return this.tautologyResult.toString();
	}

	private void testTautology(Expression e) {
		// get all the variables first
		HashSet<String> variables;
		VariableFinder finder = new VariableFinder();
		e.accept(finder);
		variables = finder.getSet();

		ArrayList<String> sequence = new ArrayList<String>();

		for (Expression expr : this.expressions) {
			if (expr instanceof Declaration) {
				String ID = ((Declaration) expr).ID;
				if (variables.contains(ID) && !sequence.contains(ID)) {
					sequence.add(((Declaration) expr).ID);
				}
			}
		}

		if (variables.contains("true"))
			sequence.add("true");
		if (variables.contains("false"))
			sequence.add("false");

		// now we need to find all the combinations of variables and skip the existing
		// ones

		testValue(sequence, 0, e, (HashMap<String, Boolean>) declaredBools.clone());
	}

	private void testValue(List<String> variables, int index, Expression e, HashMap<String, Boolean> values) {
		if (index == variables.size() - 1) {
			// the base case, test the last element
			String variable = variables.get(index);

			Evaluator evaluator;
			if (values.containsKey(variable)) {
				evaluator = new Evaluator(values);
				e.accept(evaluator);
				if (evaluator.value == false) {
					this.addResult(variables, e, values);
				} else {
					this.addTautologyResult(e);
				}
			} else {
				HashMap<String, Boolean> testTrue = (HashMap<String, Boolean>) values.clone();
				HashMap<String, Boolean> testFalse = (HashMap<String, Boolean>) values.clone();
				testTrue.put(variables.get(index), true);
				testFalse.put(variables.get(index), false);

				evaluator = new Evaluator(testFalse);
				e.accept(evaluator);
				if (evaluator.value == false) {
					this.addResult(variables, e, testFalse);
				} else {
					this.addTautologyResult(e);
				}

				evaluator = new Evaluator(testTrue);
				e.accept(evaluator);
				if (evaluator.value == false) {
					this.addResult(variables, e, testTrue);
				} else {
					this.addTautologyResult(e);
				}
			}
			return;
		}

		if (values.containsKey(variables.get(index))) {
			testValue(variables, index + 1, e, values);
		} else {
			HashMap<String, Boolean> testTrue = (HashMap<String, Boolean>) values.clone();
			HashMap<String, Boolean> testFalse = (HashMap<String, Boolean>) values.clone();
			testTrue.put(variables.get(index), true);
			testFalse.put(variables.get(index), false);

			testValue(variables, index + 1, e, testFalse);
			testValue(variables, index + 1, e, testTrue);
		}
	}

	private HashSet<Expression> tautology = new HashSet<Expression>();
	private HashSet<Expression> notTauto = new HashSet<Expression>();

	private void addTautologyResult(Expression e) {
		// if the expression is in the not tauto, skip
		if (notTauto.contains(e))
			return;
		else if (!tautology.contains(e)) {
			this.tautologyResult.append("==========\n");
			PrettyPrinter printer = new PrettyPrinter();
			e.accept(printer);
			this.tautologyResult.append(printer.printResult + " is a tautology.\n");
			tautology.add(e);
		}
	}

	private void addResult(List<String> variables, Expression e, HashMap<String, Boolean> values) {
		if (tautology.contains(e)) {
			// that means we remove 2 lines of character
			this.tautologyResult.delete(this.tautologyResult.lastIndexOf("==========\n"),
					this.tautologyResult.length());
			tautology.remove(e);
		}

		if (!notTauto.contains(e)) {
			this.tautologyResult.append("==========\n");
			PrettyPrinter printer = new PrettyPrinter();
			e.accept(printer);
			this.tautologyResult.append(printer.printResult + " is not a tautology.\n");
			notTauto.add(e);
		}

		for (String var : variables) {
			if (var.equals("true") || var.equals("false"))
				continue;
			this.tautologyResult.append(var + "=" + values.get(var).toString() + ",");
		}

		this.tautologyResult.deleteCharAt(this.tautologyResult.length() - 1);
		if (this.tautologyResult.charAt(this.tautologyResult.length() - 1) != '\n')
			this.tautologyResult.append('\n');
	}
}
