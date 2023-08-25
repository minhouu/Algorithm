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

	// ex -> 배열 크기를 지수 형태로 보내준다
	// dir -> 탐색 방향을 계속 바꿔주야하기 때문에 사용
	public static void help(int x, int y, int ex, int dir) {
//		if (isEnd) { // 탈출 조건
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
		if (dir == -1) { // dir == -1이면 -> 함수 호출 시 dir == 1, 오른쪽으로 누운n자 모양 호출
			help(x, y, ex - 1, dir * -1);
			help(x, y + len, ex - 1, dir);
			help(x - len, y + len, ex - 1, dir);
			help(x - len, y, ex - 1, dir * -1);
			return;
		}
		if (dir == 1) { // dir == 1 -> 함수 호출시 dir == -1, n자 모양으로 호출
			help(x, y, ex - 1, dir * -1);
			help(x - len, y, ex - 1, dir);
			help(x - len, y + len, ex - 1, dir);
			help(x, y + len, ex - 1, dir*-1);
			return;
		}

	}
}
