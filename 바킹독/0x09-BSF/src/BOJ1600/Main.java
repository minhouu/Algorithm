package BOJ1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// board �Է¹޴� �κ�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int K = Integer.parseInt(st.nextToken());
		s = bf.readLine();
		st = new StringTokenizer(s);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = bf.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �����
		int[][][] dist = new int[K + 1][N][M]; // 0~k�� �پ���� ������ �ٸ� �迭�� ����
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		int[] hx = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] hy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

		// dist -1�� �ʱ�ȭ
		for (int i = 0; i < K + 1; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					dist[i][j][k] = -1;
				}
			}
		}
		if (N == 1 && M == 1) {
			System.out.println(0);
			return;
		}

		// bsf
		q.add(new int[] { 0, 0, 0 }); // k�� �󸶳������ ����
		dist[0][0][0] = 0;
		while (!q.isEmpty()) {
			int[] temp = q.pop();
			int distance = dist[temp[2]][temp[0]][temp[1]];
			// 4���� Ž��
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x == N - 1 && y == M - 1) { // Ż������
					System.out.println(distance + 1);
					return;
				}
				if (x < 0 || x >= N || y < 0 || y >= M) { // ���� ������
					continue;
				}
				if (board[x][y] == 1 || dist[temp[2]][x][y] != -1) {
					// ���̰ų�, �̹� �ش� �������� �湮�� �� ���� ��
					continue;
				}
				dist[temp[2]][x][y] = distance + 1;
				q.add(new int[] { x, y, temp[2] });
			}

			// ����Ʈ Ž��
			if (temp[2] < K) { // ���� ����Ʈ �������� �� �� ������
				for (int dir = 0; dir < 8; dir++) {
					int x = temp[0] + hx[dir];
					int y = temp[1] + hy[dir];
					if (x == N - 1 && y == M - 1) { // Ż������
						System.out.println(distance + 1);
						return;
					}
					if (x < 0 || x >= N || y < 0 || y >= M) { // ���� ������
						continue;
					}
					if (board[x][y] == 1 || dist[temp[2] + 1][x][y] != -1) {
						// ���̰ų�, �̹� ���� �������� �湮�� �� ���� ��
						continue;
					}
					dist[temp[2] + 1][x][y] = distance + 1;
					q.add(new int[] { x, y, temp[2] + 1 });
				}
			}
		}
		System.out.println(-1);
		return;
	}
}
