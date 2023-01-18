import java.util.Scanner;

public class LastFactorialDigit {
	public static int computeLastDigit(int n) {
		if (n <= 1) return 1;
		if (n <= 2) return 2;
		if (n <= 3) return 6;
		if (n <= 4) return 4;
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();

		while (counter > 0) {
			int N = sc.nextInt();
			System.out.println(LastFactorialDigit.computeLastDigit(N));
			counter--;
		}
	}
}

			

		
