package �ֻ���;

public class sol2 {
	static int[] dice = { 1, 2, 3, 4, 5, 6 };
	static int[][] all = new int[20][];
	static int idx = 0;
	static int N = 3;

	public static void main(String[] args) {
		int[] result = new int[3];

		comb(0, 0, result);
		for (int i = 0; i < all.length; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(all[i][j] + " ");
			}
			System.out.println("");
		}

	}

	public static void comb(int cnt, int start, int[] result) {
		if (cnt == N) {
//			if (result[0] == 0 || result[1] == 0 || result[2] == 0)
//				return;
			int[] temp = new int[3];
			for (int i = 0; i < cnt; i++) {
				temp[i] = result[i];
			}
			all[idx] = temp;
			idx++;
			return;
		}
		for (int i = start; i < dice.length; i++) {
			result[cnt] = dice[i];
			comb(cnt + 1, i+1, result);
		}

	}
}
