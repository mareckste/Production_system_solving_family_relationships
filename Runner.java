package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Runner {
	private static final String D_condition = "[():,]+";
	private static final String D_space = "[ ]+";
	private static final String D_result = "[()]+";
	
	public static void main(String[] args) {
		try {
		initRules();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static ArrayList<Rule> initRules() throws Exception {
		ArrayList<Rule> rules = new ArrayList<>();
		FileReader fr = new FileReader("files/rules.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] tmp, tmp_r;
		String name="", cond="", res="";
		Condition c;
		ResultFact rf;
		Rule rule;
		
		int t = 1;
		
		while ((name = br.readLine()) != null ) {
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
			
			rule.printRule();
			rules.add(rule);
			t++;
			name = br.readLine(); //emptyLine
		}
			br.close();
			fr.close();
		
		
		return rules;
	}

}
