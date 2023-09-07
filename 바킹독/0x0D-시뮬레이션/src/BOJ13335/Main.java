package BOJ13335;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int L = sc.nextInt();
		int[] trucks = new int[n]; // Ʈ�� ���� ����
		ArrayList<int[]> on = new ArrayList<>(); // ���� �Ÿ�, Ʈ�� ���� �Բ� �����ϴ� list
		int pointer = 0; // ������ ���� Ʈ�� ��ġ ����
		int time = 0; // �ɸ� �ð�
		int sum_w = 0; // ���� �ٸ��� �ö� Ʈ�� ���� ����

		for (int i = 0; i < n; i++) {
			trucks[i] = sc.nextInt();
		}

		while (pointer < n) {
			// �ð� ������Ų��
			time++;

			// on�� ������Ʈ �Ѵ�(�� ĭ�� ������ ����)
			for (int i = on.size() - 1; i >= 0; i--) {
				// ���� ���� �Ÿ��� 0�� �Ǹ�, sum_w���� �ش� Ʈ���� ���Ը� ����, on���� �����Ѵ�
				if (--on.get(i)[0] == 0) {
					sum_w -= on.get(i)[1];
					on.remove(i);
				}
			}

			// ���� pointer ��ġ�� Ʈ���� �ٸ� ���� �ö� �� ������
			if (sum_w + trucks[pointer] <= L) {
				// sum_w�� Ʈ�� ���� �߰��ϰ�
				sum_w += trucks[pointer];
				// list�� �߰�
				on.add(new int[] { w, trucks[pointer] });
				pointer++;
			}
		}
		
		System.out.println(time + w);

	}
}
