package Graph;

import java.util.*;

public class Longest_Cycle_Lenght {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(largestSumCycle(n, arr));
	}

	public static long largestSumCycle(int n, int[] edge) {

		int[] in = new int[n];
		// Count the in-degrees
		for (int i : edge) {
			if (i != -1)
				in[i]++;
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];

		// Nodes with in-degree 0 are not part of any cycle
		for (int i = 0; i < n; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}

		// Process the q
		while (!q.isEmpty()) {
			int node = q.poll();
			visited[node] = true;
			if (edge[node] == -1)
				continue;
			in[edge[node]]--;
			if (in[edge[node]] == 0) {
				q.add(edge[node]);
			}
		}

		long ans = -1;

		// Calculate the maximum sum of a cycle
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				long val = i;
				visited[i] = true;
				int nbrs = edge[i];
				while (nbrs != i) {
					val += nbrs;
					visited[nbrs] = true;
					nbrs = edge[nbrs];
				}
				ans = Math.max(ans, val);
			}
		}

		return ans;
	}
}
