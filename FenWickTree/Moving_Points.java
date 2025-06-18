package FenWickTree;

import java.util.*;

public class Moving_Points {
	static class Point implements Comparable<Point> {
		int x, v;

		public Point(int x, int v) {
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
	}

	static class FenwickTree {
		long[] tree;
		int size;

		FenwickTree(int size) {
			this.size = size;
			tree = new long[this.size];
		}

		void update(int index, long value) {
			while (index < size) {
				tree[index] += value;
				index += index & (~(index - 1));
			}
		}

		long query(int index) {
			long result = 0;
			while (index > 0) {
				result += tree[index];
				index -= index & (~(index - 1));
			}
			return result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point[] arr = new Point[n];
		int[] allV = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = new Point(sc.nextInt(), 0);
		for (int i = 0; i < n; i++) {
			arr[i].v = sc.nextInt();
			allV[i] = arr[i].v;
		}
		// Step 1: Group same velocities
		HashMap<Integer, List<Integer>> velocityGroups = new HashMap<>();
		for (Point p : arr) {
			if (!velocityGroups.containsKey(p.v)) {
				velocityGroups.put(p.v, new ArrayList<>());
			}
			velocityGroups.get(p.v).add(p.x);

		}
		long result = 0;

		// System.out.println(velocityGroups);
		for (int velocity : velocityGroups.keySet()) {
			List<Integer> group = velocityGroups.get(velocity);
			Collections.sort(group);
			long prefix = 0;
			for (int i = 0; i < group.size(); i++) {
				result += (long)group.get(i) * i - prefix;
				prefix += group.get(i);
				// System.out.println(result);
			}

		}
		// System.out.println(result);
		// Step 2: Coordinate compression of velocities
		Set<Integer> velocitySet = new HashSet<>();
		for (int val : allV) {
			velocitySet.add(val);
		}
		List<Integer> sortedVelocities = new ArrayList<>(velocitySet);
		Collections.sort(sortedVelocities);
		HashMap<Integer, Integer> velocityIndex = new HashMap<>();
		for (int i = 0; i < sortedVelocities.size(); i++) {
			velocityIndex.put(sortedVelocities.get(i), i + 1);
		}

		// Step 3: Sort points by position
		Arrays.sort(arr);
		// Step 4: Fenwick Trees
		FenwickTree countx = new FenwickTree(n + 1);
		FenwickTree sumx = new FenwickTree(n + 1);
		for (Point p : arr) {
			int vidx = velocityIndex.get(p.v);
			long counx = countx.query(vidx - 1);
			long sum = sumx.query(vidx - 1);
			result += p.x * counx - sum;
			countx.update(vidx, 1);
			sumx.update(vidx, p.x);

		}
		System.out.println(result);

	}

}
