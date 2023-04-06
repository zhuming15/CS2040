import java.util.*;

class LostMap {
	PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
	int numOfEdgesRequired;
	int numOfVillages;

	LostMap(int numOfVillages) {
		this.numOfVillages = numOfVillages;
		this.numOfEdgesRequired = numOfVillages - 1;
	}

	void readInput(Kattio io) {
		for (int i = 1; i <= numOfVillages; i++) {
			for (int j = 1; j <= numOfVillages; j++) {
				if (i <= j)
					io.getInt();
				else
					edgeList.add(new Edge(i, j, io.getInt()));
			}
		}
	}

	void KruskalMST(Kattio io) {
		UFDS set = new UFDS(numOfVillages);
		while (numOfEdgesRequired != 0) {
			Edge currEdge = edgeList.poll();
			int source = currEdge.getSource();
			int dest   = currEdge.getDestination();
			if (set.canUnion(source, dest)) { 
				--numOfEdgesRequired;
				io.print(source);
				io.print(" ");
				io.println(dest);
			}
		}
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
