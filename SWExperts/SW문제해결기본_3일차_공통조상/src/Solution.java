import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int count = 0;  // subnode ���� �����ϴ� �۷ι�����
	static TreeNode[] tree;  // tree ������ �迭�� �����ϴ� �۷ι�����
	static class TreeNode {  // parent ������ ������ treenode
		int val = -1;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			// V, E, �� ���� ��ȣ �Է¹ޱ�
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// tree ���� �� �ʱ�ȭ, count �ʱ�ȭ
			tree = new TreeNode[V+1];
			for (int i = 1; i < V + 1; i++) {
				tree[i] = new TreeNode();
				tree[i].val = i;
			}
			count = 0;
			
			// tree�� �����
			s = bf.readLine();
			st = new StringTokenizer(s);
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				// 1. parent�� left, Ȥ�� right�� �־���
				if (tree[parent].left == null) {
					tree[parent].left = tree[child];
				}
				else {
					tree[parent].right = tree[child];
				}
				
				// 2. child�� parent�� parent �־��� (�������� ã�����ؼ�)
				tree[child].parent = tree[parent];
			}
			int co = coParent(x, y);
			subTree(tree[co]);
			System.out.println("#" + t + " " + co + " " + count);
		}
		
	}
	
	// sub tree ���� Ȯ���ϴ� method
	public static void subTree(TreeNode node) {
		// base case (leaf node�� ��). left node�� ������ �ڽ��� ���°�
		if (node.left == null) {
			count++;  // count�� ���� ���
			return;
		}
		
		subTree(node.left);
		count++;
		// right�� �����ϴ� ��� right�� search
		if (node.right != null) {
			subTree(node.right);
		}
		
	}
	
	// ���� ����� ���� ���� ã�� method
	public static int coParent(int x, int y) {
		ArrayList<Integer> listX = new ArrayList<>();
		ArrayList<Integer> listY = new ArrayList<>();
		
		// x, y�� ����� ��� �Է¹޴´�
		TreeNode temp = tree[x];
		while (temp.parent != null) {
			listX.add(temp.parent.val);
			temp = temp.parent;
		}
		temp = tree[y];
		while (temp.parent != null) {
			listY.add(temp.parent.val);
			temp = temp.parent;
		}
		// x, y�� ����� �� ���� ����� �������� ã�´�.
		for (int i = 0; i < listX.size(); i++) {
			if (listY.contains(listX.get(i))) {
				return listX.get(i);
			}
		}
		return -1;
	}
}
