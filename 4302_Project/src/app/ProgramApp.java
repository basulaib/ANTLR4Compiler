package app;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;
import expression.*;
import expression.binary.*;
import function.Assignment;
import function.Function;
import function.Parameter;
import program.*;
import program.Class;
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

			AntlrToProgram progVisitor = new AntlrToProgram();
//
			Program prog = progVisitor.visit(antlrAST);
//

			PrettyPrinter printer = new PrettyPrinter();

			String result = printer.getPrintResult(prog);
			System.out.print("\n");
			System.out.print(result);

		}
////////////////////////////////////////////////////////
//		class Account{
//			declare {
//		    	int	amount;
//				int a = 5;
//		    }
//
//			assume{
//				amount > 23 + 25;	
//			}
//		
//			assert {
//				amount > 0;
//			}
//			func int increase(int x, int y){
//				require {
//					x > 0;
//				}
//				amount = amount + x;
//		        
//				ensure {
//					amount == amount + x;
//				}		
//			}
//		}	
////////////////////////////////////////////////////////
//		PrettyPrinter printer = new PrettyPrinter();
//		Constant left = new NumConst(23);
//		Constant right = new NumConst(25);
//		BiAddition add = new BiAddition(left, right);
////
////		String result = printer.getPrintResult(add);
//
//		Class Account = new Class("Account", new ArrayList<String>());
//		Assumption assume = new Assumption();
//		assume.addExpr(new BiLarger(new NumVariable("amount"), add));
//
//		Account.addAssumption(assume);
//
//		Account.addDeclaration(new Declaration("amount", Constant.Type.num));
//		Account.addDeclaration(new Declaration("a", new NumConst(5)));
//
//		Assertion asser = new Assertion();
//		asser.addExpression(new BiLarger(new NumVariable("amount"), new NumConst(0)));
//
//		Account.addAssertion(asser);
//
//		Function func = new Function("increase");
//
//		func.addPreCondition(new BiLarger(new NumVariable("x"), new NumConst(0)));
//
//		func.addStatement(new Assignment("amount", new BiAddition(new NumVariable("amount"), new NumVariable("x"))));
//
//		func.addPostCondition(new BiEqual(new NumVariable("amount"),
//				new BiAddition(new NumVariable("amount"), new NumVariable("x"))));
//
//		func.addParameter(new Parameter("num", "x"));
//		func.addParameter(new Parameter("num", "y"));
//		Account.addFunction(func);
//
//		String result = printer.getPrintResult(Account);
//
//		System.out.print(result);
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
