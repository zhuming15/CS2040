import java.util.*;
import java.io.*;

class DelimiterSoup {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < n; i++) {
			char curr = arr[i];
			if (curr == ' ') { continue; }
			if (curr == '}' || curr == ']' || curr == ')') {
				if (stack.isEmpty()) {
					pw.println(curr + " " + i);
					pw.flush();
					pw.close();
					return;
				} 

		}
	}
}
