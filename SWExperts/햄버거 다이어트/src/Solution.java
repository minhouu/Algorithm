import java.util.Scanner;

public class Solution {
	static int N;
	static int max_cal;
	static int[][] list;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력부
			N = sc.nextInt();
			max_cal = sc.nextInt();
			list = new int[N][2];
			for (int i = 0; i < N; i++) {
				int taste = sc.nextInt();
				int cal = sc.nextInt();
				list[i] = new int[] { taste, cal };
			}

			// max_cal 초기화
			result = Integer.MIN_VALUE;
			help(0, 0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	public static void help(int taste_sum, int cal_sum, int cnt) {
		if (cnt == N) {
			if (cal_sum <= max_cal) {
				result = Math.max(result, taste_sum);
			}
			return;
		}

		help(taste_sum + list[cnt][0], cal_sum + list[cnt][1], cnt + 1);
		help(taste_sum, cal_sum, cnt + 1);
	}
}
