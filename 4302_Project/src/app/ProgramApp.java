package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import antlr.ExprParser;
import expression.*;
import program.AntlrToProgram;
import program.Program;
import visitor.*;

public class ProgramApp {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		if (args.length != 1) {
//			System.err.println("Usage: file name");
//		} else {
//			String fileName = args[0];
//			ExprParser parser = getParser(fileName);
//
//			// tell ANTLR to build a parse tree from the start symbol 'prog'
//
//			ParseTree antlrAST = parser.prog();
//
//			AntlrToProgram progVisitor = new AntlrToProgram();
//
//			Program prog = progVisitor.visit(antlrAST);
//
//			System.out.print(prog.GetTautologyResult());
//
//		}
//	}
//
//	private static ExprParser getParser(String fileName) {
//		ExprParser parser = null;
//		try {
//			CharStream input = CharStreams.fromFileName(fileName);
//			ExprLexer lexer = new ExprLexer(input);
//			CommonTokenStream tokens = new CommonTokenStream(lexer);
//			parser = new ExprParser(tokens);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return parser;
//	}
}
