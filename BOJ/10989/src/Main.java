import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		list = new int[1000000];
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < 1000000; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, 1000000);
		System.out.println(list[500000]);

	}

	public static void mergeSort(int head, int tail) {
		// 1. base case
		if (head + 1 == tail) {
			return;
		}

		// 2. ������ ������
		int half = (head + tail) / 2;

		// 2 - 1. ������ ���ȣ��
		mergeSort(head, half);
		mergeSort(half, tail);

		// front, rear, result idx
		int idx_f = head;
		int idx_r = half;
		int idx_result = 0;
		int[] result = new int[tail - head];

		// front, rear idx�� �迭 ���̿� �������� �ش� �κ��� ��ġ�� ���� ���� ��.
		while (idx_f < half && idx_r < tail) {
			if (list[idx_f] <= list[idx_r]) {
				result[idx_result] = list[idx_f];
				idx_f++;
				idx_result++;
				continue;
			}
			result[idx_result] = list[idx_r];
			idx_r++;
			idx_result++;
		}

		// ���� �κ� �����ش�
		for (int i = idx_result; i < tail - head; i++) {
			if (idx_f != half) {
				result[i] = list[idx_f];
				idx_f++;
				continue;
			}
			result[i] = list[idx_r];
			idx_r++;
		}

		// result�� list�� ������Ʈ ���ش�
		for (int i = head, j = 0; i < tail; i++, j++) {
			list[i] = result[j];
		}
	}
}
