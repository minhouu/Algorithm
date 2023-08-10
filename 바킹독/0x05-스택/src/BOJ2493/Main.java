package BOJ2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // ž�� ����
		StringTokenizer st = new StringTokenizer(bf.readLine()); // ž�� ���� ���ڿ��� �޾ƿ�
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { (int) (1e8 + 1), 0 }); // �ִ밪 �̻��� �ʱⰪ stack�� ���� 
		// �ڱ⺸�� ������ ���̰� ���� ž�� ������(�̰Ͱ� ���Ҷ��� �ݵ�� �۱� ������), 0�� ���� ������ ����
		StringBuilder output = new StringBuilder();
		
		
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken()); // ���� �Է¹���
			while (stack.peek()[0] < h) {
				stack.pop();
			}
			output.append(stack.peek()[1]);
			output.append(" ");
			stack.push(new int[] {h, i+1});
		}
		System.out.println(output);
	}
}
