package visitor;

import expression.*;
import expression.binary.BiAddition;
import expression.binary.BiConjunction;
import expression.binary.BiDisjunction;
import expression.binary.BiDivision;
import expression.binary.BiEqual;
import expression.binary.BiEquivalence;
import expression.binary.BiImplication;
import expression.binary.BiLarger;
import expression.binary.BiLargerOrEqual;
import expression.binary.BiMultiplication;
import expression.binary.BiNotEqual;
import expression.binary.BiSmaller;
import expression.binary.BiSmallerOrEqual;
import expression.binary.BiSubtraction;
import function.*;
import program.*;
import program.Class;
import loop.*;

public interface Visitor {
    // binary operation
    // Numeric operation
    public void visitMult(BiMultiplication mult);

    public void visitDiv(BiDivision div);

    public void visitAdd(BiAddition add);

    public void visitSub(BiSubtraction sub);

    public void visitLarger(BiLarger lar);

    public void visitSmaller(BiSmaller sma);

    public void visitLargerOrEqual(BiLargerOrEqual loe);

    public void visitSmallerOrEqual(BiSmallerOrEqual soe);

    public void visitEqual(BiEqual equ);

    public void visitNotEqual(BiNotEqual neq);

    // Boolean operation
    public void visitConjunction(BiConjunction conjunc);

    public void visitDisjunction(BiDisjunction disjunct);

    public void visitImplication(BiImplication imply);

    public void visitEquivalence(BiEquivalence equal);

    public void visitNegation(Negation neg);

    // const

    public void visitBoolConst(BoolConst con);

    public void visitNumConst(NumConst con);

    public void visitStrConst(StringConst str);

    // variables

    public void visitStrVar(StringVariable str);

    public void visitBoolVar(BoolVariable boo);

    public void visitNumVar(NumVariable num);

    public void visitArrayVar(ArrayVariable arr);

    // function cluster
    public void visitDeclaration(Declaration decl);

    public void visitFunction(Function func);

    public void visitFunctionCall(FunctionCall funcCall);

    public void visitConditional(Conditional cond);

    public void visitAssignment(Assignment assign);

    public void visitPreCondition(PreCondition preCond);

    public void visitPostCondition(PostCondition postCond);

    // program

    public void visitClass(Class cla);

    public void visitProgram(Program program);

    // loop
    public void visitLoop(Loop loop);

    public void visitFromBlock(FromBlock fromBlock);

    public void visitUntilBlock(UntilBlock untilBlock);

    public void visitInvariant(Invariant invariant);

    public void visitVariant(Variant variant);
}