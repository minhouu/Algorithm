package BOJ11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	// 스태틱 선언부
	static char[][] board;
	static int[][] visited;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// 입력부
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		visited = new int[12][6];
		for (int i = 0; i < 12; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 6; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		// 선언부
		boolean isScored = true; //뿌요뿌요가 되었는지 체크
		int score = 0; // 총 스코어 체크

		while (isScored) {
			isScored = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j] == 0 && board[i][j] != '.') { // 아직 방문하지 않았고, 빈칸이 아니면 bfs
						bfs(i, j);
					}
				}
			}

			loop: for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j] == -1) { // 만약 -1이 된 칸(뿌요뿌요가 된 칸)이 있으면 isScored = true
						isScored = true;
						break loop;
					}
				}
			}
			
			
			if (isScored) { // 만약 뿌요뿌요 했으면 score++하고 보드를 업데이트해준다
				score++;
				updateBoard();
			}
		}

		System.out.println(score);
	}

	public static void bfs(int i, int j) {
		char selected_color = board[i][j]; 
		ArrayDeque<int[]> q = new ArrayDeque<>(); // bfs용 queue
		ArrayList<int[]> list = new ArrayList<>(); // bfs에 사용된 저장하는 list
		q.add(new int[] {i, j});
		list.add(new int[] {i, j});
		int cnt = 1; // 인접한 같은색깔 타일 갯수 저장하는 변수
		visited[i][j] = 1;
		
		// bfs
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int x = temp[0] + dx[dir];
				int y = temp[1] + dy[dir];
				
				if (x < 0 || x >= 12 || y < 0 || y >= 6) { // 범위 벗어날 때
					continue;
				}
				if (board[x][y] != selected_color) { // 색깔 다를 때
					continue;
				}
				if (visited[x][y] != 0) { // 방문했을 때(-1이거나 1일 때
					continue;
				}
				visited[x][y] = 1;
				q.add(new int[] { x, y });
				list.add(new int[] { x, y });
				cnt++;
			}
		}

		if (cnt >= 4) { // 만약에 인접한 같은 색깔 타일이 4개 이상이면
			for (int pos = 0; pos < cnt; pos++) { // visited의 해당 좌표 -1로 업데이트
				visited[list.get(pos)[0]][list.get(pos)[1]] = -1;
			}
		}
	}

	public static void updateBoard() { // board 업데이트 하는 함수
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visited[i][j] == -1) { // -1인 경우 빈칸으로 바꾸어준다
					board[i][j] = '.';
				}
			}
		}
		
		// 모든 요소들을 밑으로 밀착시킨다(뒤로밀착!)
		for (int j = 0; j < 6; j++) { // 모든 열에 대해서
			char[] temp = new char[12]; // 새로운 열의 정보 저장할 배열
			
			// temp 빈칸으로 초기화
			for (int i = 0; i < 12; i++) { 
				temp[i] = '.';
			}
			
			int idx = 11;
			// 빈칸이 아닌 타일들을 뒤에서부터 순서대로 temp에 담는다
			for (int i = 11; i >= 0; i--) {
				if (board[i][j] != '.') { 
					temp[idx] = board[i][j];
					idx--;
				}
			}
			
			// temp를 board에 복사
			for (int i = 0; i < 12; i++) {
				board[i][j] = temp[i];
			}
		}
		
		visited = new int[12][6]; // visited 초기화
	}
}
