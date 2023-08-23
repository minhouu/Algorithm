import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int count = 0;  // subnode 개수 저장하는 글로벌변수
	static TreeNode[] tree;  // tree 노드들을 배열로 저장하는 글로벌변수
	static class TreeNode {  // parent 정보를 포함한 treenode
		int val = -1;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			// V, E, 두 정점 번호 입력받기
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// tree 선언 및 초기화, count 초기화
			tree = new TreeNode[V+1];
			for (int i = 1; i < V + 1; i++) {
				tree[i] = new TreeNode();
				tree[i].val = i;
			}
			count = 0;
			
			// tree로 만들기
			s = bf.readLine();
			st = new StringTokenizer(s);
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				// 1. parent의 left, 혹은 right에 넣어줌
				if (tree[parent].left == null) {
					tree[parent].left = tree[child];
				}
				else {
					tree[parent].right = tree[child];
				}
				
				// 2. child의 parent에 parent 넣어줌 (상향으로 찾기위해서)
				tree[child].parent = tree[parent];
			}
			int co = coParent(x, y);
			subTree(tree[co]);
			System.out.println("#" + t + " " + co + " " + count);
		}
		
	}
	
	// sub tree 개수 확인하는 method
	public static void subTree(TreeNode node) {
		// base case (leaf node일 때). left node가 없으면 자식이 없는것
		if (node.left == null) {
			count++;  // count에 개수 기록
			return;
		}
		
		subTree(node.left);
		count++;
		// right가 존재하는 경우 right도 search
		if (node.right != null) {
			subTree(node.right);
		}
		
	}
	
	// 가장 가까운 공통 조상 찾는 method
	public static int coParent(int x, int y) {
		ArrayList<Integer> listX = new ArrayList<>();
		ArrayList<Integer> listY = new ArrayList<>();
		
		// x, y의 조상들 모두 입력받는다
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
		// x, y의 조상들 중 가장 가까운 교차점을 찾는다.
		for (int i = 0; i < listX.size(); i++) {
			if (listY.contains(listX.get(i))) {
				return listX.get(i);
			}
		}
		return -1;
	}
}
