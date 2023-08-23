package BOJ1074;

import java.util.Scanner;

public class Main {
	static int count = 0;
	static int[][] board;
	static int r;
	static int c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = 2 << (N - 1); // �迭 ���̷� Ȱ���ϱ� ���ؼ� int���̷� ��ȯ
		r = sc.nextInt();
		c = sc.nextInt();
		help(0, 0, N);

	}

	public static void help(int x, int y, int len) { // x, y : üũ�� �迭�� ������ ��ǥ, len : �迭�� �� ���� ����
		// base case
		if (len == 1) { // len == 1�̸� ã�� ��. count�� �迭�� �ش� ��ġ�� �� �� - 1�� �������Ƿ� count ���
			System.out.println(count);
			return;
		}

		// recursive case
		// ������� �� ��и鿡 �ִ��� Ȯ�����ش�
		int half = len / 2;
		int half_r = x + half;
		int half_c = y + half;
		if (r < half_r && c < half_c) { // 1��°(4��и�)
			help(x, y, half);
			return;
		}
		if (r < half_r && c >= half_c) { // 2��°(1��и�)
			count += half * half;
			help(x, half_c, half);
			return;
		}
		if (r >= half_r && c < half_c) { // 3��°(3��и�)
			count += half * half * 2;
			help(half_r, y, half);
			return;
		}
		if (r >= half_r && c >= half_c) { // 4��°(2��и�)
			count += half * half * 3;
			help(half_r, half_c, half);
			return;
		}
		
	}
}
