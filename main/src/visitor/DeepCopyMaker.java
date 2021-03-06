package visitor;

import expression.*;
import expression.binary.*;
import function.*;
import loop.FromBlock;
import loop.Invariant;
import loop.Loop;
import loop.UntilBlock;
import loop.Variant;
import program.Declaration;
import program.Program;
import program.Class;

public class DeepCopyMaker implements Visitor {
    //currently it can only make a deep-copy of binary expression
    private Expression copy;
    private DeepCopyMaker copyMaker;

    public Expression getExprCopy() {
        return this.copy;
    }

    public Expression getExprCopy(Expression expr) {
        expr.accept(this);
        return this.copy;
    }

    public DeepCopyMaker() {
    }

    private void reset() {
        if (copyMaker == null)
            this.copyMaker = new DeepCopyMaker();
    }

    private Expression leftCopy(BinaryOperation binary) {
        reset();
        binary.getLeft().accept(copyMaker);
        Expression left = copyMaker.copy;
        return left;
    }

    private Expression rightCopy(BinaryOperation binary) {
        reset();
        binary.getRight().accept(copyMaker);
        Expression right = copyMaker.copy;
        return right;
    }

    @Override
    public void visitMult(BiMultiplication mult) {
        // TODO Auto-generated method stub
        this.copy = new BiMultiplication(leftCopy(mult), rightCopy(mult));
    }

    @Override
    public void visitDiv(BiDivision div) {
        // TODO Auto-generated method stub
        this.copy = new BiDivision(leftCopy(div), rightCopy(div));
    }

    @Override
    public void visitAdd(BiAddition add) {
        // TODO Auto-generated method stub
        this.copy = new BiAddition(leftCopy(add), rightCopy(add));
    }

    @Override
    public void visitSub(BiSubtraction sub) {
        // TODO Auto-generated method stub
        this.copy = new BiSubtraction(leftCopy(sub), rightCopy(sub));
    }

    @Override
    public void visitLarger(BiLarger lar) {
        // TODO Auto-generated method stub
        this.copy = new BiLarger(leftCopy(lar), rightCopy(lar));
    }

    @Override
    public void visitSmaller(BiSmaller sma) {
        // TODO Auto-generated method stub
        this.copy = new BiSmaller(leftCopy(sma), rightCopy(sma));
    }

    @Override
    public void visitLargerOrEqual(BiLargerOrEqual loe) {
        // TODO Auto-generated method stub
        this.copy = new BiLargerOrEqual(leftCopy(loe), rightCopy(loe));
    }

    @Override
    public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
        // TODO Auto-generated method stub
        this.copy = new BiSmallerOrEqual(leftCopy(soe), rightCopy(soe));
    }

    @Override
    public void visitEqual(BiEqual equ) {
        // TODO Auto-generated method stub
        this.copy = new BiEqual(leftCopy(equ), rightCopy(equ));
    }

    @Override
    public void visitNotEqual(BiNotEqual neq) {
        // TODO Auto-generated method stub
        this.copy = new BiNotEqual(leftCopy(neq), rightCopy(neq));
    }

    @Override
    public void visitConjunction(BiConjunction conjunc) {
//		reset();
//		conjunc.getLeft().accept(copyMaker);
//		Expression left = copyMaker.copy;
//		conjunc.getRight().accept(copyMaker);
//		Expression right = copyMaker.copy;
        this.copy = new BiConjunction(leftCopy(conjunc), rightCopy(conjunc));
    }

    @Override
    public void visitDisjunction(BiDisjunction disjunct) {
        // TODO Auto-generated method stub
        this.copy = new BiDisjunction(leftCopy(disjunct), rightCopy(disjunct));
    }

    @Override
    public void visitImplication(BiImplication imply) {
        // TODO Auto-generated method stub
        this.copy = new BiImplication(leftCopy(imply), rightCopy(imply));
    }

    @Override
    public void visitEquivalence(BiEquivalence equal) {
        // TODO Auto-generated method stub
        this.copy = new BiEquivalence(leftCopy(equal), rightCopy(equal));
    }

    @Override
    public void visitDeclaration(Declaration decl) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitNegation(Negation neg) {
        // TODO Auto-generated method stub
        reset();
        neg.expr.accept(copyMaker);
        Expression copy = copyMaker.copy;
        this.copy = new Negation(copy);
    }

    @Override
    public void visitBoolConst(BoolConst con) {
        // TODO Auto-generated method stub
        this.copy = new BoolConst(con.getBoolValue());
    }

    @Override
    public void visitNumConst(NumConst con) {
        // TODO Auto-generated method stub
        this.copy = new NumConst(con.getNumValue());
    }

    @Override
    public void visitStrConst(StringConst str) {
        // TODO Auto-generated method stub
        this.copy = new StringConst(str.getStrValue());
    }

    private Constant getConstCopy(Constant con) {
        reset();
        con.accept(copyMaker);
        return (Constant) this.copyMaker.copy;
    }

    @Override
    public void visitStrVar(StringVariable str) {
        // TODO Auto-generated method stub
//		if (str.getValueDefined()) {
        this.copy = new StringVariable(str.getID());
        ((Variable) copy).setFree(str.isFree());
//		} else {
//			this.copy = new StringVariable(str.getID());
//		}
    }

    @Override
    public void visitBoolVar(BoolVariable boo) {
        // TODO Auto-generated method stub
//		if (boo.getValueDefined()) {
        this.copy = new BoolVariable(boo.getID());
        ((Variable) copy).setFree(boo.isFree());
//		} else {
//			this.copy = new BoolVariable(boo.getID());
//		}
    }

    @Override
    public void visitNumVar(NumVariable num) {
        // TODO Auto-generated method stub
//		if (num.getValueDefined()) {
        this.copy = new NumVariable(num.getID());
        ((Variable) copy).setFree(num.isFree());
//		} else {
//			this.copy = new NumVariable(num.getID());
//		}
    }

    @Override
    public void visitArrayVar(ArrayVariable arr) {
        //currently array reference cannot be a parameter type
        reset();
        this.copy = new ArrayVariable(arr.getID(), arr.getType(), copyMaker.getExprCopy(arr.getIndex()));
        ((Variable) copy).setFree(arr.isFree());
        //if the array is an array of boolean, also translate that
    }


    @Override
    public void visitFunction(Function func) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitConditional(Conditional cond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitAssignment(Assignment assign) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPreCondition(PreCondition preCond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitPostCondition(PostCondition postCond) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitProgram(Program program) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitClass(Class cla) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitLoop(Loop loop) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitFromBlock(FromBlock fromBlock) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitUntilBlock(UntilBlock untilBlock) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitInvariant(Invariant invariant) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitFunctionCall(FunctionCall funcCall) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitVariant(Variant variant) {
        // TODO Auto-generated method stub

    }


}
