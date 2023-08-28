package BOJ17071;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 선언부
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] visited = new int[2][100];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < visited.length; j++) {
				visited[i][j] = -1;
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();

		// bfs
		q.add(N);
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int dir = 1; dir <= 3; dir++) {
				int x = temp;
				if (dir == 1) {
					x -= 1;
				} else if (dir == 2) {
					x += 1;
				} else {
					x *= 2;
				}
				// 범위 나가면 continue;
				if (x < 0 || x >= visited.length) {
					continue;
				}

				for (int mod = 0; mod < 2; mod++) {
					if (visited[mod][x] != -1) {
						continue;
					}
					visited[mod][x] = visited[1-mod][temp] + 1;
					q.add(x);
				}
				
			}
		}
		
		System.out.println(Arrays.toString(visited[0]));
		System.out.println(Arrays.toString(visited[1]));

		
//		int k = K;
//		int t = 0;
//		int min = Integer.MAX_VALUE;
//		while (k <= 500000) {
//			int isOdd = t % 2;
//			if (isOdd == visited[k] % 2) {
//				if (t >= visited[k]) {
//					min = Math.min(min, t);
//				}
//			}
//			t++;
//			k = K + (t * (t + 1) / 2);			
//		}
//		if (min != Integer.MAX_VALUE) {
//			System.out.println(min);
//			return;
//		}
//		System.out.println(-1);
	}
}
