import java.util.*;

class UFDS {
	int[] parent;
	int[] rank;
	int numOfHeads;
	boolean[] head;

	UFDS(int V) {
		this.numOfHeads = V;
		this.parent = new int[V+1];
		this.rank = new int[V+1];
		this.head = new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	int find(int i) {
		if (parent[i] == i) { return i; }
		return parent[i] = find(parent[i]);
	}

	boolean union(int from, int to) {
		int iParent = find(from);
		int jParent = find(to);
		if (iParent != jParent) {
			if (!head[to]) {
				head[to] = true;
				numOfHeads--;
			}
			if (rank[iParent] > rank[jParent]) { 
				parent[jParent] = iParent; 
				return true;
			}
			parent[iParent] = jParent;
			if (rank[iParent] == rank[jParent]) { rank[jParent]++; }
			return true;
		}
		return false;
	}

	int getNumOfHeads() { return numOfHeads; }

	@Override
	public String toString() {
		System.out.println(Arrays.toString(parent));
		System.out.println(Arrays.toString(rank));
		return "";
	}
}
