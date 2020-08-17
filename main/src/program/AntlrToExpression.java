package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import function.Function;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

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
import antlr.ProjectBaseVisitor;
import expression.*;
import expression.binary.*;
import function.Parameter;
import visitor.TypeChecker;

//
public class AntlrToExpression extends ProjectBaseVisitor<Expression> {

    private Map<String, Declaration> decls; // stores all the variables declared in the program so far
    private HashMap<String, Parameter> parameters;
    private List<String> semanticErrors; // 1. duplicate declaration 2. reference to undeclared variable
    private TypeChecker typeChecker;
    // Note that semantic errors are different from syntactic errors

    public AntlrToExpression(List<String> semanticErrors, Map<String, Declaration> decls) {
        this.decls = decls;
        this.semanticErrors = semanticErrors;
        typeChecker = new TypeChecker();
    }

    public void setParameters(HashMap<String, Parameter> pars) {
        this.parameters = pars;
    }

    @Override
    public Expression visitMultiplication(MultiplicationContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitAddition(AdditionContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitNotEqual(NotEqualContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitSmallerOrEqual(SmallerOrEqualContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitLarger(LargerContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitImplication(ImplicationContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitLargerOrEqual(LargerOrEqualContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitDisjunction(DisjunctionContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitSubtraction(SubtractionContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitEquivalence(EquivalenceContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitEqual(EqualContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitConjunction(ConjunctionContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitDivision(DivisionContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    @Override
    public Expression visitSmaller(SmallerContext ctx) {
        return this.visitBinaryExpr(ctx);
    }

    private Expression visitBinaryExpr(ExprContext ctx) {
        Expression left = visit(ctx.getChild(0));// recursively visit the left subtree of the current addition node
        Expression right = visit(ctx.getChild(2));
        Expression result;

        if (ctx.getChild(1).getText().equals("+")) {
            result = new BiAddition(left, right);
        } else if (ctx.getChild(1).getText().equals("-")) {
            result = new BiSubtraction(left, right);
        } else if (ctx.getChild(1).getText().equals("/")) {
            result = new BiDivision(left, right);
        } else if (ctx.getChild(1).getText().equals("*")) {
            result = new BiMultiplication(left, right);
        } else if (ctx.getChild(1).getText().equals("&&")) {
            result = new BiConjunction(left, right);
        } else if (ctx.getChild(1).getText().equals("||")) {
            result = new BiDisjunction(left, right);
        } else if (ctx.getChild(1).getText().equals(">")) {
            result = new BiLarger(left, right);
        } else if (ctx.getChild(1).getText().equals("<")) {
            result = new BiSmaller(left, right);
        } else if (ctx.getChild(1).getText().equals(">=")) {
            result = new BiLargerOrEqual(left, right);
        } else if (ctx.getChild(1).getText().equals("<=")) {
            result = new BiSmallerOrEqual(left, right);
        } else if (ctx.getChild(1).getText().equals("==")) {
            result = new BiEqual(left, right);
        } else if (ctx.getChild(1).getText().equals("<=>")) {
            result = new BiEquivalence(left, right);
        } else if (ctx.getChild(1).getText().equals("=>")) {
            result = new BiImplication(left, right);
        } else {
            result = new BiNotEqual(left, right);
        }

        //
        TypeChecker.Type typeResult = typeChecker.getTypeResult(result);

        if (typeResult == TypeChecker.Type.ERROR) {
            Token startToken = ctx.getStart();
            int line = startToken.getLine();
            int column = startToken.getCharPositionInLine() + 1;
            String text = ctx.getText();
            //TODO: why the hell do we have duplicated error messages?
            this.semanticErrors.add("Error: expression " + text + " has type error, please make sure the expression is valid (" + line + ", " + column + ")");
        }

        return result;
    }

    @Override
    public Expression visitUnaryExpr(UnaryExprContext ctx) {
        Expression expr = visit(ctx.getChild(1));
        if (ctx.getChild(0).getText().equals("!")) {
            return new Negation(expr);
        }
        /* will add more cases as more features are implemented */
        return new Negation(expr);

    }

    private Expression checkAndReturn(TypeChecker.Type targetType, ExprContext exprContext) {
        Expression expression = this.visit(exprContext);
        TypeChecker.Type type = typeChecker.getTypeResult(expression);

        if (type != targetType) {
            Token token = exprContext.getStart();
            int line = token.getLine();
            int column = token.getCharPositionInLine() + 1;
            semanticErrors.add("Error: expression (" + exprContext.getText() + ")'s type [" + type.toString() + "] does not match target type [" + targetType.toString() + "] (" + line + ", " + column + ")");
        }
        return expression;
    }

    @Override
    public Expression visitArrExpr(ArrExprContext ctx) {
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        String id = ctx.getChild(0).getText();
        Expression index = checkAndReturn(TypeChecker.Type.num, ctx.expr());

        if (!decls.containsKey(id)) {
            semanticErrors.add("Error: array " + id + " not declared (" + line + ", " + column + ")");
            return new ArrayVariable(id, Constant.Type.num, index);
        } else {
            ArrayVariable result = (ArrayVariable) decls.get(id).getVariableReference();
            result.setIndex(index);
            return result;
        }
    }

    @Override
    public Expression visitVarExpr(VarExprContext ctx) {
        // Expression expr = visit(ctx.getChild(0));
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        String id = ctx.getChild(0).getText();

        if (!decls.containsKey(id) && !parameters.containsKey(id)) {
            semanticErrors.add("Error: variable " + id + " not declared (" + line + ", " + column + ")");
            return new NumVariable(id);
        } else {
            return decls.containsKey(id) ? (decls.get(id).getVariableReference())
                    : parameters.get(id).getVariableReference();
        }
    }

    @Override
    public Expression visitParenthesizedExpr(ParenthesizedExprContext ctx) {
        Expression expr = visit(ctx.getChild(1));
        expr.parenthesized = true;
        return expr;
    }

    @Override
    public Expression visitBoolNumExpr(BoolNumExprContext ctx) {
        String exp = ctx.getChild(0).getText();
        Token idToken = ctx.VAR().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        if (exp.charAt(0) == ('"')) {
            if (exp.length() > 2)
                return new StringConst(exp.substring(1, exp.length() - 1));
            else
                return new StringConst("");
        } else if (exp.equals("true")) {
            return new BoolConst(true);
        } else if (exp.equals("false")) {
            return new BoolConst(false);
        } else if (exp.charAt(0) >= '0' || exp.charAt(0) <= '9') {
            return new NumConst(Integer.parseInt(exp));
        } else {
            semanticErrors.add("Error: expression: " + exp + " is not a valid constant (" + line + ", " + column + ")");
            return new BoolConst(false);
        }
    }
}