package BOJ5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder output = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			// �����
			ArrayDeque<Integer> dq = new ArrayDeque<>(); // �迭
			String cal = bf.readLine();// �Լ� ���ڿ�(RDRD)
			int N = Integer.parseInt(bf.readLine()); // �迭����
			boolean isReversed = false; // R�� ���� (���ʿ��� �̾ƾ� �ϴ��� ����)

			// �迭 parsing
			String s;
			String[] arr = new String[0];
			if (N != 0) { // �迭���̰� 0�� �ƴϸ�
				s = bf.readLine();
				arr = s.substring(1, s.length() - 1).split(","); // �迭������ string�� string �迭�� ��ȯ
			} else {
				bf.readLine();
			}

			// N�� �迭 ���� �ٸ� ��
			if (arr.length != N) {
				output.append("error\n");
				continue;
			}

			// �迭 dq�� ����
			for (int i = 0; i < arr.length; i++) {
				dq.add(Integer.parseInt(arr[i]));
			}

			// �Լ� ����
			boolean flag = false; // error���� �Ǵ�
			for (int i = 0; i < cal.length(); i++) {
				char func = cal.charAt(i);
				if (func == 'R') { // R�� ������ reversed �ٲ۴�
					isReversed = !isReversed;
					continue;
				} else if (func == 'D') {
					if (dq.size() == 0) {
						flag = true;
						break;
					}

					if (isReversed) { // reversed�Ǹ�
						if (dq.pollLast() == null) { // �ڿ��� �̰� null�̸� ���� ��´�
							flag = true;
							break;
						}
					} else {
						if (dq.pollFirst() == null) {
							flag = true;
							break;
						}
					}
				} else {
					flag = true;
					break;
				}
			}

			// string builder�� �ֱ�
			if (flag)
				output.append("error\n");
			else {
				if (isReversed) {
					// R ����� on�� �����̸� deque�� �������ش�
					ArrayDeque<Integer> temp = new ArrayDeque<>();
					while (dq.isEmpty() != true) {
						temp.push(dq.pop());
					}
					dq = temp;
				}

				output.append("[");
				while (dq.isEmpty() != true) {
					output.append(dq.pop());
					if (dq.isEmpty() != true) {
						output.append(",");
					}
				}
				output.append("]\n");
			}

		}
		System.out.println(output + "\n");
	}
}
