import java.util.*;

class Grid {
	int length;
	int width;
	int[][] grid;
	boolean[][] visited;

	Grid(int length, int width) {
		this.length = length;
		this.width = width;
		this.grid = new int[length][width];
		this.visited = new boolean[length][width];
	}

	void readInput(Kattio io) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = io.getInt();
				visited[i][j] = false;
			}
		}
	}

	int computeWeightDiff(int x, int y, int nextX, int nextY) { 
		int diff = grid[nextX][nextY] - grid[x][y];
		return diff >= 0 ? diff : 0;
	}

	boolean withinBounds(int x, int y)    { return withinHorizontalBounds(x) && withinVerticalBounds(y); }
	boolean withinHorizontalBounds(int x) { return x >= 0 && x < length; }
	boolean withinVerticalBounds  (int y) { return y >= 0 && y < width;  } 
	boolean isDestination(int x, int y) { return x == length-1 && y == width-1; }

	boolean isVisited(int x, int y) { return visited[x][y]; }
	void visited(int x, int y) { visited[x][y] = true; }

	@Override
	public String toString() {
		for (int i = 0; i < length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		return "";
	}
}
