package BOJ10773;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// �����
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int N = sc.nextInt(); // �� input ��
		int result = 0; // ����� ���
		
		// ��� ��� ��ȸ�ϸ鼭
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) { // ���� num == 0 �̸� stack�� head ����
				stack.pop();
				continue;
			}
			stack.push(num); // ������ ��� stack�� push
		}
		
		// �� ���
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}
