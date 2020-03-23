package program;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

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
import expression.BoolConst;
import expression.Constant;
import expression.NumConst;
import expression.StringConst;
import function.Function;

public class AntlrToClass extends ProjectBaseVisitor<Object> {
	
	List<String> semanticErrors;
	Class c;
	
	public AntlrToClass(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
		this.c = new Class(this.semanticErrors);
	}
	
	@Override
	public Class visitClassBlock(ClassBlockContext ctx) {
		// classBlock: 'class' ID '{' body '}'
		c.setName(ctx.getChild(1).getText());
		visit(ctx.getChild(3));
		return (Class) super.visitClassBlock(ctx);
		
	}

	@Override
	public Object visitClassBody(ClassBodyContext ctx) {
		// body: declBody? (assume | func | assertion)*
		Declaration decl;
		Assumption assump;
		Function func;
		// List<Function> functions = new ArrayList<>();
		Assertion assrt;
		for (ParseTree c : ctx.children) {
			visit(c);
//			if (c instanceof DeclBodyContext) {
//				// decl = (Declaration) visit(c);
//				visit(c);
//			}
//			else if (c instanceof AssumptionContext) {
//				// assump = (Assumption) visit(c);
//				visit(c);
//			}
//			else if (c instanceof FunctionContext) {
//				// func = (Function) visit(c);
//				// functions.add(func);
//				visit(c);
//			}
//			else if (c instanceof AssertionContext) {
//				// assrt = (Assertion) visit(c);
//				visit(c);
//			}
		}
		return super.visitClassBody(ctx);
		
	}

	@Override
	public Object visitDeclBody(DeclBodyContext ctx) {
		// TODO Auto-generated method stub
		
		for (ParseTree c : ctx.children) {
			visit(c);
//			if (c instanceof VarDeclContext) {
//				visit(c);
//			}
//			else if (c instanceof VarInitContext) {
//				
//			}
		}
		return super.visitDeclBody(ctx);
	}

	@Override
	public Object visitVarDecl(VarDeclContext ctx) {
		// TODO Auto-generated method stub
		String type = ctx.getChild(0).getText();
		if (type.equals("int")) {
			Integer value = Integer.parseInt(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new NumConst(value)));
		}
		else if (type.equals("string")) {
			String value = ctx.getChild(3).getText();
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new StringConst(value)));
		}
		else if (type.equals("bool")) {
			Boolean value = Boolean.parseBoolean(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new BoolConst(value)));
		}
		return super.visitVarDecl(ctx);
	}

	@Override
	public Object visitVarInit(VarInitContext ctx) {
		// TODO Auto-generated method stub
		String type = ctx.getChild(0).getText();
		if (type.equals("int")) {
			Integer value = Integer.parseInt(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new NumConst(value)));
		}
		else if (type.equals("string")) {
			String value = ctx.getChild(3).getText();
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new StringConst(value)));
		}
		else if (type.equals("bool")) {
			Boolean value = Boolean.parseBoolean(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			this.c.addDeclaration(new Declaration(id, new BoolConst(value)));
		}
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
