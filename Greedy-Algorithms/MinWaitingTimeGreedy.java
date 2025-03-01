package document;

import java.util.Scanner;

public class MinWaitingTimeGreedy {

	private static int getMinWaitingTime(int[] input) {

		int totalWaitingTime = 0;
		int accumulatedTime = 0;
		int n = input.length;

		boolean[] treated = new boolean[n];

		for (int i = 0; i < n; i++) {
			int minIndex = -1;
			int minTime = Integer.MAX_VALUE;

			for (int j = 0; j < n; j++) {
				if (!treated[j] && input[j] < minTime) {
					minIndex = j;
					minTime = input[j];
				}
			}

			treated[minIndex] = true;
			totalWaitingTime += accumulatedTime;
			accumulatedTime += minTime;
		}

		return totalWaitingTime;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		System.out.println(getMinWaitingTime(input));
	}

}
