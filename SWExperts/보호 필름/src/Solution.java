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
		// �Էº�
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

			// selected_row : ��ǰ�� ������ �� ���� (-1 : �ƹ��͵� ����, 0 : A(0)���� �ٲ�, 1 : B(1)�� �ٲ�
			int[] selected_row = new int[N];
			for (int i = 0; i < N; i++) {
				selected_row[i] = -1;
			}

			// ��� ����� �� Ž�� ����
			main(0, 0, selected_row);

			// ���
			System.out.println("#" + t + " " + result);
		}
	}

	public static void main(int cnt, int start, int[] selected_row) { // ��� ���̽� �����س���
		if (cnt >= K) { // �ִ� K�� ��ǰ�� �����ϸ� �ݵ�� ���ɰ˻� ��� �����ϱ� ������, �� ���� ���̽��� ����Ѵ�
			return;
		}
		if (isValid(selected_row)) { // �� ���̽����� valid���� üũ�Ѵ�
			result = Math.min(result, cnt); // ���� valid�ϸ�, result�� ������Ʈ���ش�.
			return;
		}
		for (int i = start; i < N; i++) { // valid���� ������, ���õ��� ���� �ٸ� ��� ����� �����ϴ� ����� ���� ����Ѵ� .
			if (selected_row[i] == -1) {
				selected_row[i] = 0; // A�� �ش� ���� ��ä
				main(cnt + 1, i + 1, selected_row);
				selected_row[i] = 1; // B�� �ش� ���� ��ü
				main(cnt + 1, i + 1, selected_row);
				selected_row[i] = -1; 
			}
		}
	}

	public static boolean isValid(int[] selected_row) {
		for (int i = 0; i < board[0].length; i++) { // ��� ���� ���ؼ�
			int streak = 1; // ���ӵǴ� ���� ����� �ִ� ����
			int streak_now = 1; // ���� �� �� ° ���������� üũ
			for (int j = 0; j < board.length - 1; j++) { // �࿡ ���ӵǴ� ���� ����� �ִ� ����(streak)�� ����
				int here = board[j][i]; // ���� ���� ��
				int nxt = board[j + 1][i]; // ���� ���� ��

				// ���� ��ǰ�� ���ԵǾ��ٸ� �ݿ����ش�
				// ex. selected_row[j] = 0�̸� �ش� ���� ��� 0
				if (selected_row[j] != -1) {
					here = selected_row[j];
				}
				if (selected_row[j + 1] != -1) {
					nxt = selected_row[j + 1];
				}

				// ���� ������ streak_now �ϳ� �����ְ�, streak ���� ������Ʈ���ش�
				if (here == nxt) {
					streak_now++;
					streak = Math.max(streak, streak_now);
					continue;

					// ���� �ٸ���, streak update�� ��, streak_now �ʱ�ȭ���ش�
				} else {
					streak = Math.max(streak, streak_now);
					streak_now = 1;
				}

			}
			if (streak < K) { // ���� streak�� K���� ������ false ��ȯ
				return false;
			}
		}
		return true;
	}

}
