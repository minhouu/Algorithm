import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			arr = countingSort(arr, 100);
			for (int i = 0; i < N; i++) {
				arr[0]++;
				arr[99]--;
				// ÀçÁ¤·Ä
				if (arr[0] > arr[1]) {
					int k = 0;
					while (arr[k] > arr[k + 1]) {
						int temp = arr[k];
						arr[k] = arr[k + 1];
						arr[k + 1] = temp;
						k++;
					}
				}
				if (arr[98] > arr[99]) {
					int k = 99;
					while (arr[k - 1] > arr[k]) {
						int temp = arr[k];
						arr[k] = arr[k - 1];
						arr[k - 1] = temp;
						k--;
					}
				}
				
			}
			System.out.println("#"+ (tc+1) + " " + (arr[99] - arr[0]));
		}
		sc.close();

	}

	public static int[] countingSort(int[] arr, int n) {
		int[] temp = new int[100];
		int[] cnt = new int[101];
		// count
		for (int i = 0; i < 100; i++) {
			cnt[arr[i]]++;
		}

		// accumulate
		for (int i = 1; i < 101; i++) {
			cnt[i] += cnt[i - 1];
		}

		// copy to new arr
		for (int i = 99; i >= 0; i--) {
			cnt[arr[i]]--;
			temp[cnt[arr[i]]] = arr[i];
		}

		return temp;

	}
}
