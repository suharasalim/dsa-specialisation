package greedy;

import java.util.Scanner;

public class CarFueling {
	static int computeMinRefills(int dist, int tank, int[] stops) {
		int refills = 0;

		int lastRefillPos = 0;
		int currentFuel = tank;
		int lastPossibleRefill = 0;

		int i = 0;
		int n = stops.length;

		while (currentFuel + lastRefillPos < dist) {
			lastPossibleRefill = lastRefillPos;
			boolean refilled = false;

			while (i < n && stops[i] <= currentFuel + lastRefillPos) {
				lastPossibleRefill = stops[i];
				i++;
				refilled = true;
			}

			if (!refilled) {
				return -1;
			}
			lastRefillPos = lastPossibleRefill;
			currentFuel = tank;
			refills++;

		}

		return refills;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));
	}

}
