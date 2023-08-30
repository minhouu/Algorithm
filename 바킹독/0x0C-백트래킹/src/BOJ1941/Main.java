package BOJ1941;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	static int[] board = new int[25];
	static int[][] board_2d;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 5*5 2���� board�� 1�������� ��ȯ
		// y -> 0, x -> 1�� ��ȯ
		for (int i = 0; i < 25; i += 5) {
			String s = sc.next();
			for (int j = 0; j < 5; j++) {
				if (s.charAt(j) == 'Y') {
					board[i + j] = 0;
					continue;
				}
				board[i + j] = 1;
			}
		}

		help(0, 0, new int[7]);
		System.out.println(result);

	}

	public static void help(int cnt, int start, int[] result) {
		if (cnt == 7) {
			// 1. board���� 1�� 4�� �̻����� üũ
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += board[result[i]];
			}
			if (sum >= 4) {
				// 4�� �̻��̸� ���� üũ�Ѵ�
				board_2d = new int[5][5];
				for (int i = 0; i < 7; i++) {
					board_2d[result[i] / 5][result[i] % 5] = 1;
				}
				bfs(new int[] { result[0] / 5, result[0] % 5 });
			}
			return;
		}

		for (int i = start; i < 25; i++) {
			result[cnt] = i;
			help(cnt + 1, i + 1, result);
		}
	}

	public static void bfs(int[] start) {
		int[][] visited = new int[5][5];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		q.add(start);
		visited[start[0]][start[1]] = 1;
		// bfs �ϸ� ��Ҹ� q�� ���� ������ cnt ������Ų��
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x < 0 || x >= 5 || y < 0 || y >= 5) {
					continue;
				}
				if (visited[x][y] == 1 || board_2d[x][y] == 0) {
					continue;
				}
				q.add(new int[] { x, y });
				visited[x][y] = 1;
				cnt++;
			}
		}
		
		if (cnt == 7) { // 7���� �� ����Ǿ� ������ resul++
			result++;
		}
	}
}
