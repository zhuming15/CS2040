import java.util.Scanner;

public class Skener {
	private static StringBuilder transformation(String s, int ZC) {
		StringBuilder transformedRow = new StringBuilder();
		for (int charIndex = 0; charIndex < s.length(); charIndex++) {
			for (int counter = 0; counter < ZC; counter++) {
				transformedRow.append(s.charAt(charIndex));
			}
		}
		return transformedRow;
	}

	private static void repitition(StringBuilder s, int ZR) {
		for (int i = 0; i < ZR; i++) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int ROW = Integer.valueOf(sc.next());
		final int COL = Integer.valueOf(sc.next());
		final int ZR = Integer.valueOf(sc.next());
		final int ZC = Integer.valueOf(sc.next());
		sc.nextLine();

		for (int i = 0; i < ROW; i++) {
			String current = sc.nextLine();
			StringBuilder modifiedRow = Skener.transformation(current, ZC);
			Skener.repitition(modifiedRow, ZR);
		}
	}
}
