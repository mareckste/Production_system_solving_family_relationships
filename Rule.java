package solution;

import java.util.ArrayList;

public class Rule {
	private String name;
	private ArrayList<Condition> conditions;
	private ArrayList<ResultCondition> resultConditions;
	
	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	
	
	public void setConditions(ArrayList<Condition> conditions, String delim) {
		this.conditions = conditions;
	}
	
	
	public ArrayList<ResultCondition> getResultConditions() {
		return resultConditions;
	}
	
	
	public void setResultConditions(ArrayList<ResultCondition> resultConditions, String delim) {
		this.resultConditions = resultConditions;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
