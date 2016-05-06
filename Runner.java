package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Runner {
	private static final String D_condition = "[():,]+";
	private static final String D_space = "[ ]+";
	
	public static void main(String[] args) {
		try {
		initRules();
		} catch (Exception e) {
			System.out.println("File not found");
		}
		
		
	}
	
	
	private static ArrayList<Rule> initRules() throws Exception {
		ArrayList<Rule> rules = new ArrayList<>();
		FileReader fr = new FileReader("files/rules.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] tmp;
		String name="", cond="", res="";
		Condition c;
		Rule rule;
		
		int t = 1;
		
		while ((name = br.readLine()) != null ) {
			cond = br.readLine();
			res = br.readLine();
			
			rule = new Rule();
			
			
			tmp = cond.split(D_condition);
		    
			System.out.println("===============C:" + t);
			for (int i = 1; i < tmp.length; i++) {
				c = new Condition(tmp[i].split(D_space));
				rule.addCondition(c);
			}

			rules.add(rule);
			t++;
			name = br.readLine(); //emptyLine
		}
			br.close();
			fr.close();
		
		
		return rules;
	}

}
