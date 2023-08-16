import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// �����
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.nextLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			int result = 0;

			// input string�� ���ؼ� ��ȸ
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') { // ���� ��ȣ�� �ٷ� stack�� push
					stack.push(s.charAt(i));
				} else { // �ݴ� ��ȣ�� ��
					if (s.charAt(i - 1) == ')') { // ')'�� ���ӵǾ� ������(�������� �ƴϸ�) �̰� �踷��Ⱑ ���� ��
						stack.pop();
						result++; // �߸��� ���� �踷��� �� ���� �����ϰ� �־��ش�
						continue;
					}
					stack.pop(); // �������̸� ('('�� ')'�� �پ ������)
					result += stack.size(); // stack�� �����ŭ result�� �����ش�
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
