import java.util.*;

class Islands {
	public String[] rows;
	public boolean[][] visited;
	public int ROW;
	public int COL;
	private int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

	Islands(int r, int c) {
		this.ROW = r;
		this.COL = c;
		this.rows = new String[r];
		this.visited = new boolean[r][c];
	}

	void readInput(Kattio io) {
		for (int i = 0; i < ROW; i++) {
			rows[i] = io.getWord();
		}
	}

	int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{r,c});
		visited[r][c] = true;
		int res = 0;
		while (!queue.isEmpty()) {
			int[] currRC = queue.poll();
			for (int[] dir : dirs) {
				r = currRC[0] + dir[0];
				c = currRC[1] + dir[1];
				if (r >= 0 && r < ROW && c >= 0 && c < COL && !isVisited(r,c) && rows[r].charAt(c) != 'W') {
					visited[r][c] = true;
					queue.add(new int[]{r, c});
				}
			}
		}
		return res;
	}
	
	boolean getChar(int r, int c) {
		return rows[r].charAt(c) == 'L';
	}

	boolean isVisited(int r, int c) {
		return visited[r][c];
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Islands test = new Islands(io.getInt(), io.getInt());
		test.readInput(io);
		int islandNum = 0;
		for (int r = 0; r < test.ROW; r++) {
			for (int c = 0; c < test.COL; c++) {
				if (!test.isVisited(r,c) && test.getChar(r,c)) {
					islandNum++;
					islandNum += test.bfs(r,c);
				}
			}
		}
		io.println(islandNum);
		io.flush();
		io.close();
	}
}
