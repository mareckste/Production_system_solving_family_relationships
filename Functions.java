package solution;

public class Functions {
	public static String[] shiftRight(String[] words) {
		String[] tmp = new String[words.length - 1];
		for (int i = 1; i < words.length; i++) {
			tmp[i-1] = words[i];
		}
		return tmp;
	}
}
