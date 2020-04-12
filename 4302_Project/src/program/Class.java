package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.FuncStatement;
import function.Function;
import function.FunctionCall;
import visitor.Visitor;

public class Class {
	private String id;
	private List<String> semanticErrors;
	private List<Assumption> assumptions;// the expression can be declaration expression or constrains
	private List<Declaration> declarations;
	private List<Assertion> assertions;
	private List<Function> functions;

	// public HashMap<String, Boolean> declaredBools;
	private Map<Function, List<Function>> adjacencyList;

	public Class(List<String> semanticErrors) {
		this.id = "";
		this.semanticErrors = semanticErrors;
		this.assumptions = new ArrayList<Assumption>();
		this.declarations = new ArrayList<Declaration>();
		this.functions = new ArrayList<Function>();
		this.assertions = new ArrayList<Assertion>();
	}

	public Class(String id, List<String> semanticErrors) {
		this.id = id;
		this.semanticErrors = semanticErrors;
		this.assumptions = new ArrayList<Assumption>();
		this.declarations = new ArrayList<Declaration>();
		this.functions = new ArrayList<Function>();
		this.assertions = new ArrayList<Assertion>();
	}

	public void accept(Visitor visitor) {
		visitor.visitClass(this);
	}

	public void addAssumption(Assumption assume) {
		this.assumptions.add(assume);
	}

	public void addDeclaration(Declaration decl) {
		this.declarations.add(decl);
	}

	public void addAssertion(Assertion asser) {
		this.assertions.add(asser);
	}

	public void addFunction(Function funct) {
		this.functions.add(funct);
	}

	public void setName(String name) {
		this.id = name;
	}

	public String getName() {
		return this.id;
	}

	public List<Assumption> getAssumptions() {
		return this.assumptions;
	}

	public List<Declaration> getDeclarations() {
		return this.declarations;
	}

	public List<Assertion> getAssertions() {
		return this.assertions;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public List<String> getSemanticErrors() {
		return this.semanticErrors;
	}
	
	public boolean recursionDetection() {
		adjacencyList = new HashMap<Function, List<Function>>();
		//create adjacency list
		if(!this.functions.isEmpty()) {
			for(Function function : this.functions) {
				adjacencyList.put(function, new ArrayList<Function>());
				if(!function.getStatements().isEmpty()) {
					for(FuncStatement statement : function.getStatements()) {
						if(statement instanceof FunctionCall) {
							FunctionCall funcCall = (FunctionCall) statement;
							adjacencyList.get(function).add(funcCall.getTarget());
						}
					}
				}
			}
		}else {
			return false;
		}
		//check for cycle
		Map<Function, Boolean> visited = new HashMap<Function, Boolean>();
		Map<Function, Boolean> recStack = new HashMap<Function, Boolean>();
		
		for(Function function : this.functions) {
			visited.put(function, false);
			recStack.put(function, false);
		}
		
		for(Function function : this.functions) {
			if(isCyclicUtil(function, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCyclicUtil (Function func, Map<Function, Boolean> visited, Map<Function, Boolean> recStack) {
		if(recStack.get(func)) {
			return true;
		}
		if(visited.get(func)) {
			return false;
		}
		visited.put(func, true);
		recStack.put(func, true);
		
		List<Function> children = adjacencyList.get(func);
		for(Function function : children) {
			if (isCyclicUtil(function, visited, recStack)) {
				return true;
			}
		}
		recStack.put(func, false);
		
		return false;
		
	}
}
