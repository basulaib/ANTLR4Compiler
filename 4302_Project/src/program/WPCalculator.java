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
        if (allPostconds.isEmpty()) allPostconds.add(new BoolConst(true));

        Expression postCond = this.conjunctAll(allPostconds, 0, allPostconds.size() - 1);
        return sequentialCase(func.getStatements(), postCond);
    }

    // the rule for a single statement
    private Expression singleStatement(FuncStatement statement, Expression postCond) {
        if (statement instanceof Assignment) {
            return baseCase((Assignment) statement, postCond);
        } else if (statement instanceof Conditional) {
            return conditionalCase((Conditional) statement, postCond);
        } else if (statement instanceof Loop) {
            return loopCase((Loop) statement, postCond);
        } else {
            return functionCallCase((FunctionCall) statement, postCond);
        }
    }

    private Expression functionCallCase(FunctionCall call, Expression postCond) {
        Expression result = null;
        //pre[P/x] of call must be implied (This one's variable is free)
        //call must be correct (which is verified later)
        //post[P/x] of call implies postCond (This on is locked, meaning no variable is a free occurrence)
        Function target = call.getTargetFunction();

        DeepCopyMaker copyMaker = new DeepCopyMaker();
        Expression targetPrecond = conjunctAll(target.getPreCondition(), 0, target.getPreCondition().size() - 1);
        if (targetPrecond == null) targetPrecond = new BoolConst(true);
        targetPrecond = copyMaker.getExprCopy(targetPrecond);

        Expression targetPostcond = conjunctAll(target.getPostCondition(), 0, target.getPostCondition().size() - 1);
        if (targetPostcond == null) targetPostcond = new BoolConst(true);
        targetPostcond = copyMaker.getExprCopy(targetPostcond);

        List<Expression> input = call.getParameters();
        List<Parameter> pars = target.getParameters();
        //each input should correspond to one parameter
        for (int i = 0; i < input.size(); i++) {
            String id = pars.get(i).getID();
            Expression in = input.get(i);
            replace(id, in, targetPrecond);
            replace(id, in, targetPostcond);
        }

        //now we have a processed target precondition and target post condition.
        Expression post = new BiImplication(targetPostcond, postCond);
        VariableLocker locker = new VariableLocker();
        post.accept(locker);

        result = new BiConjunction(targetPrecond, post);

        return result;
    }

    private Expression loopCase(Loop loop, Expression postCond) {
        List<Expression> loopHoareTriples = new ArrayList<Expression>();
        loopHoareTriples.add(hoareTripleOne(loop));
        loopHoareTriples.add(hoareTripleTwo(loop));
        loopHoareTriples.add(hoareTripleThree(loop, postCond));
        loopHoareTriples.add(hoareTripleFour(loop));
        loopHoareTriples.add(hoareTripleFive(loop));

        //We must lock all the variables except for the first hoare triple.
        //because all the previous function statements can be seen as initialization step.
        VariableLocker locker = new VariableLocker();
        loopHoareTriples.get(1).accept(locker);
        loopHoareTriples.get(2).accept(locker);
        loopHoareTriples.get(3).accept(locker);
        loopHoareTriples.get(4).accept(locker);

        return conjunctAll(loopHoareTriples, 0, loopHoareTriples.size() - 1);
    }

    private Expression hoareTripleOne(Loop loop) {
        //{Q} Sinit {I}
        //{True} Sinit {I}

        List<Assignment> declFrom = loop.getFromBlock().getAssignments();
        int current = declFrom.size() - 1;
        Expression currentPostCond = conjunctAll(loop.getInvariant(), 0, loop.getInvariant().size() - 1);
        DeepCopyMaker copyMaker = new DeepCopyMaker();
        currentPostCond = copyMaker.getExprCopy(currentPostCond);

        while (current >= 0) {
            replace(declFrom.get(current).getID(), declFrom.get(current).getExpr(), currentPostCond);
            current--;
        }

        return currentPostCond;
    }

    private Expression hoareTripleTwo(Loop loop) {
        //{I^!B} Sbody {I}
        //we want
        List<Expression> invariants = new ArrayList<>(loop.getInvariant());
        Expression invariant = conjunctAll(new ArrayList<>(invariants), 0, invariants.size() - 1);

        List<Expression> loopConditions = new ArrayList<>(loop.getUntilBlock());
        Expression loopCondition = conjunctAll(new ArrayList<>(loopConditions), 0, loopConditions.size() - 1);
        Expression notLoopCondition = new Negation(loopCondition);

        Expression wp = this.sequentialCase(new ArrayList<>(loop.getStatementList()), invariant);

        return new BiImplication(new BiConjunction(invariant, notLoopCondition), wp);
    }

    private Expression hoareTripleThree(Loop loop, Expression postCond) {
        //I ^ B => R
        List<Expression> invariants = new ArrayList<>(loop.getInvariant());
        Expression invariant = conjunctAll(new ArrayList<>(invariants), 0, invariants.size() - 1);

        List<Expression> loopConditions = new ArrayList<>(loop.getUntilBlock());
        Expression loopCondition = conjunctAll(new ArrayList<>(loopConditions), 0, loopConditions.size() - 1);

        return new BiImplication(new BiConjunction(invariant, loopCondition), postCond);
    }

    private Expression hoareTripleFour(Loop loop) {
        //{I ^ !B}Sbody {V >= 0}
        List<Expression> invariants = new ArrayList<>(loop.getInvariant());
        Expression invariant = conjunctAll(new ArrayList<>(invariants), 0, invariants.size() - 1);

        List<Expression> loopConditions = new ArrayList<>(loop.getUntilBlock());
        Expression loopCondition = conjunctAll(new ArrayList<>(loopConditions), 0, loopConditions.size() - 1);
        Expression notLoopCondition = new Negation(loopCondition);

        Expression wp = this.sequentialCase(new ArrayList<>(loop.getStatementList()), new BiLargerOrEqual(loop.getVariant(), new NumConst(0)));

        return new BiImplication(new BiConjunction(invariant, notLoopCondition), wp);
    }

    private Expression hoareTripleFive(Loop loop) {
        //{I∧¬B} Sbody {V < V0}
        Expression v0 = loop.getVariant();

        DeepCopyMaker copyMaker = new DeepCopyMaker();
        Expression v = copyMaker.getExprCopy(v0);

        //lock v0 so that it won't be replaced.
        VariableLocker locker = new VariableLocker();
        v0.accept(locker);
        Expression wp = new BiSmaller(v, v0);

        wp = sequentialCase(loop.getStatementList(), wp);

        Expression invariant = conjunctAll(loop.getInvariant(), 0, loop.getInvariant().size() - 1);
        Expression exitCondition = conjunctAll(loop.getUntilBlock(), 0, loop.getUntilBlock().size() - 1);
        Expression notExitCondition = new Negation(exitCondition);

        return new BiImplication(new BiConjunction(invariant, notExitCondition), wp);
    }

    // condition rule
    private Expression conditionalCase(Conditional condition, Expression postCond) {
        Expression result;
        condition.addConditionalStatement(null); //just to make sure the default case is always included.
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

    // replace all FREE occurrences of x in R with e.
    private void replace(String x, Expression e, Expression R) {
        // CAUTION: always use this method with deepCopyMaker
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
                if (((Variable) left).getID().equals(x) && ((Variable) left).isFree())
                    ((BinaryOperation) R).setLeft(e);
            } else {
                // recursive case
                replace(x, e, left);
            }

            if (right instanceof Variable) {
                if (((Variable) right).getID().equals(x) && ((Variable) right).isFree())
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
}
