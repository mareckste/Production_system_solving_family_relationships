package solution;

public class ResultFact {
	
	private String[] words;
	private Action type;
	
	public ResultFact(String[] words) {
		this.words = words;
		setType();
		shiftRight();
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
		System.out.println("ResultFact type: " + type.toString() + " " + this);
		for (int i = 0; i < words.length; i++)
			System.out.println(i +": "+words[i]);
	}
	
	public void shiftRight() {
		String[] tmp = new String[words.length - 1];
		for (int i = 1; i < words.length; i++) {
			tmp[i-1] = words[i];
		}
		words = tmp;
	}
}
