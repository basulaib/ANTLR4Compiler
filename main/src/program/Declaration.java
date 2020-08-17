package program;

import expression.*;
import visitor.Visitor;

import java.util.List;

public class Declaration {
    private Constant.Type type;
    private String id;
    private Constant value;
    private boolean arrayDeclaration = false;

    private List<Constant> constantArray;

    public Declaration() {
        this.id = "unknown";
        this.value = null;
    }

    public Declaration(String id) {
        this.id = id;
        this.value = null;
    }

    public Declaration(String id, Constant value) {
        this.id = id;
        this.value = value;
        this.type = value.type;
    }

    public Declaration(String id, Constant.Type type) {
        this.id = id;
        this.value = null;
        this.type = type;
    }

    public Declaration(String id, List<Constant> arrayValue) {
        this.arrayDeclaration = true;
        this.id = id;
        this.constantArray = arrayValue;
        this.type = arrayValue.get(0).type;
    }

    public boolean isArrayDeclaration() {
        return arrayDeclaration;
    }

    public void setArrayDeclaration(boolean arrayDeclaration) {
        this.arrayDeclaration = arrayDeclaration;
    }

    public List<Constant> getConstantArray() {
        return constantArray;
    }

    public Constant.Type getType() {
        return type;
    }

    public void setType(Constant.Type type) {
        this.type = type;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setConstant(Constant value) {
        this.value = value;
    }

    public String getID() {
        return this.id;
    }

    public Constant getConst() {
        return this.value;
    }

    public Variable getVariableReference() {
        Variable result;
        switch (this.type) {
            case string:
                result = value == null ? new StringVariable(this.id) : new StringVariable(this.id, this.value);
                break;
            case num:
                result = value == null ? new NumVariable(this.id) : new NumVariable(this.id, this.value);
                break;
            default:
                result = value == null ? new BoolVariable(this.id) : new BoolVariable(this.id, this.value);
                break;
        }

        if (isArrayDeclaration()) {
            result = new ArrayVariable(this.id, this.type, new NumConst(0));
        }

        return result;
    }

    public void accept(Visitor visitor) {
        visitor.visitDeclaration(this);
    }
}
