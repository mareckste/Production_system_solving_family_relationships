package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Runner {
	private static final String DELIM = "[():,]+";
	
	
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
		boolean t = true;
		
		while ((name = br.readLine()) != null ) {
			cond = br.readLine();
			res = br.readLine();
			//System.out.println(name + "\n" + cond + "\n" + res);
			
			tmp = cond.split(DELIM);
			if (t) {
			for (String c : tmp) {
				System.out.println(c);
				System.out.println("");
			}
			}
			
			t = false;
			name = br.readLine(); //emptyLine
		}
			br.close();
			fr.close();
		
		
		return rules;
	}

}
