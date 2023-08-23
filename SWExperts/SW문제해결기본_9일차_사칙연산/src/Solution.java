import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 노드 개수
	static TreeNode[] tree; // TreeNode 저장하는 배열

	static class TreeNode {
		int val; // 정수 값
		String op; // 연산자일 경우
		TreeNode left;
		TreeNode right;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(bf.readLine());
			tree = new TreeNode[N + 1];
			for (int i = 1; i <= N; i++) {
				// 입력받기
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				st.nextToken();
				String content = st.nextToken();
				
				// 기존 tree에 treenode가 생성되어 있지 않았다면 treenode 새로 생성
				if (tree[i] == null) {
					tree[i] = new TreeNode();
				}

				// content가 연산자일 경우와 정수일 경우 구분
				// 1. 연산자일 경우
				if (st.hasMoreTokens()) { // 자식 노드 정보가 존재하므로
					// 1 - 1. operator 등록
					tree[i].op = content;
					
					// 1 - 2. left, right 등록
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					tree[left] = new TreeNode();
					tree[right] = new TreeNode();
					tree[i].left = tree[left];
					tree[i].right = tree[right];
					continue;
				}
				// 2. 숫자일 경우
				tree[i].val = Integer.parseInt(content);
			}
			System.out.println("#" + t + " " +(int) calculate(tree[1]));
		}
	}
	
	public static double calculate(TreeNode node) {
		// base case (자식노드 없을 때 - 숫자일 때)
		if (node.left == null) {
			return (double) node.val;
		}
		// recursive case (연산자일 때)
		double num1 = calculate(node.left);
		double num2 = calculate(node.right);
		String s = node.op;
		if (s.equals("-")) {
			return num1 - num2;
		}
		if (s.equals("+")) {
			return num1 + num2;
		}
		if (s.equals("*")) {
			return num1 * num2;
		}
		if (s.equals("/")) {
			return num1 / num2;
		}
		return 0;
	}
}
