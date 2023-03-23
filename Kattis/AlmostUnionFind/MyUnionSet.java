import java.util.*;

class MyUnionSet {
	public HashMap<Integer, Integer> setToParent;
	//public HashMap<Integer, Integer> parentToRank;
	public int[] rank;

	MyUnionSet(int N) {
		this.setToParent = new HashMap<Integer, Integer>();
		//this.parentToRank = new HashMap<Integer, Integer>();
		this.rank = new int[N+1];
		for (int i = 1; i <= N; i++) {
			setToParent.put(i, i);
			//parentToRank.put(i, 1);
			rank[i] = 1;
		}
	}

	public int findSet(int p) {
		int temp = setToParent.get(p);
		if (temp == p)
			return p;
		else {
			setToParent.put(p, findSet(temp));
			return temp;
		}
	}

	boolean isSameSet(int p, int q) {
		return findSet(p) == findSet(q);
	}

	void unionSet(int p, int q) {
		if (!isSameSet(p, q)) {
			int x = findSet(p);
			int y = findSet(q);
			if (rank[x] > rank[y]) 
				setToParent.put(q, x);
			else {
				setToParent.put(p, y);
				if (rank[x] == rank[y]) 
					rank[y] = rank[y] + 1;
			}
		}
	}

	void move(int p, int q) {
		if (!isSameSet(p, q)) {
			int x = findSet(p);
			int y = findSet(q);
			setToParent.put(p, y);
		}
	}

	@Override
	public String toString() {
		return setToParent.toString();
	}
}

