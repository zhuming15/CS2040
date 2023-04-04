import java.util.*;

class MillionaireMadness {
	Grid grid;
	long minLadderHeight = 1_000_000_000;
	int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

	MillionaireMadness(int length, int width) {
		this.grid = new Grid(length, width);
	}

	void readInput(Kattio io) { grid.readInput(io); }

	long bfs(int x, int y) {
		PriorityQueue<WeightedNode> pq = new PriorityQueue<WeightedNode>();
		pq.add(new WeightedNode(0,0,0));
		grid.visited(0,0);
		long minLadder = 0;
		while (!pq.isEmpty()) {
			WeightedNode node = pq.poll();
			int iniX = node.getX();
			int iniY = node.getY();
			grid.visited(iniX, iniY);
			if (grid.isDestination(iniX, iniY) && minLadderHeight > minLadder) {
				minLadderHeight = minLadder;
				continue;
			}
			minLadder = minLadder < node.getWeight() ? node.getWeight() : minLadder;
			for (int[] dir : dirs) {
				int nextX = iniX + dir[0];
				int nextY = iniY + dir[1];
				if (grid.withinBounds(nextX, nextY) && !grid.isVisited(nextX, nextY)) {
					long weight = grid.computeWeightDiff(iniX, iniY, nextX, nextY);
					pq.add(new WeightedNode(nextX, nextY, weight));
				}
			}
		}
		return minLadderHeight;
	}

	public static void main(String[] args) {
		Kattio io  = new Kattio(System.in, System.out);
		int length = io.getInt();
		int width  = io.getInt();
		MillionaireMadness test = new MillionaireMadness(length, width);
		test.readInput(io);
		io.println(test.bfs(0,0));
		io.flush();
		io.close();
	}
}
