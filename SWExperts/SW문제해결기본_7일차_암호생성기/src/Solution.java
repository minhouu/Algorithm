import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// �����
			sc.nextInt();
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean stop = false;
			
			// �Է¹����鼭 q�� �ִ´�
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt() % 15);
			}
			
			
			while (true) {
				for (int i = 1; i <= 5; i++) { // 5���� ���ѹݺ�
					int temp = q.pop();
					// ���� �� ���� 0���� ���Ŵ� ������ �����
					if (temp - i <= 0) {
						stop = true;
						break;
					}
					q.add(temp - i);
				}
				if (stop)
					break;
			}
			q.add(0);
			
			// ���
			System.out.print("#" + t + " ");
			while(!q.isEmpty()) {
				System.out.print(q.pop() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
