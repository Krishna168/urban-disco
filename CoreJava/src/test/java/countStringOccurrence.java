
public class countStringOccurrence {

	public static void main(String[] args) {

		int count = countOccurrence("Krishna Prasath", 'a');
		System.out.println(count);
	}

	public static int countOccurrence(String word, char c) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				count++;
			}
		}
		return count;

	}

}
