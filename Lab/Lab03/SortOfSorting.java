import java.io.*;
import java.util.Arrays;

class SortOfSorting {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String[] readInput( int numOfNames) throws IOException {
		String[] strarr = new String[numOfNames];
		for (int i = 0; i < numOfNames; i++) {
			strarr[i] = SortOfSorting.br.readLine();
		}
		return strarr;
	}		

	public static void sortThenPrint(String[] arr) {
		Arrays.sort(arr, (s1, s2) -> (s1.substring(0,2).compareTo(s2.substring(0,2))));

		for (String s: arr) {
			SortOfSorting.pw.println(s);
		}
		SortOfSorting.pw.println("");
	}

	public static void main(String[] args) throws IOException {
		SortOfSorting test = new SortOfSorting();
		int numOfNames = Integer.parseInt(SortOfSorting.br.readLine());
		while (numOfNames != 0) {
			String[] strarr = SortOfSorting.readInput(numOfNames);
			SortOfSorting.sortThenPrint(strarr);
			numOfNames = Integer.parseInt(SortOfSorting.br.readLine());
		}
		SortOfSorting.pw.flush();
		SortOfSorting.pw.close();
	}
}
