import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력부
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			String[] arr = new String[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = bf.readLine();
			}
			
			// 출력부
			System.out.print("#" + t + " ");
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if (i < arr[j].length()) { // i번째 자리에 string이 존재하는 경우만 출력한다
						System.out.print(arr[j].charAt(i));
					}
				}
			}
			System.out.println();
		}
	}
}
