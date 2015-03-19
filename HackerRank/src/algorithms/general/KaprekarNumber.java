/**
 * 
 */
package algorithms.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement
 * 
 * A Kaprekar number is a positive whole number n with d digits, such that when
 * we split its square into two pieces - a right hand piece r with d digits and
 * a left hand piece l that contains the remaining d or d−1 digits, the sum of
 * the pieces is equal to the original number (i.e. l + r = n).
 * 
 * Here's an alternative explanation from Wikipedia: In mathematics, a Kaprekar
 * number for a given base is a non-negative integer, the representation of
 * whose square in that base can be split into two parts that add up to the
 * original number again. For instance, 45 is a Kaprekar number, because 45² =
 * 2025 and 20+25 = 45.
 * 
 * The Task You are given the two positive integers p and q, where p is lower
 * than q. Write a program to determine how many Kaprekar numbers are there in
 * the range between p and q (both inclusive) and display them all.
 * 
 * Input Format
 * 
 * There will be two lines of input: p, lowest value q, highest value
 * 
 * Constraints: 0<p<q<100000 Output Format
 * 
 * Output each Kaprekar number in the given range, space-separated on a single
 * line. If no Kaprekar numbers exist in the given range, print INVALID RANGE.
 * 
 * Sample Input
 * 
 * 1 100
 * 
 * Sample Output
 * 
 * 1 9 45 55 99
 * 
 * 
 * 
 * 
 * @author PraveenK
 *
 */
public class KaprekarNumber {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(isKaprekar(99999));
//		List<Integer> abc = kaprekarNumebrs(Integer.parseInt(br.readLine()),
//				Integer.parseInt(br.readLine()));
//		for (int i = 0; i < abc.size(); i++) {
//			System.out.print(abc.get(i));
//			if (i < abc.size() - 1)
//				System.out.print(" ");
//		}
	}

	public static List<Integer> kaprekarNumebrs(int min, int max) {
		List<Integer> intList = new ArrayList<Integer>();

		for (; min <= max; min++) {
			if (isKaprekar(min))
				intList.add(min);
		}
		return intList;
	}

	private static boolean isKaprekar(int n) {

		int sq = n * n; // finding the square of the number
		String s = Integer.toString(sq); // converting the square into a String

		if (sq <= 9)
			s = "0" + s; // Adding a zero in the beginning if the square is of
							// single digit

		int l = s.length(); // finding the length (i.e. no. of digits in the
							// square).
		int mid = l / 2; // finding the middle point

		String left = s.substring(0, mid); // extracting the left digits from
											// the square
		String right = s.substring(mid); // extracting the right digits from the
											// square
		System.out.println(sq);
		System.out.println(left);
		System.out.println(right);
		int x = Integer.parseInt(left); // converting the left String into
										// Integer
		int y = Integer.parseInt(right); // converting the right String into
											// Integer

		// if sum of left and right numbers is equal to the original number then
		// it is a Kaprekar number
		if (x + y == n)
			return true;
		return false;
	}
}
