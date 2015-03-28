/**
 * 
 */
package algorithms.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Alice recently started learning about cryptography and found that anagrams
 * are very useful. Two strings are anagrams of each other if they have same
 * character set. For example strings "bacdc" and "dcbac" are anagrams, while
 * strings "bacdc" and "dcbad" are not.
 * 
 * Alice decides on an encryption scheme involving 2 large strings where
 * encryption is dependent on the minimum number of character deletions required
 * to make the two strings anagrams. She need your help in finding out this
 * number.
 * 
 * Given two strings (they can be of same or different length) help her in
 * finding out the minimum number of character deletions required to make two
 * strings anagrams. Any characters can be deleted from any of the strings.
 * 
 * Input Format Two lines each containing a string.
 * 
 * Constraints 1 <= Length of A,B <= 10000 A and B will only consist of
 * lowercase latin letter.
 * 
 * Output Format A single integer which is the number of character deletions.
 * 
 * Sample Input #00:
 * cde 
 * abc 
 * 
 * Sample Output #00:
 * 4
 * 
 * @author PraveenK
 *
 */
public class MakeItAnagram {

	public static int makeAnagam(String word1, String word2) {
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		int ret = 0;
		for (char c : word1.toCharArray()) {
			if (map1.containsKey(c))
				map1.put(c, map1.get(c) + 1);
			else
				map1.put(c, 1);
		}

		for (char c : word2.toCharArray()) {
			if (map1.containsKey(c) && map1.get(c) > 0)
				map1.put(c, map1.get(c) - 1);
			else if (map2.containsKey(c))
				map2.put(c, map2.get(c) + 1);
			else
				map2.put(c, 1);
		}

		for (Character c : map1.keySet())
			ret += map1.get(c);
		for (Character c : map2.keySet())
			ret += map2.get(c);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println(makeAnagam(s.nextLine(), s.nextLine()));
		s.close();
	}
}
