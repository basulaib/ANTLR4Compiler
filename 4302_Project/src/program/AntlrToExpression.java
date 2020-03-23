package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

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
import antlr.ProjectParser.*;
import antlr.ProjectParser.BinaryExprContext;
import antlr.ProjectBaseVisitor;
import expression.*;
import expression.binary.*;
//
public class AntlrToExpression extends ProjectBaseVisitor<Expression> {
    private Map<String, Variable> vars; //stores all the variables declared in the program so far
    private List<String> semanticErrors; //1. duplicate declaration 2. reference to undeclared variable
    //Note that semantic errors are different from syntactic errors


    public AntlrToExpression(List<String> semanticErrors, Map<String, Variable> vars) {
        this.vars = vars;
        this.semanticErrors = semanticErrors;

    }

    public Expression visitBinaryExpr(BinaryExprContext ctx){
        Expression left = visit(ctx.getChild(0));// recursively visit the left subtree of the current addition node
        Expression right = visit(ctx.getChild(2));
        if(ctx.getChild(1).getText().equals("+")) {
        	return new BiAddition(left, right);
        }
        else if(ctx.getChild(1).getText().equals("-")) {
        	return new BiSubtraction(left, right);
        }
        else if(ctx.getChild(1).getText().equals("/")) {
        	return new BiDivision(left, right);
        }
        else if(ctx.getChild(1).getText().equals("*")) {
        	return new BiMultiplication(left, right);
        }
        else if(ctx.getChild(1).getText().equals("&&")) {
        	return new BiConjunction(left, right);
        }
        else if(ctx.getChild(1).getText().equals("||")) {
        	return new BiDisjunction(left, right);
        }
        else if(ctx.getChild(1).getText().equals(">")) {
        	return new BiLarger(left, right);
        }
        else if(ctx.getChild(1).getText().equals("<")) {
        	return new BiSmaller(left, right);
        }
        else if(ctx.getChild(1).getText().equals(">=")) {
        	return new BiLargerOrEqual(left, right);
        }
        else if(ctx.getChild(1).getText().equals("<=")) {
        	return new BiSmallerOrEqual(left, right);
        }
        else if(ctx.getChild(1).getText().equals("==")) {
        	return new BiEquivalence(left, right);
        }
        else {
        	return new BiNotEqual(left, right);
        }

    }
    
    public Expression visitUnaryExpr(UnaryExprContext ctx) {
    	Expression expr = visit(ctx.getChild(1));
    	if(ctx.getChild(0).getText().equals("!")) {
    		return new Negation(expr);
    	}
    	/*will add more cases as more features are implemented*/
    	return new Negation(expr);
    	
    }
    
    public Expression visitVarExpr(VarExprContext ctx) {
    	//Expression expr = visit(ctx.getChild(0));
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		
    	if(!vars.containsKey(ctx.getChild(0).getText())) {
    		semanticErrors.add("Error: variable " + id + " not declared (" + line + ", " + column + ")");
    	}
    	return vars.get(ctx.getChild(0).getText());
    }
    
    public Expression visitParenthesizedExpr(ParenthesizedExprContext ctx) {
    	Expression expr = visit(ctx.getChild(1));
    	expr.parenthesized = true;
    	return expr;
    }
    
    public Expression visitBoolNumExpr(BoolNumExprContext ctx) {
    	String exp = ctx.getChild(0).getText();
		Token idToken = ctx.getToken(0,1).getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
    	
    	if(exp.charAt(0) == ('\"')) {
    		return new StringConst(exp.substring(1,exp.length()-1));
    	}else if(exp.equals("true")) {
    		return new BoolConst(true);
    	}else if(exp.equals("false")) {
    		return new BoolConst(false);
    	}else if(exp.charAt(0) >= '0' || exp.charAt(0) <= '9') {
    		return new NumConst(Integer.parseInt(exp));
    	}else {
    		semanticErrors.add("Error: expression: " + exp + " is not a valid constant (" + line + ", " + column + ")");
    		return new BoolConst(false);
    	}
    }
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
}