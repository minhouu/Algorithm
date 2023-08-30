import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] list;
	static int[] visited;
	static int[] end;
	static int min_len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			// 입력 및 선언
			N = sc.nextInt();
			list = new int[N][2]; // 고객 위치 저장
			visited = new int[N]; // 순열 만들기 위해 방문한 위치 체크
			int[] start = new int[] { sc.nextInt(), sc.nextInt() }; // 회사
			end = new int[] { sc.nextInt(), sc.nextInt() }; // 집 위치
			for (int i = 0; i < N; i++) { // 고객 위치 list에 저장
				list[i][0] = sc.nextInt();
				list[i][1] = sc.nextInt();
			}
			min_len = Integer.MAX_VALUE; // min_len 초기화

			help(0, 0, start);
			System.out.println("#" + t + " " + min_len);
		}

	}

	public static void help(int cnt, int dist, int[] last_pos) {
		// cnt : 현재 순열 진행 상황 저장, dist : 이제까지 누적 거리 저장, last_pos : 가장 마지막에 선택된 좌표

		// base case
		if (cnt == N) {
			int dist_add = Math.abs(last_pos[0] - end[0]) + Math.abs(last_pos[1] - end[1]); // 집과 마지막 방문 위치의 거리
			min_len = Math.min(min_len, dist + dist_add);
			return;
		}

		// recursive case
		for (int i = 0; i < N; i++) {
			if (visited[i] != 1) { // 방문하지 않은 곳이면
				visited[i] = 1;
				// 마지막 방문 위치(처음은 집, 나중에는 그 전 방문한 좌표)와 현재 선택된 좌표의 거리 계산 후
				int dist_add = Math.abs(last_pos[0] - list[i][0]) + Math.abs(last_pos[1] - list[i][1]);
				// 기존 dist값에 해당 값 더해서 재귀호출
				// last_pos도 현재 선택된 좌표로 업데이트
				help(cnt + 1, dist + dist_add, new int[] { list[i][0], list[i][1] });
				visited[i] = 0;
			}
		}
	}
}
