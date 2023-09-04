import java.util.Scanner;

public class sol2 {
	static int[] dx = new int[] { -1, 1, 1, -1 };
	static int[] dy = new int[] { 1, 1, -1, -1 };
	static int[][] board;
	static int[] visited;
	static int start_r;
	static int start_c;
	static int N;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력부
			N = sc.nextInt();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			result = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new int[101];
					start_r = i;
					start_c = j;
					visited[board[i][j]] = 1;
					help(i, j, 0, 1);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	public static void help(int r, int c, int dir, int len) {
		if (dir >= 4)
			return;

		int x = r + dx[dir];
		int y = c + dy[dir];

		// 방향 그대로 갈 때
		if (x >= 0 && y >= 0 && x < N && y < N) {
			if (x == start_r && y == start_c) {
				result = Math.max(result, len);
				return;
			}
			if (visited[board[x][y]] != 1) {
				visited[board[x][y]] = 1;
				help(x, y, dir, len + 1);
				visited[board[x][y]] = 0;
			}
		}

		// 방향 바꿀 때
		if (dir + 1 < 4) {
			x = r + dx[dir + 1];
			y = c + dy[dir + 1];
			if (x >= 0 && y >= 0 && x < N && y < N) {
				if (x == start_r && y == start_c) {
					result = Math.max(result, len);
					return;
				}
				if (visited[board[x][y]] != 1) {
					visited[board[x][y]] = 1;
					help(x, y, dir + 1, len + 1);
					visited[board[x][y]] = 0;
				}
			}
		}

	}
}
