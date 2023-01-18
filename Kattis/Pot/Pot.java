import java.util.Scanner;
import java.lang.Math;

public class Pot {
	public static int compute(int n) {
		return (int) Math.pow(n / 10, n % 10);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();
		int result = 0;

		while (counter > 0) {
			int N = sc.nextInt();
			result += Pot.compute(N);
			counter--;
		}
		System.out.println(result);
	}
}
