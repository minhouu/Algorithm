import java.util.Arrays;

public class Main {
	final static int INF = 123456789;
	static int[] memo = new int[100000];

	public static void main(String[] args) {
		int N = 1000;
		Arrays.fill(memo, INF);
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(help(N));
	}

	public static int help(int n) {
		if (n < 0) {
			return INF;
		}

		if (memo[n] == INF) {
			memo[n] = Math.min(help(n - 6) + 1, Math.min(help(n - 4) + 1, help(n - 1) + 1));
		}

		return memo[n]; 
	}
}
