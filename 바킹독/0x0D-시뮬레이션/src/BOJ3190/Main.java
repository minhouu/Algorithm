package BOJ3190;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[N][N]; // 0 : �׳� �� ĭ, 2 : ���, 1 : �� ��ġ
		int time = 1;
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };

		// ��� ��ġ �迭�� ���
		for (int i = 0; i < K; i++) {
			board[sc.nextInt()-1][sc.nextInt()-1] = 2;
		}

		// ��ɵ� ������ �迭 ����
		int L = sc.nextInt();
		int[] orders = new int[10001];
		for (int i = 0; i < L; i++) {
			int t = sc.nextInt();
			String d = sc.next();
			if (d.equals("D")) {
				orders[t] = 1;
				continue;
			}
			orders[t] = 2;
		}

		// �� �̵�
		ArrayDeque<int[]> snake = new ArrayDeque<>();
		snake.add(new int[] { 0, 0, 1 });
		board[0][0] = 1;
		while (true) {

			// �Ӹ� ����ĭ�� ��ġ��Ų��
			int[] prev_head = snake.peek();
			int x = prev_head[0] + dx[prev_head[2]];
			int y = prev_head[1] + dy[prev_head[2]];

			// ���� ���� ��
			if (x < 0 || x >= N || y < 0 || y >= N) {
				break;
			}
			// �ڱ� ���� ���� ��
			if (board[x][y] == 1) {
				break;
			}

			// snake head ������Ʈ
			snake.push(new int[] { x, y, snake.peek()[2] });

			// ����� ���� ���� ��
			if (board[x][y] != 2) {
				int[] temp = snake.pollLast(); // deque���� ���� ����
				board[temp[0]][temp[1]] = 0;
			}

			board[x][y] = 1;

			// ���� ������ �ٲ�� �Ѵٸ�
			if (orders[time] != 0) {
				int[] temp_head = snake.poll();
				int od = temp_head[2] + 4;
				temp_head[2] = orders[time] == 1 ? (od + 1) % 4 : (od - 1) % 4;
				snake.push(temp_head);
			}

//			// ������ ���
//			System.out.println("time : " + time);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-----------------");

			time++;

		}

		System.out.println(time);
	}
}
