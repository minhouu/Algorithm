import java.util.Scanner;

public class Sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // �迭 ����
			int S = sc.nextInt(); // ã�ƾ��ϴ� ���� ��
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}

			int cnt = 0; // count �ʱ�ȭ
			// ��Ʈ����ŷ���� ��� �κ�����(0 0 0 0 ~ 1 1 1 1)�� sum�� S�� ��
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) > 0) {
						sum += list[j];
					}
				}
				if (sum == S) { 
					cnt++;
				}
			}

			if (S == 0) { // S == 0�� ���� ��� ���� ���ϴ� ���̽� ���ش�(ũ�Ⱑ ���� �κм����� ������ ã�ƾ� �ϱ� ����)
				cnt--;
			}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}
