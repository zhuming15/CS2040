import java.io.*;
import java.lang.Math;
import java.util.StringTokenizer;

public class ExactlyElectrical {
	private final Point point1;
	private final Point point2;
	private final int numOfCharge;
	private static Kattio io = new Kattio(System.in, System.out);

	ExactlyElectrical() {
		this.point1 = new Point(io.getInt(), io.getInt());
		this.point2 = new Point(io.getInt(), io.getInt());
		this.numOfCharge = io.getInt();
	}

	public char computePossibility() {
		if (point1.possiblePath(numOfCharge, point2)) {
			return 'Y';
		}
		return 'N';
	}

	public static void main(String[] args) {
		ExactlyElectrical test = ExactlyElectrical();
		io.println(test.computePossibility());
	}
}

class Point {
	private final int x;
	private final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int computeMinEletric(Point p) {
		int del_x = Math.abs(this.getX() - p.getX());
		int del_y = Math.abs(this.getY() - p.getY());
		return del_x + del_y;
	}

	private int getX() {
		return this.x;
	}

	private int getY() {
		return this.y;
	}

	public boolean possiblePath(int n, Point p) {
		int minElecRequired = this.computeMinEletric(p);
		int diff = n - minElecRequired;

		if (diff >= 0 && diff % 2 == 0) {
			return true;
		}
		return false;
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
