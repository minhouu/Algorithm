import java.util.Scanner;

public class Solution {
	static int N;
	static int S;
	static int[] list;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 배열 길이
			S = sc.nextInt(); // 찾아야하는 합의 수
			list = new int[N]; 
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
		
			cnt = 0; // count 초기화
			help(0, 0);
			if (S == 0) { // S가 0이면 아무것도 선택하지 않은 부분집합의 개수가 포함됨
				cnt--;
			}
			System.out.println("#" + t + " " +cnt);
		}
		sc.close();
	}

	public static void help(int sum, int num) {
		if (num == N) { // N개의 부분집합을 다 선택했으면
			if (sum == S) { // 합이 S면 cnt++
				cnt++;
				return;
			}
			return;
		}
		help(sum, num + 1); // list[num]을 선택하지 않은 케이스
		help(sum + list[num], num + 1); // list[num]을 선택한 케이스

	}
}