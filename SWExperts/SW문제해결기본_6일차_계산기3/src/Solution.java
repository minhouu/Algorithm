import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			// �����
			bf.readLine();
			String s = bf.readLine();
			StringBuilder sb = new StringBuilder();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			HashMap<Character, int[]> map = new HashMap<>();
			map.put('(', new int[] { 0, 3 }); // idx 0 : stack�ȿ����� �켱����
			map.put('*', new int[] { 2, 2 }); // idx 1 : stack�ۿ����� �켱����
			map.put('+', new int[] { 1, 1 });

			// ���������ڷ� �����
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
				} else {
					char temp = s.charAt(i);
					if (temp == ')') { // �ݴ� ��ȣ�� ������
						while (stack.peek() != '(') {
							sb.append(stack.pop()); // ���� ��ȣ ���ö����� stack���� pop�Ѵ�.
						}
						stack.pop();
					} else {
						if (stack.isEmpty()) {
							stack.push(temp);
							continue;
						}
						int icp = map.get(temp)[1];
						int isp = map.get(stack.peek())[0];
						if (icp <= isp) {
							// ������ ���� �켱�������� stack �ȿ� �ִ� ���� �켱������ ���ų� ������
							while (map.get(stack.peek())[0] >= icp) {
								sb.append(stack.pop());
							}
							stack.push(temp);
						} else {
							stack.push(temp);
						}
					}
				}
			}
			// stack�� ���� �� �� �־��ֱ�
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}

			// ����ϱ�
			ArrayDeque<Integer> stack2 = new ArrayDeque<>();
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
					stack2.push(sb.charAt(i) - '0'); // ���ڸ� push
				} else { // �����ڸ� ���� �� �ٽ� stack�� �ִ´�
					int second = stack2.pop();
					int first = stack2.pop();
					if (sb.charAt(i) == '*') {
						stack2.push(second * first);
					}
					else if (sb.charAt(i) == '+') {
						stack2.push(second + first);
					}
				}
			}
			int result = stack2.pop();
			System.out.println("#" + t + " " + result);
		}
	}
}
