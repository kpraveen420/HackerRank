/**
 * 
 */
package algorithms.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author PraveenK
 *
 */
public class ConnectedGrids {

	private static int[][] data;
	private static int x, y;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());
		data = new int[x][y];
		for (int i = 0; i < x; i++) {
			String[] d = br.readLine().split("\\s+");
			int j = 0;
			for (String word : d) {
				data[i][j++] = Integer.parseInt(word);
			}
		}
		System.out.println(findMax());

	}

	private static int findMaxCells(int a, int b) {

		if (a >= x || b >= y || data[a][b] == 0)
			return 0;
		else {
			return 1 + Math.max(Math.max(
					b < y - 1 ? findMaxCells(a, b + 1) : 0,
					a < x - 1 ? findMaxCells(a + 1, b) : 0), Math.max(
					(a < x - 1 && b < y - 1) ? findMaxCells(a + 1, b + 1) : 0,
					b > 0 ? findMaxCells(a + 1, b - 1) : 0));
		}
	}

	public static int findMax() {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				if (data[i][j] != 0)
					set.add(findMaxCells(i, j));
		int max = 0;
		for (int temp : set)
			if (max < temp)
				max = temp;
		return max;
	}
}
