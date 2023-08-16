import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			// �����
			int N = Integer.parseInt(bf.readLine()); // input ����
			String s = bf.readLine();
			ArrayDeque<Character> q = new ArrayDeque<>(); // stack
			boolean isValid = true;

			for (int i = 0; i < s.length(); i++) {
				// ���� ���°�ȣ�� stack�� push
				if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<') {
					q.push(s.charAt(i));
					continue;
				}

				// �ݴ� ��ȣ��
				else {
					// stack ��������� invalid
					if (q.isEmpty()) {
						isValid = false;
						break;
					}

					// stack �� ��������� pop�� ���ҿ� ��ȣ�� ¦�� �´��� ��
					// �ȸ����� break
					char brk = q.pop();
					if (s.charAt(i) == ')') {
						if (brk != '(') {
							isValid = false;
							break;
						}
					}
					if (s.charAt(i) == ']') {
						if (brk != '[') {
							isValid = false;
							break;
						}

					}
					if (s.charAt(i) == '}') {
						if (brk != '{') {
							isValid = false;
							break;
						}

					}
					if (s.charAt(i) == '>') {
						if (brk != '<') {
							isValid = false;
							break;
						}

					}
				}
			}
			
			//��ȣ���� Ʋ���� �ʰ� stack�� ��������� 1, �ƴϸ� 0
			if (isValid && q.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
}
