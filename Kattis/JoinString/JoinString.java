import java.io.*;

public class JoinString {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int numOfStrings = io.getInt();
		StringBuilder[] wordList = new StringBuilder[numOfStrings+2];

		for (int counter = 1; counter <= numOfStrings; counter++) {
			wordList[counter] = new StringBuilder(io.getWord());
		}

		StringBuilder lastString = wordList[1] == null ? new StringBuilder() : wordList[1];

		for (int ithOperation = 1; ithOperation < numOfStrings; ithOperation++) {
			int a = io.getInt();
			int b = io.getInt();

			wordList[a].append(wordList[b]);
			lastString = wordList[a];
		}
		pw.println(lastString.toString());
		pw.flush();
		pw.close();
	}
}	
