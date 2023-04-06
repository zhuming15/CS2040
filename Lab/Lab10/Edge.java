import java.util.*;

class Edge implements Comparable<Edge> {
	int source;
	int destination;
	int weight;

	Edge (int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	int getSource()      { return source; }
	int getDestination() { return destination; }
	int getWeight()      { return weight; }

	@Override
	public int compareTo(Edge others) {
		return this.getWeight() - others.getWeight();
	}

	@Override
	public String toString() {
		return String.format("((%d, %d), %d)", source, destination, weight);
	}
}
