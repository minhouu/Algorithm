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

		// 2. 반절로 나누기
		int half = (head + tail) / 2;

		// 2 - 1. 반절씩 재귀호출
		mergeSort(head, half);
		mergeSort(half, tail);

		// front, rear, result idx
		int idx_f = head;
		int idx_r = half;
		int idx_result = 0;
		int[] result = new int[tail - head];

		// front, rear idx가 배열 길이와 같아지면 해당 부분을 합치는 것이 끝난 것.
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

		// 남은 부분 합쳐준다
		for (int i = idx_result; i < tail - head; i++) {
			if (idx_f != half) {
				result[i] = list[idx_f];
				idx_f++;
				continue;
			}
			result[i] = list[idx_r];
			idx_r++;
		}

		// result로 list를 업데이트 해준다
		for (int i = head, j = 0; i < tail; i++, j++) {
			list[i] = result[j];
		}
	}
}
