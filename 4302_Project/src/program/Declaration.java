package program;

import expression.*;

public class Declaration {
	private String id;
	private Constant value;

	public Declaration() {
		this.id = "unknown";
		this.value = null;
	}

	public Declaration(String id, Constant value) {
		this.id = id;
		this.value = value;
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
}
