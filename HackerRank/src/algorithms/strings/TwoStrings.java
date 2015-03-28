/**
 * 
 */
package algorithms.strings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Problem Statement
 * 
 * You are given two strings, A and B. Find if there is a substring that appears
 * in both A and B.
 * 
 * Input Format
 * 
 * Several test cases will be given to you in a single file. The first line of
 * the input will contain a single integer T, the number of test cases.
 * 
 * Then there will be T descriptions of the test cases. Each description
 * contains two lines. The first line contains the string A and the second line
 * contains the string B.
 * 
 * Output Format
 * 
 * For each test case, display YES (in a newline), if there is a common
 * substring. Otherwise, display NO.
 * 
 * Constraints
 * 
 * All the strings contain only lowercase Latin letters. 1<=T<=10
 * 1<=|A|,|B|<=105 
 * Sample Input
 * 2 
 * hello 
 * world 
 * hi 
 * world 
 * 
 * Sample Output
 * 
 * YES
 * NO
 * 
 * @author PraveenK
 *
 */
public class TwoStrings {
	public static String commonSubString(String line1, String line2) {
		Set<Character> set1 = new HashSet<Character>();
		for (char c : line1.toCharArray())
			set1.add(c);
		for (char c : line2.toCharArray())
			if (set1.contains(c))
				return "YES";
		return "NO";
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		for (int i = 0; i < cases; i++)
			System.out.println(commonSubString(s.nextLine(), s.nextLine()));
		s.close();
	}
}
