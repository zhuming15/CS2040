import java.io.*;
import java.util.ArrayList;

public class Akcija {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfBooks = Integer.parseInt(br.readLine());
		ArrayList<Integer> books = new ArrayList<Integer>();

		for (int counter = 0; counter < numOfBooks; counter++) {
			books.add(Integer.valueOf(br.readLine()));
		}

		books.sort((b1, b2) -> (Integer.compare(b2, b1)));
		int pay = 0;

		for (int nthBook = 0; nthBook < numOfBooks; nthBook++) {
			if ((nthBook + 1) % 3 != 0) 
				pay += books.get(nthBook);
		}
		System.out.println(pay);
	}
}
