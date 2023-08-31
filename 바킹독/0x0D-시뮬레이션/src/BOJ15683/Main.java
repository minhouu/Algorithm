package BOJ15683;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<int[]> cctv;
	static int[][] board;
	static int cctv_cnt;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// �Էº�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] >= 1 && board[i][j] <= 5) { // cctv�� ����
					cctv.add(new int[] { i, j });
				}
			}
		}
		cctv_cnt = cctv.size();

		help(0, new int[cctv_cnt]);
		System.out.println(result);
	}

	public static void help(int cnt, int[] dir) {
		// base case
		if (cnt == cctv_cnt) {
			int[][] board_temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board_temp[i][j] = board[i][j];
				}
			}

			for (int i = 0; i < cctv_cnt; i++) {
				// ��� cctv�� ���ؼ� �� ���⿡ �°� bfs�ؼ� ���ñ����� ä���ش�
				int a = cctv.get(i)[0];
				int b = cctv.get(i)[1];
				for (int d = 0; d < 4; d++) {
					if (board_temp[a][b] == 1) { // 1���� �� ���⸸ Ž��
						if (d != dir[i]) {
							continue;
						}
					}
					if (board_temp[a][b] == 2) {
						if (d % 2 != dir[i] % 2) { // 2���� �� ����, �ݴ� ���� Ž��
							continue;
						}
					}
					if (board_temp[a][b] == 3) {
						if (!(d % 4 == dir[i] % 4 || (d + 1) % 4 == dir[i] % 4)) { // dir[i] ����� �� ������ ���⸸ ����
							continue;
						}
					}
					if (board_temp[a][b] == 4) {
						if (d != dir[i] && d % 2 == dir[i] % 2) { // �� ���� ���� �� �ǰ�
							continue;
						}
					}
					int x = a + dx[d];
					int y = b + dy[d];
					while (x >= 0 && y >= 0 && x < N && y < M && board_temp[x][y] != 6) { // ���� ����ų� 6 �Ǹ� ����
						if (board_temp[x][y] == 0) { // 0�϶��� -1�� üũ�Ѵ�
							board_temp[x][y] = -1;
						}
						x += dx[d];
						y += dy[d];
					}
				}
			}
			
			int blind = 0; // �ش� ��� �簢������ ���� ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board_temp[i][j] == 0) {
						blind++;
					}
				}
			}
			// ��ü result ������Ʈ
			result = Math.min(result, blind);
			return;
		}
		
		
		// recursive case
		int x = cctv.get(cnt)[0]; // ���õ� cctv ��ǥ
		int y = cctv.get(cnt)[1];
		if (board[x][y] == 5) { // 5�� ���� ���� �ʿ� ���� ��
			help(cnt + 1, dir);
			return;
		}
		if (board[x][y] == 2) { // 2�� 2���⸸ �����ϸ� ��
			for (int i = 0; i < 2; i++) {
				dir[cnt] = i;
				help(cnt + 1, dir);
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			dir[cnt] = i;
			help(cnt + 1, dir);
		}
		return;
	}
}
