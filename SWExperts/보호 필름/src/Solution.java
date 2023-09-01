import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int K;
	static int[][] board;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력부
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			result = K;
			for (int i = 0; i < N; i++) {
				s = bf.readLine();
				st = new StringTokenizer(s);
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// selected_row : 약품을 투입한 행 저장 (-1 : 아무것도 안함, 0 : A(0)으로 바꿈, 1 : B(1)로 바꿈
			int[] selected_row = new int[N];
			for (int i = 0; i < N; i++) {
				selected_row[i] = -1;
			}

			// 모든 경우의 수 탐색 시행
			main(0, 0, selected_row);

			// 출력
			System.out.println("#" + t + " " + result);
		}
	}

	public static void main(int cnt, int start, int[] selected_row) { // 모든 케이스 조합해낸다
		if (cnt >= K) { // 최대 K번 약품을 투입하면 반드시 성능검사 통과 가능하기 때문에, 그 이전 케이스만 고려한다
			return;
		}
		if (isValid(selected_row)) { // 매 케이스마다 valid함을 체크한다
			result = Math.min(result, cnt); // 만약 valid하면, result를 업데이트해준다.
			return;
		}
		for (int i = start; i < N; i++) { // valid하지 않으면, 선택되지 않은 다른 모든 행들을 선택하는 경우의 수를 고려한다 .
			if (selected_row[i] == -1) {
				selected_row[i] = 0; // A로 해당 행을 교채
				main(cnt + 1, i + 1, selected_row);
				selected_row[i] = 1; // B로 해당 행을 교체
				main(cnt + 1, i + 1, selected_row);
				selected_row[i] = -1; 
			}
		}
	}

	public static boolean isValid(int[] selected_row) {
		for (int i = 0; i < board[0].length; i++) { // 모든 열에 대해서
			int streak = 1; // 연속되는 같은 요소의 최대 길이
			int streak_now = 1; // 현재 몇 개 째 연속중인지 체크
			for (int j = 0; j < board.length - 1; j++) { // 행에 연속되는 같은 요소의 최대 길이(streak)을 측정
				int here = board[j][i]; // 현재 행의 값
				int nxt = board[j + 1][i]; // 다음 행의 값

				// 만약 약품이 투입되었다면 반영해준다
				// ex. selected_row[j] = 0이면 해당 행은 모두 0
				if (selected_row[j] != -1) {
					here = selected_row[j];
				}
				if (selected_row[j + 1] != -1) {
					nxt = selected_row[j + 1];
				}

				// 값이 같으면 streak_now 하나 더해주고, streak 값도 업데이트해준다
				if (here == nxt) {
					streak_now++;
					streak = Math.max(streak, streak_now);
					continue;

					// 값이 다르면, streak update한 뒤, streak_now 초기화해준다
				} else {
					streak = Math.max(streak, streak_now);
					streak_now = 1;
				}

			}
			if (streak < K) { // 만약 streak이 K보다 작으면 false 반환
				return false;
			}
		}
		return true;
	}

}
