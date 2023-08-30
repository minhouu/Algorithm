package �丮��;

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] synergy; // �ó��� ���� ����
	static int min_diff; // �ּ� ���� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// �Էº�
			N = sc.nextInt();
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			
			min_diff = Integer.MAX_VALUE; // �ּ� ���� �ʱ�ȭ
			int[] result = new int[N];
			comb(0, 0, result);
			System.out.println("#" + t + " " + min_diff);

		}
	}

	public static void comb(int cnt, int start, int[] result) {
		// cnt : ���� result�� �� ���� ���Ұ� ������ üũ
		// start : recursive case�� for���� ���� ��ġ�� ��(�������� ���տ��� ����� ���� ����� ��  + 1)
		// result : � ��ᰡ ���� ���õǾ����� ������ ����(���õǸ� 1, ���� �ȵǸ� 0)
		
		// base case
		if (cnt == N / 2) {
			// ���õ� �ֵ� temp1, ���þȵ� �ֵ� temp2
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
			// temp1�� �丮�� ���� ���� temp2�� �丮�� ���� ���� ���̸� ���� ��, min_diff ������Ʈ
			min_diff = Math.min(min_diff, Math.abs(per(temp1) - per(temp2)));
			return;
		}
		
		// recursive case
		for (int i = start; i < N; i++) { // start���� ����ϱ� �����ؼ�
			result[i] = 1; // i�� �����Ѵ�
			comb(cnt + 1, i + 1, result); // ���ȣ��
			result[i] = 0;
		}

	}

	public static int per(int[] result) { // �ߺ������� ���� �丮�� ���� ���Ѵ�
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (i == j) { // ���� ��Ḧ ���ÿ� ��� �Ұ� (��� �̺κ� ��� �ȴ�. ������ synergy �迭���� ���� 0�̶�)
					continue;
				}
				sum += synergy[result[i]][result[j]];
			}
		}
		return sum;
	}
}
