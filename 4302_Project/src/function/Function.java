package function;

import java.util.ArrayList;
import java.util.List;

import expression.Constant;
import expression.Expression;
import visitor.Visitor;

public class Function {
	private String id;
	private Constant.Type type;
	private List<Parameter> parameterList;
	private List<FuncStatement> statementList;
	private PreCondition preCondition;
	private PostCondition postCondition;
	
	public Function(String id) {
		this.id = id;
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = new ArrayList<FuncStatement>();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition();
	}
	
	public Function(String id, Constant.Type type) {
		this.id = id;
		this.type = type;
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = new ArrayList<FuncStatement>();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function) {
		this.id = function.getId();
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function, PreCondition preCondition) {
		this.id = function.getId();
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition(preCondition);
		this.postCondition = new PostCondition();
	}
	
	public Function(Function function, PostCondition postCondition) {
		this.id = function.getId();
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = function.getStatements();
		this.preCondition = new PreCondition();
		this.postCondition = new PostCondition(postCondition);
	}
	
	public Function(String id, PreCondition preCondition, PostCondition postCondition) {
		this.id = id;
		this.parameterList = new ArrayList<Parameter>();
		this.statementList = new ArrayList<FuncStatement>();
		this.preCondition = new PreCondition(preCondition);
		this.postCondition = new PostCondition(postCondition);
	}
	public Function(Function function, PreCondition preCondition, PostCondition postCondition) {
		this.id = function.getId();
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

	public List<Parameter> getParameters() {return this.parameterList; }

	public void accept(Visitor visitor) {
		visitor.visitFunction(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<FuncStatement> getStatementList() {
		return statementList;
	}

	public List<Parameter> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<Parameter> parameterList) {
		this.parameterList = parameterList;
	}

	public Constant.Type getType() {
		return type;
	}

	public void setStatementList(List<FuncStatement> statementList) {
		this.statementList = statementList;
	}

	public void setPreCondition(PreCondition preCondition) {
		this.preCondition = preCondition;
	}

	public void setPostCondition(PostCondition postCondition) {
		this.postCondition = postCondition;
	}
	
	
}
