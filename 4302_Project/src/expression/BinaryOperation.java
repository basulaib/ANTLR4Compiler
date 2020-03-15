package expression;

public abstract class BinaryOperation extends Expression {
	private Expression left;
	private Expression right;

	public BinaryOperation(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return this.left;
	}

	public Expression getRight() {
		return this.right;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public void setRight(Expression right) {
		this.right = right;
	}
}
