import java.util.*;

class LostMap {
	PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
	boolean[] connected;
	int numOfVillages;

	LostMap(int numOfVillages) {
		this.numOfVillages = numOfVillages;
		this.connected = new boolean[numOfVillages + 1];
	}

	void readInput(Kattio io) {
		for (int i = 1; i <= numOfVillages; i++) {
			for (int j = 1; j <= numOfVillages; j++) {
				if (i <= j) { 
					io.getInt();
					continue;
				}
				int weight = io.getInt();
				edgeList.add(new Edge(i, j, weight));
			}
		}
	}

	void KruskalMST(Kattio io) {
		int numOfEdges = numOfVillages;
		UFDS set = new UFDS(numOfVillages);
		while (numOfEdges != 0) {
			Edge currEdge = edgeList.poll();
			int source = currEdge.getSource();
			int dest   = currEdge.getDestination();
			if (set.union(source, dest)) { 
				if (connected[source] && connected[dest]) { continue; }
				if (!connected[source]) { 
					--numOfEdges;
					connected[source] = true;
				}
				if (!connected[dest])   { 
					--numOfEdges;
					connected[dest] = true;
				}
				io.print(source);
				io.print(" ");
				io.println(dest);
			} else {
				continue;
			}
		}
		System.out.println(Arrays.toString(connected));
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int numOfVillages = io.getInt();
		LostMap test = new LostMap(numOfVillages);
		test.readInput(io);
		test.KruskalMST(io);
		io.flush();
		io.close();
	}
}
