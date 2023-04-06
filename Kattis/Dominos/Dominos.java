import java.util.*;

class Dominos {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfTestCases = io.getInt();
		while (numOfTestCases-- > 0) {
			int numOfTiles = io.getInt();
			int numOfEdges = io.getInt();
			boolean[] tiles = new boolean[numOfTiles+1];
			while (numOfEdges-- > 0) {
				int s = io.getInt();
				int d = io.getInt();
				tiles[d] = true;
			}
			int numOfKnockedDown = 0;
			for (int i = 1; i <= numOfTiles; i++) {
				if (!tiles[i]) { numOfKnockedDown++; }
			}
			io.println(numOfKnockedDown);
		}
		io.flush();
		io.close();
	}
}
