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
			N = Integer.parseInt(bf.readLine()); // 노드 갯수
			tree = new String[N]; // 배열에 tree 저장
			for (int i = 0; i < N; i++) {
				// 입력 받기
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				// 완전이진트리이므로 배열에 꽉 차게 들어간다 -> 그냥 content만 순서대로 배열에 넣어준다
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
