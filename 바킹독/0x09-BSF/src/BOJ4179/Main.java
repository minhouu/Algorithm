package BOJ4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] board = new String[R];
		int[][] dist1 = new int[R][C]; // 불 위치
		int[][] dist2 = new int[R][C]; // 지훈이 위치
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		ArrayDeque<int[]> q1 = new ArrayDeque<>();
		ArrayDeque<int[]> q2 = new ArrayDeque<>();

		// -1로 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dist1[i][j] = -1;
				dist2[i][j] = -1;
			}
		}

		// get input
		for (int i = 0; i < R; i++) {
			s = bf.readLine();
			board[i] = s;
		}

		// 불, 지훈이 배열에서 시작점 체크 및 q에 넣음
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i].charAt(j) == 'F') {
					q1.add(new int[] { i, j });
					dist1[i][j] = 0;
				}
				if (board[i].charAt(j) == 'J') {
					q2.add(new int[] { i, j });
					dist2[i][j] = 0;
				}
			}
		}

		while (!q1.isEmpty()) {
			int[] temp = q1.pop();
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x < 0 || x >= R || y < 0 || y >= C)
					continue;
				if (board[x].charAt(y) == '#' || dist1[x][y] >= 0)
					continue;
				dist1[x][y] = dist1[temp[0]][temp[1]] + 1;
				q1.add(new int[] { x, y });
			}
		}
//
//		for (int i = 0; i < R; i++) {
//			System.out.println(board[i]);
//		}
//		System.out.println("");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(dist1[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(dist2[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("");

		// 지훈이 bsf

		while (!q2.isEmpty()) {
			int[] temp = q2.pop();
			// 탈출조건 체크
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				if (x < 0 || x >= R || y < 0 || y >= C) {
					System.out.println(dist2[temp[0]][temp[1]] + 1);
					return;
				}
				if (board[x].charAt(y) == '#' || dist2[x][y] >= 0) {
					continue;
				}
				if (dist1[x][y] != -1 && dist1[x][y] <= dist2[temp[0]][temp[1]] + 1) {
					continue;
				}
				dist2[x][y] = dist2[temp[0]][temp[1]] + 1;
				q2.add(new int[] { x, y });
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
