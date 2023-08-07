package prob2;

public class find100 {
	public static void main(String[] args) {
		int[] arr = {4, 13, 63, 87};
		System.out.println(help(arr));
	}

	public static int help(int[] arr) {
		int[] temp = new int[101];
		for (int i = 0; i < arr.length; i++) {
			int numNeed = 100 - arr[i];
//			System.out.println(numNeed);
			if (temp[numNeed] != 0) {
				return 1;
			}
//			System.out.println(temp[numNeed]);
			temp[arr[i]]++;
		}
		return 0;
	}
}
