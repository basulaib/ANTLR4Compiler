package program;

import java.util.ArrayList;
import java.util.List;

import antlr.ProjectBaseVisitor;
import antlr.ProjectParser.AssertionContext;
import antlr.ProjectParser.AssumptionContext;
import antlr.ProjectParser.ClassBlockContext;
import antlr.ProjectParser.ClassBodyContext;
import antlr.ProjectParser.ConditionalContext;
import antlr.ProjectParser.DeclBodyContext;
import antlr.ProjectParser.ElseConditionalContext;
import antlr.ProjectParser.ElseIfConditionalContext;
import antlr.ProjectParser.FuncStatementContext;
import antlr.ProjectParser.FunctionBodyContext;
import antlr.ProjectParser.FunctionContext;
import antlr.ProjectParser.IfConditionalContext;
import antlr.ProjectParser.ParameterContext;
import antlr.ProjectParser.ParenthesizedExprContext;
import antlr.ProjectParser.PostCondContext;
import antlr.ProjectParser.PreCondContext;
import antlr.ProjectParser.VarDeclContext;
import antlr.ProjectParser.VarInitContext;

public class AntlrToClass extends ProjectBaseVisitor<Object> {

	@Override
	public Class visitClassBlock(ClassBlockContext ctx) {
		// classBlock: 'class' ID '{' body '}'
		return (Class) super.visitClassBlock(ctx);
	}

	@Override
	public Object visitClassBody(ClassBodyContext ctx) {
		// body: (declBody | assume | func | assertion)*
		return super.visitClassBody(ctx);
	}

	@Override
	public Object visitDeclBody(DeclBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeclBody(ctx);
	}

	@Override
	public Object visitVarDecl(VarDeclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVarDecl(ctx);
	}

	@Override
	public Object visitVarInit(VarInitContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVarInit(ctx);
	}

	@Override
	public Object visitAssumption(AssumptionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssumption(ctx);
	}

	@Override
	public Object visitParenthesizedExpr(ParenthesizedExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParenthesizedExpr(ctx);
	}

	@Override
	public Object visitFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunction(ctx);
	}

	@Override
	public Object visitFunctionBody(FunctionBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionBody(ctx);
	}

	@Override
	public Object visitFuncStatement(FuncStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFuncStatement(ctx);
	}

	@Override
	public Object visitPreCond(PreCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPreCond(ctx);
	}

	@Override
	public Object visitPostCond(PostCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPostCond(ctx);
	}

	@Override
	public Object visitAssertion(AssertionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssertion(ctx);
	}

	@Override
	public Object visitConditional(ConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConditional(ctx);
	}

	@Override
	public Object visitIfConditional(IfConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfConditional(ctx);
	}

	@Override
	public Object visitElseIfConditional(ElseIfConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElseIfConditional(ctx);
	}

	@Override
	public Object visitElseConditional(ElseConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElseConditional(ctx);
	}

	@Override
	public Object visitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParameter(ctx);
	}

}
