import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] array = new int[n][n];
		int dir = 1;

		for (int i = 1, j = 0, k = 0; i <= n * n; i++) {
			array[j][k] = i;
			switch (dir) {
			case 1:
				if ((k >= n-1) || (array[j][k+1] != 0)) {
					dir = 2;
					j++;
					break;
				}
				k++;
				break;
			case 2:
				if (j == n - 1 || array[j+1][k] != 0) {
					dir = 3;
					k--;
					break;
				}
				j++;
				break;
			case 3:
				if (k == 0 || array[j][k-1] != 0) {
					dir = 4;
					j--;
					break;
				}
				k--;
				break;
			case 4:
				if (j == 0 || array[j-1][k] != 0) {
					dir = 1;
					k++;
					break;
				}
				j--;
				break;
			}
		}
//		System.out.println("#" + test_case);
		for (int i = 0; i<n ; i++) {
			for (int j = 0; j<n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
