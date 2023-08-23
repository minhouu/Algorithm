import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N; // ��� ����
	static TreeNode[] tree; // TreeNode �����ϴ� �迭

	static class TreeNode {
		int val; // ���� ��
		String op; // �������� ���
		TreeNode left;
		TreeNode right;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(bf.readLine());
			tree = new TreeNode[N + 1];
			for (int i = 1; i <= N; i++) {
				// �Է¹ޱ�
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				st.nextToken();
				String content = st.nextToken();
				
				// ���� tree�� treenode�� �����Ǿ� ���� �ʾҴٸ� treenode ���� ����
				if (tree[i] == null) {
					tree[i] = new TreeNode();
				}

				// content�� �������� ���� ������ ��� ����
				// 1. �������� ���
				if (st.hasMoreTokens()) { // �ڽ� ��� ������ �����ϹǷ�
					// 1 - 1. operator ���
					tree[i].op = content;
					
					// 1 - 2. left, right ���
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					tree[left] = new TreeNode();
					tree[right] = new TreeNode();
					tree[i].left = tree[left];
					tree[i].right = tree[right];
					continue;
				}
				// 2. ������ ���
				tree[i].val = Integer.parseInt(content);
			}
			System.out.println("#" + t + " " +(int) calculate(tree[1]));
		}
	}
	
	public static double calculate(TreeNode node) {
		// base case (�ڽĳ�� ���� �� - ������ ��)
		if (node.left == null) {
			return (double) node.val;
		}
		// recursive case (�������� ��)
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
