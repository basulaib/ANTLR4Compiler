package visitor;

import expression.*;
import expression.binary.*;
import function.*;
import loop.*;
import program.Class;
import program.Declaration;
import program.Program;

public class VariableLocker implements Visitor {
    //this visitor class will make changes to the expression!
    //better use it with DeepCopyMaker.

    @Override
    public void visitFunctionCall(FunctionCall funcCall) {
        // TODO Auto-generated method stub

    }

    private void binaryOp(BinaryOperation bi) {
        bi.getLeft().accept(this);
        bi.getRight().accept(this);
    }

    @Override
    public void visitMult(BiMultiplication mult) {
        binaryOp(mult);
    }

    @Override
    public void visitDiv(BiDivision div) {
        binaryOp(div);
    }

    @Override
    public void visitAdd(BiAddition add) {
        binaryOp(add);
    }

    @Override
    public void visitSub(BiSubtraction sub) {
        binaryOp(sub);
    }

    @Override
    public void visitLarger(BiLarger lar) {
        binaryOp(lar);
    }

    @Override
    public void visitSmaller(BiSmaller sma) {
        binaryOp(sma);
    }

    @Override
    public void visitLargerOrEqual(BiLargerOrEqual loe) {
        binaryOp(loe);
    }

    @Override
    public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
        binaryOp(soe);
    }

    @Override
    public void visitEqual(BiEqual equ) {
        binaryOp(equ);
    }

    @Override
    public void visitNotEqual(BiNotEqual neq) {
        binaryOp(neq);
    }

    @Override
    public void visitConjunction(BiConjunction conjunc) {
        binaryOp(conjunc);
    }

    @Override
    public void visitDisjunction(BiDisjunction disjunct) {
        binaryOp(disjunct);
    }

    @Override
    public void visitImplication(BiImplication imply) {
        binaryOp(imply);
    }

    @Override
    public void visitEquivalence(BiEquivalence equal) {
        binaryOp(equal);
    }

    @Override
    public void visitNegation(Negation neg) {
        neg.expr.accept(this);
    }

    @Override
    public void visitBoolConst(BoolConst con) {
    }

    @Override
    public void visitNumConst(NumConst con) {
    }

    @Override
    public void visitStrConst(StringConst str) {

    }

    @Override
    public void visitStrVar(StringVariable str) {
        str.setFree(false);
    }

    @Override
    public void visitBoolVar(BoolVariable boo) {
        boo.setFree(false);
    }

    @Override
    public void visitNumVar(NumVariable num) {
        //TODO: if the variable to be locked is not a number, maybe we should report semantic error since we only use it for loop variant
        num.setFree(false);
    }

    @Override
    public void visitArrayVar(ArrayVariable arr) {
        arr.setFree(false);
        arr.getIndex().accept(this);
    }

    @Override
    public void visitDeclaration(Declaration decl) {

    }

    @Override
    public void visitFunction(Function func) {

    }

    @Override
    public void visitConditional(Conditional cond) {

    }

    @Override
    public void visitAssignment(Assignment assign) {

    }

    @Override
    public void visitPreCondition(PreCondition preCond) {

    }

    @Override
    public void visitPostCondition(PostCondition postCond) {

    }

    @Override
    public void visitClass(Class cla) {

    }

    @Override
    public void visitProgram(Program program) {

    }

    @Override
    public void visitLoop(Loop loop) {

    }

    @Override
    public void visitFromBlock(FromBlock fromBlock) {

    }

    @Override
    public void visitUntilBlock(UntilBlock untilBlock) {

    }

    @Override
    public void visitInvariant(Invariant invariant) {

    }

    @Override
    public void visitVariant(Variant variant) {

    }
}
