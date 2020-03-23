package function;

import java.util.ArrayList;
import java.util.List;

import expression.BoolVariable;
import expression.Constant;
import expression.Constant.Type;
import expression.Expression;
import expression.NumVariable;
import expression.StringVariable;
import expression.Variable;
import expression.Variable.*;
import visitor.Visitor;

public class Parameter {
	private Constant.Type type;
	private String ID;
//    private Constant value;

	public Parameter(String type, String ID) {
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

	public Type getType() {
		return this.type;
	}

	public String getID() {
		return this.ID;
	}

	public Variable getVariableReference() {
		switch (this.type) {
		case string:
			return new StringVariable(this.ID);
		case num:
			return new NumVariable(this.ID);
		default:
			return new BoolVariable(this.ID);
		}
	}
}