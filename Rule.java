package solution;

import java.util.ArrayList;

public class Rule {
	private String name;
	private ArrayList<Condition> conditions;
	private ArrayList<ResultCondition> resultConditions;
	
	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	
	
	public void addCondition(Condition c) {
		this.conditions.add(c);
	}
	
	
	public ArrayList<ResultCondition> getResultConditions() {
		return resultConditions;
	}
	
	
	public void addResultCondition(ResultCondition r) {
		this.resultConditions.add(r);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
