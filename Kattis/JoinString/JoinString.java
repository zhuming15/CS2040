import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

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
