package 작업순서;

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
			degree = new int[V + 1]; // 각 정점의 진입간선 개수 저장
			arr = new int[V + 1][V + 1]; // 간선 정보 저장하는 2차원배열
			stack = new ArrayDeque<>(); // 정렬 정보 저장하는 stack
			visited = new int[V + 1];

			// 입력부
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr[start][end] = 1;
				degree[end]++;
			}

			// 진입간선이 0개인 노드들 q에 저장
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					DFS(i);
				}
			}

			// 출력
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
