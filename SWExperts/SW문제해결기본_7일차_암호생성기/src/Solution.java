import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// 선언부
			sc.nextInt();
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean stop = false;
			
			// 입력받으면서 q에 넣는다
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt() % 15);
			}
			
			
			while (true) {
				for (int i = 1; i <= 5; i++) { // 5번씩 무한반복
					int temp = q.pop();
					// 만약 뺀 값이 0보다 같거다 작으면 멈춘다
					if (temp - i <= 0) {
						stop = true;
						break;
					}
					q.add(temp - i);
				}
				if (stop)
					break;
			}
			q.add(0);
			
			// 출력
			System.out.print("#" + t + " ");
			while(!q.isEmpty()) {
				System.out.print(q.pop() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
