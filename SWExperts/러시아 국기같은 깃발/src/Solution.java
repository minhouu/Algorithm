import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력부
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			for (int i = 0; i < N; i++) {
				s = bf.readLine();
				for (int j = 0; j < M; j++) {
					char input = s.charAt(j);
					// w : 0, b : 1, r : 2로 치환하여 board 생성
					if (input == 'W') {
						board[i][j] = 0;
					} else if (input == 'B') {
						board[i][j] = 1;
					} else if (input == 'R') {
						board[i][j] = 2;
					}
				}
			}

			int min_count = Integer.MAX_VALUE;
			int count;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					// System.out.println("0 ~ " + i + ", " + (i + 1) + " ~ " + j + ", " + (j + 1) +
					// " ~ " + (N - 1));
					// 모든 w, b, r 조합을 순회하면서
					// 바꿔야하는 횟수(count)를 측정하고
					// 그 중 가장 작은 값(min_count)를 찾는다
					count = 0;
					for (int row = 0; row <= i; row++) {
						for (int col = 0; col < M; col++) {
							if (board[row][col] != 0) {
								count++;
							}
						}
					}
					for (int row = i + 1; row <= j; row++) {
						for (int col = 0; col < M; col++) {
							if (board[row][col] != 1) {
								count++;
							}
						}
					}
					for (int row = j + 1; row < N; row++) {
						for (int col = 0; col < M; col++) {
							if (board[row][col] != 2) {
								count++;
							}
						}
					}
					min_count = Math.min(count, min_count);

				}
			}
			System.out.println("#" + t + " " + min_count);

		}

	}
}
