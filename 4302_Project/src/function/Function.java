package function;

import java.util.ArrayList;
import java.util.List;

import expression.Expression;
import visitor.Visitor;

public class Function {
	private List<Parameter> parameterList;
	private List<FuncStatement> statementList;
	private PreCondition preCondition;
	private PostCondition postCondition;
	
	public Function() {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = new ArrayList<FuncStatement>();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function) {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function, PreCondition preCondition) {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition(preCondition);
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function, PostCondition postCondition) {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition(postCondition);
	}
	
	public Function(PreCondition preCondition, PostCondition postCondition) {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = new ArrayList<FuncStatement>();
		this.preCondition = new PreCondition(preCondition);
		this.postCondition = new PostCondition(postCondition);
	}
	public Function(Function function, PreCondition preCondition, PostCondition postCondition) {
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition(preCondition);
		this.postCondition = new PostCondition(postCondition);
	}
	
	//add statement to function
	public void addStatement(FuncStatement statement) {
		this.statementList.add(statement);
	}
	
	public void addPreCondition(Expression preCond) {
		this.preCondition.addPreCondition(preCond);
	}
	
	public void addPostCondition(Expression postCond) {
		this.postCondition.addPostCondition(postCond);
	}

	public void addParameter(Parameter param) {
		this.parameterList.add(param);
	}
	
	public List<Expression> getPreCondition(){
		return this.preCondition.getPreConditions();
	}
	
	public List<Expression> getPostCondition(){
		return this.postCondition.getPostConditions();
	}
	
	public List<FuncStatement> getStatements(){
		return this.statementList;
	}

	public List<Paramter> getParameters() {return this.parameterList; }

	public void accept(Visitor visitor) {
		visitor.visitFunction(this);
	}
}
