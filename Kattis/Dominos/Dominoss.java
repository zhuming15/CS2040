import java.util.*;

class Dominoss {
	ArrayList<ArrayList<Integer>> adjLst;
	int V;

	Dominoss(int V) {
		this.V = V;
		this.adjLst = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= V; i++) {
			adjLst.add(new ArrayList<Integer>());
		}
	}

	void addEdge(int v, int u) { adjLst.get(v).add(u); }

	void topologicalSortUntil(int v, boolean[] visited, Stack<Integer> s) {
		visited[v] = true;
		for (Integer neighbour : adjLst.get(v)) {
			if (!visited[neighbour]) {
				topologicalSortUntil(neighbour, visited, s);
			}
		}
		s.push(v);
	}

	public Stack<Integer> toposort() {
		Stack<Integer> topoSeq = new Stack<Integer>();
		boolean[] visited = new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				topologicalSortUntil(i, visited, topoSeq);
			}
		}
		return topoSeq;
	}

	void knockDown(Stack<Integer> seq, boolean[] knockedDown, int v) {
		knockedDown[v] = true;
		for (Integer n : adjLst.get(v)) {
			if (!knockedDown[n]) {
				knockDown(seq, knockedDown, n);
			}
		}
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfTestCases = io.getInt();
		while (numOfTestCases-- > 0) {
			int numOfTiles = io.getInt();
			int numOfEdges = io.getInt();
			Dominoss test = new Dominoss(numOfTiles);
			while (numOfEdges-- > 0) {
				test.addEdge(io.getInt(), io.getInt());
			}
			Stack<Integer> topoSeq = test.toposort();
			boolean[] knockedDown = new boolean[numOfTiles+1];
			int numOfKnockRequired = 0;
			while (!topoSeq.empty()) {
				int v = topoSeq.pop();
				if (!knockedDown[v]) {
					numOfKnockRequired++;
					test.knockDown(topoSeq, knockedDown, v); 
				}
			}
			io.println(numOfKnockRequired);
		}
		io.flush();
		io.close();
	}
}
