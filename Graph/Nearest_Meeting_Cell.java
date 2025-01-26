package Graph;

import java.util.*;

public class Nearest_Meeting_Cell {

	class Pair {
		long dist;
		int node;

		Pair(long dist, int node) {
			this.dist = dist;
			this.node = node;
		}

	}

	// Dijkstra's algorithm implementation
	public long[] dijkstra(List<List<Integer>> graph, int source) {
		int v = graph.size();
		long[] ans = new long[v];
		Arrays.fill(ans, Long.MAX_VALUE);
//		ans[source] = 0;

		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1.dist, o2.dist);
			}

		});
		pq.add(new Pair(0, source));

		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			long dist = current.dist;
			int node = current.node;
			if (ans[node] > dist) {
				ans[node] = dist;
			}
			for (int neighbor : graph.get(node)) {
				if (ans[neighbor] == Long.MAX_VALUE) {
					pq.add(new Pair(dist + 1, neighbor));
				}
			}
		}
		return ans;
	}

	public int minimumWeight(int n, int[] edges, int C1, int C2) {
		// Create the graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			if (edges[i] != -1) {
				graph.get(i).add(edges[i]);
			}
		}

		// Part 1 & 2: Use Dijkstra's algorithm to find distances from C1 and C2
		long[] A = dijkstra(graph, C1);
		// System.out.println(Arrays.toString(A));
		long[] B = dijkstra(graph, C2);
		// System.out.println(Arrays.toString(B));

		// Part 3: Find the node with the minimum sum of distances
		int node = -1;
		long dist = Long.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (A[i] == Long.MAX_VALUE || B[i] == Long.MAX_VALUE) {
				continue;
			}
			if (dist > A[i] + B[i]) {
				dist = A[i] + B[i];
				node = i;
			}
		}

		return node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] edges = new int[n];
		for (int i = 0; i < n; i++) {
			edges[i] = sc.nextInt();
		}

		int C1 = sc.nextInt();
		int C2 = sc.nextInt();

		int nearestMeetingCell = new Nearest_Meeting_Cell().minimumWeight(n, edges, C1, C2);
		System.out.println(nearestMeetingCell);

		sc.close();
	}
}
