
public class CountingSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 7, 7, 5, 3, 2, 1, 0, 0, 8, 4 };
		int[] cnt = new int[9];
		int[] temp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			cnt[arr[i]]++;
		}

		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for (int i = 0; i < temp.length; i++) {
			cnt[arr[i]]--;
			temp[cnt[arr[i]]] = arr[i];
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
}
