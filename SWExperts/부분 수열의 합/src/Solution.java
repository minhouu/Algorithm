import java.util.Scanner;

public class Solution {
	static int N;
	static int S;
	static int[] list;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // �迭 ����
			S = sc.nextInt(); // ã�ƾ��ϴ� ���� ��
			list = new int[N]; 
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
		
			cnt = 0; // count �ʱ�ȭ
			help(0, 0);
			if (S == 0) { // S�� 0�̸� �ƹ��͵� �������� ���� �κ������� ������ ���Ե�
				cnt--;
			}
			System.out.println("#" + t + " " +cnt);
		}
		sc.close();
	}

	public static void help(int sum, int num) {
		if (num == N) { // N���� �κ������� �� ����������
			if (sum == S) { // ���� S�� cnt++
				cnt++;
				return;
			}
			return;
		}
		help(sum, num + 1); // list[num]�� �������� ���� ���̽�
		help(sum + list[num], num + 1); // list[num]�� ������ ���̽�

	}
}