import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력부
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int result = -1;

			// 가능한 모든 점들에 대해서
			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < N-2; j++) {
					int[] temp = new int[] { i, j }; // 선택된 점
					ArrayList<int[]> q1 = new ArrayList<>(); // 우상향 방향에 선택가능한 모든 점 저장
					ArrayList<int[]> q2 = new ArrayList<>(); // 좌상향 방향에 선택가능한 모든 점 저장
					int x = i;
					int y = j;
					// 우상향 가능한 점들 모두 q1에 저장
					while (true) {
						x = x - 1;
						y = y + 1;
						if (x < 0 || x >= N || y < 0 || y >= N) {
							break;
						}
						q1.add(new int[] { x, y });

					}
					x = i;
					y = j;
					// 우하향 가능한 점들 모두 q2에 저장
					while (true) {
						x = x + 1;
						y = y + 1;
						if (x < 0 || x >= N || y < 0 || y >= N) {
							break;
						}
						q2.add(new int[] { x, y });
					}

					// temp 좌표에 대해서 가능한 모든 q1, q2의 요소들의 조합에 대해
					// temp, q1, q2로 구성된 사각형의 board 점수 합을 체크한다
					// *** 세 점의 위치를 알면 (마름모이기 때문에) 4번째 점이 자동으로 정해진다
					// *** 만약 같은 값이 있으면 멈춘다

					for (int pos1 = 0; pos1 < q1.size(); pos1++) {
						loop: for (int pos2 = 0; pos2 < q2.size(); pos2++) {

							// 선언부
							int[] visited = new int[101]; // 같은 숫자 나왔는지 체크 위한 배열
							int sum = 0; // 총합 저장
							int[] spot_u = new int[] { q1.get(pos1)[0], q1.get(pos1)[1] }; // 사각형의 위쪽 점
							int[] spot_r = new int[] { q1.get(pos1)[0] + q2.get(pos2)[0] - temp[0],
									q1.get(pos1)[1] + q2.get(pos2)[1] - temp[1] }; // 사각형의 맨 오른쪽 점
							int[] spot_d = new int[] { q2.get(pos2)[0], q2.get(pos2)[1] };

							// 0. spot_r이 범위 넘어가면 continue
							if (spot_r[0] >= N || spot_r[1] >= N) {
								continue;
							}
							

							// 1. temp to spot_u (우상향)
							for (int p = temp[0], q = temp[1]; p > spot_u[0] && q < spot_u[1]; p--, q++) {
								if (visited[board[p][q]] != 0) {
									continue loop;
								}
								visited[board[p][q]] = 1;
								sum++;
							}

							// spot_u to spot_r (우하향)
							for (int p = spot_u[0], q = spot_u[1]; p < spot_r[0] && q < spot_r[1]; p++, q++) {
								if (visited[board[p][q]] != 0) {
									continue loop;
								}
								visited[board[p][q]] = 1;
								sum++;
							}

							// spot_r to spot_d
							for (int p = spot_r[0], q = spot_r[1]; p < spot_d[0] && q > spot_d[1]; p++, q--) {
								if (visited[board[p][q]] != 0) {
									continue loop;
								}
								visited[board[p][q]] = 1;
								sum++;
							}

							// spot_d to temp
							for (int p = spot_d[0], q = spot_d[1]; p > temp[0] && q > temp[1]; p--, q--) {
								if (visited[board[p][q]] != 0) {
									continue loop;
								}
								visited[board[p][q]] = 1;
								sum++;
							}

							result = Math.max(result, sum);
						}
					}

				}
			}

			System.out.println("#" + t + " " + result);

		}
	}
}
