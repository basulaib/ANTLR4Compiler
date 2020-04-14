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
import expression.binary.BinaryOperation;
import function.*;
import loop.FromBlock;
import loop.Invariant;
import loop.Loop;
import loop.UntilBlock;
import loop.Variant;
import program.Class;
import program.Declaration;
import program.Program;

import java.lang.reflect.Type;
import java.util.List;

public class TypeChecker implements Visitor {

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
	public void visitVariant(Variant variant) {
		// TODO Auto-generated method stub
		
	}

	private Type type;
    private TypeChecker checker;

    public enum Type {
        bool, num, string, ERROR// ERROR means the type is incorrect/inconsistent
        // string type is only possible for constant/ variable type.
    }

    public TypeChecker() {
        // the type for expression can either be evaluated to boolean or integer
    }

    public Type getTypeResult(Declaration decl) {
        return getType(decl.getType());
    }

    public Type getTypeResult(Parameter parameter) {
        return getType(parameter.getType());
    }

    private Type getType(Constant.Type type) {
        switch (type) {
            case num:
                return Type.num;
            case string:
                return Type.string;
            case bool:
                return Type.bool;
            default:
                return Type.ERROR;
        }
    }

    public Type getTypeResult(Expression expr) {
        expr.accept(this);
        return this.type;
    }

    private void reset() {
        if (checker == null)
            checker = new TypeChecker();
    }

    // input type is the type of left and right, result type is the resulting
    // overall type
    private void visitBinarytExpr(BinaryOperation Expr, Type inputType, Type resultType) {
        reset();
        Type left = checker.getTypeResult(Expr.getLeft());
        Type right = checker.getTypeResult(Expr.getRight());
        if (left == right && left == inputType) {
            this.type = resultType;
        } else {
            this.type = Type.ERROR;
        }
    }

    @Override
    public void visitMult(BiMultiplication mult) {
        visitBinarytExpr(mult, Type.num, Type.num);
    }

    @Override
    public void visitDiv(BiDivision div) {
        visitBinarytExpr(div, Type.num, Type.num);

    }

    @Override
    public void visitAdd(BiAddition add) {
        visitBinarytExpr(add, Type.num, Type.num);
    }

    @Override
    public void visitSub(BiSubtraction sub) {
        visitBinarytExpr(sub, Type.num, Type.num);
    }

    @Override
    public void visitLarger(BiLarger lar) {
        visitBinarytExpr(lar, Type.num, Type.bool);
    }

    @Override
    public void visitSmaller(BiSmaller sma) {
        visitBinarytExpr(sma, Type.num, Type.bool);
    }

    @Override
    public void visitLargerOrEqual(BiLargerOrEqual loe) {
        visitBinarytExpr(loe, Type.num, Type.bool);
    }

    @Override
    public void visitSmallerOrEqual(BiSmallerOrEqual soe) {
        visitBinarytExpr(soe, Type.num, Type.bool);
    }

    @Override
    public void visitEqual(BiEqual equ) {
        reset();
        Type leftType = this.checker.getTypeResult(equ.getLeft());
        visitBinarytExpr(equ, leftType, Type.bool);
    }

    @Override
	public void visitFunctionCall(FunctionCall funcCall) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void visitNotEqual(BiNotEqual neq) {
        reset();
        Type leftType = this.checker.getTypeResult(neq.getLeft());
        visitBinarytExpr(neq, leftType, Type.bool);
    }

    @Override
    public void visitConjunction(BiConjunction conjunc) {
        visitBinarytExpr(conjunc, Type.bool, Type.bool);
    }

    @Override
    public void visitDisjunction(BiDisjunction disjunct) {
        visitBinarytExpr(disjunct, Type.bool, Type.bool);

    }

    @Override
    public void visitImplication(BiImplication imply) {
        visitBinarytExpr(imply, Type.bool, Type.bool);

    }

    @Override
    public void visitEquivalence(BiEquivalence equal) {
        // equivalence means iff, so it can only be bool
        visitBinarytExpr(equal, Type.bool, Type.bool);
    }

    @Override
    public void visitNegation(Negation neg) {
        // negation for number is being handled during parsing, we shouldn't have to
        // worry about that

        this.type = this.checker.getTypeResult(neg.expr);
        if (this.type != Type.bool) {
            this.type = Type.ERROR;
        }
    }

    @Override
    public void visitBoolConst(BoolConst con) {
        this.type = Type.bool;
    }

    @Override
    public void visitNumConst(NumConst con) {
        this.type = Type.num;
    }

    @Override
    public void visitStrConst(StringConst str) {
        this.type = Type.string;
    }

    @Override
    public void visitStrVar(StringVariable str) {
        this.type = Type.string;
    }

    @Override
    public void visitBoolVar(BoolVariable boo) {
        this.type = Type.bool;
    }

    @Override
    public void visitNumVar(NumVariable num) {
        this.type = Type.num;
    }

    @Override
    public void visitDeclaration(Declaration decl) {
        // TODO Auto-generated method stub

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
    public void visitClass(Class cla) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitProgram(Program program) {
        // TODO Auto-generated method stub

    }

}
