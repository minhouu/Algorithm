package sol1;

public class hanoi {
	public static void main(String[] args) {
		f(10, "A", "B", "C");
	}

	static public void f(int n, String from, String to, String via) {
		if (n == 1) {
			System.out.println("Move " + n + " from " + from + " to " + to);
			return;
		}
		f(n - 1, from, via, to);
		System.out.println("Move " + n + " from " + from + " to " + to);
		f(n - 1, via, to, from);
		return;
	}
}
