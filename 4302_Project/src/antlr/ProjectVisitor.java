// Generated from Project.g4 by ANTLR 4.8

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProjectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProjectVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ProjectParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ProjectParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#classBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBlock(ProjectParser.ClassBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link ProjectParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(ProjectParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#declBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclBody(ProjectParser.DeclBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(ProjectParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarInit}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInit(ProjectParser.VarInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assumption}
	 * labeled alternative in {@link ProjectParser#assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumption(ProjectParser.AssumptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolNumExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolNumExpr(ProjectParser.BoolNumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(ProjectParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(ProjectParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpr(ProjectParser.ParenthesizedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ProjectParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ProjectParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ProjectParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link ProjectParser#funcBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(ProjectParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#funcStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncStatement(ProjectParser.FuncStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreCond}
	 * labeled alternative in {@link ProjectParser#precon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreCond(ProjectParser.PreCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostCond}
	 * labeled alternative in {@link ProjectParser#postcon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostCond(ProjectParser.PostCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(ProjectParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(ProjectParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link ProjectParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfConditional(ProjectParser.IfConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfConditional}
	 * labeled alternative in {@link ProjectParser#elseifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfConditional(ProjectParser.ElseIfConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseConditional}
	 * labeled alternative in {@link ProjectParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseConditional(ProjectParser.ElseConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parameter}
	 * labeled alternative in {@link ProjectParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(ProjectParser.ParameterContext ctx);
}