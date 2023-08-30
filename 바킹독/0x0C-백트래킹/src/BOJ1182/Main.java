package BOJ1182;

import java.util.Scanner;

public class Main {
	static int N;
	static int S;
	static int[] list;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}

		help(0, 0);
		if (S == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}

	public static void help(int sum, int num) {
		if (num == N) {
			if (sum == S) {
				cnt++;
				return;
			}
			return;
		}
		help(sum, num + 1);
		help(sum + list[num], num + 1);

	}
}
