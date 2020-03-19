// Generated from Project.g4 by ANTLR 4.8

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjectParser}.
 */
public interface ProjectListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ProjectParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProjectParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ProjectParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProjectParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void enterClassBlock(ProjectParser.ClassBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void exitClassBlock(ProjectParser.ClassBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link ProjectParser#body}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ProjectParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link ProjectParser#body}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ProjectParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#declBody}.
	 * @param ctx the parse tree
	 */
	void enterDeclBody(ProjectParser.DeclBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#declBody}.
	 * @param ctx the parse tree
	 */
	void exitDeclBody(ProjectParser.DeclBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(ProjectParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(ProjectParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarInit}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(ProjectParser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarInit}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(ProjectParser.VarInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assumption}
	 * labeled alternative in {@link ProjectParser#assume}.
	 * @param ctx the parse tree
	 */
	void enterAssumption(ProjectParser.AssumptionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assumption}
	 * labeled alternative in {@link ProjectParser#assume}.
	 * @param ctx the parse tree
	 */
	void exitAssumption(ProjectParser.AssumptionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolNumExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolNumExpr(ProjectParser.BoolNumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolNumExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolNumExpr(ProjectParser.BoolNumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(ProjectParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(ProjectParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(ProjectParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(ProjectParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpr(ProjectParser.ParenthesizedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpr(ProjectParser.ParenthesizedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ProjectParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ProjectParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ProjectParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ProjectParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ProjectParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ProjectParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link ProjectParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(ProjectParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link ProjectParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(ProjectParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#funcStatement}.
	 * @param ctx the parse tree
	 */
	void enterFuncStatement(ProjectParser.FuncStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#funcStatement}.
	 * @param ctx the parse tree
	 */
	void exitFuncStatement(ProjectParser.FuncStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreCond}
	 * labeled alternative in {@link ProjectParser#precon}.
	 * @param ctx the parse tree
	 */
	void enterPreCond(ProjectParser.PreCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreCond}
	 * labeled alternative in {@link ProjectParser#precon}.
	 * @param ctx the parse tree
	 */
	void exitPreCond(ProjectParser.PreCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostCond}
	 * labeled alternative in {@link ProjectParser#postcon}.
	 * @param ctx the parse tree
	 */
	void enterPostCond(ProjectParser.PostCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostCond}
	 * labeled alternative in {@link ProjectParser#postcon}.
	 * @param ctx the parse tree
	 */
	void exitPostCond(ProjectParser.PostCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(ProjectParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(ProjectParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(ProjectParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(ProjectParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link ProjectParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfConditional(ProjectParser.IfConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link ProjectParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfConditional(ProjectParser.IfConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfConditional}
	 * labeled alternative in {@link ProjectParser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfConditional(ProjectParser.ElseIfConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfConditional}
	 * labeled alternative in {@link ProjectParser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfConditional(ProjectParser.ElseIfConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseConditional}
	 * labeled alternative in {@link ProjectParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseConditional(ProjectParser.ElseConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseConditional}
	 * labeled alternative in {@link ProjectParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseConditional(ProjectParser.ElseConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parameter}
	 * labeled alternative in {@link ProjectParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ProjectParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parameter}
	 * labeled alternative in {@link ProjectParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ProjectParser.ParameterContext ctx);
}