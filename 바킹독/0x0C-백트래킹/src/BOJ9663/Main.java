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

	public static void help(int row) { // �� ��° �ٿ��� �� �ڸ� ã���ִ����� row�� ǥ��
		// base case
		if (row == N) {
			cnt++;
			return;
		}

		// recursive case
		for (int col = 0; col < N; col++) { // row�࿡ �ִ� ��� ���� ���ؼ�
			// �� ���� �� �ִ� �ڸ����� üũ
			boolean isPossible = true;

			// 1. ���� üũ
			for (int j = 0; j < N; j++) { // ��� �࿡ ���ؼ� �˻�
				if (visited[j][col] == 1) {
					isPossible = false;
					break;
				}
			}
			// �밢�� üũ
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
			if (isPossible) { // �� row ���� col ���� ���� ���� �� ���� �� ���ȣ��
				visited[row][col] = 1;
				help(row + 1);
				visited[row][col] = 0;
			}

		}
	}
}
