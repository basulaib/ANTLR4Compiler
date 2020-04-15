package program;

import java.util.*;

import expression.*;
import expression.binary.BiEquivalence;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ProjectBaseVisitor;
import antlr.ProjectParser.AssertionContext;
import antlr.ProjectParser.AssumptionContext;
import antlr.ProjectParser.BoolNumExprContext;
import antlr.ProjectParser.ClassBlockContext;
import antlr.ProjectParser.ClassBodyContext;
import antlr.ProjectParser.ConditionalContext;
import antlr.ProjectParser.CaseContext;
import antlr.ProjectParser.DeclBodyContext;
import antlr.ProjectParser.DeclContext;
import antlr.ProjectParser.DefaultContext;
import antlr.ProjectParser.DoBlockContext;
import antlr.ProjectParser.DoBodyContext;
import antlr.ProjectParser.ElseConditionalContext;
import antlr.ProjectParser.ElseIfConditionalContext;
import antlr.ProjectParser.ExprContext;
import antlr.ProjectParser.FromBlockContext;
import antlr.ProjectParser.FromBodyContext;
import antlr.ProjectParser.FuncBodyContext;
import antlr.ProjectParser.FuncStatementContext;
import antlr.ProjectParser.FunctionBodyContext;
import antlr.ProjectParser.FunctionContext;
import antlr.ProjectParser.IfConditionalContext;
import antlr.ProjectParser.InvariantBlockContext;
import antlr.ProjectParser.InvariantBodyContext;
import antlr.ProjectParser.LoopContext;
import antlr.ProjectParser.ParamContext;
import antlr.ProjectParser.ParameterContext;
import antlr.ProjectParser.ParenthesizedExprContext;
import antlr.ProjectParser.PostCondContext;
import antlr.ProjectParser.PreCondContext;
import antlr.ProjectParser.SwitchContext;
import antlr.ProjectParser.SwitchBodyContext;
import antlr.ProjectParser.UnaryExprContext;
import antlr.ProjectParser.UntilBlockContext;
import antlr.ProjectParser.UntilBodyContext;
import antlr.ProjectParser.VarDeclContext;
import antlr.ProjectParser.VarExprContext;
import antlr.ProjectParser.VarInitContext;
import antlr.ProjectParser.VariantBlockContext;
import antlr.ProjectParser.VariantBodyContext;
import antlr.ProjectParser.FunctionCallContext;
import function.Assignment;
import function.Conditional;
import function.FuncStatement;
import function.Function;
import function.FunctionCall;
import function.Parameter;
import function.PostCondition;
import function.PreCondition;
import loop.FromBlock;
import loop.Invariant;
import loop.Loop;
import loop.UntilBlock;
import loop.Variant;
import visitor.TypeChecker;
import visitor.TypeChecker.Type;

public class AntlrToClass extends ProjectBaseVisitor<Object> {

    Map<String, Declaration> decls;
    List<String> semanticErrors;
    Class c;
    AntlrToExpression toExpression;
    TypeChecker typeChecker;
    private HashMap<String, Parameter> currentPars; //the current parameters for the currentFunc
    private Function currentFunc; //the current function being visited, must be NULL if the function is returned.
    private Expression switchExpression; //Expression used in comparison in the switch block
    
    public AntlrToClass(List<String> semanticErrors, Map<String, Declaration> decls) {
        this.semanticErrors = semanticErrors;
        this.c = new Class(this.semanticErrors);
        toExpression = new AntlrToExpression(this.semanticErrors, decls);
        typeChecker = new TypeChecker();
        this.decls = decls;
    }

    //check the error and return the expression
    private Expression checkAndReturn(TypeChecker.Type targetType, ExprContext exprContext) {
        Expression expression = this.toExpression.visit(exprContext);
        TypeChecker.Type type = typeChecker.getTypeResult(expression);

        if (type != targetType) {
            Token token = exprContext.getStart();
            int line = token.getLine();
            int column = token.getCharPositionInLine() + 1;
            semanticErrors.add("Error: expression (" + exprContext.getText() + ")'s type [" + type.toString() + "] does not match target type [" + targetType.toString() + "] (" + line + ", " + column + ")");
        }
        return expression;
    }

