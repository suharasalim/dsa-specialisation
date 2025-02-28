package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Knapsack {
	int value;
	int weight;

	Knapsack(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}

public class FractionalKnapsack {

	private static int getMaxKnapsackValue(List<Knapsack> list, int weight) {

		Collections.sort(list,
				(o1, o2) -> Double.compare((double) o2.value / o2.weight, (double) o1.value / o1.weight));

		int totalValue = 0;

		for (Knapsack item : list) {
			if (weight == 0)
				break;
			int currWeight = item.getWeight();
			int currValue = item.getValue();

			int a = Math.min(currWeight, weight);
			totalValue += a * ((double) currValue / currWeight);
			item.setWeight(currWeight - a);

			weight = weight - a;

		}

		return totalValue;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Knapsack> list = new ArrayList<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(new Knapsack(sc.nextInt(), sc.nextInt()));
		}

		int weight = sc.nextInt();

		System.out.println(getMaxKnapsackValue(list, weight));
	}

}
