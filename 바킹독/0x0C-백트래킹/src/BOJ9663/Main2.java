package BOJ9663;

import java.util.Scanner;

public class Main2 {
	static int[] used_col;
	static int[] used_dgnl_ru; // diagonal - right up
	static int[] used_dgnl_lu; // diagonal - left up
	static int cnt = 0;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		used_col = new int[N];
		used_dgnl_ru = new int[N * 2 - 1];
		used_dgnl_lu = new int[N * 2 - 1];

		help(0);
		System.out.println(cnt);
	}

	public static void help(int x) {
		if (x == N) {
			cnt++;
			return;
		}
		for (int y = 0; y < N; y++) {
			if (used_col[y] == 0 && used_dgnl_ru[x + y] == 0 &&used_dgnl_lu[x - y + N - 1] == 0) {
				used_col[y] = 1;
				used_dgnl_ru[x + y] = 1;
				used_dgnl_lu[x - y + N - 1] = 1;
				help(x + 1);
				used_col[y] = 0;
				used_dgnl_ru[x + y] = 0;
				used_dgnl_lu[x - y + N - 1] = 0;
			}
		}
	}
}
