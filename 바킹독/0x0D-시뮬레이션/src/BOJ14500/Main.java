package BOJ14500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] board;
	static int N;
	static int M;
	static int result = 0; // 최종 결과 저장
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// 입력부
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// 4x4 칸으로 나누어서 search하기 위해, 4x4 판의 왼쪽 맨 위 점을 모두 선택한다
		for (int i = 0; i <= N - 4; i++) {
			for (int j = 0; j <= M - 4; j++) {
				for (int a = 0; a < 16; a++) {
					for (int b = a + 1; b < 16; b++) {
						for (int c = b + 1; c < 16; c++) {
							for (int d = c + 1; d < 16; d++) {
								isPossible(i, j, new int[] { a, b, c, d });
							}
						}
					}
				}

			}
		}

		System.out.println(result);

	}

	public static void isPossible(int x, int y, int[] selectedNums) {
		// 4x4 형태의 미니보드를 선언하고, 선택된 4개 점을 1로 표시한다
		int[][] miniBoard = new int[4][4];
		for (int i = 0; i < 4; i++) {
			miniBoard[selectedNums[i] / 4][selectedNums[i] % 4] = 1;
		}

		int max_with = 0;
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int with = 0;
			int temp_x = selectedNums[i] / 4;
			int temp_y = selectedNums[i] % 4;
			sum += board[x + temp_x][y + temp_y];
			for (int dir = 0; dir < 4; dir++) {
				int a = temp_x + dx[dir];
				int b = temp_y + dy[dir];
				if (a < 0 || a >= 4 || b < 0 || b >= 4) {
					continue;
				}
				if (miniBoard[a][b] == 1) {
					with++;
				}
			}
			if (with == 0) {
				return;
			}
			max_with = Math.max(max_with, with);
		}

		// 만약 4개가 연결되어 있으면, result 업데이트
		if (max_with >= 2) {
			result = Math.max(result, sum);
		}
	}
}
