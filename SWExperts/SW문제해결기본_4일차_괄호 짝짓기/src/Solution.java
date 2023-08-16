import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			// 선언부
			int N = Integer.parseInt(bf.readLine()); // input 길이
			String s = bf.readLine();
			ArrayDeque<Character> q = new ArrayDeque<>(); // stack
			boolean isValid = true;

			for (int i = 0; i < s.length(); i++) {
				// 만약 여는괄호면 stack에 push
				if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<') {
					q.push(s.charAt(i));
					continue;
				}

				// 닫는 괄호면
				else {
					// stack 비어있으면 invalid
					if (q.isEmpty()) {
						isValid = false;
						break;
					}

					// stack 안 비어있으면 pop한 원소와 괄호의 짝이 맞는지 비교
					// 안맞으면 break
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
			
			//괄호쌍이 틀리지 않고 stack이 비어있으면 1, 아니면 0
			if (isValid && q.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
}