    private TypeChecker.Type getVariableType(String id) {
        //search and return the correct type of a variable if you encounter
        //we should need this only during variable re-assignment, use this with checkAndReturn!
        Parameter parameter = currentPars.getOrDefault(id, null);
        Declaration declaration = decls.getOrDefault(id, null);
        TypeChecker.Type idType = parameter == null ? typeChecker.getTypeResult(declaration) : typeChecker.getTypeResult(parameter);

        return idType;
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
            } else if (c instanceof AssumptionContext) {
                // assump = (Assumption) visit(c);
                this.c.addAssumption((Assumption) visit(c));
            } else if (c instanceof FunctionContext) {
                // func = (Function) visit(c);
                // functions.add(func);
                this.c.addFunction((Function) visit(c));
            } else if (c instanceof AssertionContext) {
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
            if (c instanceof DeclContext)
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
        Declaration result = new Declaration();
        String type = ctx.getChild(0).getText();
        if (type.equals("int")) {
            String id = ctx.getChild(1).getText();
            result = new Declaration(id, Constant.Type.num);
        } else if (type.equals("string")) {
            String id = ctx.getChild(1).getText();
            result = new Declaration(id, Constant.Type.string);
        } else if (type.equals("bool")) {
            String id = ctx.getChild(1).getText();
            result = new Declaration(id, Constant.Type.bool);
        }

        this.decls.put(result.getID(), result);
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
        } else if (type.equals("string")) {
            String value = ctx.getChild(3).getText().substring(1, ctx.getChild(3).getText().length() - 1);
            String id = ctx.getChild(1).getText();
            result = new Declaration(id, new StringConst(value));
        } else if (type.equals("bool")) {
            Boolean value = Boolean.parseBoolean(ctx.getChild(3).getText());
            String id = ctx.getChild(1).getText();
            result = new Declaration(id, new BoolConst(value));
        }
        this.decls.put(result.getID(), result);
        return result;
    }

    @Override
    public Assumption visitAssumption(AssumptionContext ctx) {
        // TODO Auto-generated method stub
        Assumption result = new Assumption();
        for (ParseTree t : ctx.children) {
// (t instanceof BinaryExprContext) || (t instanceof ParenthesizedExprContext) || (t instanceof UnaryExprContext) || (t instanceof VarExprContext) || (t instanceof BoolNumExprContext)
            if (t instanceof ExprContext) {
                Expression e = toExpression.visit(t);
                result.addExpr(e);
            }
        }
        return result;
    }

    @Override
    public Function visitFunction(FunctionContext ctx) {
        // TODO Auto-generated method stub
        Function result = new Function("");
        currentFunc = result;
        // if its not void, we can still calculate the wp
//		if (ctx.getChild(1).getText().equals("void")) {
        result = new Function(ctx.getChild(2).getText());

        currentPars = new HashMap<String, Parameter>();
        this.toExpression.setParameters(currentPars);
        for (ParseTree funcTree : ctx.children) {
            if (funcTree instanceof ParamContext) {
                Parameter par = (Parameter) visit(funcTree);
                currentPars.put(par.getID(), par);
                result.addParameter(par);
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
                        result.addStatement((FuncStatement) visit(funcBodyTree));
                    }
                }
            }
        }

        currentFunc = null;
        currentPars = null;
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
        if (ctx.getChild(0) instanceof ConditionalContext) {
            result = (Conditional) visit(ctx.getChild(0));
        } else if (ctx.getChild(0) instanceof LoopContext) {
            result = (Loop) visit(ctx.getChild(0));
        } else if (ctx.getChild(0) instanceof FunctionCallContext) {
            result = (FunctionCall) visit(ctx.getChild(0));
        }else if (ctx.getChild(0) instanceof SwitchContext){
        	result = (Conditional) visit(ctx.getChild(0));
        } else { // Assignment
            String id = ctx.getChild(0).getText();
            Expression expression;
            if (!decls.containsKey(id) && !currentPars.containsKey(id)) {
                //if the ID of the assignment is not declared, semantic error
                Token idToken = ctx.ID().getSymbol();
                int line = idToken.getLine();
                int column = idToken.getCharPositionInLine() + 1;
                semanticErrors.add("Error: variable " + id + " not declared (" + line + ", " + column + ")");
                expression = this.toExpression.visit(ctx.expr());
            } else {
                TypeChecker.Type idType = getVariableType(id);
                expression = checkAndReturn(idType, ctx.expr());
            }

            result = new Assignment(ctx.getChild(0).getText(), expression);
        }
        return result;
    }

    @Override
    public PreCondition visitPreCond(PreCondContext ctx) {
        // TODO Auto-generated method stub
        PreCondition result = new PreCondition();
        for (ParseTree t : ctx.children) {
            if (t instanceof ExprContext) {
                result.addPreCondition(checkAndReturn(TypeChecker.Type.bool, (ExprContext) t));
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
                result.addPostCondition(checkAndReturn(TypeChecker.Type.bool, (ExprContext) t));
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
                result.addExpression(checkAndReturn(TypeChecker.Type.bool, (ExprContext) t));
            }
        }
        return result;
    }
    
    @Override
    public Conditional visitSwitch(SwitchContext ctx) {
    	switchExpression = toExpression.visit(ctx.getChild(2));
    	return visitSwitchBody((SwitchBodyContext) ctx.getChild(5));
    }
    
    @Override
    public Conditional visitSwitchBody(SwitchBodyContext ctx) {
    	//
    	Conditional result = new Conditional();
    	FuncStatement fs;
    	Expression e = null;
    	for(ParseTree t: ctx.children) {
    		if(t instanceof CaseContext) {
    			for(ParseTree tt : ((ParserRuleContext) t).children ) {
    				if(tt instanceof FuncStatementContext) {
    					fs = (FuncStatement) visit(tt);
    					Expression condition = new BiEquivalence(switchExpression, e);
    					result.addConditionalStatement(condition, fs);
    				}else if(tt instanceof ExprContext) {
    					e = toExpression.visit(tt); 
    				}
    			}
    		}else if(t instanceof DefaultContext) {
    			boolean emptyBlock = true;
    			for(ParseTree tt : ((ParserRuleContext) t).children ) {
    				if(tt instanceof FuncStatementContext) {
    					fs = (FuncStatement) visit(tt);
    					result.addConditionalStatement(fs);
    					emptyBlock = false;
    				}
    			}
    			if (emptyBlock) {
    				FuncStatement nullStatement = null;
                    result.addConditionalStatement(nullStatement);
    			}
    		}
    	}    	
    	switchExpression = null;
    	return result;
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        // TODO Auto-generated method stub
        Conditional result = new Conditional();
        Expression e;
        FuncStatement fs;
        for (ParseTree t : ctx.children) { // blocks
            if (t instanceof IfConditionalContext || t instanceof ElseIfConditionalContext) {
                e = checkAndReturn(TypeChecker.Type.bool, (ExprContext) t.getChild(2));
                if (((ParserRuleContext) t).children.size() > 6) { // statements exist
                    for (ParseTree tt : ((ParserRuleContext) t).children) {
                        if (tt instanceof FuncStatementContext) {
                            fs = (FuncStatement) visit(tt);
                            result.addConditionalStatement(e, fs);
                        }
                    }
                } else {
                    FuncStatement nullStatement = null;
                    result.addConditionalStatement(e, nullStatement);
                }
            } else {
                boolean emptyBlock = true;
                for (ParseTree tt : ((ElseConditionalContext) t).children) {
                    if (tt instanceof FuncStatementContext) {
                        fs = (FuncStatement) visit(tt);
                        result.addConditionalStatement(fs);
                        emptyBlock = false;
                    }
                }
                if (emptyBlock) {
                    FuncStatement nullStatement = null;
                    result.addConditionalStatement(nullStatement);
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

    @Override
    public Object visitLoop(LoopContext ctx) {
        // TODO Auto-generated method stub
        Loop result = new Loop();
        for (ParseTree t : ctx.children) {
            if (t instanceof FromBlockContext) {
                FromBlock fb = (FromBlock) visit(t);
                result.setFromBlock(fb);
            } else if (t instanceof UntilBlockContext) {
                UntilBlock ub = (UntilBlock) visit(t);
                result.setUntilBlock(ub);
            } else if (t instanceof InvariantBlockContext) {
                Invariant inv = (Invariant) visit(t);
                result.setInvariant(inv);
            } else if (t instanceof DoBlockContext) {
                List<FuncStatement> fs = (List<FuncStatement>) visit(t);
                result.setStatementList(fs);
            } else if (t instanceof VariantBlockContext) { // variant block
                //t must be a variant block context otherwise v will be set to NULL.
                Variant v = (Variant) visit(t);
                result.setVariant(v);
            }
        }
        return result;
    }

    @Override
    public Object visitFromBlock(FromBlockContext ctx) {
        // TODO Auto-generated method stub
        FromBlock result = new FromBlock();
        for (ParseTree t : ctx.children) {
            if (t instanceof FromBodyContext) {
                result.addAssignment((Assignment) visit(t));
            }
        }
        return result;
    }

    @Override
    public Assignment visitFromBody(FromBodyContext ctx) {
        // TODO Auto-generated method stub
        String name = ctx.getChild(0).getText();
        if (!decls.containsKey(name) && !this.currentPars.containsKey(name)) {
            //if the ID of the assignment is not declared, semantic error
            Token idToken = ctx.ID().getSymbol();
            int line = idToken.getLine();
            int column = idToken.getCharPositionInLine() + 1;
            semanticErrors.add("Error: variable " + name + " not declared (" + line + ", " + column + ")");
            // expression = this.toExpression.visit(ctx.expr());
        }
        TypeChecker.Type type = getVariableType(name);
        Expression e = checkAndReturn(type, (ExprContext) ctx.getChild(2));
        Assignment a = new Assignment(name, e);
        return a;
    }

    @Override
    public UntilBlock visitUntilBlock(UntilBlockContext ctx) {
        UntilBlock result = new UntilBlock();
        for (ParseTree t : ctx.children) {
            if (t instanceof UntilBodyContext) {
                result.addExpr((Expression) visit(t));
            }
        }
        return result;
    }

    @Override
    public Expression visitUntilBody(UntilBodyContext ctx) {
        return checkAndReturn(Type.bool, (ExprContext) ctx.getChild(0));
    }

    @Override
    public Invariant visitInvariantBlock(InvariantBlockContext ctx) {
        // TODO Auto-generated method stub
        Invariant result = new Invariant();
        for (ParseTree t : ctx.children) {
            if (t instanceof InvariantBodyContext) {
                result.addExpr((Expression) visit(t));
            }
        }
        return result;
    }

    @Override
    public Expression visitInvariantBody(InvariantBodyContext ctx) {
        return checkAndReturn(Type.bool, (ExprContext) ctx.getChild(0));
    }

    @Override
    public List<FuncStatement> visitDoBlock(DoBlockContext ctx) {
        // TODO Auto-generated method stub
        ArrayList<FuncStatement> result = new ArrayList<>();
        for (ParseTree t : ctx.children) {
            if (t instanceof DoBodyContext) result.add((FuncStatement) visit(t));
        }
        return result;
    }

    @Override
    public FuncStatement visitDoBody(DoBodyContext ctx) {
        // TODO Auto-generated method stub
        return (FuncStatement) visit(ctx.getChild(0));
    }

    @Override
    public Variant visitVariantBlock(VariantBlockContext ctx) {
        // TODO Auto-generated method stub
        Variant result = new Variant();
        for (ParseTree t : ctx.children) {
            if (t instanceof VariantBodyContext) {
                result.setVariant((Expression) visit(t));
            }
        }
        return result;
    }

    @Override
    public Expression visitVariantBody(VariantBodyContext ctx) {
        // TODO Auto-generated method stub
        return checkAndReturn(Type.num, (ExprContext) ctx.getChild(0));
    }

    @Override
    public FunctionCall visitFunctionCall(FunctionCallContext ctx) {
        // TODO Auto-generated method stub
        String refFunction = ctx.getChild(0).getText();
        List<Expression> params = new ArrayList<>();
        //String id = ctx.getChild(0).getText();
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            if (ctx.getChild(i) instanceof ExprContext) {
                Expression e = toExpression.visit(ctx.getChild(i));
                params.add(e);
            }
        }
        FunctionCall result = new FunctionCall(refFunction, params);
        result.setTargetClass(c);
        
        return result;

    }

}
