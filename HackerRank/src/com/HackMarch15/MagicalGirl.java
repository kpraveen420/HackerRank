/**
 * 
 */
package com.HackMarch15;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Problem Statement
 * 
 * During a fair, magical girl gets separated from her parents. Night has fallen
 * and it is dark already. The spirits have started appearing, and she has been
 * trapped on a bridge. She needs to cross the bridge to return home safely.
 * 
 * Initially, she is at the start of the bridge (i.e. at index 0) with 0 initial
 * strength. On the bridge, there are a total of n spirits (which appear in the
 * order 1 to n), both good and bad ones. Each spirit has a parameter strength
 * Si. When she comes in contact with good spirit, it increases her strength by
 * |Si| (Si≥0) while bad ones decrease by |Si| (Si<0).
 * 
 * Being skeptical about her safety, her master, Devu, had already granted her a
 * very special power called "reverse the effect", which can be used at most
 * once. By using this power on a spirit, it can change a bad spirit to a good
 * spirit and vice versa. Formally a spirit having initial strength Si, will
 * have −Si strength after the application of special power on it. Note that she
 * can use this special power on the spirit before the spirit show their effects
 * of strengths. If, at any position, her strength becomes negative, she dies
 * instantly.
 * 
 * As she is quite intelligent, she will use the power provided by her master
 * smartly. If she is able to reach home safely, print "She did it!" (without
 * quotes). Otherwise print the maximum position up to which she could reach
 * (i.e. the position at which she died due to the effect of spirits).
 * 
 * Please find it fast! My heart is praying for her safety!
 * 
 * Note
 * 
 * reverse the effect special power is applied on the spirit
 * 
 * Input Format
 * 
 * The first line of the input contains a single integer, T, denoting the number
 * of test cases. For each test case, there are two lines. The first line will
 * contain a single integer, n, denoting the number of spirits. The second line
 * will contain n space-separated integers denoting the strengths of the spirits
 * (i.e. the ith integer will denote Si). Output Format
 * 
 * For each test case, print a single line denoting the answer to the problem.
 * 
 * Constraints
 * 
 * 1≤T≤105 1≤n≤105 −103≤Si≤103 Sum of n over all the test cases will be less
 * than or equal to 106.
 * 
 * 
 * Sample Input
 * 
 * 3 
 * 2 
 * -1 -2 
 * 3 
 * 1 -2 3 
 * 4 
 * 1 2 3 -7
 * 
 * Sample Output
 * 
 * 2 
 * She did it! 
 * She did it! 
 * 
 * Test Case 1:
 * 
 * When she meets the first spirit, her strength will become negative, so in
 * order not to die, she has to apply the "reverse the effect" power on the
 * first spirit. After applying this power, she will have strength equal to 1.
 * Now she will go to the second spirit, where her strength will become -1 and
 * she will die at that position. So you need to print 2, denoting the position
 * where she died. Test Case 2:
 * 
 * When she meets the first spirit, her strength will become 1. At the second
 * position, her strength will become -1 (1 - 2), so in order not to die, she
 * has to apply the "reverse the effect" power on the second spirit. After
 * applying this power, she will have strength equal to 3 (1 + 2). Now she will
 * go to the third spirit, her strength will become 6, so she will cross the
 * bridge and reach her home safely. Test Case 3:
 * 
 * At 1, 2 and 3rd position, she meets the spirit and her strength increases to
 * 6. At the 4th position, she meets the spirit and her strength decreases to -1
 * ( 6 - 7), she then uses the power reverse the effect on the 4th spirit and
 * her strength increases to 13 (6+7)
 * 
 * @author PraveenK
 *
 */
public class MagicalGirl {
	public static String journey(int[] spirits) {
		int girlPower = 0;
		boolean reverse = true;
		int prevPower = 0, prevIndex = 0;
		for (int i = 0; i < spirits.length; i++) {
			if (reverse && spirits[i] < 0 && spirits[i] < spirits[prevIndex]) {
				prevIndex = i;
				prevPower = girlPower - spirits[i];
			}
			if (girlPower + spirits[i] < 0)
				if (!reverse)
					return "" + (i + 1);
				else {
					if (i != prevIndex) {
						i = prevIndex;
						girlPower = prevPower;
						reverse = false;
						continue;
					}
					girlPower -= spirits[i];
					reverse = false;
				}
			else
				girlPower += spirits[i];
		}
		return "She did it!";
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());
		int[] input;
		String j, data[];
		for (int i = 0; i < testCases; i++) {
			s.nextLine();
			j = s.nextLine();
			data = j.split("\\s+");
			input = new int[data.length];
			for (int k = 0; k < data.length; k++)
				input[k] = Integer.parseInt(data[k]);
			System.out.println(journey(input));
		}
		s.close();
	}
}