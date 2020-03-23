package program;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ProjectBaseVisitor;
import antlr.ProjectParser.AssertionContext;
import antlr.ProjectParser.AssumptionContext;
import antlr.ProjectParser.BinaryExprContext;
import antlr.ProjectParser.BoolNumExprContext;
import antlr.ProjectParser.ClassBlockContext;
import antlr.ProjectParser.ClassBodyContext;
import antlr.ProjectParser.ConditionalContext;
import antlr.ProjectParser.DeclBodyContext;
import antlr.ProjectParser.ElseConditionalContext;
import antlr.ProjectParser.ElseIfConditionalContext;
import antlr.ProjectParser.FuncBodyContext;
import antlr.ProjectParser.FuncStatementContext;
import antlr.ProjectParser.FunctionBodyContext;
import antlr.ProjectParser.FunctionContext;
import antlr.ProjectParser.IfConditionalContext;
import antlr.ProjectParser.ParamContext;
import antlr.ProjectParser.ParameterContext;
import antlr.ProjectParser.ParenthesizedExprContext;
import antlr.ProjectParser.PostCondContext;
import antlr.ProjectParser.PreCondContext;
import antlr.ProjectParser.UnaryExprContext;
import antlr.ProjectParser.VarDeclContext;
import antlr.ProjectParser.VarExprContext;
import antlr.ProjectParser.VarInitContext;
import expression.BoolConst;
import expression.Constant;
import expression.Expression;
import expression.NumConst;
import expression.StringConst;
import function.Function;
import function.Parameter;
import function.PostCondition;
import function.PreCondition;

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
//			visit(c);
			if (c instanceof DeclBodyContext) {
				// decl = (Declaration) visit(c);
				List<Declaration> ldr = (List<Declaration>) visit(c);
				for (Declaration d : ldr) {
					this.c.addDeclaration(d);
				}
			}
			else if (c instanceof AssumptionContext) {
				// assump = (Assumption) visit(c);
				visit(c);
			}
			else if (c instanceof FunctionContext) {
				// func = (Function) visit(c);
				// functions.add(func);
				visit(c);
			}
			else if (c instanceof AssertionContext) {
				// assrt = (Assertion) visit(c);
				visit(c);
			}
		}
		return super.visitClassBody(ctx);
		
	}

	@Override
	public List<Declaration> visitDeclBody(DeclBodyContext ctx) {
		// TODO Auto-generated method stub
		List<Declaration> result = new ArrayList<>();
		for (ParseTree c : ctx.children) {
			result.add((Declaration) visit(c));
//			if (c instanceof VarDeclContext) {
//				visit(c);
//			}
//			else if (c instanceof VarInitContext) {
//				
//			}
		}
		return result;
	}

	@Override
	public Declaration visitVarDecl(VarDeclContext ctx) {
		// TODO Auto-generated method stub
		Declaration result = new Declaration();
		String type = ctx.getChild(0).getText();
		if (type.equals("int")) {
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, Constant.Type.num);
		}
		else if (type.equals("string")) {
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, Constant.Type.string);
		}
		else if (type.equals("bool")) {
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, Constant.Type.bool);
		}
		return result;
	}

	@Override
	public Declaration visitVarInit(VarInitContext ctx) {
		// TODO Auto-generated method stub
		Declaration result = new Declaration();
		String type = ctx.getChild(0).getText();
		if (type.equals("int")) {
			Integer value = Integer.parseInt(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, new NumConst(value));
		}
		else if (type.equals("string")) {
			String value = ctx.getChild(3).getText();
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, new StringConst(value));
		}
		else if (type.equals("bool")) {
			Boolean value = Boolean.parseBoolean(ctx.getChild(3).getText());
			String id = ctx.getChild(1).getText();
			result = new Declaration(id, new BoolConst(value));
		}
		return result;
	}

	@Override
	public Assumption visitAssumption(AssumptionContext ctx) {
		// TODO Auto-generated method stub
		Assumption result = new Assumption();
		for (ParseTree t : ctx.children) {
			if ((t instanceof BinaryExprContext) || (t instanceof ParenthesizedExprContext) || (t instanceof UnaryExprContext) || (t instanceof VarExprContext) || (t instanceof BoolNumExprContext)) {
				Expression e = (Expression) visit(t);
				result.addExpr(e);
			}
		}
		return result;
	}

	@Override
	public Function visitFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		Function result = new Function("");
		if (ctx.getChild(1).getText().equals("void")) {
			result = new Function(ctx.getChild(2).getText());
			for (ParseTree t : ctx.children) {
				if (t instanceof ParamContext) {
					result.addParameter((Parameter) visit(t));
				}
				if (t instanceof FuncBodyContext) {
					for (ParseTree tt : ((FuncBodyContext) t).children) {
//						if (tt instanceof PreCondContext) {
//							result.addPreCondition((PreCondition) visit(tt));
//						}
//						if (tt instanceof PostCondContext) {
//							result.addPostCondition((PostCondition) visit(tt));
//						}
//						if (tt instanceof FuncStatementContext) {
//							
//						}
					}
				}
			}
		}
		return result;
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
	public Parameter visitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub
		Parameter result = new Parameter(ctx.getChild(0).getText(), ctx.getChild(1).getText());
		return result;
	}

}
