import java.util.*;

class Set {
	public int[] root;
	public int[] parent;
	public int[] rank;
	public int numOfElems;

	Set(int N) {
		this.numOfElems = N;
		this.root = new int[N+1];
		this.parent = new int [N+1];
		this.rank = new int[N+1];
		for (int i = 0; i < N + 1; i++) {
			root[i] = i;
			parent[i] = i;
			rank[i] = 1;
		}
	}

	int findRootSet(int i) {
		int rootIdx = root[i];
		if (rootIdx == i) { return i; }
		else {
			root[i] = rootIdx;
			return findRootSet(rootIdx);
		}
	}

	int findParentSet(int i) {
		int parentIdx = parent[i];
		if (parentIdx == i) { return i; }
		else {
			parent[i] = parentIdx;
			return findParentSet(parentIdx);
		}
	}

	int findSet(int i) {
		int rootIdx = findRootSet(i);
		int parentIdx = findParentSet(rootIdx);
		return parentIdx;
	}

	boolean isSameSet(int p, int q) {
		return findSet(p) == findSet(q);
	}

	void unionSet(int p, int q) {
		if (!isSameSet(p, q)) {
			int x = findSet(p);
			int y = findSet(q);
			if (rank[x]> rank[y]) {
				root[y] = x;
				parent[y] = x;
			} else {
				root[x] = y;
				parent[p] = y;
				if (rank[x] == rank[y]) {
					rank[y] = rank[y] + 1;
				}
			}
		}
	}

	void move(int p, int q) {
		if(!isSameSet(p, q)) {
			int qRootIdx = findRootSet(q);
			int qParentIdx = findParentSet(qRootIdx);
			root[p] = qParentIdx;
		}
	}

	@Override
	public String toString() {
		System.out.println("parent : " + Arrays.toString(parent));
		System.out.println("root   : " + Arrays.toString(root));
		System.out.println("rank   : " + Arrays.toString(rank));
		return "end";
	}
}	
