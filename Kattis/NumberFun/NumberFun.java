import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.*;

public class NumberFun {
	public static void test(String A, String B, String C) {
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		int c = Integer.parseInt(C);
		if (a + b == c || a * b == c ||	
			a - b == c || b - a == c || 
			(a % b == 0 && a / b == c) ||
		    (b % a == 0 && b / a == c)) {
			System.out.println("Possible");
			return;
		}
		System.out.println("Impossible");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int counter = Integer.parseInt(input);	

		while (counter > 0) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			
			NumberFun.test(arr[0], arr[1], arr[2]);
			counter--;
		}
	}
}

