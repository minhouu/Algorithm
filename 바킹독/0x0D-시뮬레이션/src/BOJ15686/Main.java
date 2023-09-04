package BOJ15686;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int MIN_SUM = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// �Էº�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				// ġŲ�� ��ǥ ����
				if (temp == 2) {
					chicken.add(new int[] { i, j });
					continue;
				}
				// �� ��ǥ ����
				if (temp == 1) {
					house.add(new int[] { i, j });
				}
			}
		}
		
		help(0, 0, new int[M]);
		System.out.println(MIN_SUM);

	}

	public static void help(int cnt, int start, int[] result) {
		// base case
		if (cnt == M) {
			int sum = 0;
			// ��� ������ ġŲ�Ÿ� ���Ѵ�
			for (int i = 0; i < house.size(); i++) {
				int min_dist = Integer.MAX_VALUE;
				// ��� ġŲ�� �� ���� ����� �Ÿ� ����(min_dist)
				for (int ch = 0; ch < M; ch++) {
					int x = chicken.get(result[ch])[0];
					int y = chicken.get(result[ch])[1];
					int dist = Math.abs(x - house.get(i)[0]) + Math.abs(y - house.get(i)[1]);
					min_dist = Math.min(min_dist, dist);
				}
				// sum�� min_dist �����ش�
				sum += min_dist;
			}
			// ���� ��� update
			MIN_SUM = Math.min(MIN_SUM, sum);
			return;
		}
		
		// recursive case
		// M���� ġŲ���� �����ϴ� ��� ���տ� ���ؼ�
		for (int i = start; i < chicken.size(); i++) {
			result[cnt] = i;
			help(cnt + 1, i + 1, result);
		}
	}
}
