import java.util.Scanner;

public class DetailedDifferences {
	public static void compareThenPrint(String s1, String s2) {
		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) 
				finalString.append(".");
		   	else 
				finalString.append("*");
		}
		System.out.println(s1 + "\n" + s2 + "\n" + finalString + "\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();

		while (counter > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			DetailedDifferences.compareThenPrint(s1, s2);
			counter--;
		}
	}
}
