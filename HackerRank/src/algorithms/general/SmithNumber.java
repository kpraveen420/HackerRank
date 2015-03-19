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
 * @author PraveenK
 *
 */
public class SmithNumber {

	public static List<Integer> primeFactors(long number) {
		List<Integer> primefactors = new ArrayList<Integer>();
		long copyOfInput = number;
		for (int i = 2; i <= copyOfInput; i++) {
			if (copyOfInput % i == 0) {
				primefactors.add(i); // prime factor
				copyOfInput /= i;
				i--;
			}
		}
		return primefactors;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(smithNumber(Integer.parseInt(br.readLine())));

	}

	public static int smithNumber(int num) {
		int ret = 0;
		List<Integer> primeFactors = primeFactors(num);
		int sumOfFactors = 0;
		for (int a : primeFactors)
			sumOfFactors += sumDigits(a);

		System.out.println(sumOfFactors);
		System.out.println(ret);

		return sumDigits(num) == sumOfFactors ? 1 : 0;
	}

	private static int sumDigits(int num) {
		int ret = 0;
		while (num > 0) {
			ret += num % 10;
			num /= 10;
		}
		return ret;
	}
}
