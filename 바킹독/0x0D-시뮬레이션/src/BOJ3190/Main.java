package BOJ3190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[N][N]; // -1 : ��, 0 : �׳� �� ĭ, 1 : ���, 2 : �� ��ġ
		int time = 0;
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };

		// ��� ��ġ �迭�� ���
		for (int i = 0; i < K; i++) {
			board[sc.nextInt()][sc.nextInt()] = 1;
		}

		// ��ɵ� ������ �迭 ����
		int L = sc.nextInt();
		int[] orders = new int[10001];
		for (int i = 0; i < L; i++) {
			int t = sc.nextInt();
			System.out.println(t);
			String d = sc.next();
			System.out.println(d);
			if (d.equals("D")) {
				orders[t] = 1;
				continue;
			}
			orders[t] = -1;
		}

		// board�� ���� �ٱ��� ��ҵ��� �� (-1) ���� ä���ش�
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == N - 1) {
				for (int j = 0; j < N; j++) {
					board[i][j] = -1;
				}
				continue;
			}
			board[i][0] = -1;
			board[i][N - 1] = -1;
		}

		// �� �̵�
		int[][] pos = new int[][] { { 0, 0, 1 }, { 0, 0, 1 } }; // �� �Ӹ��� ����, ������ ���� ����
		while (true) {

		}
	}
}
