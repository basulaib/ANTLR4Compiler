//package program;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//import org.antlr.v4.runtime.Token;
//
//import antlr.ExprBaseVisitor;
//import antlr.ExprParser.BooleanContext;
//import antlr.ExprParser.ConjunctionContext;
//import antlr.ExprParser.ConstraintContext;
//import antlr.ExprParser.DeclarationContext;
//import antlr.ExprParser.DisjunctionContext;
//import antlr.ExprParser.EquivalenceContext;
//import antlr.ExprParser.ImplicationContext;
//import antlr.ExprParser.InitializationContext;
//import antlr.ExprParser.NegationContext;
//import antlr.ExprParser.ParenthesizedContext;
//import antlr.ExprParser.VariableContext;
//import expression.*;
//
//public class AntlrToExpression extends ExprBaseVisitor<Expression> {
//	/*
//	 * 
//	 */
////	private List<String> vars; // stores all the variables declared in the program so far
//
//	// TODO: not sure what to do with it so far.
//	private List<String> semanticErrors;// dup decl, ref to undecl
//	private HashMap<String, Boolean> declaredBools;
//	private HashSet<String> vars;
//
//	public AntlrToExpression(List<String> semanticErrors) {
//		this.declaredBools = new HashMap<String, Boolean>();
//		this.semanticErrors = semanticErrors;
//		vars = new HashSet<String>();
//
//		this.declaredBools.put("true", true);
//		this.declaredBools.put("false", false);
//	}
//
//	public HashMap<String, Boolean> getDeclaredBools() {
//		return this.declaredBools;
//	}
//
//	@Override
//	public Expression visitDeclaration(DeclarationContext ctx) {
//		String ID = ctx.ID().getText();
//		boolean value = ctx.bool().getText().equals("true");
//
//		Token idToken = ctx.ID().getSymbol();
//		int line = idToken.getLine();
//		int col = idToken.getCharPositionInLine() + 1;
//
//		if (vars.contains(ID)) {
//			semanticErrors.add("Error: variable " + ID + " already declared (" + line + ", " + col + ")");
//		} else {
//			this.declaredBools.put(ID, value);
//			vars.add(ID);
//		}
//
//		Declaration result = new Declaration(ID, value);
//		return result;
//	}
//
//	@Override
//	public Expression visitInitialization(InitializationContext ctx) {
//		String ID = ctx.ID().getText();
//
//		Token idToken = ctx.ID().getSymbol();
//		int line = idToken.getLine();
//		int col = idToken.getCharPositionInLine() + 1;
//
//		if (vars.contains(ID)) {
//			semanticErrors.add("Error: variable " + ID + " already declared (" + line + ", " + col + ")");
//		} else {
//			vars.add(ID);
//		}
//
//		Declaration result = new Declaration(ID);
//		return result;
//	}
//
//	@Override
//	public Expression visitDisjunction(DisjunctionContext ctx) {
//		// must visit its left and right first
//		Expression left = visit(ctx.getChild(0));
//		Expression right = visit(ctx.getChild(2));
//		BiDisjunction result = new BiDisjunction(left, right);
//		return result;
//	}
//
//	@Override
//	public Expression visitBoolean(BooleanContext ctx) {
//		String boolValue = ctx.bool().getText();
//		BoolVariable variable;
//		variable = new BoolVariable(boolValue, boolValue.equals("true"));
//		return variable;
//	}
//
//	@Override
//	public Expression visitVariable(VariableContext ctx) {
//		// this is the base case for expression
//		String ID = ctx.ID().getText();
//		BoolVariable variable;
////		boolean value = false;
//		if (this.declaredBools.containsKey(ID)) {
//			variable = new BoolVariable(ID, declaredBools.get(ID));
//		} else {
//			variable = new BoolVariable(ID);
//		}
//
//		Token idToken = ctx.ID().getSymbol();
//		int line = idToken.getLine();
//		int col = idToken.getCharPositionInLine() + 1;
//
//		if (!vars.contains(ID)) {
//			semanticErrors.add("Error: variable " + ID + " not declared (" + line + ", " + col + ")");
//		}
//
//		return variable;
//	}
//
//	@Override
//	public Expression visitNegation(NegationContext ctx) {
//		Expression expr = visit(ctx.expr());
//		Negation result = new Negation(expr);
//		return result;
//	}
//
//	@Override
//	public Expression visitEquivalence(EquivalenceContext ctx) {
//		Expression left = visit(ctx.getChild(0));
//		Expression right = visit(ctx.getChild(2));
//		BiEquivalence result = new BiEquivalence(left, right);
//		return result;
//	}
//
//	@Override
//	public Expression visitParenthesized(ParenthesizedContext ctx) {
//		Expression expr = visit(ctx.expr());
//		expr.parenthesized = true;
//		return expr;
//	}
//
//	@Override
//	public Expression visitConjunction(ConjunctionContext ctx) {
//		Expression left = visit(ctx.getChild(0));
//		Expression right = visit(ctx.getChild(2));
//		BiConjunction result = new BiConjunction(left, right);
//		return result;
//	}
//
//	@Override
//	public Expression visitImplication(ImplicationContext ctx) {
//		Expression left = visit(ctx.getChild(0));
//		Expression right = visit(ctx.getChild(2));
//		BiImplication result = new BiImplication(left, right);
//		return result;
//	}
//
//	@Override
//	public Expression visitConstraint(ConstraintContext ctx) {
//		Expression result = visit(ctx.expr());
//		result.constraint = true;
//		return result;
//	}
//
//// I probably don't need this.
////	@Override
////	public Expression visitTrue(TrueContext ctx) {
////
////		// TODO Auto-generated method stub
////		return super.visitTrue(ctx);
////	}
////
////	@Override
////	public Expression visitFalse(FalseContext ctx) {
////		// TODO Auto-generated method stub
////		return super.visitFalse(ctx);
////	}
//}