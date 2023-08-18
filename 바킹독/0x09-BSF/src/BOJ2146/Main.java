package BOJ2146;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// �Էº�
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		int[][] visited = new int[N][N];
		int color = 1; // ����� ���� ����
		int min_length = Integer.MAX_VALUE; // �����

		// 1. �� ����� �ٸ� ������ ĥ�Ѵ�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// �� ����� ���� bfs�ϸ鼭 ���� �ٸ��� ĥ�Ѵ�(1, 2, 3, ...)
				if (board[i][j] != 0 && visited[i][j] == 0) {
					q.add(new int[] { i, j });
					board[i][j] = color;
					visited[i][j] = 1;
					while (!q.isEmpty()) {
						int[] temp = q.pop();
						for (int dir = 0; dir < 4; dir++) {
							int x = temp[0] + dx[dir];
							int y = temp[1] + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= N) {
								continue;
							}
							if (visited[x][y] == 1 || board[x][y] == 0) {
								continue;
							}
							q.add(new int[] { x, y });
							visited[x][y] = 1;
							board[x][y] = color;
						}
					}
					// �� ��� ��ĥ�� ������ color�� �ٲ��ش�(+1)
					color++;
				}

			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 2. �� ����� ĭ�鿡�� 0�� ���� �� ã��, �ش� ĭ���� �ٸ� ������ �� �� �ִ� ���� ª�� �ٸ��� ã�´�
		for (int c = 1; c <= color; c++) { // �� �÷����� ��ȸ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == c) {
						// 0�� ���� ���� �ִ��� üũ
						boolean isShore = false;
						for (int dir = 0; dir < 4; dir++) {
							int x = i + dx[dir];
							int y = j + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= N) {
								continue;
							}
							if (board[x][y] == 0) {
								isShore = true;
								break;
							}
						}

						// �ش� ���� �� ���� ��, �ٸ� ������ ���� �ٸ��� �ִܰŸ� ã�� bfs �����Ѵ�
						if (isShore) {

							// visited -1 �� �ʱ�ȭ. �Ÿ� �����ϴ� �迭�� ����Ѵ�
							visited = new int[N][N];
							for (int a = 0; a < N; a++) {
								for (int b = 0; b < N; b++) {
									visited[a][b] = -1;
								}
							}
							
							// bfs
							q.add(new int[] { i, j });
							visited[i][j] = 0;
							while (!q.isEmpty()) {
								int[] temp = q.pop();
								int distance = visited[temp[0]][temp[1]];
								for (int dir = 0; dir < 4; dir++) {
									int x = temp[0] + dx[dir];
									int y = temp[1] + dy[dir];
									if (x < 0 || x >= N || y < 0 || y >= N) {
										continue;
									}
									// Ż������ : �ٸ� color �����ϸ� �����
									if (board[x][y] != c && board[x][y] != 0) {
										min_length = Math.min(min_length, distance);
										q.clear();
										break;
									}
									
									// �̹� �湮�� ���̰ų�, ���� ������ ���� ���̸� continue
									if (visited[x][y] != -1 || board[x][y] == c) {
										continue;
									}
									q.add(new int[] {x, y});
									visited[x][y] = distance + 1;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(min_length);
	}
}
