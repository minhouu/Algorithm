import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// ���� �� �Էº�
			int N = sc.nextInt();
			p = new int[N]; // ���μ�����
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			int[][] list = new int[N][2]; // �Է¹޴� ���� ��ǥ ����
			for (int i = 0; i < N; i++) {
				list[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				list[i][1] = sc.nextInt();
			}

			double tax = sc.nextDouble();
			double[][] ecoArr = new double[N * (N - 1) / 2][]; // ��� ���鳢���� ȯ��δ�� ���� ����

			for (int i = 0, idx = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int x1 = list[i][0];
					int x2 = list[j][0];
					int y1 = list[i][1];
					int y2 = list[j][1];
					// i, j�� i�� j������ ȯ��δ�� ����
					ecoArr[idx] = new double[] { i, j, tax * (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) };
					idx++;
				}
			}

			// ȯ��δ�� ������������ ����
			Arrays.sort(ecoArr, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});


			// ũ�罺Į �˰���
			double result = 0;
			int cnt = 0;
			for (int i = 0; i < ecoArr.length; i++) {
				if (cnt == N - 1)
					break;
				if (peekHead((int) ecoArr[i][0]) != peekHead((int) ecoArr[i][1])) {
					union((int) ecoArr[i][0], (int) ecoArr[i][1]);
					cnt++;
					result += ecoArr[i][2];
				}
			}

			System.out.println("#" + tc + " " + Math.round(result));

		}
	}

	public static int peekHead(int x) {
		if (p[x] != x)
			p[x] = peekHead(p[x]);
		return p[x];
	}

	public static void union(int x, int y) {
		p[peekHead(x)] = peekHead(y);
	}
}