class Pair implements Comparable<Pair> {
	int i;
	double dist;

	Pair(int i, double dist) {
		this.i = i;
		this.dist = dist;
	}

	@Override
	public int compareTo(Pair other) {
		if (this.dist < other.dist) { return -1; }
		else if (this.dist > other.dist) { return 1; }
		else { return 0; }
	}
}
