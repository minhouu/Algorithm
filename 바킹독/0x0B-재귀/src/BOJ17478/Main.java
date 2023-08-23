package BOJ17478;

import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		help(N);
		System.out.print(sb.toString());

	}

	public static void help(int n) {
		if (n == 0) {
			for (int i = 0; i < N - n; i++) {
				sb.append("____");
			}
			sb.append("\"����Լ��� ������?\"\n");
			for (int i = 0; i < N - n; i++) {
				sb.append("____");
			}
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			for (int i = 0; i < N - n; i++) {
				sb.append("____");
			}
			sb.append("��� �亯�Ͽ���.\n");
			return;
		}

		// base case
		for (int i = 0; i < N - n; i++) {
			sb.append("____");
		}
		sb.append("\"����Լ��� ������?\"\n");
		for (int i = 0; i < N - n; i++) {
			sb.append("____");
		}
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		for (int i = 0; i < N - n; i++) {
			sb.append("____");
		}
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		for (int i = 0; i < N - n; i++) {
			sb.append("____");
		}
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		help(n-1);
		for (int i = 0; i < N - n; i++) {
			sb.append("____");
		}
		sb.append("��� �亯�Ͽ���.\n");

	}
}
