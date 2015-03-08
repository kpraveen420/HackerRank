package algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	// Solution1
	// public static void main(String[] args) throws IOException {
	// // Scanner s = new Scanner(System.in);
	// StringBuffer sb = new StringBuffer();
	// BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
	// int testCases = Integer.parseInt(s.readLine());
	// String line, word[] = new String[2];
	//
	//
	// while (testCases > 0) {
	// HashMap<Character, Integer> map = new HashMap();
	// line = s.readLine();
	// if (line.length() % 2 == 1 || line.length() == 0) {
	// System.out.println(-1);
	// testCases--;
	// continue;
	// }
	// word[0] = line.substring(0, line.length() / 2);
	// word[1] = line.substring(line.length() / 2);
	// for (int i = 0; i < word[0].length(); i++) {
	// if (map.get(word[0].charAt(i)) != null)
	// map.put(word[0].charAt(i), map.get(word[0].charAt(i)) + 1);
	// else
	// map.put(word[0].charAt(i), 1);
	// }
	//
	// for (int i = 0; i < word[1].length(); i++) {
	// if (map.get(word[1].charAt(i)) != null
	// && map.get(word[1].charAt(i)) > 0)
	// map.put(word[1].charAt(i),map.get(word[1].charAt(i))-1);
	// }
	//
	// int changeChars = 0;
	// for (Character c : map.keySet())
	// changeChars += map.get(c);
	// System.out.println(changeChars);
	//
	// testCases--;
	// }
	// }

	// Solution2
	public static void main(String[] args) throws IOException {
		// StringBuffer sb = new StringBuffer();
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(s.readLine());
		String line, word[] = new String[2];
		while (testCases > 0) {
			short[] charMap = new short[26];
			short num = 0;
			line = s.readLine();
			if (line.length() % 2 == 1 || line.length() == 0) {
				System.out.println(-1);
				testCases--;
				continue;
			}
			word[0] = line.substring(0, line.length() / 2);
			word[1] = line.substring(line.length() / 2);
			for (int i = 0; i < word[0].length(); i++)
				charMap[word[0].charAt(i) - 'a'] += 1;
			for (int i = 0; i < word[1].length(); i++)
				if (charMap[word[1].charAt(i) - 'a'] > 0)
					charMap[word[1].charAt(i) - 'a'] -= 1;
			for (int i = 0; i < 26; num += charMap[i++])
				;
			System.out.println(num);
			testCases--;

		}

	}

}
