package FenWickTree;

import java.util.Arrays;
import java.util.Scanner;

public class UPDATEIT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int q1 = sc.nextInt();
			Fenwick_Tree ft = new Fenwick_Tree(n);
			for (int i = 0; i < q1; i++) {
				int l = sc.nextInt();

				int r = sc.nextInt();
				int val = sc.nextInt();
				ft.update(l+1, val, n);
				ft.update(r + 2, -val, n);
				System.out.println(Arrays.toString(ft.BIT));
				

			}
			System.out.println(Arrays.toString(ft.BIT));
			int q2 = sc.nextInt();
			for (int i = 0; i < q2; i++) {
				int l = sc.nextInt();
				System.out.println(ft.qurray(l + 1));
			}

		}
	}

	static class Fenwick_Tree {
		int[] BIT;

		public Fenwick_Tree(int n) {
			// TODO Auto-generated constructor stub
			BIT = new int[n + 1];

		}

		public void update(int i, int x, int n) {
			while (i <= n) {
				// System.out.println(i);
				BIT[i] += x;
				i += i & (~(i - 1));// i&(-i)

			}
		}

		public int qurray(int i) {
			int sum = 0;
			while (i > 0) {
				sum += BIT[i];
				i -= i & (~(i - 1));
			}
			return sum;
		}

	}
}


