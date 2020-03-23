package function;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Constant.Type;
import expression.Expression;
import visitor.Visitor;

public class Parameter {
	private Constant.Type type;
    private String ID;
//    private Constant value;

    public Parameter(String type, String ID){
        if (type.equals("string")) {
        	this.type = Constant.Type.string;
        } else if (type.equals("bool")) {
        	this.type = Constant.Type.bool;
        } else {
        	this.type = Constant.Type.num;
        }
        this.ID = ID;
//        this.value = value;
    }

    public Type getType(){
        return this.type;
    }

    public String getID() {
        return this.ID;
    }
}