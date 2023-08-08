import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		selectionSort(arr, N);
		int mid = N / 2;
		System.out.println(arr[mid]);
	}

	public static void bubbleSort(int[] arr, int n) {
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
	}

	public static void selectionSort(int[] arr, int n) {
		for (int i = n - 1; i >= 0; i--) {
			int maxIdx = 0;
			for (int j = 0; j <= i; j++) {
				if (arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			int temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
	}
}
