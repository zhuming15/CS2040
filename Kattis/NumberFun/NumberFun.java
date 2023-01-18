import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.*;

public class NumberFun {
	public static void test(int a, int b, int c) {
		if (a + b == c || a * b == c ||	
			a - b == c || b - a == c || 
			a / b == c || b / a == c) {
			System.out.println("Possible");
			return;
		}
		System.out.println("Impossible");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();

		while (counter > 0) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			ArrayList<Integer> intList = new ArrayList<Integer>();
			
			for (String s : arr) {
				intList.add(Integer.parseInt(s));
			}

			NumberFun.test(intList.get(0), intList.get(1), intList.get(2));
			counter--;
		}
	}
}

