package 요리사;

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] synergy; // 시너지 정보 저장
	static int min_diff; // 최소 차이 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력부
			N = sc.nextInt();
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			
			min_diff = Integer.MAX_VALUE; // 최소 차이 초기화
			int[] result = new int[N];
			comb(0, 0, result);
			System.out.println("#" + t + " " + min_diff);

		}
	}

	public static void comb(int cnt, int start, int[] result) {
		// cnt : 현재 result에 몇 개의 원소가 들어갔는지 체크
		// start : recursive case의 for문의 시작 위치가 됨(이전까지 조합에서 고려된 최종 요소의 값  + 1)
		// result : 어떤 재료가 현재 선택되었는지 정보를 저장(선택되면 1, 선택 안되면 0)
		
		// base case
		if (cnt == N / 2) {
			// 선택된 애들 temp1, 선택안된 애들 temp2
			int[] temp1 = new int[N / 2];
			int[] temp2 = new int[N / 2];
			for (int i = 0, idx1 = 0, idx2 = 0; i < N; i++) {
				if (result[i] == 1) {
					temp1[idx1] = i;
					idx1++;
					continue;
				}
				temp2[idx2] = i;
				idx2++;
			}
			// temp1의 요리의 맛의 값과 temp2의 요리의 맛의 값의 차이를 구한 뒤, min_diff 업데이트
			min_diff = Math.min(min_diff, Math.abs(per(temp1) - per(temp2)));
			return;
		}
		
		// recursive case
		for (int i = start; i < N; i++) { // start부터 고려하기 시작해서
			result[i] = 1; // i를 선택한다
			comb(cnt + 1, i + 1, result); // 재귀호츨
			result[i] = 0;
		}

	}

	public static int per(int[] result) { // 중복순열을 통해 요리의 값을 구한다
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (i == j) { // 같은 재료를 동시에 사용 불가 (사실 이부분 없어도 된다. 어차피 synergy 배열에서 값이 0이라서)
					continue;
				}
				sum += synergy[result[i]][result[j]];
			}
		}
		return sum;
	}
}
