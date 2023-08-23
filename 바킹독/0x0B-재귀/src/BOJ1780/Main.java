package BOJ1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map.put(1, 0);
		map.put(-1, 0);
		map.put(0, 0);

		help(board);
		System.out.println(map.get(-1));
		System.out.println(map.get(0));
		System.out.println(map.get(1));

	}

	public static void help(int[][] board) {
		// 1. base case
		// 1 - 1. board ũ�Ⱑ 1�� �� return
		if (board.length == 1) {
			map.put(board[0][0], map.get(board[0][0]) + 1);
			return;
		}
		
		// 1 - 2. board�� ��� ���� ���� ������ �ִ��� Ȯ��
		// board ���� ����
		int len = board.length;

		// board�� ��Ұ� 1�θ�, -1�θ�, 0���θ� �̷�������� Ȯ���Ѵ�
		// use hashmap
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.put(1, 0);
		temp.put(-1, 0);
		temp.put(0, 0);
		// 1, -1, 0 �������
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int num = board[i][j];
				temp.put(num, temp.get(num) + 1);
			}
		}
		
		// 1, -1, 0 ���θ� �̷���� ��� return
		for (int i = -1; i <= 1; i++) {
			if (temp.get(i) == len * len) {
				map.put(i, map.get(i) + 1);
				return;
			}
		}

		// 2. recursive case
		int interval = board.length / 3;
		for (int r_head = 0; r_head < board.length; r_head += interval) { // ���� ������
			for (int c_head = 0; c_head < board.length; c_head += interval) { // ���� ������
				int[][] new_board = new int[interval][interval];
				for (int i = r_head; i < r_head + interval; i++) {
					for (int j = c_head; j < c_head + interval; j++) {
						new_board[i - r_head][j - c_head] = board[i][j]; // 1/3¥�� �� ������� help�� �־ ��� ȣ��
						
					}
				}
				help(new_board);
			}
		}

	}
}
