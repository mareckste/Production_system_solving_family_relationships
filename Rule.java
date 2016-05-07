package solution;

import java.util.ArrayList;

public class Rule {
	private String name;
	private ArrayList<Condition> conditions; /* Podmienky AK*/
	private ArrayList<ResultFact> resultFacts; /*Podmienky potom*/
	
	
	public Rule(String name) {
		this.name = name;
		conditions = new ArrayList<>();
		resultFacts = new ArrayList<>();
	}
	
	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	
	
	public void addCondition(Condition c) {
		this.conditions.add(c);
	}
	
	
	public ArrayList<ResultFact> getResultConditions() {
		return resultFacts;
	}
	
	
	public void addResultFact(ResultFact r) {
		this.resultFacts.add(r);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void printRule() {
		System.out.println("================"+ this + "================");
		for (Condition curr : conditions) {
			curr.printWords();
		}
		
		for (ResultFact curr : resultFacts) {
			curr.printWords();
		}
	}
}
