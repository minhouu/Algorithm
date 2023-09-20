import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N + 1];
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			// 모든 간선에 대해서
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			int[] isUsed = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				if(isUsed[findSet(p[i])] != 1) {
					isUsed[findSet(p[i])] = 1;
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static void union(int a, int b) {
		p[findSet(a)] = findSet(b);
	}

	public static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}
