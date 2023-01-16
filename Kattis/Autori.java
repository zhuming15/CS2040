import java.util.Scanner;

public class Autori {
	private final String s;
	
	Autori(String s) {
		this.s = s;
	}

	private String getNextChar(int startIndex) {
		return s.substring(startIndex + 1, startIndex + 2);
	}

	public String transform() {
		int indexOfHyphen = s.indexOf("-");
		String shortForm = (s.length() >= 0) ? (s.substring(0, 1)) : "";

		if (indexOfHyphen == -1) return shortForm;

		while (indexOfHyphen != -1) {
			shortForm += this.getNextChar(indexOfHyphen);
			indexOfHyphen = s.indexOf("-", indexOfHyphen + 1);
		}
		return shortForm;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		Autori test = new Autori(s);
		System.out.println("ShortForm is " + test.transform());
	}	
}
