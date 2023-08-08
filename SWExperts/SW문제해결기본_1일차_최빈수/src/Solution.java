import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[101];
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}
			int maxIdx = 0;
			for (int i = 0; i < 101; i++) {
				if(arr[maxIdx] <= arr[i]) {
					maxIdx = i;
				}
			}
			System.out.println("#" + N + " " + maxIdx);
			
		}
		sc.close();
	}
}
