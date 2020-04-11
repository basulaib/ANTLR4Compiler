package program;

import java.util.*;

import expression.*;
import expression.binary.*;
import function.*;
import loop.Loop;
import visitor.*;

public class WPCalculator {

    public WPCalculator() {
    }

    //return the hoare triple of the function that included all the class invariants.
    public Expression getHoareTriple(Function func, List<Expression> invariants) {
//        if (func.getPostCondition().isEmpty())
//            return null;
        List<Expression> allPreconds = new ArrayList<>(invariants);
        allPreconds.addAll(func.getPreCondition());

        Expression wp = getWP(func, invariants);

        Expression precond = this.conjunctAll(allPreconds, 0, allPreconds.size() - 1);

        return precond == null ? wp : new BiImplication(precond, wp);
    }

    // passing in the function, it will return the weakest precondition for that
    // function
    private Expression getWP(Function func, List<Expression> invariants) {
        List<Expression> allPostconds = new ArrayList<>(invariants);
        allPostconds.addAll(func.getPostCondition());
        if (allPostconds.isEmpty()) return new BoolConst(true);

        Expression postCond = this.conjunctAll(allPostconds, 0, allPostconds.size() - 1);
        return sequentialCase(func.getStatements(), postCond);
    }

    // the rule for a single statement
    private Expression singleStatement(FuncStatement statement, Expression postCond) {
        if (statement instanceof Assignment) {
            return baseCase((Assignment) statement, postCond);
        } else if (statement instanceof Conditional) {
            // conditio
            return conditionalCase((Conditional) statement, postCond);
        } else {
            return loopCase((Loop) statement, postCond);
        }
    }

    private Expression loopCase(Loop loop, Expression postCond) {

    }

    private Expression hoareTripleOne() {
    	
    }

    private Expression hoareTripleTwo() {

    }

    private Expression hoareTripleThree() {

    }

    private Expression hoareTripleFour() {
    	/*line 1
    	 * line2
    	 * line3
    	 * line4
    	 * line5
    	 * line6
    	 * line7 (new)
    	 * line 8 (new)
    	 * line 9 (new)
    	 * pls dont merge conflict aha*/
    }

    private Expression hoareTripleFive() {
        //line
        //line
        //line
        //line
        //line
    }

    // condition rule
    private Expression conditionalCase(Conditional condition, Expression postCond) {
        Expression result;
        List<Expression> originConditions = condition.getOrder();
        // must pre-process the conditions, negate all the previous conditions.
        List<Expression> processedConditions = processCondition(originConditions);

        // must conjunct all of these later
        List<Expression> conjunctPrecond = new ArrayList<Expression>();

        for (int i = 0; i < originConditions.size(); i++) {
            List<FuncStatement> statements = condition.getStatements(originConditions.get(i));
            BiImplication imply = new BiImplication(processedConditions.get(i), sequentialCase(statements, postCond));
            conjunctPrecond.add(imply);
        }

        result = conjunctAll(conjunctPrecond, 0, conjunctPrecond.size() - 1);

        return result;
    }

    // for each conditions, negate all the previous conditions and conjunct them all
    // with it self.
    private List<Expression> processCondition(List<Expression> conditions) {
        List<Expression> result = new ArrayList<Expression>();
        for (int i = 0; i < conditions.size(); i++) {
            List<Expression> currentCondition = new ArrayList<Expression>();
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    currentCondition.add(conditions.get(i));
                else
                    currentCondition.add(new Negation(conditions.get(j)));
            }
            result.add(conjunctAll(currentCondition, 0, i));
        }
        return result;
    }

    private Expression conjunctAll(List<Expression> exprs, int start, int end) {
        // return the conjunction of all the expression passed in, start, end inclusive
        // lets divide and conquer !!

        if (exprs.isEmpty())
            return null;

        if (end - start == 0) {
            return exprs.get(start);
        } else {
            int mid = (start + end) / 2;
            return new BiConjunction(conjunctAll(exprs, start, mid), conjunctAll(exprs, mid + 1, end));
        }

    }

    // sequential rule
    private Expression sequentialCase(List<FuncStatement> statements, Expression postCond) {
        // we can actually do a loop here

        int current = statements.size() - 1;
        Expression currentPostCond = postCond;

        while (current >= 0) {
            currentPostCond = singleStatement(statements.get(current), currentPostCond);
            current--;
        }

        return currentPostCond;
    }

    // this is the case for only one assignment
    private Expression baseCase(Assignment ass, Expression postCond) {
        String name = ass.getID();
        Expression expr = ass.getExpr();

        // now replace all free occurrences of variable x in postCond with expr

        // make a deep copy of the post condition so we can modify it freely
        DeepCopyMaker copyMaker = new DeepCopyMaker();
        postCond.accept(copyMaker);
        Expression wp = copyMaker.getExprCopy();

        this.replace(name, expr, wp);

        return wp;
    }

    // replace all occurrences of x in R with e.
    private void replace(String x, Expression e, Expression R) {
        // base case
        if (R instanceof Constant)
            return;

        if (R instanceof Negation) {
            replace(x, e, ((Negation) R).expr);
            return;
        }

        if (R instanceof BinaryOperation) {
            Expression left = ((BinaryOperation) R).getLeft();
            Expression right = ((BinaryOperation) R).getRight();

            if (left instanceof Variable) {
                if (((Variable) left).getID().equals(x))
                    ((BinaryOperation) R).setLeft(e);
            } else {
                // recursive case
                replace(x, e, left);
            }

            if (right instanceof Variable) {
                if (((Variable) right).getID().equals(x))
                    ((BinaryOperation) R).setRight(e);
            } else {
                // recursive case
                replace(x, e, right);
            }
        } else {
            PrettyPrinter printer = new PrettyPrinter();
            System.err.print("The post condition is neither binary operation nor negation:\n");
            System.err.print(printer.getPrintResult(R) + "\n");
        }

    }

}
