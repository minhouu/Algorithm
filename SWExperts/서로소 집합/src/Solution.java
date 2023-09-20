import java.util.Scanner;

public class Solution {
	public static int[] p;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N + 1]; // 집합 저장하는 배열
			// initialize
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			sb = new StringBuilder(); // 출력결과 저장

			for (int order = 0; order < M; order++) {
				int n = sc.nextInt(); // 명령 종류
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (n == 0) {
					union(a, b);
					continue;
				}
				isSameP(a, b);
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	public static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	public static void union(int a, int b) {
		p[findSet(a)] = findSet(b);
	}

	public static void isSameP(int a, int b) {
		if (findSet(a) == findSet(b)) {
			sb.append(1);
			return;
		}
		sb.append(0);
	}
}
