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
		// 선언 및 입력받기
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
		// x, y : board에서 탐색하기 시작할 좌표, len : 길이
		// board를 잘라서 argument를 보내는 게 아니라, 그냥 idx와 길이 정보만 전달

		// base case
		if (len == 0) {
			// 끝나서 return;
			return;
		}

		int sum = 0;
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				sum += board[i][j];
			}
		}

		// board가 0이나 1로만 구성되어 있다면
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
