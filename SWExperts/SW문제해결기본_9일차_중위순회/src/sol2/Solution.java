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
			N = Integer.parseInt(bf.readLine()); // 노드 갯수
			tree = new String[N + 1]; // 배열에 tree 저장 (편리 위해서 idx 1부터 사용)
			ArrayDeque<Integer> stack = new ArrayDeque<>(); // bfs 위한 stack 선언
			StringBuilder sb = new StringBuilder(); // 출력 위한 스트링 빌더
			
			for (int i = 1; i < N + 1; i++) {
				// 입력 받기
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				// 완전이진트리이므로 배열에 꽉 차게 들어간다 -> 그냥 content만 순서대로 배열에 넣어준다
				st.nextToken();
				tree[i] = st.nextToken(); 
			}
			
			// bfs (by 정점 번호)
			int cur = 1; // 현재 노드 위치를 저장할 cur 선언, 첫번째 node의 index로 초기화.
			while (cur <= N || !stack.isEmpty()) { // 스택도 비고, cur도 범위를 넘어가야 while문 멈춤
				while (cur <= N) {  // cur이 범위에 맞을 때, cur을 포함한 왼쪽 노드들을 전부 stack에 넣는다
					stack.push(cur);
					cur = cur * 2;
				}
				cur = stack.pop(); // cur을 stack의 top로 업데이트 해준다.
				sb.append(tree[cur]); 
				cur = cur * 2 + 1; // cur을 오른쪽 노드로 업데이트 해준다
				
				// 1. 만약 여기서 cur이 범위를 넘어간다면(오른쪽 노드가 없다면)
				// cur은 while(cur <= N) [내부 while문] 의 조건을 벗어나게 되어 
				// 자동으로 stack의 head(다음 순서의 노드)로 update되게 된다. 
				
				// 2. cur이 범위 안이라면(오른쪽 노드가 존재한다면)
				// cur은 while(cur <= N> [내부 while문] 의 조건에 부합하기에
				// 자동으로 stack에 cur의 왼쪽 노드들을 전부 담게 된다. 
				// 이후 cur은 stack의 새로운 head로 update된다.
				// 이후 stack을 pop하면서 왼쪽 노드들 중 마지막 노드부터 차례로 방문하게 된다. 
			}
			System.out.println("#" + t + " " + sb.toString());
			
		}
	}
}
