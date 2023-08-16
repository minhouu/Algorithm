import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			bf.readLine();
			String target = bf.readLine();
			String s = bf.readLine();
			int result = 0;
			for (int i = 0; i < s.length() - target.length() + 1; i++) {
				boolean isSame = true;
				for (int j = 0; j < target.length(); j++) {
					if (s.charAt(i + j) != target.charAt(j)) {
						isSame = false;
						continue;
					}
				}
				if (isSame)
					result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
