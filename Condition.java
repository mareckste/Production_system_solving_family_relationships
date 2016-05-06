package solution;

public class Condition {
	private String[] words;
	
	
	public Condition(String[] words) {
		this.words = words;
	}
	
	public String[] getWords() {
		return this.words;
	}
	
	public void printWords() {
		System.out.println("Condition: " + this);
		for (int i = 0; i < words.length; i++)
			System.out.println(i +": "+words[i]);
	}
}
