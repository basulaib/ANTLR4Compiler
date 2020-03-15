package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import expression.*;
import function.*;
import visitor.*;

public class Program {

	private List<String> semanticErrors;
	private List<Class> classes;

//	public HashMap<String, Boolean> declaredBools;

	public Program(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
		this.classes = new ArrayList<Class>();
	}

	public List<Class> getClasses() {
		return this.classes;
	}

	public List<String> getSemanticErrors() {
		return this.semanticErrors;
	}

	public void addClass(Class c) {
		this.classes.add(c);
	}
}
