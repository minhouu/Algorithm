package BOJ13549;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] d = new int[] { 1, -1 };
		if (K <= N) {
			System.out.println(N - K);
			return;
		}
		int[] visited = new int[200001];
		for (int i = 0; i < 200001; i++) {
			visited[i] = -1;
		}
		ArrayDeque<Integer> q = new ArrayDeque<>(); // 1, -1 ������ �� ����ϴ� q

		// bsf
		// N�� ���� �־��ش�
		q.add(N);
		visited[N] = 0;
		while (true) {
			ArrayDeque<Integer> q2 = new ArrayDeque<>();// �ش� �Ͽ��� �����̵����� ���� ������ �� �����ϴ� q
			// q(1, -1�̵�)�� ��鿡 ���ؼ�
			while (!q.isEmpty()) { // q�� �� ������ �����̵����� ���ٰ����� �� visited��  üũ
				int temp = q.pop();
				q2.add(temp);
				int dist = visited[temp];
				
				while (temp < K * 2 && temp != 0) {
					if (temp == K) { // ��ġ�ϸ� return
						System.out.println(dist);
						return;
					}
					if (visited[temp] != -1) { // �̹� �湮������ continue
						temp *= 2;
						continue;
					}
					q2.add(temp);
					visited[temp] = dist;
					temp *= 2;
				}
			}
			
			
			// 2. �ش� �Ͽ� �����̵� ������ ��� ��ġ���� -1, 1 Ž���ϰ� q�� ����
			while (!q2.isEmpty()) {
				int temp = q2.pop();
				for (int dir = 0; dir < 2; dir++) {
					int x = temp + d[dir];
					if (x == K) {
						System.out.println(visited[temp] + 1);
						return;
					}
					
					if (x < 0 || x > K * 2) { // ��������� �Ѿ
						continue;
					}
					if (visited[x] != -1) { // �湮������ �Ѿ
						continue;
					}
					q.add(x);
					visited[x] = visited[temp] + 1;
				}
			}
		}
	}
}
