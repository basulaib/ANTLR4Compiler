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
	 * Visit a parse tree produced by the {@code ArrDecl}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrDecl(ProjectParser.ArrDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrInit}
	 * labeled alternative in {@link ProjectParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrInit(ProjectParser.ArrInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assumption}
	 * labeled alternative in {@link ProjectParser#assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumption(ProjectParser.AssumptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(ProjectParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(ProjectParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(ProjectParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SmallerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerOrEqual(ProjectParser.SmallerOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Larger}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLarger(ProjectParser.LargerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ProjectParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(ProjectParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LargerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLargerOrEqual(ProjectParser.LargerOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(ProjectParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrExpr(ProjectParser.ArrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(ProjectParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equivalence}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalence(ProjectParser.EquivalenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(ProjectParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolNumExpr}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolNumExpr(ProjectParser.BoolNumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(ProjectParser.ConjunctionContext ctx);
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
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(ProjectParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Smaller}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmaller(ProjectParser.SmallerContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link ProjectParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(ProjectParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#fromBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromBlock(ProjectParser.FromBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#fromBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromBody(ProjectParser.FromBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#untilBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilBlock(ProjectParser.UntilBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#untilBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilBody(ProjectParser.UntilBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#invariantBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantBlock(ProjectParser.InvariantBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#invariantBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantBody(ProjectParser.InvariantBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#doBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoBlock(ProjectParser.DoBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#doBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoBody(ProjectParser.DoBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#variantBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariantBlock(ProjectParser.VariantBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#variantBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariantBody(ProjectParser.VariantBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link ProjectParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ProjectParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Switch}
	 * labeled alternative in {@link ProjectParser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch(ProjectParser.SwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#switchBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBody(ProjectParser.SwitchBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Case}
	 * labeled alternative in {@link ProjectParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(ProjectParser.CaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Default}
	 * labeled alternative in {@link ProjectParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault(ProjectParser.DefaultContext ctx);
}