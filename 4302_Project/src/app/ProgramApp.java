package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;
import program.*;
import visitor.*;

public class ProgramApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("Usage: [input file] [output path]");
		} else {
			String fileName = args[0];
			String path = args[1];
			ProjectParser parser = getParser(fileName);

			// tell ANTLR to build a parse tree from the start symbol 'prog'

			ParseTree antlrAST = parser.prog();

			AntlrToProgram progVisitor = new AntlrToProgram();
//
			Program prog = progVisitor.visit(antlrAST);
//

			PrettyPrinter printer = new PrettyPrinter();

			String result = printer.getPrintResult(prog);

			try {
				Path p = Paths.get(fileName);
				String alsFileName = p.getFileName().toString();
				alsFileName = alsFileName.substring(0, alsFileName.length() - 4);
				System.out.println(alsFileName);
				String output = path + "output-" + alsFileName + ".als";
				System.out.println(output);
				File nf = new File(output);
				FileWriter f = new FileWriter(nf);
				f.write("\n");
				f.write(result);
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			// System.out.print("\n");
			// System.out.print(result);

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
