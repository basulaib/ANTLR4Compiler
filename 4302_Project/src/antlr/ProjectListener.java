// Generated from .\antlr\Project.g4 by ANTLR 4.8

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
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(ProjectParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(ProjectParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(ProjectParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(ProjectParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(ProjectParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(ProjectParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SmallerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSmallerOrEqual(ProjectParser.SmallerOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SmallerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSmallerOrEqual(ProjectParser.SmallerOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Larger}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLarger(ProjectParser.LargerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Larger}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLarger(ProjectParser.LargerContext ctx);
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
	 * Enter a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterImplication(ProjectParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitImplication(ProjectParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LargerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLargerOrEqual(ProjectParser.LargerOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LargerOrEqual}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLargerOrEqual(ProjectParser.LargerOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(ProjectParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(ProjectParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(ProjectParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(ProjectParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equivalence}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquivalence(ProjectParser.EquivalenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equivalence}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquivalence(ProjectParser.EquivalenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(ProjectParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(ProjectParser.EqualContext ctx);
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
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(ProjectParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(ProjectParser.ConjunctionContext ctx);
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
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(ProjectParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(ProjectParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Smaller}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSmaller(ProjectParser.SmallerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Smaller}
	 * labeled alternative in {@link ProjectParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSmaller(ProjectParser.SmallerContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link ProjectParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(ProjectParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(ProjectParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#fromBlock}.
	 * @param ctx the parse tree
	 */
	void enterFromBlock(ProjectParser.FromBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#fromBlock}.
	 * @param ctx the parse tree
	 */
	void exitFromBlock(ProjectParser.FromBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#fromBody}.
	 * @param ctx the parse tree
	 */
	void enterFromBody(ProjectParser.FromBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#fromBody}.
	 * @param ctx the parse tree
	 */
	void exitFromBody(ProjectParser.FromBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#untilBlock}.
	 * @param ctx the parse tree
	 */
	void enterUntilBlock(ProjectParser.UntilBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#untilBlock}.
	 * @param ctx the parse tree
	 */
	void exitUntilBlock(ProjectParser.UntilBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#untilBody}.
	 * @param ctx the parse tree
	 */
	void enterUntilBody(ProjectParser.UntilBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#untilBody}.
	 * @param ctx the parse tree
	 */
	void exitUntilBody(ProjectParser.UntilBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#invariantBlock}.
	 * @param ctx the parse tree
	 */
	void enterInvariantBlock(ProjectParser.InvariantBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#invariantBlock}.
	 * @param ctx the parse tree
	 */
	void exitInvariantBlock(ProjectParser.InvariantBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#invariantBody}.
	 * @param ctx the parse tree
	 */
	void enterInvariantBody(ProjectParser.InvariantBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#invariantBody}.
	 * @param ctx the parse tree
	 */
	void exitInvariantBody(ProjectParser.InvariantBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#doBlock}.
	 * @param ctx the parse tree
	 */
	void enterDoBlock(ProjectParser.DoBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#doBlock}.
	 * @param ctx the parse tree
	 */
	void exitDoBlock(ProjectParser.DoBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#doBody}.
	 * @param ctx the parse tree
	 */
	void enterDoBody(ProjectParser.DoBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#doBody}.
	 * @param ctx the parse tree
	 */
	void exitDoBody(ProjectParser.DoBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#variantBlock}.
	 * @param ctx the parse tree
	 */
	void enterVariantBlock(ProjectParser.VariantBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#variantBlock}.
	 * @param ctx the parse tree
	 */
	void exitVariantBlock(ProjectParser.VariantBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#variantBody}.
	 * @param ctx the parse tree
	 */
	void enterVariantBody(ProjectParser.VariantBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#variantBody}.
	 * @param ctx the parse tree
	 */
	void exitVariantBody(ProjectParser.VariantBodyContext ctx);
}