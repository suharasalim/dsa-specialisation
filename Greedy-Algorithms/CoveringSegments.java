package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {
	private static int[] optimalPoints(Segment[] segments) {
		Arrays.sort(segments, (o1, o2) -> o1.end - o2.end);
		List<Integer> points = new ArrayList<>();

		int i = 0;

		int n = segments.length;

		while (i < n) {
			
			int pos = segments[i].end;
			points.add(pos);
			
			while (i < n && segments[i].start <= pos) {

				i++;
			}

		}
		
		return points.stream().mapToInt(Integer::intValue).toArray();

	}

	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}
	}
}
