import java.util.*;

class UFDS {
	int[] parent;
	int[] rank;

	UFDS(int V) {
		this.parent = new int[V+1];
		this.rank = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	int find(int i) {
		if (parent[i] == i) { return i; }
		return parent[i] = find(parent[i]);
	}

	boolean canUnion(int i, int j) {
		int iParent = find(i);
		int jParent = find(j);
		if (iParent != jParent) {
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
}
