package divideAndConquer;

import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int[] a, int x) {
		int left = 0, right = a.length;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}
		for (int i = 0; i < m; i++) {
			// replace with the call to binarySearch when implemented
			System.out.print(binarySearch(a, b[i]) + " ");
		}
	}
}
