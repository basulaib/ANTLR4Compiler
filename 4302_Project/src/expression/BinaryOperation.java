package expression;

public abstract class BinaryOperation extends Expression {
	public Expression left;
	public Expression right;

	public BinaryOperation(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
