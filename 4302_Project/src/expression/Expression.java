package expression;

import visitor.*;

public abstract class Expression {
	@Override
	public int hashCode() {
		HashCodeCalculator codeCalculator = new HashCodeCalculator();
		final int prime = 31;
		int result = 1;
		result = prime * result + codeCalculator.getHashCode(this);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO: this is not complete!
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expression other = (Expression) obj;

		PrettyPrinter printer = new PrettyPrinter();

		String myString = printer.getPrintResult(this);
		String otherString = printer.getPrintResult(other);

		return myString.equals(otherString);
	}

	public boolean parenthesized = false;
//	public boolean constraint = false; // is this expression a constraint to be solved?

	public void accept(Visitor visitor) {
	};

}
