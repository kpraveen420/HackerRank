package algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SongOfPi {

	private static String pi = "31415926535897932384626433833";

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (byte T = Byte.parseByte(br.readLine()); T > 0; --T) {
			if (piChecker(br.readLine())) {
				System.out.println("It's a pi song.");
			} else {
				System.out.println("It's not a pi song.");
			}
		}

	}

	private static boolean piChecker(String line) {
		String myPi = "";
		for (String word : line.split("\\s+")) {
			int num = 0;
			for (int index = 0; index < word.length(); index++) {
				if (Character.isLetter(word.charAt(index)))
					num++;
			}
			myPi = myPi + num;
		}
		return contains(pi, myPi);
	}

	private static boolean contains(String name1, String name2) {

		for (int i = 0; i < name1.length(); i++) {
			if (i < name2.length()) {
				if (name1.charAt(i) != name2.charAt(i))
					return false;
			} else
				break;

		}
		return true;
	}

}