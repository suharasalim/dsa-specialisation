package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class KnapsackComparable implements Comparable<KnapsackComparable> {
	int value;
	int weight;

	KnapsackComparable(int value, int weight) {
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

	@Override
	public int compareTo(KnapsackComparable o) {
		return Double.compare((double) o.value / o.weight, (double) this.value / this.weight);
	}

}
public class FractionalKnapsackComparable {
	private static int getMaxKnapsackValue(List<KnapsackComparable> list, int weight) {

		Collections.sort(list);

		int totalValue = 0;

		for (KnapsackComparable item : list) {
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
		List<KnapsackComparable> list = new ArrayList<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(new KnapsackComparable(sc.nextInt(), sc.nextInt()));
		}

		int weight = sc.nextInt();

		System.out.println(getMaxKnapsackValue(list, weight));
	}
}
