package BOJ2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ���� �� �Է¹ޱ�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map.put(1, 0);
		map.put(0, 0);
		help(0, 0, N);
		System.out.println(map.get(0) + " " + map.get(1));
	}

	public static void help(int x, int y, int len) {
		// x, y : board���� Ž���ϱ� ������ ��ǥ, len : ����
		// board�� �߶� argument�� ������ �� �ƴ϶�, �׳� idx�� ���� ������ ����

		// base case
		if (len == 0) {
			// ������ return;
			return;
		}

		int sum = 0;
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				sum += board[i][j];
			}
		}

		// board�� 0�̳� 1�θ� �����Ǿ� �ִٸ�
		if (sum == 0 || sum == len * len) {
			map.put(board[x][y], map.get(board[x][y]) + 1);
			return;
		}

		// recursive case
		for (int i = x; i < x + len; i += len / 2) {
			for (int j = y; j < y + len; j += len / 2) {
				help(i, j, len / 2);
			}
		}

	}
}
