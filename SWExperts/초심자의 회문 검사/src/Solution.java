import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = bf.readLine();
			boolean isPalindrome = true;
			for (int i = 0; i < s.length(); i++) {
//				System.out.println(s.charAt(i));
//				System.out.println(s.charAt(s.length() - 1 - i));
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
//					System.out.println("false");
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome) {
				System.out.println("#" + tc + " " + 1);
				continue;
			}
			System.out.println("#" + tc + " " + 0);

		}
	}
}
