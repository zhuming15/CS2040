import java.io.*;

public class JoinString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int numOfStrings = Integer.parseInt(br.readLine());
		StringBuilder[] wordList = new StringBuilder[numOfStrings+2];
		StringBuilder emptyString = new StringBuilder();

		for (int counter = 1; counter <= numOfStrings; counter++) {
			wordList[counter] = new StringBuilder(br.readLine());
		}

		StringBuilder lastString = null;

		for (int ithOperation = 1; ithOperation < numOfStrings; ithOperation++) {
			String[] strarr = br.readLine().split(" ");
			int a = Integer.parseInt(strarr[0]);
			int b = Integer.parseInt(strarr[1]);

			wordList[a].append(wordList[b]);
			wordList[b] = emptyString;
			lastString = wordList[a];
		}
		pw.println(lastString);
		pw.flush();
		pw.close();
	}
}	
