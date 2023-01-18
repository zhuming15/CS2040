import java.util.Scanner;

class TwoStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n % 2 == 0) {
			System.out.println("Alice");
			return;
		} else {
			System.out.println("Bob");
			return;
		}
	}
}
