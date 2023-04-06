import java.util.*;

class UFDS {
	int[] parent;
	int[] rank;

	UFDS(int n) {
		this.parent = new int[n+2];
		this.rank = new int[n+2];
		for (int i = 0; i <= n+1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	int find(int i) {
		if (parent[i] == i) { return i; }
		parent[i] = find(parent[i]);
		return parent[i];
	}

	boolean canUnion(int i, int j) {
		int iParent = find(i);
		int jParent = find(j);
		if (iParent != jParent) {
			if (rank[iParent] < rank[jParent]) { parent[iParent] = jParent; }
			else if (rank[iParent] > rank[jParent]) { parent[jParent] = iParent; }
			else    {
				parent[iParent] = jParent;
				rank[iParent]++;
			}
			return true;
		} else { 
			return false;
		}
	}
}
