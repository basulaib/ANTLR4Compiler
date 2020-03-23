package function;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import visitor.Visitor;

public class Parameter {

    private String Type;
    private String ID;
    private Constant value;

    public Parameter(String type, String ID, Constant value){
        this.Type = type;
        this.ID = ID;
        this.value = value;
    }

    public String getType(){
        return this.Type;
    }

    public String getID() {
        return this.ID;
    }
}