package BOJ2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// �����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int[][][] dist = new int[2][N][M];
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean isPossible = false;

		for (int i = 0; i < N; i++) {
			s = bf.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[0][i][j] = -1;
				dist[1][i][j] = -1;
			}
		}
		
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}

		// bsf
		q.add(new int[] { 0, 0, 0 }); // 3��° ��� : �� �μ��� ����� üũ�ϴ� ����
		dist[0][0][0] = 1;
		while (!q.isEmpty() && !isPossible) {
			int[] temp = q.pop();
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x == N - 1 && y == M - 1) {
					System.out.println(dist[temp[2]][temp[0]][temp[1]] + 1);
					return;
				}
				if (x < 0 || x >= N || y < 0 || y >= M) { // ���� ������ ������ continue
					continue;
				}
				
				if (board[x][y] == 1 && temp[2] == 0 && dist[1][x][y] == -1) {
					// (x,y)�� ���̰�, ���� ���� �μ��� �ʾ�����, ���� �μ� �ĸ� üũ�ϴ� �迭���� ���� �湮���� �ʾ�����
					q.add(new int[] {x, y, 1});
					dist[1][x][y] = dist[0][temp[0]][temp[1]] + 1;
				}
				else if (board[x][y] == 0 && dist[temp[2]][x][y] == -1) {
					// (x, y)�� ���� �ƴϸ�, (���� �μ� �ĵ� �ƴϵ�) ���� ����ϴ� �迭���� �� dist�� ����س����� q�� �߰��Ѵ�.
					q.add(new int[] {x, y, temp[2]});
					dist[temp[2]][x][y] = dist[temp[2]][temp[0]][temp[1]] + 1;
				}
//				System.out.println("���μ����� dist");
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(dist[0][i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("���μ����� dist");
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(dist[1][i][j] + " ");
//					}
//					System.out.println();
//				}
			}
		}
		System.out.println(-1);
		return;
	}
}
