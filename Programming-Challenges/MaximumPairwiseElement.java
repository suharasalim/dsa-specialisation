/*
 * Maximum Pairwise Product Problem
Find the maximum product of two distinct numbers in a sequence of non-negative integers.
Input: An integer n and a sequence of n non-negative integers.
Output: The maximum value
that can be obtained by multiplying two different elements from
the sequence.
 * */

package document;

import java.util.Scanner;

public class MaximumPairwiseElement {

	private static int getMaximumPairwiseElement(int[] arr) {
		if (arr.length < 2) {
			throw new IllegalArgumentException("Atleast 2 records needed");
		}
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstMax) {
				secondMax = firstMax;
				firstMax = arr[i];
			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
			}
		}
		return firstMax * secondMax;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(getMaximumPairwiseElement(arr));
	}

}
