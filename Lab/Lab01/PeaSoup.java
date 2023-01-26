import java.util.Scanner;

public class PeaSoup {
	public static void findVersionOne() {
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

	public static void findVersionTwo() {
		Scanner sc = new Scanner(System.in);
		int numOfRestaurant = Integer.valueOf(sc.nextLine());

		for (int i = 0; i < numOfRestaurant; i++) {
			int numOfItems = Integer.valueOf(sc.nextLine());
			String restaurantName = sc.nextLine();
			boolean hasPancakes = false;
			boolean hasPeaSoup = false;

			for (int j = 0; j < numOfItems; j++) {
				String dish = sc.nextLine();
				if (dish.equals("pancakes"))
					hasPancakes = true;
				else if (dish.equals("pea soup"))
					hasPeaSoup = true;

				if (hasPeaSoup && hasPancakes) {
					System.out.println(restaurantName);
					return;
				}
			}
		}
		System.out.println("Anywhere is fine I guess");
	}

	public static void main(String[] args) {
		PeaSoup.findVersionTwo();
	}
}
