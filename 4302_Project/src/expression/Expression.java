package expression;

import visitor.Visitor;

public abstract class Expression {
	public boolean parenthesized = false;
	public boolean constraint = false; // is this expression a constraint to be solved?

	public void accept(Visitor visitor) {
	};
}
