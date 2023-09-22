package 작업순서;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] degree = new int[V + 1]; // 각 정점의 진입간선 개수 저장
			int[][] arr = new int[V + 1][V + 1]; // 간선 정보 저장하는 2차원배열
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");

			// 입력부
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr[start][end] = 1;
				degree[end]++;
			}

			// 위상정렬
			ArrayDeque<Integer> q = new ArrayDeque<>();

			// 진입간선이 0개인 노드들 q에 저장
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					q.add(i);
				}
			}

			// queue를 통한 위상정렬
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
