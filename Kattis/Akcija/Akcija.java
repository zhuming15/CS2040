import java.io.*;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Akcija {
	/*
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
	*/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int numOfBooks = Integer.parseInt(br.readLine());
		Integer[] books = new Integer[numOfBooks];

		for (int counter = 0; counter < numOfBooks; counter++) {
			books[counter] = Integer.valueOf(br.readLine());
		}

		Arrays.sort(books, Collections.reverseOrder());
		int pay = 0;

		for (int index = 0; index < numOfBooks; index++) {
			if ((index + 1) % 3 != 0)
				pay += books[index];
		}
		pw.println(pay);
		pw.flush();
		pw.close();
	}
}
