import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 0; test_case < 10; test_case++) {
			int N = sc.nextInt();
			int result = 0;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 2; i < N - 2; i++) {
				int left = Math.max(arr[i - 2], arr[i - 1]);
				int right = Math.max(arr[i + 1], arr[i + 2]);
				int temp = arr[i] - Math.max(left, right);
				if (temp > 0) {
					result += temp;
				}
			}
			System.out.println("#" + (test_case + 1) + " " + result);
		}
		sc.close();
	}
}
