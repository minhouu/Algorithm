package BOJ9663;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] visited;
	static int cnt = 0;
	static int[][] dir = new int[][] { { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new int[N][N];
		help(0);
		System.out.println(cnt);

	}

	public static void help(int row) { // 몇 번째 줄에서 퀸 자리 찾고있는지를 row로 표현
		// base case
		if (row == N) {
			cnt++;
			return;
		}

		// recursive case
		for (int col = 0; col < N; col++) { // row행에 있는 모든 열에 대해서
			// 퀸 놓을 수 있는 자리인지 체크
			boolean isPossible = true;

			// 1. 세로 체크
			for (int j = 0; j < N; j++) { // 모든 행에 대해서 검사
				if (visited[j][col] == 1) {
					isPossible = false;
					break;
				}
			}
			// 대각선 체크
			for (int j = 1; j < row + 1; j++) {
				if (isPossible) {
					for (int k = 0; k < N; k++) {
						if (visited[j][k] == 1) {
							if (Math.abs(row - j) == Math.abs(col - k)) {
								isPossible = false;
								break;
							}
						}
					}
				}

			}
			if (isPossible) { // 이 row 행의 col 열에 퀸을 놓을 수 있을 때 재귀호출
				visited[row][col] = 1;
				help(row + 1);
				visited[row][col] = 0;
			}

		}
	}
}
