package BOJ15650;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = i + 1;
		}
		int[] result = new int[M];
		help(0, 0, result);
		
	}

	public static void help(int cnt, int start, int[] result) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < list.length; i++) {
			result[cnt] = list[i];
			help(cnt + 1, i + 1, result);
		}
	}
}
