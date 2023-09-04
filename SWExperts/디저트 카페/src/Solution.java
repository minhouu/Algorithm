import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// �Էº�
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int result = -1;

			// ������ ��� ���鿡 ���ؼ�
			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < N-2; j++) {
					int[] temp = new int[] { i, j }; // ���õ� ��
					ArrayList<int[]> q1 = new ArrayList<>(); // ����� ���⿡ ���ð����� ��� �� ����
					ArrayList<int[]> q2 = new ArrayList<>(); // �»��� ���⿡ ���ð����� ��� �� ����
					int x = i;
					int y = j;
					// ����� ������ ���� ��� q1�� ����
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
					// ������ ������ ���� ��� q2�� ����
					while (true) {
						x = x + 1;
						y = y + 1;
						if (x < 0 || x >= N || y < 0 || y >= N) {
							break;
						}
						q2.add(new int[] { x, y });
					}

					// temp ��ǥ�� ���ؼ� ������ ��� q1, q2�� ��ҵ��� ���տ� ����
					// temp, q1, q2�� ������ �簢���� board ���� ���� üũ�Ѵ�
					// *** �� ���� ��ġ�� �˸� (�������̱� ������) 4��° ���� �ڵ����� ��������
					// *** ���� ���� ���� ������ �����

					for (int pos1 = 0; pos1 < q1.size(); pos1++) {
						loop: for (int pos2 = 0; pos2 < q2.size(); pos2++) {

							// �����
							int[] visited = new int[101]; // ���� ���� ���Դ��� üũ ���� �迭
							int sum = 0; // ���� ����
							int[] spot_u = new int[] { q1.get(pos1)[0], q1.get(pos1)[1] }; // �簢���� ���� ��
							int[] spot_r = new int[] { q1.get(pos1)[0] + q2.get(pos2)[0] - temp[0],
									q1.get(pos1)[1] + q2.get(pos2)[1] - temp[1] }; // �簢���� �� ������ ��
							int[] spot_d = new int[] { q2.get(pos2)[0], q2.get(pos2)[1] };

							// 0. spot_r�� ���� �Ѿ�� continue
							if (spot_r[0] >= N || spot_r[1] >= N) {
								continue;
							}
							

							// 1. temp to spot_u (�����)
							for (int p = temp[0], q = temp[1]; p > spot_u[0] && q < spot_u[1]; p--, q++) {
								if (visited[board[p][q]] != 0) {
									continue loop;
								}
								visited[board[p][q]] = 1;
								sum++;
							}

							// spot_u to spot_r (������)
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
