package BOJ3190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[N][N]; // -1 : 벽, 0 : 그냥 빈 칸, 1 : 사과, 2 : 뱀 위치
		int time = 0;
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };

		// 사과 위치 배열에 기록
		for (int i = 0; i < K; i++) {
			board[sc.nextInt()][sc.nextInt()] = 1;
		}

		// 명령들 저장할 배열 선언
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

		// board의 가장 바깥쪽 요소들은 벽 (-1) 으로 채워준다
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

		// 뱀 이동
		int[][] pos = new int[][] { { 0, 0, 1 }, { 0, 0, 1 } }; // 뱀 머리와 방향, 꼬리와 방향 저장
		while (true) {

		}
	}
}
