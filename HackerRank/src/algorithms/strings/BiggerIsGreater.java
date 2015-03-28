/**
 * 
 */
package algorithms.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Problem Statement
 * 
 * Given a word w, rearrange the letters of w to construct another word s in
 * such a way that, s is lexicographically greater than w. In case of multiple
 * possible answers, find the lexicographically smallest one.
 * 
 * Input Format The first line of input contains t, number of test cases. Each
 * of the next t lines contains w.
 * 
 * Constraints 1≤t≤105 1≤|w|≤100 w will contain only lower case english letters
 * and its' length will not exceed 100.
 * 
 * Output Format For each testcase, output a string lexicographically bigger
 * than w in a separate line. In case of multiple possible answers, print the
 * lexicographically smallest one and if no answer exists, print no answer.
 * 
 * Sample Input
 * 
 * 3 
 * ab 
 * bb 
 * hefg 
 * 
 * Sample Output
 * 
 * ba 
 * no answer 
 * hegf
 * 
 * @author PraveenK
 *
 */
public class BiggerIsGreater {

	public static String lexicographicallyBigger(String word) {
		String ret = "no answer";
		int index = -1, last = -1;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i - 1) < word.charAt(i)) {
				index = i - 1;
				last = i;
			} else if (index != -1) {
				if (word.charAt(last) > word.charAt(i)
						&& word.charAt(index) < word.charAt(i)) {
					last = i;
				}
			}
		}

		if (index != -1) {
			char[] abc = new char[last - index + word.length() - last - 1];
			int a = 0;
			for (char ch : word.substring(index, last).toCharArray())
				abc[a++] = ch;
			for (char ch : word.substring(last + 1).toCharArray())
				abc[a++] = ch;
			Arrays.sort(abc);
			ret = word.substring(0, index) + word.charAt(last)
					+ new String(abc);
		}
		return ret;

	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());
		for (int i = 0; i < testCases; i++) {
			System.out.println(lexicographicallyBigger(s.nextLine()));
		}
		s.close();
	}

}
