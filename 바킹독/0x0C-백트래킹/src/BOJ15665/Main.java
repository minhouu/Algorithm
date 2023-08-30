package BOJ15665;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		help(0, new int[M]);
		System.out.println(sb.toString());
	}

	public static void help(int cnt, int[] result) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		// �ߺ� �������� ����
		// ���� �� for������ i-1��° ���ҿ� i��° ���Ұ� ���ٸ�
		// �ش� ������ �ߺ��� ������ �ȴ�
		// �׷� ��� continue���ִ� ���� �߰�
		int temp = -1;
		for (int i = 0; i < N; i++) {
			if (temp == list[i]) {
				continue;
			}
			result[cnt] = list[i];
			help(cnt + 1, result);
			temp = list[i];
		}

	}
}
