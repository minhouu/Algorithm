package BOJ18808;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] board;
	static int[][][] stickers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		board = new int[N][M];
		stickers = new int[K][][];
		for (int i = 0; i < K; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			stickers[i] = new int[n][m];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					stickers[i][r][c] = sc.nextInt();
				}
			}
		}

		for (int st = 0; st < K; st++) { // ��� ��ƼĿ�� ���Ͽ�
			boolean isPossible = false;
			for (int dir = 0; dir < 4; dir++) { // 4���� ȸ�� ���⿡ ����
				for (int i = 0; i < N; i++) { // ��� ��ǥ����
					for (int j = 0; j < M; j++) {
						// �� ��ǥ���� ��ƼĿ�� ���� �� �ִ��� üũ
						isPossible = check(new int[] { i, j }, stickers[st], dir);

						// ���� �ش� ��ġ�� ��ƼĿ�� ���� �� �ִٸ� board�� �ش� ��ƼĿ�� ǥ���Ѵ�
						if (isPossible) {
							break;
						}
					}
					if (isPossible)
						break;
				}
				if (isPossible)
					break;
			}
		}

		// ��ƼĿ�� ���� ĭ�� ���� ����
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}

	public static boolean check(int[] head, int[][] sticker, int dir) {
		// head : üũ�� board�� ���� ���� �� ��ǥ
		// sticker : ��ƼĿ ������ 2�����迭
		// dir : ����

		// 1. ��ƼĿ�� dir(����)�� ���� �����ϰ� temp_sticker �迭�� ���¸� �����Ѵ�.
		int[][] temp_sticker = sticker;

		if (dir != 0) {
			if (dir == 1) {
				temp_sticker = new int[sticker[0].length][sticker.length];
				for (int i = 0; i < sticker[0].length; i++) {
					for (int j = 0; j < sticker.length; j++) {
						temp_sticker[i][j] = sticker[sticker.length - j - 1][i];
					}
				}
			}

			else if (dir == 2) {
				temp_sticker = new int[sticker.length][sticker[0].length];
				for (int i = 0; i < sticker.length; i++) {
					for (int j = 0; j < sticker[0].length; j++) {
						temp_sticker[i][j] = sticker[sticker.length - 1 - i][sticker[0].length - 1 - j];
					}
				}
			}

			else if (dir == 3) {
				temp_sticker = new int[sticker[0].length][sticker.length];
				for (int i = 0; i < sticker[0].length; i++) {
					for (int j = 0; j < sticker.length; j++) {
						temp_sticker[i][j] = sticker[j][sticker[0].length - 1 - i];
					}
				}
			}
		}
		
		
		
		// ��ƼĿ�� board�� ��踦 �Ѿ�� ����
		if (head[0] + temp_sticker.length > N || head[1] + temp_sticker[0].length > M) {
			return false;
		}
			

		// 2. head�� ��ġ���� �����Ͽ�, �ش� ��ġ�� sticker�� �� �� �ִ��� Ȯ���Ѵ�.
		for (int i = head[0], r = 0; i < head[0] + temp_sticker.length; i++, r++) {
			for (int j = head[1], c = 0; j < head[1] + temp_sticker[0].length; j++, c++) {
				if (temp_sticker[r][c] == 1) {
					if (board[i][j] != 0) {
						return false;
					}
				}
			}
		}
		
		// 3. board�� ĥ�Ѵ�
		for (int i = head[0], r = 0; i < head[0] + temp_sticker.length; i++, r++) {
			for (int j = head[1], c = 0; j < head[1] + temp_sticker[0].length; j++, c++) {
				if (temp_sticker[r][c] == 1) {
					board[i][j] = 1; 
 				}
			}
		}
		return true;
	}
}
