package program;

import java.util.ArrayList;
import java.util.List;

import antlr.ProjectBaseVisitor;
import antlr.ProjectParser.ProgramContext;

public class AntlrToProgram extends ProjectBaseVisitor<Program> {

	public List<String> semanticErrors;

//	@Override
//	public Program visitProgram(ProgramContext ctx) {
//		this.semanticErrors = new ArrayList<>();
//
//		Program result = new Program(this.semanticErrors);
//
//		AntlrToClass antlrToClass = new AntlrToClass();
//
//		for (int i = 0; i < ctx.getChildCount() - 1; i++) {
//			result.addExpression(exprVisitor.visit(ctx.getChild(i)));
//		}
//
//		result.declaredBools = exprVisitor.getDeclaredBools();
//
//		return result;
//	}

}
