package BOJ12851;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] dist = new int[N > K ? N + 1 : K * 2 + 1]; // �Ÿ� ����
		int[] visited = new int[N > K ? N + 1 : K * 2 + 1]; // �ش� idx�� �ִܰŸ��� �� �༮�� ���� ����
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < visited.length; i++) {
			dist[i] = -1;
		}

		// bfs�� �ϸ�, Ż�� ������ ����
		// visited �迭�� �ش� ��ġ�� �� �� �����ߴ��� üũ
		// dist �迭�� ������ ���� ������ ũ��(�� ���� �ɷ��� �����ϸ�) continue���ش�
		q.add(N);
		
		// dist���� �Ÿ�(�ɸ� �ð�) ����
		dist[N] = 0;
		
		// visited���� �湮�� Ƚ�� ����
		visited[N] = 1;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			int distance = dist[temp] + 1;
			for (int dir = 1; dir <= 3; dir++) {
				int x = temp;
				if (dir == 1) {
					x -= 1;
				} else if (dir == 2) {
					x += 1;
				} else {
					x *= 2;
				}

				// ���� ����� ��
				if (x < 0 || x >= visited.length) {
					continue;
				}

				// �̹� �湮�ߴµ�, x�� �ɸ� �ð��� �� �� ��
				if (dist[x] != -1 && dist[x] < distance) {
					continue;
				}

				visited[x]++;
				dist[x] = distance;
				q.add(x);
			}
		}
		System.out.println(dist[K]);
		System.out.println(visited[K]);

	}
}
