import java.util.*;

class WeakVertices {
	private Map<Integer, ArrayList<Integer>> adjList;
	private int numOfInputs;

	WeakVertices(int NInputs) {
		this.adjList = new HashMap<Integer, ArrayList<Integer>>();
		this.numOfInputs = NInputs;
	}

	void createAdjMatrix(Kattio io) {
		for (int i = 0; i < numOfInputs; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < numOfInputs; j++) {
				int temp = io.getInt();
				if (temp == 1) { list.add(j); }
			}
			adjList.put(i, list);
		}
	}

	StringBuilder findWeakVertices() {
		StringBuilder weakVertices = new StringBuilder("");
		for (int a = 0; a < numOfInputs; a++) {
			boolean isTriangle = false;
			for (int b : adjList.get(a)) {
				for (int c : adjList.get(b)) {
					for (int A : adjList.get(c)) {
						if (A == a) { 
							isTriangle = true;
							break;
						}
					}
					if (isTriangle) { break; }
				}
				if (isTriangle) { break; }
			}
			if (!isTriangle) { weakVertices.append(a + " "); }
		}
		return weakVertices;
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int N = io.getInt();
		while (N != -1) {
			WeakVertices test = new WeakVertices(N);
			test.createAdjMatrix(io);
			StringBuilder weakVertices = test.findWeakVertices();
			io.println(weakVertices);
			N = io.getInt();
		}
		io.flush();
	}
}
