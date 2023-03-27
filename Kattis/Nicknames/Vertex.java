import java.util.*;

class Vertex {
	public String key;
	public Vertex parent = null;
	public Vertex left = null;
	public Vertex right = null;
	public int height;
	public int size;

	private Vertex(String key) {
		this.key = key;
	}

	public static Vertex of(String key) {
		Vertex temp = new Vertex(key);
		temp.height = 0;
		temp.size = 1;
		return temp;
	}

	public int getSize(Vertex v) { return (v == null) ? 0 : v.size; }
	public int updateSize() { return this.size = getSize(right) + getSize(left) + 1; }

	private int getHeight(Vertex v) { return (v == null) ? -1 : v.height; }
	public int updateHeight() { return this.height = 1 + Math.max(getHeight(left), getHeight(right)); }

	public int getBalanceFactor() { return getHeight(left) - getHeight(right); }

	@Override
	public String toString() { return this.key; }
}
