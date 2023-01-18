import java.util.Scanner;

public class Autori {
	public static String transform(String s) {
		int indexOfHyphen = s.indexOf("-");
		String shortForm = (s.length() >= 0) ? (s.substring(0, 1)) : "";

		if (indexOfHyphen == -1) {
			return shortForm;
		}

		while (indexOfHyphen != -1) {
			shortForm += s.substring(indexOfHyphen + 1, indexOfHyphen + 2);
			indexOfHyphen = s.indexOf("-", indexOfHyphen + 1);
		}

		return shortForm;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(Autori.transform(s));
	}	
}
