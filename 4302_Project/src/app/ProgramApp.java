package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;
import expression.*;
import expression.binary.*;
import program.*;
import visitor.*;

public class ProgramApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err.println("Usage: file name");
		} else {
			String fileName = args[0];
			ProjectParser parser = getParser(fileName);

			// tell ANTLR to build a parse tree from the start symbol 'prog'

			ParseTree antlrAST = parser.prog();

//			AntlrToProgram progVisitor = new AntlrToProgram();
//
//			Program prog = progVisitor.visit(antlrAST);
//
//			PrettyPrinter printer = new PrettyPrinter();
//
//			Constant left = new NumConst(23);
//			Constant right = new NumConst(25);
//			BiAddition add = new BiAddition(left, right);
//
//			String result = printer.getPrintResult(add);

		}
	}

	private static ProjectParser getParser(String fileName) {
		ProjectParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			ProjectLexer lexer = new ProjectLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new ProjectParser(tokens);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parser;
	}

}
