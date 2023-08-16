import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			bf.readLine();
			String[] arr = new String[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = bf.readLine();
			}
			int max = 0;
			// 가로
			for (int i = 0; i < 100; i++) {
				max = Math.max(max, maxPalindromeLength(arr[i]));
			}
			
			//세로
			for (int i = 0; i < 100; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 100; j++) {
					sb.append(arr[j].charAt(i));
				}
				max = Math.max(max, maxPalindromeLength(sb.toString()));
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	public static int maxPalindromeLength(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String temp = s.substring(i, j + 1);
//				System.out.println(temp);
				if (isPalindrome(temp)) {
					max = Math.max(max, temp.length());
				}
			}
		}
		return max;
	}

	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			return true;
		}
		return false;
	}

}
