import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 배열로 달과 날짜 짝 선언
		int[] cal = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 입력부
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int m_start = sc.nextInt(); // 시작 달
			int d_start = sc.nextInt(); // 시작 날짜
			int m_end = sc.nextInt(); // 끝 달
			int d_end = sc.nextInt(); // 끝 날짜
			int result = 0;
			for (int i = m_start; i < m_end; i++) { // 시작 달부터 끝달 전까지 날짜를 더해준다
				result += cal[i];
			}
			result += d_end; // 끝달의 날을 더해준다
			result -= (d_start - 1); // 첫 달의 날을 빼준다 (해당 날 포함해야 해서 -1)
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}
