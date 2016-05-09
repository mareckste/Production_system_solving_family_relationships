package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
	private static final String D_condition = "[():,]+";
	private static final String D_space = "[ ]+";
	private static final String D_result = "[()]+";
	private static final String D_fact = "[() ]+";
	
	private static ArrayList<Rule> rules;
	public static ArrayList<Fact> facts;
	public static ArrayList<NewFact> newFacts = new ArrayList<>();
	
	public static void main(String[] args) {
		boolean e = true;
		try {
		rules = initRules();
		facts = initFacts();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		while (true) {
			e = true;
			for (Rule r : rules) {
				r.findMatch(0, new ArrayList<Variable>(), facts);
			}
			
			if (newFacts.size() == 0) {
				break;
			}
				NewFact newf = newFacts.remove(0);
				
				switch (newf.getAction()) {
				case pridaj:
					System.out.println("Pridaj: " + newf);
					facts.add(new Fact(newf.getWords()));
					break;
				
				case vymaz:
					int index=0;
					boolean found = false;
					String[] nf = newf.getWords();
					for (Fact fact : facts) {
						String[] fa = fact.getWords();
						if (Arrays.equals(fa, nf) == true) {
							found = true;
							facts.remove(index);
							System.out.println("Vymaz: " + newf);
							break; 
						}
						index++;
					}
					if (found == false) e = false;
					break;
				
				case sprava:
					System.out.println("Sprava: " + newf);
					break;
				default: e = false; break;
				
			}
				if (e == true) {
				 System.out.println("Press ENTER to next step: ");
			     @SuppressWarnings("resource")
			     Scanner scanIn = new Scanner(System.in);
			     scanIn.nextLine();
				}
			    

		}
		System.out.println("****========FINAL_FACTS==========****");
		for (Fact r : facts) {
			
			System.out.println(r);
		}
		System.out.println("****========END==========****");
	}
	
	
	private static ArrayList<Rule> initRules() throws Exception {
		FileReader fr = new FileReader("files/rules.txt");
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<Rule> t_rules = new ArrayList<>();
		String[] tmp, tmp_r;
		String name="", cond="", res="";
		Condition c; ResultFact rf; Rule rule;
		
		while ((name = br.readLine()) != null ) { //turns text into objects
			cond = br.readLine();
			res = br.readLine();
			
			rule = new Rule(name);
			tmp = cond.split(D_condition); //splits certain conditions on lines and then for each line separates words
		    tmp_r = res.split(D_result);
			
		    for (int i = 1; i < tmp_r.length; i++) {
		    	rf = new ResultFact(tmp_r[i].split(D_space));
		    	rule.addResultFact(rf);
		    }
		    
			for (int i = 1; i < tmp.length; i++) {
				c = new Condition(tmp[i].split(D_space));
				rule.addCondition(c);
			}
			
			t_rules.add(rule);
			name = br.readLine(); //emptyLine
		}
		br.close();
		fr.close();
		
		return t_rules;
	}

	private static ArrayList<Fact> initFacts() throws Exception {
		FileReader fr = new FileReader("files/facts.txt");
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<Fact> t_facts = new ArrayList<>();
		String[] tmp;
		String line_f = "";
		Fact fact;
		
		while ((line_f = br.readLine()) != null ) {
			tmp = line_f.split(D_fact);
			tmp = Functions.shiftRight(tmp);
			fact = new Fact(tmp);
			t_facts.add(fact);
		}
		
		br.close();
		fr.close();
		
		return t_facts;
	}
}
