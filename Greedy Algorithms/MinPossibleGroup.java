package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinPossibleGroup {

	private static int getMinPossibleGroup(int[] ages, int n) {
		int groups = 0;

		int i = 0;
		Arrays.sort(ages);

		while (i < n) {
			int groupStart = ages[i];
			groups++;
			i++;

			while (i < n && ages[i] <= groupStart + 1) {
				i++;
			}

		}

		return groups;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		System.out.println(getMinPossibleGroup(input, n));
	}
}
