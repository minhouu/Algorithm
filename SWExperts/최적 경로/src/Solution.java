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

			// �Է� �� ����
			N = sc.nextInt();
			list = new int[N][2]; // �� ��ġ ����
			visited = new int[N]; // ���� ����� ���� �湮�� ��ġ üũ
			int[] start = new int[] { sc.nextInt(), sc.nextInt() }; // ȸ��
			end = new int[] { sc.nextInt(), sc.nextInt() }; // �� ��ġ
			for (int i = 0; i < N; i++) { // �� ��ġ list�� ����
				list[i][0] = sc.nextInt();
				list[i][1] = sc.nextInt();
			}
			min_len = Integer.MAX_VALUE; // min_len �ʱ�ȭ

			help(0, 0, start);
			System.out.println("#" + t + " " + min_len);
		}

	}

	public static void help(int cnt, int dist, int[] last_pos) {
		// cnt : ���� ���� ���� ��Ȳ ����, dist : �������� ���� �Ÿ� ����, last_pos : ���� �������� ���õ� ��ǥ

		// base case
		if (cnt == N) {
			int dist_add = Math.abs(last_pos[0] - end[0]) + Math.abs(last_pos[1] - end[1]); // ���� ������ �湮 ��ġ�� �Ÿ�
			min_len = Math.min(min_len, dist + dist_add);
			return;
		}

		// recursive case
		for (int i = 0; i < N; i++) {
			if (visited[i] != 1) { // �湮���� ���� ���̸�
				visited[i] = 1;
				// ������ �湮 ��ġ(ó���� ��, ���߿��� �� �� �湮�� ��ǥ)�� ���� ���õ� ��ǥ�� �Ÿ� ��� ��
				int dist_add = Math.abs(last_pos[0] - list[i][0]) + Math.abs(last_pos[1] - list[i][1]);
				// ���� dist���� �ش� �� ���ؼ� ���ȣ��
				// last_pos�� ���� ���õ� ��ǥ�� ������Ʈ
				help(cnt + 1, dist + dist_add, new int[] { list[i][0], list[i][1] });
				visited[i] = 0;
			}
		}
	}
}
