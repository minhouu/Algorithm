package BOJ1874;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �� input ���� ����
		int head = 1; // ���� �� ��° �ڿ����� �� �� �ִ��� �����ִ� head
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder output = new StringBuilder(); // output ��� ��Ʈ������
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input == head) {
				head++;
				output.append("+\n");
				output.append("-\n");
			} else if (input > head) {
				for (int j = head; j < input; j++) { // input�� ������ stack�� �־��ش�
					stack.push(j);
					output.append("+\n");
				}
				head = input + 1; // input�� �ش��ϴ� ���� �־��� ���ٰ� ġ��, output�� ���, head ����
				output.append("+\n");
				output.append("-\n");
			} else {
				int stackVal = stack.pop();
				if (input == stackVal) {
					output.append("-\n");
					continue;
				}
				System.out.println("NO");
				return;
			}
		}
		System.out.print(output);
		sc.close();
		return;
	}
}
