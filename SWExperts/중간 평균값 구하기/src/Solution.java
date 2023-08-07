import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
//			System.out.println(T);
			for (int i = 0; i < 10; i++) {
				int input = sc.nextInt();
//				System.out.println(input);
				if (input > max) {
					max = input;
				}
				if (input < min) {
					min = input;
				}
				sum += input;
//				System.out.println(sum);
			}
			System.out.println("#" + (test_case + 1) + " " + (int) ((sum - min - max) / (double) 8 + 0.5));
		}
		sc.close();
	}
}
