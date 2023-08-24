import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static class MyPriorityQueue {
		int[] list = new int[((int) 1e5) + 1];
		int tail = 1; // ������ ��� ���� ��ġ ���� (length = tail - 1)

		public void insert(int n) {
			list[tail] = n;
			int idx = tail; // ������ ��� ��ġ ����
			tail++; // tail �ϳ� ����������
			while (idx > 1) {
				if (list[idx / 2] >= list[idx]) { // �߰��� ��ġ�� �θ� ���� �� ũ��
					return;
				}
				// �θ�� �ڽĳ�� ��ȯ
				int temp = list[idx];
				list[idx] = list[idx / 2];
				list[idx / 2] = temp;
				idx = idx / 2;
			}
		}

		public int peek() {
			if (tail == 1) { // ���� 0�̸�
				return -1;
			}

			int head = list[1]; // �� �� ��� head�� ����
			list[1] = list[tail - 1]; // �� �� ��� �迭 �� �տ� ����
			tail--;
			int idx = 1;

			while (idx * 2 <= tail - 1) { // size���� idx * 2(�ڽ� ��� idx)�� �۰ų� ���ƾ� �ڽĳ�尡 �����ϴ� ��
				int max_idx;
				if (idx * 2 + 1 <= tail - 1) {
					max_idx = list[idx * 2] > list[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
				} else {
					max_idx = idx * 2;
				}
				
				if (list[idx] > list[max_idx]) {
					break;
				}
				// �ڽ� ��尡 �� ũ��
				int temp = list[idx];
				list[idx] = list[max_idx];
				list[max_idx] = temp;
				idx = max_idx;

			}
			return head;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // ���� ����
		for (int t = 1; t <= T; t++) {
			MyPriorityQueue q = new MyPriorityQueue();
			StringBuilder sb = new StringBuilder(); // ������� ��Ʈ������
			sb.append("#" + t + " ");
			int N = sc.nextInt(); // ���� ����
			for (int i = 0; i < N; i++) {
				int op = sc.nextInt();
				if (op == 1) { // insert
					int n = sc.nextInt();
					q.insert(n);
				} else { // peek
					sb.append(q.peek() + " ");
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}
}
