import java.util.Scanner;
import java.util.HashMap;


public class Apaxians {
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.nextLine());
		int counter = 0;
		int loopBoundary = str.length() - 1;
		while (counter < loopBoundary) {
			if (str.charAt(counter) == str.charAt(counter + 1)) { 
				str.deleteCharAt(counter);
				loopBoundary--;
				continue;
			}
			counter++;
		}
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringBuilder str = new StringBuilder(String.valueOf(input.charAt(0)));
		//str.append(input.charAt(0));

		for (int index = 1; index < input.length(); index++) {
			if (input.charAt(index - 1) != input.charAt(index)) 
				str.append(input.charAt(index));
		}
		System.out.println(str);
	}
}
