import java.util.Scanner;

public class TimeLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = " Abracadabra";

		for (int j = 1; j <= n; j++) {
			System.out.println(j + s);
		}
	}
}
