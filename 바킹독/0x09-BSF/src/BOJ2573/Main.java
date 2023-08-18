package BOJ2573;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	static int M;
	static int N;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// �Էº�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// �����
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int time = 0; // �ɸ��ð� ����
		int sum = 1; // visited �迭 Ȯ�ο�
		int[][] visited; // 1. ��� ���� ���
		
		// ���� �� ���ϰ� �ϳ����� üũ
		if (isSeperated(board)) {
			System.out.println(0);
			return;
		}

		// ������ 2���� �ɰ����� ������, �ð��� �� �Ǳ� ������ �ݺ�
		while (sum > 0) {
			visited = new int[N][M];
			// 0�� �ƴ� �κи��� 4���� üũ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] != 0) { // 0�� �ƴ� ��� ��忡��
						for (int dir = 0; dir < 4; dir++) {
							int x = i + dx[dir];
							int y = j + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= M) {
								continue;
							}
							if (board[x][y] == 0) {
								visited[i][j]++;
							}
						}
						// �ش� ��� q�� ����
						q.add(new int[] { i, j });
					}
				}
			}

			// visited �迭 ������� board ������Ʈ
			while (!q.isEmpty()) {
				int[] temp = q.pop();
				int x = temp[0];
				int y = temp[1];
				if (board[x][y] < visited[x][y]) {
					board[x][y] = 0;
					continue;
				}
				board[x][y] -= visited[x][y];
			}

			// 2������ ���� üũ
			time++;
			if (isSeperated(board)) {
				System.out.println(time);
				return;
			}
			
			// visited �迭 Ȯ���Ͽ� ���� �ʾҴ��� üũ
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += visited[i][j];
				}
			}

		}
		System.out.println(0);
	}

	public static boolean isSeperated(int[][] board) {
		int[][] visited = new int[N][M];
		int rep = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		// bsf
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 0 && visited[i][j] == 0) {
					q.add(new int[] { i, j });
					visited[i][j] = 1;
					while (!q.isEmpty()) {
						int[] temp = q.pop();
						for (int dir = 0; dir < 4; dir++) {
							int x = temp[0] + dx[dir];
							int y = temp[1] + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= M) {
								continue;
							}
							if (visited[x][y] == 1 || board[x][y] == 0) {
								continue;
							}
							visited[x][y] = 1;
							q.add(new int[] { x, y });
						}
					}
					// 1���� bsf ���������� rep����
					rep++;
				}
			}
		}
		// 2�� �̻����� �������� ������ true
		if (rep > 1) {
			return true;
		}
		return false;
	}
}
