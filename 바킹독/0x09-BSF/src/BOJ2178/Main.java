package BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// declaration
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int[][] dist = new int[N][M]; // visited대신 거리 저장하는 dist 배열 사용
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		ArrayDeque<int[]> q = new ArrayDeque<>();

		// get input
		for (int i = 0; i < N; i++) {
			s = bf.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}

		// bsf
		q.add(new int[] { 0, 0 });
		dist[0][0] = 1;
		while (!q.isEmpty()) {
			int[] temp = q.pop();
			for (int dir = 0; dir < 4; dir++) { // bsf
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				if (dist[x][y] != 0 || board[x][y] == 0) // dist가 0이 아니면 -> 이미 방문했기 때문에 넘어감. 
					continue;
				dist[x][y] = dist[temp[0]][temp[1]] + 1; // dist를 전 층위의 값보다 1 크게 작성해준다
				q.add(new int[] { x, y });
			}
		}
		System.out.println(dist[N-1][M-1]);
	}

}
