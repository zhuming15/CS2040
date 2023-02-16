import java.util.*;
import java.io.*;

public class CoconutSplat {
	private final int numOfSyllables;
	private final int numOfPlayers;
	private Deque<Player> dq = new LinkedList<Player>();

	CoconutSplat(int numOfS, int numOfP) {
		this.numOfSyllables = numOfS;
		this.numOfPlayers = numOfP;

		for (int ithPlayer = 1; ithPlayer <= numOfP; ithPlayer++) {
			this.dq.addLast(new Player(ithPlayer));
		}
	}

	Player estimateWinner() {
		while (dq.size() != 1) {
			this.playRound();
			this.endRoundAction();
		}
		return dq.pollFirst();
	}

	void playRound() {
		for (int  ithSyllable = 0; ithSyllable < numOfSyllables+1; ithSyllable++) {
			Player frontPlayer = dq.pollFirst();
			dq.addLast(frontPlayer);
		}
	}

	void endRoundAction() {
		Player endRoundPlayer = dq.pollFirst();

		if (endRoundPlayer.isStillFolded()) {
			endRoundPlayer.unfold();
			dq.addFirst(endRoundPlayer);
			dq.addFirst(endRoundPlayer);
		} else if (endRoundPlayer.isNotPalmDown()) {
			endRoundPlayer.palmDowning();
			dq.addFirst(endRoundPlayer);
			dq.addLast(endRoundPlayer);
		}
	}

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);
		CoconutSplat CS = new CoconutSplat(io.getInt(), io.getInt());
		Player winner = CS.estimateWinner();
		io.println(winner.toString());
		io.close();
	}
}

class Player {
	final int NUM;
	boolean stillFolded = true;
	boolean palmDown = false;

	Player(int NUM) {
		this.NUM = NUM;
	}

	boolean isStillFolded() {
		return this.stillFolded;
	}

	boolean isNotPalmDown() {
		return !(this.palmDown);
	}

	void palmDowning() {
		this.palmDown = true;
	}

	void unfold() {
		this.stillFolded = false;
	}

	@Override
	public String toString() {
		return "" + this.NUM;
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
