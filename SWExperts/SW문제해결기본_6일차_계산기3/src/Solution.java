import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			// 선언부
			bf.readLine();
			String s = bf.readLine();
			StringBuilder sb = new StringBuilder();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			HashMap<Character, int[]> map = new HashMap<>();
			map.put('(', new int[] { 0, 3 }); // idx 0 : stack안에서의 우선순위
			map.put('*', new int[] { 2, 2 }); // idx 1 : stack밖에서의 우선순위
			map.put('+', new int[] { 1, 1 });

			// 후위연산자로 만들기
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
				} else {
					char temp = s.charAt(i);
					if (temp == ')') { // 닫는 괄호가 나오면
						while (stack.peek() != '(') {
							sb.append(stack.pop()); // 여는 괄호 나올때까지 stack에서 pop한다.
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
							// 들어오는 놈의 우선순위보다 stack 안에 있는 놈의 우선순위가 높거나 같으면
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
			// stack에 남은 것 다 넣어주기
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}

			// 계산하기
			ArrayDeque<Integer> stack2 = new ArrayDeque<>();
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
					stack2.push(sb.charAt(i) - '0'); // 숫자면 push
				} else { // 연산자면 연산 후 다시 stack에 넣는다
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
