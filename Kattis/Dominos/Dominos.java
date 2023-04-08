import java.util.*;

class Dominos {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfTestCases = io.getInt();
		while (numOfTestCases-- > 0) {
			int numOfTiles = io.getInt();
			int numOfEdges = io.getInt();
			ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
			boolean[] visited = new boolean[numOfTiles+1];
			UFDS sets = new UFDS(numOfTiles);
			for (int i = 0; i <= numOfTiles; i++) {
				adjList.add(new ArrayList<Integer>());
			}
			while (numOfEdges-- > 0) {
				int s = io.getInt();
				int d = io.getInt();
				adjList.get(s).add(d);
			}
			for (int u = 1; u <= numOfTiles; u++) {
				if (!visited[u]) {
					visited[u] = true;
					Stack<Integer> stack = new Stack<Integer>();
					stack.push(u);
					while (!stack.isEmpty()) {
						int cur = stack.pop();
						for (Integer v : adjList.get(cur)) {
							if (!visited[v]) {
								visited[v] = true;
								sets.union(cur, v);
								stack.push(v);
							}
						}
					}
				}
			}
			io.println(sets.getNumOfSets());
		}
		io.flush();
		io.close();
	}
}
