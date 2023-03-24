import java.util.*;

class AlmostUnionFind {
	public Set set;

	AlmostUnionFind(int N) {
		this.set = new Set(N);
	}

	void runOperation(int command, Kattio io) {
		if (command == 1) { set.unionSet(io.getInt(), io.getInt()); }
		else if (command == 2) { set.move(io.getInt(), io.getInt()); }
		else { set.printOutput(io.getInt(), io); }
	}
	
	void printSet(Kattio io) {
		io.println(set.toString());
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		while (io.hasMoreTokens()) {
			int N = io.getInt();
			int M = io.getInt();
			AlmostUnionFind test = new AlmostUnionFind(N);
			test.printSet(io);	
			while (M-- > 0) {
				int operation = io.getInt();
				test.runOperation(operation, io);
				test.printSet(io);
			}
		}
		io.flush();
		io.close();
	}
}					
