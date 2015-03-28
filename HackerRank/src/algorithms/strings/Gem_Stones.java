/**
 * 
 */
package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author PraveenK
 *
 */
public class Gem_Stones {

	public static int findGemStones(String[] words) {
		Set<Character> baseSet = new HashSet<Character>(), currentSet = new HashSet<Character>();

		for (char a = 'a'; a <= 'z'; a++) {
			baseSet.add(a);
		}
		for (String word : words) {
			currentSet.clear();
			for (int i = 0; i < word.length(); i++)
				// chars[word.charAt(i) - 'a'] = chars[word.charAt(i) - 'a']+1;
				currentSet.add(word.charAt(i));
			baseSet.retainAll(currentSet);

		}

		return baseSet.size();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());
		String[] input = new String[testCases];
		for (int i = 0; i < testCases; i++)
			input[i] = s.nextLine();
		System.out.println(findGemStones(input));

		s.close();
	}
}