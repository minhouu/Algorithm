import java.util.Scanner;

public class Solution {
	static class LinkedNode {
		int val;
		LinkedNode next;

		// ������
		public LinkedNode() {
		}

		public LinkedNode(int val) {
			this.val = val;
		}

		// ����
		// head������ ��밡���ϴ�
		public void insert(int x, int y, int[] s) {
			
			LinkedNode start; // ���� ���� ��ġ ������ ���� ����
			start = this;
			
			for (int i = 0; i < x; i++) { // ���� ������ġ���� ����
				start = start.next;
			}

			LinkedNode end = start.next; // ���� �� ��ġ�� ������ ����
			
			for (int i = 0; i < y; i++) { // �ϳ��� �����Ѵ�
				start.next = new LinkedNode(s[i]);
				start = start.next;
			}
			start.next = end;
		}

		// ���
		// head������ ��� �����ϴ�
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			LinkedNode temp = this;
			
			// ��ü��ȯ
			
//			while (temp.next != null) {
//				sb.append(temp.next.val);
//				sb.append(" ");
//				temp = temp.next;
//			}
			
			// ���� ����(10��)
			for (int i = 0; i < 10; i++) {
				sb.append(temp.next.val);
				sb.append(" ");
				temp = temp.next;
			}
			
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// �����
			int N = sc.nextInt();
			LinkedNode head = new LinkedNode(); // linkedlist�� ���������� sentinel node�� head�� �������ش�
			LinkedNode cur = head; // �� ĭ�� �Է¹ޱ� ���� cursor ����

			for (int i = 0; i < N; i++) {
				cur.next = new LinkedNode(sc.nextInt()); // ��ȣ�� �Է¹޴´�
				cur = cur.next;
			}

			int O = sc.nextInt(); // ��� ����
			for (int i = 0; i < O; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				int[] s = new int[y];
				for (int j = 0; j < y; j++) {
					s[j] = sc.nextInt();
				}
				head.insert(x, y, s);
			}

			System.out.println("#" + t + " " + head.toString());
		}

	}
}
