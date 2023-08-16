package BOJ7562;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// �����
			int N = sc.nextInt(); // �� ũ��
			int[] start = new int[2]; // ������
			int[] end = new int[2]; // ����
			int[][] dist = new int[N][N]; // �Ÿ� ����
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();
			ArrayDeque<int[]> q = new ArrayDeque<>(); // queue
			int[] dx = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 }; // ��������迭
			int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
			
			// dist�迭 -1�� �ʱ�ȭ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = -1;
				}
			}

			// bsf�ϸ� �ּұ��� ã�´�
			q.add(start);
			dist[start[0]][start[1]] = 0;
			while (!q.isEmpty()) {
				int[] temp = q.pop();
				if (temp[0] == end[0] && temp[1] == end[1]) {
					System.out.println(dist[temp[0]][temp[1]]);
					break;
				}
				for (int dir = 0; dir < 8; dir++) {
					int x = temp[0] + dx[dir];
					int y = temp[1] + dy[dir];
					if (x < 0 || x >= N || y < 0 || y >= N) {
						continue;
					}
					if (dist[x][y] != -1) {
						continue;
					}
					dist[x][y] = dist[temp[0]][temp[1]] + 1;
					q.add(new int[] {x, y});
				}
			}
		}
	}
}
