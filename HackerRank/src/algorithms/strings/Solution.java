package algorithms.strings;

import java.util.Scanner;

public class Solution {

	public static void insertIntoSorted(int[] ar) {
		int small = ar[ar.length - 1];
		int j = ar.length - 1;
		while (j > 0 && ar[j - 1] > small) {
			ar[j] = ar[j - 1];
			j--;
			printArray(ar);
		}
		if (j != ar.length - 1) {
			ar[j] = small;
			printArray(ar);
		}

	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
