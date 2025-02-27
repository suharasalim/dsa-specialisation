package document;

import java.util.Arrays;
import java.util.Scanner;

public class MinWaitingTimeSorting {

	private static int getMinWaitingTime(int[] input) {
		Arrays.sort(input);

		int totalWaitingTime = 0;
		int accumulatedWaitingTime = 0;

		for (int i = 0; i < input.length; i++) {
			totalWaitingTime += accumulatedWaitingTime;
			accumulatedWaitingTime += input[i];
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
