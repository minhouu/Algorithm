package 가방에넣기;

public class Main {
	static int[] weight;
	static int[] value;
	static int[] memo;
	static int N;

	public static void main(String[] args) {
		value = new int[] { 10, 40, 30, 50 };
		weight = new int[] { 5, 4, 6, 3 };
		memo = new int[4];
		N = 4;
		
		System.out.println(help(0, 13));

	}

	// top - down
	public static int help(int n, int w) {
		if (n == N) {
			return 0;
		}
		if (w - weight[n] >= 0) {
			memo[n] = Math.max(help(n + 1, w), help(n + 1, w - weight[n]) + value[n]);
		} else {
			memo[n] = help(n + 1, w);
		}
		return memo[n];
	}
}
