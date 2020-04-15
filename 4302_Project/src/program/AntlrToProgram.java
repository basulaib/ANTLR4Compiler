package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.ProjectBaseVisitor;
import antlr.ProjectParser.ProgramContext;

public class AntlrToProgram extends ProjectBaseVisitor<Program> {

    public List<String> semanticErrors;
    private HashMap<String, Declaration> decls; // all the declared variable

    @Override
    public Program visitProgram(ProgramContext ctx) {
        this.semanticErrors = new ArrayList<>();

        Program result = new Program(this.semanticErrors);

        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            this.decls = new HashMap<String, Declaration>();
            AntlrToClass antlrToClass = new AntlrToClass(this.semanticErrors, decls);
            result.addClass((Class) antlrToClass.visit(ctx.getChild(i)));
            if (result.getClasses().get(i).recursionDetection()) {
                System.out.println("//recursion detected in class " + result.getClasses().get(i).getName() + " :)");
            } else {
                System.out.println("//recursion NOT detected in class " + result.getClasses().get(i).getName() + " :(");
            }
        }

        return result;
    }

    public List<String> getSemanticErrors() {
        return this.semanticErrors;
    }

}
