package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;
import program.*;
import visitor.*;

public class ProgramApp {

    public static void main(String[] args) {
        String help = "Usage: [input file]\t compile the input file and open the output in alloy (make sure alloy jar file is in the same directory!)" +
                "\nUsage: -o [input file]\t print out the compiled output in stdout" +
                "\nUsage: [input file] [output file path]\t save the compiled output to specified path" +
                "\nUsage: -h\t show this help";
        if (args.length == 0) {
            System.err.println(help);
        } else if (args[0].equals("-h")) {
            System.out.println(help);
        } else if (args.length == 2 && (args[0].equals("-out") || args[0].equals("-o"))) {
            //if the first parameter is -out/-o, that means the user wants to simply print out the program
            String fileName = args[1];

            System.out.println(getResult(fileName));
        } else if (args.length == 1) {
            String fileName = args[0];
            String path = fileName + ".als";
            writeFile(fileName, path);

            try {
                Runtime.getRuntime().exec("java -jar org.alloytools.alloy.dist.jar " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (args.length == 2) {
            String fileName = args[0];
            String path = args[1];
            writeFile(fileName, path);

        } else {
            System.err.println(help);
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

    private static void writeFile(String fileName, String path) {
        String result = getResult(fileName);

        try {
            File nf = new File(path);
            FileWriter f = new FileWriter(nf);
            f.write("\n");
            f.write(result);
            f.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String getResult(String fileName) {
        ProjectParser parser = getParser(fileName);

        // tell ANTLR to build a parse tree from the start symbol 'prog'

        ParseTree antlrAST = parser.prog();

        AntlrToProgram progVisitor = new AntlrToProgram();
        Program prog = progVisitor.visit(antlrAST);
        List<String> semanticError = progVisitor.getSemanticErrors();

        //TODO: this is a lazy way to deal with duplicated message, can be optimized if we have time.
        HashSet<String> duplicatedMessage = new HashSet<>();

        if (!semanticError.isEmpty()) {
            StringBuilder errors = new StringBuilder();
            for (String err : semanticError) {
                if (duplicatedMessage.contains(err)) continue;
                errors.append(err + "\n");
                duplicatedMessage.add(err);
            }

            System.err.println(errors.toString());
            return "";
        } else {
            PrettyPrinter printer = new PrettyPrinter();
            String result = printer.getPrintResult(prog);

            System.out.println("//semantic check successful");
            return result;
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
