package BOJ11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	// ����ƽ �����
	static char[][] board;
	static int[][] visited;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// �Էº�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		visited = new int[12][6];
		for (int i = 0; i < 12; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 6; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		// �����
		boolean isScored = true; //�ѿ�ѿ䰡 �Ǿ����� üũ
		int score = 0; // �� ���ھ� üũ

		while (isScored) {
			isScored = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j] == 0 && board[i][j] != '.') { // ���� �湮���� �ʾҰ�, ��ĭ�� �ƴϸ� bfs
						bfs(i, j);
					}
				}
			}

			loop: for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j] == -1) { // ���� -1�� �� ĭ(�ѿ�ѿ䰡 �� ĭ)�� ������ isScored = true
						isScored = true;
						break loop;
					}
				}
			}
			
			
			if (isScored) { // ���� �ѿ�ѿ� ������ score++�ϰ� ���带 ������Ʈ���ش�
				score++;
				updateBoard();
			}
		}

		System.out.println(score);
	}

	public static void bfs(int i, int j) {
		char selected_color = board[i][j]; 
		ArrayDeque<int[]> q = new ArrayDeque<>(); // bfs�� queue
		ArrayList<int[]> list = new ArrayList<>(); // bfs�� ���� �����ϴ� list
		q.add(new int[] {i, j});
		list.add(new int[] {i, j});
		int cnt = 1; // ������ �������� Ÿ�� ���� �����ϴ� ����
		visited[i][j] = 1;
		
		// bfs
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				
				if (x < 0 || x >= 12 || y < 0 || y >= 6) { // ���� ��� ��
					continue;
				}
				if (board[x][y] != selected_color) { // ���� �ٸ� ��
					continue;
				}
				if (visited[x][y] != 0) { // �湮���� ��(-1�̰ų� 1�� ��
					continue;
				}
				visited[x][y] = 1;
				q.add(new int[] { x, y });
				list.add(new int[] { x, y });
				cnt++;
			}
		}

		if (cnt >= 4) { // ���࿡ ������ ���� ���� Ÿ���� 4�� �̻��̸�
			for (int pos = 0; pos < cnt; pos++) { // visited�� �ش� ��ǥ -1�� ������Ʈ
				visited[list.get(pos)[0]][list.get(pos)[1]] = -1;
			}
		}
	}

	public static void updateBoard() { // board ������Ʈ �ϴ� �Լ�
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visited[i][j] == -1) { // -1�� ��� ��ĭ���� �ٲپ��ش�
					board[i][j] = '.';
				}
			}
		}
		
		// ��� ��ҵ��� ������ ������Ų��(�ڷι���!)
		for (int j = 0; j < 6; j++) { // ��� ���� ���ؼ�
			char[] temp = new char[12]; // ���ο� ���� ���� ������ �迭
			
			// temp ��ĭ���� �ʱ�ȭ
			for (int i = 0; i < 12; i++) { 
				temp[i] = '.';
			}
			
			int idx = 11;
			// ��ĭ�� �ƴ� Ÿ�ϵ��� �ڿ������� ������� temp�� ��´�
			for (int i = 11; i >= 0; i--) {
				if (board[i][j] != '.') { 
					temp[idx] = board[i][j];
					idx--;
				}
			}
			
			// temp�� board�� ����
			for (int i = 0; i < 12; i++) {
				board[i][j] = temp[i];
			}
		}
		
		visited = new int[12][6]; // visited �ʱ�ȭ
	}
}
