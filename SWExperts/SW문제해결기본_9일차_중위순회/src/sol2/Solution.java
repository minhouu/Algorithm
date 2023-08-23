package sol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static String[] tree;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(bf.readLine()); // ��� ����
			tree = new String[N + 1]; // �迭�� tree ���� (�� ���ؼ� idx 1���� ���)
			ArrayDeque<Integer> stack = new ArrayDeque<>(); // bfs ���� stack ����
			StringBuilder sb = new StringBuilder(); // ��� ���� ��Ʈ�� ����
			
			for (int i = 1; i < N + 1; i++) {
				// �Է� �ޱ�
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				// ��������Ʈ���̹Ƿ� �迭�� �� ���� ���� -> �׳� content�� ������� �迭�� �־��ش�
				st.nextToken();
				tree[i] = st.nextToken(); 
			}
			
			// bfs (by ���� ��ȣ)
			int cur = 1; // ���� ��� ��ġ�� ������ cur ����, ù��° node�� index�� �ʱ�ȭ.
			while (cur <= N || !stack.isEmpty()) { // ���õ� ���, cur�� ������ �Ѿ�� while�� ����
				while (cur <= N) {  // cur�� ������ ���� ��, cur�� ������ ���� ������ ���� stack�� �ִ´�
					stack.push(cur);
					cur = cur * 2;
				}
				cur = stack.pop(); // cur�� stack�� top�� ������Ʈ ���ش�.
				sb.append(tree[cur]); 
				cur = cur * 2 + 1; // cur�� ������ ���� ������Ʈ ���ش�
				
				// 1. ���� ���⼭ cur�� ������ �Ѿ�ٸ�(������ ��尡 ���ٸ�)
				// cur�� while(cur <= N) [���� while��] �� ������ ����� �Ǿ� 
				// �ڵ����� stack�� head(���� ������ ���)�� update�ǰ� �ȴ�. 
				
				// 2. cur�� ���� ���̶��(������ ��尡 �����Ѵٸ�)
				// cur�� while(cur <= N> [���� while��] �� ���ǿ� �����ϱ⿡
				// �ڵ����� stack�� cur�� ���� ������ ���� ��� �ȴ�. 
				// ���� cur�� stack�� ���ο� head�� update�ȴ�.
				// ���� stack�� pop�ϸ鼭 ���� ���� �� ������ ������ ���ʷ� �湮�ϰ� �ȴ�. 
			}
			System.out.println("#" + t + " " + sb.toString());
			
		}
	}
}
