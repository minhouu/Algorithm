import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static class MyPriorityQueue {
		int[] list = new int[((int) 1e5) + 1];
		int tail = 1; // 다음에 노드 넣을 위치 저장 (length = tail - 1)

		public void insert(int n) {
			list[tail] = n;
			int idx = tail; // 마지막 노드 위치 저장
			tail++; // tail 하나 증가시켜줌
			while (idx > 1) {
				if (list[idx / 2] >= list[idx]) { // 추가한 위치의 부모 값이 더 크면
					return;
				}
				// 부모와 자식노드 교환
				int temp = list[idx];
				list[idx] = list[idx / 2];
				list[idx / 2] = temp;
				idx = idx / 2;
			}
		}

		public int peek() {
			if (tail == 1) { // 길이 0이면
				return -1;
			}

			int head = list[1]; // 맨 앞 요소 head에 저장
			list[1] = list[tail - 1]; // 맨 뒤 요소 배열 맨 앞에 저장
			tail--;
			int idx = 1;

			while (idx * 2 <= tail - 1) { // size보다 idx * 2(자식 노드 idx)가 작거나 같아야 자식노드가 존재하는 것
				int max_idx;
				if (idx * 2 + 1 <= tail - 1) {
					max_idx = list[idx * 2] > list[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
				} else {
					max_idx = idx * 2;
				}
				
				if (list[idx] > list[max_idx]) {
					break;
				}
				// 자식 노드가 더 크면
				int temp = list[idx];
				list[idx] = list[max_idx];
				list[max_idx] = temp;
				idx = max_idx;

			}
			return head;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 갯수
		for (int t = 1; t <= T; t++) {
			MyPriorityQueue q = new MyPriorityQueue();
			StringBuilder sb = new StringBuilder(); // 출력위한 스트링빌더
			sb.append("#" + t + " ");
			int N = sc.nextInt(); // 연산 개수
			for (int i = 0; i < N; i++) {
				int op = sc.nextInt();
				if (op == 1) { // insert
					int n = sc.nextInt();
					q.insert(n);
				} else { // peek
					sb.append(q.peek() + " ");
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}
}
