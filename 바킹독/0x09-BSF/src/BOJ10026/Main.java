package BOJ10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		// �����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		char[][] board = new char[N][N]; // input �޴� borad
		int[][] visited = new int[N][N]; // �湮���� ���
		int[] dx = new int[] { 1, 0, -1, 0 }; // Ž������ ����� �迭
		int[] dy = new int[] { 0, 1, 0, -1 };
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int result1 = 0; // non���� ���
		int result2 = 0; // ������

		// input
		for (int i = 0; i < N; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		// non���� bsf
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) { // �湮���� �ʾҴ� ���̸�
					q.add(new int[] { i, j }); // queue�� �߰�
					visited[i][j] = 1;
					while (!q.isEmpty()) {
						int[] temp = q.pop();
						for (int dir = 0; dir < 4; dir++) { // �����¿� dx, dy �̿��ؼ� üũ
							int x = temp[0] + dx[dir];
							int y = temp[1] + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= N) { // x, y�� �ε��� ����� �Ѿ
								continue;
							}
							if (visited[x][y] == 1 || board[x][y] != board[temp[0]][temp[1]]) {
								// �̹� �湮�ߴ� ���ų�, ���� üũ�ϰ� �ִ� ����� �ٸ��� �Ѿ��
								continue;
							}
							visited[x][y] = 1;
							q.add(new int[] { x, y });
						}
					}
					result1++;
				}
			}
		}

		// visited �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = 0;
			}
		}

		// board���� �ʷϻ��� �� ���������� �ٲ������
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'G') {
					board[i][j] = 'R';
				}
			}
		}

		// ���� bsf
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) { // �湮���� �ʾҴ� ���̸�
					q.add(new int[] { i, j }); // queue�� �߰�
					visited[i][j] = 1;
					while (!q.isEmpty()) {
						int[] temp = q.pop();
						for (int dir = 0; dir < 4; dir++) { // �����¿� dx, dy �̿��ؼ� üũ
							int x = temp[0] + dx[dir];
							int y = temp[1] + dy[dir];
							if (x < 0 || x >= N || y < 0 || y >= N) { // x, y�� �ε��� ����� �Ѿ
								continue;
							}
							if (visited[x][y] == 1 || board[x][y] != board[temp[0]][temp[1]]) {
								// �̹� �湮�ߴ� ���ų�, ���� üũ�ϰ� �ִ� ����� �ٸ��� �Ѿ��
								continue;
							}
							visited[x][y] = 1;
							q.add(new int[] { x, y });
						}
					}
					result2++;
				}
			}
		}

		System.out.println(result1);
		System.out.println(result2);

	}
}
