package solution;

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
	
	public boolean findMatch(int depth, ArrayList<Variable> vars, ArrayList<Fact> facts) {
		Condition c_part;
		ArrayList<Variable> localVars = new ArrayList<>();
		boolean ok = false, eq = false; boolean done = false;
		
		if (depth > conditions.size()-1) {
			for (ResultFact rf : resultFacts) {
				String[] replaced = replace(vars, rf);
				NewFact nf = new NewFact(replaced, rf.getAction());
				
				if (saveNewFact(nf) == true)
					done = true;
			}
			return done;
		}
		 c_part = conditions.get(depth); 
		
		for (Fact fact : facts) {
			localVars.clear();
			if (vars != null)
				localVars.addAll(vars);
			ok = false; eq = false;
			
			if (equalTest(c_part, localVars) == true) { ok = true; eq = true; } 
			if (eq == false && wordsMatch(fact.getWords(), c_part.getWords()) == false) continue;
			
			String[] f = fact.getWords();
			String[] c = c_part.getWords();
			Variable lvar;
			if (eq == false) {
				for (int i = 0; i < f.length; i++) {
					ok = true;
					if (c[i].equals(f[i]) == false) {
						lvar = findVar(c[i], localVars);
						if (lvar == null) {
							localVars.add(new Variable(c[i], f[i]));
							continue;
						}
						else if (lvar.getValue().equals(f[i])) continue;
						else {ok = false; break;}
					}
				}
			}
			if (ok == true) {
				//vars.addAll(localVars);
				findMatch(depth + 1, localVars, facts);
			}
			//if (next == true) return true;
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

	private String[] replace(ArrayList<Variable> vars, ResultFact rf) {
		String [] tmp = rf.getWords();
		String [] tmp2 = new String[rf.getWords().length];
		
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].charAt(0)=='?') {
				tmp2[i] = getVarValue(tmp[i], vars).getValue();
			}
			else tmp2[i] = tmp[i];
		}
		
		return tmp2;
	}
	
	private boolean saveNewFact(NewFact nf) {
		int t = 0; Action a = nf.getAction(); String[] res = nf.getWords();
		//nf.printWords();
		if (a == Action.pridaj) {
			for (Fact f : Runner.facts) {
				String[] fa = f.getWords();
				if (Arrays.equals(fa, res) == true) { t++; break;}
			}
			for (NewFact f : Runner.newFacts) {
				String[] fa = f.getWords();
				if (Arrays.equals(fa, res) == true) { t++; break;}
			}
			if (t == 0) {
				Runner.newFacts.add(nf);
				return true;
			}
			else return false;
		}
		
		if (a == Action.vymaz) {
			for (Fact f : Runner.facts) {
				String[] fa = f.getWords();
				if (Arrays.equals(fa, res) == true) { Runner.newFacts.add(nf);return true;}
			}
			return false;
		}
		if (a == Action.sprava) {
			return false;
		}
		return false;
	}
	
	private boolean wordsMatch(String[] f, String[] c) {
		if (f.length == c.length) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].equals(c[i]) || (Character.isUpperCase(f[i].charAt(0)) && c[i].charAt(0) == '?')) {
					continue;
				}
				else return false;
			}
			return true;
		}
		else return false;
	}
	
	private boolean equalTest(Condition c, ArrayList<Variable> vars) {
		String [] tmp = c.getWords();
		Variable v1=null, v2 = null;
		boolean found = false;
		
		//c.printWords();
		
		if (tmp[0].equals("<>")) {
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].charAt(0) == '?') {
					if (found == false) {
						v1 = getVarValue(tmp[i], vars);
						found = true;
					}
					else {
						
						if (v1.getVariable().equals(tmp[i]) == false) {
							v2 = getVarValue(tmp[i], vars);
						 	if (v2.getValue().equals(v1.getValue()) == false) {
						 		
						 		return true;
						 	}
						 	else return false;
						}
					}
				}
			}
		}
		return false;
	}
	
	private Variable getVarValue(String v, ArrayList<Variable> vars) {
		for (Variable curr : vars) {
			if (curr.getVariable().equals(v)) {
				return curr;
			}
		}
		return null;
	}
	
}