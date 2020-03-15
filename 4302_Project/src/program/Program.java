package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import expression.*;
import function.*;
import visitor.*;

public class Program {
	public List<Assumption> assumptions;// the expression can be declaration expression or constrains
	public List<Declaration> declarations;
	public List<Assertion> assertions;
	public List<Function> functions;

	public List<String> semanticErrors;

	public HashMap<String, Boolean> declaredBools;

	public Program(List<String> semanticErrors) {
		this.assumptions = new ArrayList<Assumption>();
		this.declarations = new ArrayList<Declaration>();
		this.functions = new ArrayList<Function>();
		this.assertions = new ArrayList<Assertion>();
		this.semanticErrors = semanticErrors;

	}

}
