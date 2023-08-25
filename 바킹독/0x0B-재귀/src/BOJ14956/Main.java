package BOJ14956;

import java.util.Scanner;

public class Main {
	static int M;
	static int[][] board;
	static int count = 0;
	static boolean isEnd = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		int length = (int) Math.pow(2, N);
		board = new int[length][length];
		help((int) Math.pow(2, N) - 1, 0, N, 1);

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// ex -> �迭 ũ�⸦ ���� ���·� �����ش�
	// dir -> Ž�� ������ ��� �ٲ��־��ϱ� ������ ���
	public static void help(int x, int y, int ex, int dir) {
//		if (isEnd) { // Ż�� ����
//			return;
//		}

		// base case
		if (ex == 0) {
			count++;
//			if (count == M) {
//				System.out.println(x + " " + y);
//				isEnd = true;
//			}
			board[x][y] = count;
			return;
		}

		// recursive case
		int len = (int) Math.pow(2, ex - 1);
		if (dir == -1) { // dir == -1�̸� -> �Լ� ȣ�� �� dir == 1, ���������� ����n�� ��� ȣ��
			help(x, y, ex - 1, dir * -1);
			help(x, y + len, ex - 1, dir);
			help(x - len, y + len, ex - 1, dir);
			help(x - len, y, ex - 1, dir * -1);
			return;
		}
		if (dir == 1) { // dir == 1 -> �Լ� ȣ��� dir == -1, n�� ������� ȣ��
			help(x, y, ex - 1, dir * -1);
			help(x - len, y, ex - 1, dir);
			help(x - len, y + len, ex - 1, dir);
			help(x, y + len, ex - 1, dir*-1);
			return;
		}

	}
}
