import java.util.Scanner;

public class Sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 배열 길이
			int S = sc.nextInt(); // 찾아야하는 합의 수
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}

			int cnt = 0; // count 초기화
			// 비트마스킹으로 모든 부분집합(0 0 0 0 ~ 1 1 1 1)의 sum을 S와 비교
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) > 0) {
						sum += list[j];
					}
				}
				if (sum == S) { 
					cnt++;
				}
			}

			if (S == 0) { // S == 0일 때는 모두 선택 안하는 케이스 빼준다(크기가 양인 부분수열의 개수를 찾아야 하기 때문)
				cnt--;
			}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}
