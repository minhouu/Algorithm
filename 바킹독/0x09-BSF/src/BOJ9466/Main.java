package BOJ9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// �Է¹޴� �κ�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(bf.readLine());
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[N+1]; // ���� �л� ���� �����ϴ� �迭
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int result = 0;
			
			
			int[] visited = new int[N+1]; // -1 : �湮����, 0 : ���� ��, > 1 :  ���� �� ��
			for (int i = 0; i <= N; i++) {
				visited[i] = -1;
			}
			
			
			for (int i = 1; i <= N; i++) {
				if (visited[i] == -1) { // ���� �湮���� ���� ����� ��
					int temp = i; // ������
					while(true) {
						if (visited[temp] != -1) { 
							// i�� �����ų�(��ȯ�̶�� ��), 0�� ������(�ٸ� ��ȯ��带 �����ƴٴ� ��)
							// Ȥ�� i ���� �ٸ� ����(���� ���� ���� �ٸ� ��带 ������)
							while(visited[temp] != 0 && visited[temp] == i) { 
								// �ٸ� ��ȯ��峪 ���� ���� ���� ���ڸ� �����ƴٸ� �׳� �Ѿ��
								// i�� �̷���� ��ȯ����� ���� �׷����� üũ���ش�(0���� ������ش�)
								visited[temp] = 0; // �׷쿡 �־��ش�
								temp = arr[temp];
							}
							break;
						}
						visited[temp] = i; // ��ȯ üũ �������� i�� �ִ´�
						temp = arr[temp];
					}
				}
			}
			
			for(int i = 1; i <= N; i++) {
				if (visited[i] != 0) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
