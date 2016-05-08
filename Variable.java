package solution;

public class Variable {
	private String variable;
	private String value;
	
	public Variable(String var, String val) {
		this.value = val;
		this.variable = var;
	}
	
	public String getVariable() {
		return variable;
	}
	public String getValue() {
		return value;
	}
}
