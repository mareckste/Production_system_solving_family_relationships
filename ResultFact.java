package solution;

public class ResultFact {
	
	private String[] words;
	private Action type;
	
	public ResultFact(String[] words) {
		this.words = words;
		setType();
	}
	
	public void setWords(String[] s) {
		this.words = s;
	}
	
	public String[] getWords() {
		return this.words;
	}
	
	public boolean isFact(String[] s) {
		/*
		 * porovnat nejak stringy
		 */
		return true;
	}
	
	private void setType() {
		switch (words[0]) {
		
			case "pridaj": type = Action.pridaj; 
			break;
		
			case "vymaz": type = Action.vymaz;
			break;
			
			case "sprava": type = Action.sprava;
			break;
			
			default: break;
		}
	}
	
	public Action getAction() {
		return this.type;
	}
	
	public void printWords() {
		System.out.println("Condition: " + this);
		for (int i = 0; i < words.length; i++)
			System.out.println(i +": "+words[i]);
	}
}
