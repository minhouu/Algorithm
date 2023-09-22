package �۾�����;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution2 {
	static int V;
	static int E;
	static int[] degree;
	static int[][] arr;
	static int[] visited;
	static ArrayDeque<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			degree = new int[V + 1]; // �� ������ ���԰��� ���� ����
			arr = new int[V + 1][V + 1]; // ���� ���� �����ϴ� 2�����迭
			stack = new ArrayDeque<>(); // ���� ���� �����ϴ� stack
			visited = new int[V + 1];

			// �Էº�
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr[start][end] = 1;
				degree[end]++;
			}

			// ���԰����� 0���� ���� q�� ����
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					DFS(i);
				}
			}

			// ���
			System.out.print("#" + tc);
			while (!stack.isEmpty()) {
				System.out.print(" " + stack.pop());
			}
			System.out.println();
		}

	}

	public static void DFS(int v) {
		visited[v] = 1;
		for (int i = 1; i <= V; i++) {
			if (arr[v][i] == 1) {
				if (visited[i] != 1) {
					DFS(i);
				}
			}
		}
		stack.push(v);
	}
}
