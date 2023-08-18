import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// �Է�
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// �����
		int[][] visited = new int[19][19];
		// ���� ����, �¿�, �»���밢��, �����밢�� üũ�ϴ� ����
		int[][] dx = new int[][] { { 1, -1 }, { 0, 0 }, { 1, -1 }, { -1, 1 } };
		int[][] dy = new int[][] { { 0, 0 }, { 1, -1 }, { 1, -1 }, { 1, -1 } };
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt = 0;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) { // 0�� �ƴ� ��ҿ� ���Ͽ� 4���� ���̰˻�
					visited = new int[19][19];
					visited[i][j] = 1;
					// 4�������� bsf
					for (int dir = 0; dir < 4; dir++) {
						cnt = 0; // ���� ���� ���� (q���� �� �� pop�� �Ǵ����� ���� ����)
						q.add(new int[] { i, j });
						while (!q.isEmpty()) {
							int[] temp = q.pop();
							cnt++;
							for (int k = 0; k < 2; k++) {
								int x = temp[0] + dx[dir][k];
								int y = temp[1] + dy[dir][k];
								if (x < 0 || x >= 19 || y < 0 || y >= 19) { // ���� ��� ���
									continue;
								}
								if (visited[x][y] == 1 || board[x][y] != board[i][j]) { // �̹� �湮�߰ų�, ���ڰ� �ٸ� ���
									continue;
								}
								visited[x][y] = 1;
								q.add(new int[] { x, y });
							}
						}

						// ���� ���̰� 5��, ���α׷� ����
						if (cnt == 5) {
							System.out.println(board[i][j]);
							if (dir == 3) { // ����� ��� board[i][j]�� �� ������ ���̹Ƿ�, �� ���������� �Űܼ� ���
								System.out.println((i + 4 + 1) + " " + (j - 4 + 1));
								return;
							}
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
				}
			}
		}
		// ������ ������
		System.out.println(0);
	}
}
