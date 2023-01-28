import java.util.Scanner;

public class FizzBuzz { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int X = Integer.valueOf(sc.next());
		final int Y = Integer.valueOf(sc.next());
		final int N = Integer.valueOf(sc.next());

		for (int i = 1; i < N + 1; i++) {
			boolean divisibleByX = i % X == 0;
			boolean divisibleByY = i % Y == 0;
			if (divisibleByX && divisibleByY) System.out.println("FizzBuzz");
			else if (divisibleByX) System.out.println("Fizz");
			else if (divisibleByY) System.out.println("Buzz");
			else System.out.println(i);
		}
	}
}
