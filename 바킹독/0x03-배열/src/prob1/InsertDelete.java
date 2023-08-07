package prob1;

public class InsertDelete {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int len = 6;
		for (int i = 0; i < len; i++) {
			arr[i] = 2 * i - 1;
		}

		len = insert(3, 20, arr, len);
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
		len = delete(3, arr, len);
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int insert(int idx, int num, int[] arr, int len) {
		for (int i = len; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		arr[idx] = num;
		return len + 1;
	}
	
	public static int delete(int idx, int[] arr, int len) {
		for(int i = idx; i < len-1; i ++) {
			arr[i] = arr[i+1];
		}
		// 초기화한다
		arr[len-1] = 0;
		return len-1;
	}
}
