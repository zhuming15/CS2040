import java.util.*;

class Vertex {
	public String key;
	public Vertex parent = null;
	public Vertex left = null;
	public Vertex right = null;
	public int height = -1;

	Vertex(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return this.key;
	}
}
