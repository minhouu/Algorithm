package BOJ16987;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] eggs;
	static int result = 0; //
	static int[] visited;

	public static void main(String[] args) {
		// �Էº�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		eggs = new int[N][2];
		visited = new int[N];
		for (int i = 0; i < N; i++) {
			eggs[i][0] = sc.nextInt(); // ������(����)
			eggs[i][1] = sc.nextInt(); // ����(���ݷ�)
		}

		// ��� ������ ����Ѵ�
		help(0, eggs, 0);
		System.out.println(result);
	}

	public static void help(int pos, int[][] status, int cnt) { // pos : ������ġ, status : ���� ��� ��Ȳ, cnt : ���� ��� ����
		if (pos == N) { // ���������� �� ����
			result = Math.max(result, cnt);
			return;
		}

		if (status[pos][0] <= 0) { // ���� pos�� �̹� ���� ��� ��ġ���
			help(pos + 1, status, cnt);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (i == pos) {
				continue;
			}
			if (status[i][0] > 0) {
				// �����
				int temp = 0; // �� ȸ������ ���� ��� �� ����
				int prev_pos_0 = status[pos][0]; // status�� ���� �� ����
				int prev_pos_1 = status[pos][1];
				int prev_i_0 = status[i][0];
				int prev_i_1 = status[i][1];

				// ��� ���� ����
				status[pos][0] -= status[i][1];
				status[i][0] -= status[pos][1];
				if (status[pos][0] <= 0) {
					temp++;
				}
				if (status[i][0] <= 0) {
					temp++;
				}

				// ���ȣ��
				help(pos + 1, status, cnt + temp);

				// status ���󺹱�
				status[pos][0] = prev_pos_0;
				status[pos][1] = prev_pos_1;
				status[i][0] = prev_i_0;
				status[i][1] = prev_i_1;
				continue;
			}
			help(pos + 1, status, cnt);
		}

	}
}
