import java.util.Scanner;

public class Solution {
	static class LinkedNode {
		int val;
		LinkedNode next;

		// 생성자
		public LinkedNode() {
		}

		public LinkedNode(int val) {
			this.val = val;
		}

		// 삽입
		// head에서만 사용가능하다
		public void insert(int x, int y, int[] s) {
			
			LinkedNode start; // 삽입 시작 위치 저장할 변수 선언
			start = this;
			
			for (int i = 0; i < x; i++) { // 삽입 시작위치까지 간다
				start = start.next;
			}

			LinkedNode end = start.next; // 삽입 끝 위치를 저장할 변수
			
			for (int i = 0; i < y; i++) { // 하나씩 삽입한다
				start.next = new LinkedNode(s[i]);
				start = start.next;
			}
			start.next = end;
		}

		// 출력
		// head에서만 사용 가능하다
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			LinkedNode temp = this;
			
			// 전체반환
			
//			while (temp.next != null) {
//				sb.append(temp.next.val);
//				sb.append(" ");
//				temp = temp.next;
//			}
			
			// 문제 조건(10개)
			for (int i = 0; i < 10; i++) {
				sb.append(temp.next.val);
				sb.append(" ");
				temp = temp.next;
			}
			
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// 선언부
			int N = sc.nextInt();
			LinkedNode head = new LinkedNode(); // linkedlist의 시작점으로 sentinel node인 head를 선언해준다
			LinkedNode cur = head; // 한 칸씩 입력받기 위해 cursor 선언

			for (int i = 0; i < N; i++) {
				cur.next = new LinkedNode(sc.nextInt()); // 암호를 입력받는다
				cur = cur.next;
			}

			int O = sc.nextInt(); // 명령 개수
			for (int i = 0; i < O; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				int[] s = new int[y];
				for (int j = 0; j < y; j++) {
					s[j] = sc.nextInt();
				}
				head.insert(x, y, s);
			}

			System.out.println("#" + t + " " + head.toString());
		}

	}
}
