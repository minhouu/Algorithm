package BOJ16985;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][][] board = new int[5][5][5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					board[i][j][k] = sc.nextInt();
				}
			}
		}

		System.out.println(Arrays.deepToString(board));
	}

	public static void rotate(int cnt, int board_new[][][]) {
		if (cnt == 5) {
			// bfs
		}

		for (int i = 0; i < 4; i++) {
			int[][] temp = new int[5][5];
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (i == 0) { // ±×´ë·Î
						
					} else if (i == 1) {

					} else if (i == 2) {

					} else if (i == 3) {

					}
				}
			}
			board_new[cnt] = temp;
		}
	}
}
