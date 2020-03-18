//package visitor;
//
//import expression.*;
//
//public class PrettyPrinter implements Visitor {
//
//	public String printResult;
//
//	private PrettyPrinter printer;// we can reuse the same printer
//
//	public PrettyPrinter() {
//		printResult = "";
//	}
//
//	public void reset() {
//		if (this.printer == null)
//			printer = new PrettyPrinter();
//		this.printResult = "";
//	}
//
//	@Override
//	public void visitConjunction(BiConjunction conjunc) {
//		this.visitBinaryOp(conjunc, "and");
//	}
//
//	@Override
//	public void visitDisjunction(BiDisjunction disjunct) {
//		this.visitBinaryOp(disjunct, "or");
//	}
//
//	@Override
//	public void visitImplication(BiImplication imply) {
//		this.visitBinaryOp(imply, "=>");
//	}
//
//	@Override
//	public void visitEquivalence(BiEquivalence equal) {
//		this.visitBinaryOp(equal, "<=>");
//	}
//
//	@Override
//	public void visitBoolVariable(BoolVariable bool) {
//		// this is the base case
//		this.printResult = bool.ID;
//		
////		this.addParenthesis();
//	}
//
//	@Override
//	public void visitDeclaration(Declaration decl) {
//		// this should not be needed at this point;
//	}
//
//	@Override
//	public void visitNegation(Negation neg) {
//		reset();
//		neg.expr.accept(printer);
//		this.printResult = "not " + "(" + printer.printResult + ")";
//		
////		this.addParenthesis();
//	}
//
//	private void visitBinaryOp(BinaryOperation binary, String keyword) {
//		reset();
//		String left, right;
//		binary.left.accept(printer);
//		left = printer.printResult;
//		reset();
//
//		binary.right.accept(printer);
//		right = printer.printResult;
//		reset();
//
//		this.printResult = "(" + left + ")" + " " + keyword + " " + "(" + right + ")";
//
////		this.addParenthesis();
//	}
//
////	private void addParenthesis() {
////		this.printResult = "(" + this.printResult + ")";
////	}
//
//}
