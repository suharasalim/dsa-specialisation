package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// write your code here
		String result = "";
		Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));

		if (a[0].equals("0"))
			return "0";
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}
