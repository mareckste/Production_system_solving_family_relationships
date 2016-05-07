package solution;

public class Fact {
	String[] words;
	
	public Fact(String[] words) {
		this.words = words;
	}
	
	public String[] getWords() {
		return this.words;
	}
	
	public void printWords() {
		System.out.println("Fact: " + this);
		for (int i = 0; i < words.length; i++)
			System.out.println(i +": "+words[i]);
	}
}
