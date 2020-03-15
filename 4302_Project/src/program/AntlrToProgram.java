//package program;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import antlr.ExprBaseVisitor;
//import antlr.ExprParser.ProgramContext;
//
//public class AntlrToProgram extends ExprBaseVisitor<Program> {
//
//	public List<String> semanticErrors;
//
//	@Override
//	public Program visitProgram(ProgramContext ctx) {
//		this.semanticErrors = new ArrayList<>();
//
//		Program result = new Program(this.semanticErrors);
//
//		AntlrToExpression exprVisitor = new AntlrToExpression(this.semanticErrors);
//
//		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
//			result.addExpression(exprVisitor.visit(ctx.getChild(i)));
//		}
//
//		result.declaredBools = exprVisitor.getDeclaredBools();
//
//		return result;
//	}
//
//}
