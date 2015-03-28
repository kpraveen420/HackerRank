/**
 * 
 */
package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem Statement
 * 
 * John has discovered various rocks. Each rock is composed of various elements,
 * and each element is represented by a lowercase latin letter from 'a' to 'z'.
 * An element can be present multiple times in a rock. An element is called a
 * 'gem-element' if it occurs at least once in each of the rocks.
 * 
 * Given the list of N rocks with their compositions, display the number of
 * gem-elements that exist in those rocks.
 * 
 * Input Format The first line consists of N, the number of rocks. Each of the
 * next N lines contain rocks' composition. Each composition consists of
 * lowercase letters of English alphabet.
 * 
 * Output Format Print the number of gem-elements that are common in these
 * rocks. If there are none, print 0.
 * 
 * Constraints 1 ≤ N ≤ 100 Each composition consists of only lowercase latin
 * letters ('a'-'z'). 1 ≤ Length of each composition ≤ 100
 * 
 * Sample Input
 * 
 * 3 
 * abcdde 
 * baccd 
 * eeabg 
 * 
 * Sample Output
 * 
 * 2 
 * 
 * Explanation Only "a", "b" are the two kind of gem-elements, since these are
 * the only characters that occur in each of the rocks' composition.
 * 
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