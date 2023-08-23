import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static String[] tree;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(bf.readLine()); // ��� ����
			tree = new String[N]; // �迭�� tree ����
			for (int i = 0; i < N; i++) {
				// �Է� �ޱ�
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				// ��������Ʈ���̹Ƿ� �迭�� �� ���� ���� -> �׳� content�� ������� �迭�� �־��ش�
				st.nextToken();
				tree[i] = st.nextToken(); 
			}
			System.out.print("#" + t + " ");
			inorderTraversal(1);
			System.out.println();
		}
	}
	
	public static void inorderTraversal(int pos) {
		if (pos <= N) {
			inorderTraversal(pos * 2);
			System.out.print(tree[pos-1]);
			inorderTraversal(pos * 2 + 1);
		}
	}
	
}
