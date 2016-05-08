package solution;

public class NewFact extends Fact{
	private Action action;
	
	public NewFact(String[] words, Action t) {
		super(words);
		this.action = t;
	}

	public Action getAction() {
		return action;
	}
	
}
