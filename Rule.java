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
	
	/*public void findFacts(ArrayList<Fact> f) { 
		ArrayList<Replacement> rpl = new ArrayList<>();
		int x = 0;
		
		for (Condition curr : conditions) {
			String[] t_c = curr.getWords();
			for (Fact cf : f) {
				String[] t_f = cf.getWords();
				
				if (t_c.length == t_f.length) {
					for (int i = 0; i < t_c.length; i++) {
						if (t_c[i].equals(t_f[i]))
							continue;
						else if ((t_c[i].charAt(0) == '?') && Character.isUpperCase(t_f[i].charAt(0))) {
							if (x == 0)
								rpl.add(new Replacement(t_c[i], t_f[i]));
							else {
								for (Replacement r : rpl) {
									if (t_c[i].equals(r.getVariable()) && t_c[i].equals(r.getValue())) {
										
									}
								}
							}
						}
					}
				}
			}
			x++;
		}
		
	}*/
}