package Babygin;

import java.util.ArrayList;
import java.util.Arrays;

public class Babygin {
	static int[][] all = new int[720][];
	static int all_idx = 0;

	public static void main(String[] args) {
		String input = "123999";
		int[] arr = new int[6];
		int[] result = new int[6];
		int[] visited = new int[6];

		for (int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i) - '0';
		}
		help(arr, visited, result, 0);
		
//		for (int i = 0; i < all.size(); i++) {
//			for (int j = 0; j < 6; j++) {
//				System.out.print(all.get(i).get(j));
//			}
//			System.out.println("");
//		}
		for (int i = 0; i < all.length; i++) {
			int flag = 0;
			int[] temp = all[i];
			if (temp[0] == temp[1] && temp[1] == temp[2]) {
				flag += 1;
			}
			if (temp[3] == temp[4] && temp[4] == temp[5]) {
				flag += 1;
			}
			if (temp[0] + 1 == temp[1] && temp[1] + 1 == temp[2]) {
				flag += 1;
			}
			if (temp[3] + 1 == temp[4] && temp[4] + 1 == temp[5]) {
				flag += 1;
			}
			if (flag == 2) {
				System.out.println("Babygin!");
				return;
			}
				
		}
		System.out.println("Not Babygin!");

	}

	public static void help(int[] arr, int[] visited, int[] result, int cnt) {
		if (cnt == 6) {
			int[] temp = Arrays.copyOf(result, cnt);
			all[all_idx] = temp;
			all_idx++;
			return;
			
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == 1) 
				continue;
			result[cnt] = arr[i];
			visited[i] = 1;
			help(arr, visited, result, cnt+1);
			visited[i] = 0;
		}

	}
}
