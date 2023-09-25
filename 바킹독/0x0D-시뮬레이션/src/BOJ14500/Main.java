package BOJ14500;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] board;
	static int N;
	static int M;
	static int result;
	static int[] visited;
	static int[] dx

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
		result = 0;

		for (int i = 0; i <= N - 4; i++) {
			for (int j = 0; j <= M - 4; j++) {
				selectFourDots(i, j, 0, 0, new int[4]);
			}
		}

	}

	public static void selectFourDots(int x, int y, int cnt, int prev, int[] selectedNums) {
		if (cnt == 4) {
			isPossible(selectedNums);
		}

		for (int i = prev; i < 16; i++) {
			selectedNums[cnt] = i;
			selectFourDots(x, y, cnt + 1, i + 1, selectedNums);
		}
	}

	public static void isPossible(int[] selectedNums) {
		int[][] miniBoard = new int[4][4];
		for (int i = 0; i < 4; i++) {
			miniBoard[selectedNums[i] / 4][selectedNums[i] % 4] = 1;
		}
		
	}
}
