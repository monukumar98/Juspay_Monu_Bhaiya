package FenWickTree;

import java.util.Arrays;
import java.util.Scanner;

public class Fenwick_Tree {
	int[] BIT;

	public Fenwick_Tree(int n) {
		// TODO Auto-generated constructor stub
		BIT = new int[n + 1];

	}

	public void update(int i, int x, int n) {
		while (i <= n) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		Fenwick_Tree ft = new Fenwick_Tree(n);
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			ft.update(i, a[i], n);
		}
		System.out.println(Arrays.toString(ft.BIT));
		int q = sc.nextInt();
		while (q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(ft.qurray(r) - ft.qurray(l - 1));
		}
	}

}

