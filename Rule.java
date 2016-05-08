package solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public boolean findMatch(Condition c_part, int depth, ArrayList<Variable> vars, ArrayList<Fact> facts) {
		ArrayList<Variable> localVars = new ArrayList<>();
		boolean next=false, ok = false;
		
		if (depth > conditions.size()-1) {
			String[] replaced = replace(vars);
			if (saveNewFact(replaced) == true)
				return true;
			else return false;
		}
		
		for (Fact fact : facts) {
			localVars.clear();
			ok = false;
			
			if (wordsMatch(fact.getWords(), c_part.getWords()) == false) continue;
			
			String[] f = fact.getWords();
			String[] c = c_part.getWords();
			Variable lvar;
			for (int i = 0; i < f.length; i++) {
				ok = true;
				if (c[i].equals(f[i]) == false) {
					lvar = findVar(c[i], vars);
					if (lvar == null) {
						localVars.add(new Variable(c[i], f[i]));
						continue;
					}
					else if (lvar.getValue().equals(f[i])) continue;
					else {ok = false; break;}
				}
			}
			if (ok == true) {
				vars.addAll(localVars);
				next = findMatch(c_part, depth + 1, vars, facts);
			}
			if (next == true) return true;
		}
		return false;
	}
	
	private Variable findVar(String varname, ArrayList<Variable> vars) {
		for (Variable v : vars) {
			if (v.getVariable().equals(varname))
				return v;
		}
		return null;
	}

	private String[] replace(ArrayList<Variable> vars) {
		String[] tmp = new String[this.resultFacts.get(0).toString().length()];
		
		return tmp;
	}
	
	private boolean saveNewFact(String[] replaced) {
		for (Fact f : Runner.newFacts) {
			String[] fa = f.getWords();
			if (Arrays.equals(fa, replaced) == true) return false;
			
		}
		
		return true;
	}
	
	private boolean wordsMatch(String[] f, String[] c) {
		if (f.length == c.length) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].equals(c[i]) || (Character.isUpperCase(f[i].charAt(0)) && c[i].charAt(0) == '?')) {
					continue;
				}
				else return false;
			}
		}
		return true;
	}
	
}