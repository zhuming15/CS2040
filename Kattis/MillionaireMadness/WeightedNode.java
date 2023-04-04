import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {
	int x;
	int y;
	long weight;

	WeightedNode(int x, int y, long weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	int getX() { return this.x; }
	int getY() { return this.y; }
	long getWeight() { return this.weight; }

	@Override
	public int compareTo(WeightedNode others) {
		long diff = others.getWeight() - this.getWeight();
		if (diff > 0) { return -1; }
		if (diff == 0) { return 0; }
		return 1;
	}

	@Override
	public String toString() {
		return String.format("((%d, %d), %d)", x, y, weight);
	}
}

