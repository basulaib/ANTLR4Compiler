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
import antlr.ProjectParser.ExprContext;
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
import function.Assignment;
import function.Conditional;
import function.FuncStatement;
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
		return c;
	}

	@Override
	public Object visitClassBody(ClassBodyContext ctx) {
//		body: declBody? (assume | func | assertion)*
//		Declaration decl;
//		Assumption assump;
//		Function func;
//		List<Function> functions = new ArrayList<>();
//		Assertion assrt;
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
				this.c.addAssumption((Assumption) visit(c));
			}
			else if (c instanceof FunctionContext) {
				// func = (Function) visit(c);
				// functions.add(func);
				this.c.addFunction((Function) visit(c));
			}
			else if (c instanceof AssertionContext) {
				// assrt = (Assertion) visit(c);
				this.c.addAssertion((Assertion) visit(c));
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
// (t instanceof BinaryExprContext) || (t instanceof ParenthesizedExprContext) || (t instanceof UnaryExprContext) || (t instanceof VarExprContext) || (t instanceof BoolNumExprContext)
			if (t instanceof ExprContext) {
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
			for (ParseTree funcTree : ctx.children) {
				if (funcTree instanceof ParamContext) {
					result.addParameter((Parameter) visit(funcTree));
				}
				if (funcTree instanceof FuncBodyContext) {
					for (ParseTree funcBodyTree : ((FuncBodyContext) funcTree).children) {
						if (funcBodyTree instanceof PreCondContext) {
							result.setPreCondition((PreCondition) visit(funcBodyTree));
						}
						if (funcBodyTree instanceof PostCondContext) {
							result.setPostCondition((PostCondition) visit(funcBodyTree));
						}
						if (funcBodyTree instanceof FuncStatementContext) {
							for (ParseTree funcStatementTree : ((FuncStatementContext) funcBodyTree).children) {
								result.addStatement((FuncStatement) visit(funcStatementTree));
							}
						}
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
	public FuncStatement visitFuncStatement(FuncStatementContext ctx) {
		// TODO Auto-generated method stub
		FuncStatement result = null;
		if (!(ctx.getChild(0) instanceof ConditionalContext)) { // Assignment
			result = new Assignment(ctx.getChild(0).getText(), (Expression) visit(ctx.getChild(2)));
		}
		else {
			result = (Conditional) visit(ctx.getChild(0));
		}
		return result;
	}

	@Override
	public PreCondition visitPreCond(PreCondContext ctx) {
		// TODO Auto-generated method stub
		PreCondition result = new PreCondition();
		for (ParseTree t : ctx.children) {
			if (t instanceof ExprContext) {
				result.addPreCondition((Expression) visit(t));
			}
		}
		return result;
	}

	@Override
	public PostCondition visitPostCond(PostCondContext ctx) {
		// TODO Auto-generated method stub
		PostCondition result = new PostCondition();
		for (ParseTree t : ctx.children) {
			if (t instanceof ExprContext) {
				result.addPostCondition((Expression) visit(t));
			}
		}
		return result;
	}

	@Override
	public Assertion visitAssertion(AssertionContext ctx) {
		// TODO Auto-generated method stub
		Assertion result = new Assertion();
		for (ParseTree t : ctx.children) {
			if (t instanceof ExprContext) {
				result.addExpression((Expression) visit(t));
			}
		}
		return result;
	}

	@Override
	public Conditional visitConditional(ConditionalContext ctx) {
		// TODO Auto-generated method stub
		Conditional result = new Conditional();
		Expression e;
		FuncStatement fs;
		for (ParseTree t : ctx.children) { // blocks
			if (t instanceof IfConditionalContext) {
				if (((IfConditionalContext) t).children.size() > 6) { // statements exist
					e = (Expression) visit(t.getChild(2));
					for (ParseTree tt : ((IfConditionalContext) t).children) {
						if (tt instanceof FuncStatementContext) {
							fs = (FuncStatement) visit(tt);
							result.addConditionalStatement(e, fs);
						}
					}
				}
				else {
					e = (Expression) visit(t.getChild(2));
					result.addConditionalStatement(e);
				}
			}
			else if (t instanceof ElseIfConditionalContext) {
				if (((ElseIfConditionalContext) t).children.size() > 6) { // statements exist
					e = (Expression) visit(t.getChild(2));
					for (ParseTree tt : ((ElseIfConditionalContext) t).children) {
						if (tt instanceof FuncStatementContext) {
							fs = (FuncStatement) visit(tt);
							result.addConditionalStatement(e, fs);
						}
					}
				}
				else {
					e = (Expression) visit(t.getChild(2));
					result.addConditionalStatement(e);
				}
			}
			else {
				for (ParseTree tt : ((ElseConditionalContext) t).children) {
					if (tt instanceof FuncStatementContext) {
						fs = (FuncStatement) visit(tt);
						result.addConditionalStatement(fs);
					}
				}
			}
		}
		return result;
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
