import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class JoinString {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);

		int numOfStrings = io.getInt();
		StringLinkedList[] wordList = new StringLinkedList[numOfStrings+2];
		StringLinkedList head = null;

		for (int counter = 1; counter <= numOfStrings; counter++) {
			wordList[counter] = new StringLinkedList(io.getWord());
		}

		if (numOfStrings == 1) {
		   	io.print(wordList[1].toString());
			io.close();
			return; 
		}
		if (numOfStrings == 0) {
			io.print("");
			io.close();
			return;
		}

		for (int ithOperation = 1; ithOperation < numOfStrings; ithOperation++) {
			int a = io.getInt();
			int b = io.getInt();
			wordList[a].setNext(wordList[b]);
			head = wordList[a];
		}

		while (head.hasNext()) {
			io.print(head.toString());
			head = head.getNext();
		}
		io.print(head.toString());
		io.close();
	}
}	

class StringLinkedList {
	String string;
	StringLinkedList next;

	StringLinkedList(String s) {
		this(s, null);
	}
	
	StringLinkedList(String s, StringLinkedList next) {
		this.string = s;
		this.next = next;
	}

	boolean hasNext() {
		return this.next != null;
	}

	void setNext(StringLinkedList next) {
		this.next = next;
	}

	StringLinkedList getNext() {
		return this.next;
	}

	@Override
	public String toString() {
		return this.string;
	}
}

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}
	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() { 
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}



	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null) 
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null) return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) { }
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}
