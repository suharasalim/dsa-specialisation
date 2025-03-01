package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MoneyChangeProblem {

	private static int getMinNumberOfCoins(int amount, List<Integer> denominations) {

		int numcoins = 0;
		AtomicInteger remainingAmount = new AtomicInteger(amount); // to hold the mutable amount

		while (remainingAmount.get() > 0) {
			Optional<Integer> maxCoin = denominations.stream().filter(num -> num <= remainingAmount.get())
					.max(Integer::compareTo);
			if (!maxCoin.isPresent()) {
				throw new IllegalArgumentException("No valid denominations");
			}
			remainingAmount.addAndGet(-maxCoin.get());
			numcoins++;
		}

		return numcoins;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int n = 3;
		List<Integer> denominations = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			denominations.add(sc.nextInt());
		}
		System.out.println(getMinNumberOfCoins(amount, denominations));
	}

}
