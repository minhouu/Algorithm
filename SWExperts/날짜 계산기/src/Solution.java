import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// �迭�� �ް� ��¥ ¦ ����
		int[] cal = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// �Էº�
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int m_start = sc.nextInt(); // ���� ��
			int d_start = sc.nextInt(); // ���� ��¥
			int m_end = sc.nextInt(); // �� ��
			int d_end = sc.nextInt(); // �� ��¥
			int result = 0;
			for (int i = m_start; i < m_end; i++) { // ���� �޺��� ���� ������ ��¥�� �����ش�
				result += cal[i];
			}
			result += d_end; // ������ ���� �����ش�
			result -= (d_start - 1); // ù ���� ���� ���ش� (�ش� �� �����ؾ� �ؼ� -1)
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}
