import java.util.Scanner;

public class PeaSoup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfRestaurant = sc.nextInt();

		for (int i = 0; i < numOfRestaurant; i++) {
			int numOfItem = sc.nextInt();
			sc.nextLine();
			String restaurantName = sc.nextLine();
			boolean pancakesPresent = false;
			boolean peaSoupPresent = false;

			for (int j = 0; j < numOfItem; j++) {
				String temp = sc.nextLine();
				if (temp.equals("pancakes"))
					pancakesPresent = true;
				else if (temp.equals("pea soup")) 
					peaSoupPresent = true;

				if (pancakesPresent && peaSoupPresent) {
					System.out.println(restaurantName);
					return;
				}
			}
		}
		System.out.println("Anywhere is fine I guess");
	}
}
