package �۾�����;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] degree = new int[V + 1]; // �� ������ ���԰��� ���� ����
			int[][] arr = new int[V + 1][V + 1]; // ���� ���� �����ϴ� 2�����迭
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");

			// �Էº�
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr[start][end] = 1;
				degree[end]++;
			}

			// ��������
			ArrayDeque<Integer> q = new ArrayDeque<>();

			// ���԰����� 0���� ���� q�� ����
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					q.add(i);
				}
			}

			// queue�� ���� ��������
			while (!q.isEmpty()) {
				int temp = q.poll();
				sb.append(temp + " ");
				for (int i = 1; i <= V; i++) {
					if (arr[temp][i] == 1) {
						degree[i]--;
						if (degree[i] == 0) {
							q.add(i);
						}
					}
				}
			}

			System.out.println(sb.toString());
		}
	}
}
