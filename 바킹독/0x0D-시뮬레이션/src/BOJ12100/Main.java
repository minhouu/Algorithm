package BOJ12100;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
	}
	
	public static void permutation(int cnt, int[] dir) {
		if (cnt == 5) {
			
		}
	}
}
