package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import function.Function;

public class Class {
	private String id;
	private List<Assumption> assumptions;// the expression can be declaration expression or constrains
	private List<Declaration> declarations;
	private List<Assertion> assertions;
	private List<Function> functions;

	// public HashMap<String, Boolean> declaredBools;

	public Class(List<String> semanticErrors) {
		this.id = "";
		this.assumptions = new ArrayList<Assumption>();
		this.declarations = new ArrayList<Declaration>();
		this.functions = new ArrayList<Function>();
		this.assertions = new ArrayList<Assertion>();
	}
	
	public Class(String id, List<String> semanticErrors) {
		this.id = id;
		this.assumptions = new ArrayList<Assumption>();
		this.declarations = new ArrayList<Declaration>();
		this.functions = new ArrayList<Function>();
		this.assertions = new ArrayList<Assertion>();
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
}
