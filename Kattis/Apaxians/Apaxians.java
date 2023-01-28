import java.util.Scanner;

public class Apaxians {
	public static void main(String[] args) {
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
}
