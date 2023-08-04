package sol2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 바텀업으로 간다
		int max = 1000001;
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		// 최대 n 이 가능한 길이로, 최대 n의 값으로 채워진 배열을 선언
		
		dp[1] = 0;
		// 배열 초기값 선언
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for (int i = 1; i < n; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			if (i*2 < n+1) { 
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			}
			if (i*3 < n+1) {
				dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			}
		}
		System.out.print(dp[n]);
	}
}
