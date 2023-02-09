import java.io.*;
import java.util.Arrays;

class SortOfSorting {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numOfNames = Integer.parseInt(br.readLine());
		while (numOfNames != 0) {
			String[] strarr = new String[numOfNames];
			for (int i = 0; i < numOfNames; i++) {
				strarr[i] = br.readLine();
			}
			Arrays.sort(strarr, (s1, s2) -> (s1.substring(0,2).compareTo(s2.substring(0,2))));
			for (String s : strarr) {
				pw.println(s);
			}
			pw.println("");
			numOfNames = Integer.parseInt(br.readLine());
		}
		pw.flush();
		pw.close();
	}
}
